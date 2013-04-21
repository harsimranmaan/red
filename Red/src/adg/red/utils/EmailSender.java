/*
 * The EmailSender class is to send an email.
 *
 */
package adg.red.utils;

import adg.red.encryptor.Encryptor;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * The EmailSender class is to send an email.
 * <p/>
 * @author harsimran.maan
 */
public class EmailSender
{

    private String fromAddress;
    private String toAddress;
    private String message;
    private String subject;
    private Session session;
    private String password;

    /**
     * The default constructor.
     */
    private EmailSender()
    {
        final ConfigManager config = ConfigManager.getInstance();
        this.fromAddress = config.getPropertyValue("emailSender");
        this.password = Encryptor.decryptAES(config.getPropertyValue("emailToken"));
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", config.getPropertyValue("smtp"));
        props.put("mail.smtp.port", config.getPropertyValue("port"));

        session = Session.getInstance(props,
                new javax.mail.Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(fromAddress, password);
            }
        });
    }

    /**
     * The constructor.
     * <p/>
     * @param toAddress the address to send an email to
     * @param subject   the subject of the email
     * @param message   the message body of the email
     */
    public EmailSender(String toAddress, String subject, String message)
    {
        this();
        this.toAddress = toAddress;
        this.subject = subject;
        this.message = message;
    }

    /**
     * The function to send an email.
     */
    public void send()
    {
        try
        {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromAddress));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toAddress));
            message.setSubject(subject);
            message.setText(this.message);

            Transport.send(message);

        }
        catch (MessagingException e)
        {
            throw new RuntimeException(e);
        }
    }
}
