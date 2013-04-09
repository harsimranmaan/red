/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author harsimran.maan
 */
public class EmailSender
{

    private String fromAddress;
    private String toAddress;
    private String message;
    private String smtpServer;
    private String subject;
    private Session session;
    private String password;

    private EmailSender()
    {
        this.password = "adgreduser";
        this.fromAddress = "adgredinfo@gmail.com";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        session = Session.getInstance(props,
                new javax.mail.Authenticator()
        {
            protected PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication(fromAddress, password);
            }
        });
    }

    public EmailSender(String toAddress, String subject, String message)
    {
        this();
        this.toAddress = toAddress;
        this.subject = subject;
        this.message = message;
    }

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
