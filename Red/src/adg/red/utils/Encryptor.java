/*
 * The Encryptor class is responsible for encrypt and decrypt input string.
 *
 */
package adg.red.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.MimeUtility;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * The Encryptor class is responsible for encrypt and decrypt input string.
 * <p/>
 * @author harsimran.maan
 */
public class Encryptor
{

    private final static SecretKeySpec secretKey;
    private final static byte[] byteKey =
    {
        0x75, 0x68, 0x69, 0x73, 0x49, 0x73, 0x41, 0x53, 0x64, 0x63, 0x72, 0x65, 0x76, 0x4b, 0x65, 0x79
    };

    static
    {


        // SecretKeyFactory factory = SecretKeyFactory.getInstance("AES");
        secretKey = new SecretKeySpec(byteKey, "AES");
        // String pass1 = "adgRedSecretKeyForEncryptionSOMEadgRedSecretKeyForEncryptionSOME";
        // byte[] pass = pass1.getBytes();
        //key = factory.generateSecret(new DESKeySpec(pass));

    }

    /**
     * The functions to convert input byte array to String.
     * <p/>
     * @param digest the input digest
     * <p/>
     * @return converted String
     */
    private static String getString(byte[] digest)
    {
        StringBuilder hexString = new StringBuilder();

        for (int looper = 0; looper < digest.length; looper++)
        {
            String hex = Integer.toHexString(0xff & digest[looper]);
            if (hex.length() == 1)
            {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    /**
     * The function encrypts SHA to the input String password.
     * <p/>
     * @param password the String password to be encrypted
     * <p/>
     * @return the SHA encrypted String
     */
    public static String encryptSHA(String password)
    {
        String hash = password;
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(password.getBytes());
            hash = getString(md.digest());

        }
        catch (NoSuchAlgorithmException ex)
        {
            Logger.getLogger(Encryptor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hash;
    }

    /**
     * The function encrypts AES to the input String literal.
     * <p/>
     * @param literal the String to be encrypted
     * <p/>
     * @return the AES encrypted String
     */
    public static String encryptAES(String literal)
    {
        String cipherText = literal;
        try
        {
            Cipher aesCipher = Cipher.getInstance("AES");
            aesCipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] byteDataToEncrypt = literal.getBytes();
            byte[] byteCipherText = aesCipher.doFinal(byteDataToEncrypt);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            OutputStream base64OutputStream = MimeUtility.encode(baos, "base64");
            base64OutputStream.write(byteCipherText);
            base64OutputStream.close();
            cipherText = baos.toString();
            System.out.println("\n Plain Data : " + literal + " \n Cipher Data : " + cipherText);
        }
        catch (Exception ex)
        {
            Logger.getLogger(Encryptor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cipherText;
    }

    /**
     * The function decrypts AES from the input cipherText String.
     * <p/>
     * @param cipherText the String to be decrypted
     * <p/>
     * @return the AES decrypted String
     */
    public static String decryptAES(String cipherText)
    {
        String decryptedText = cipherText;
        try
        {
            Cipher aesCipher = Cipher.getInstance("AES");
            aesCipher.init(Cipher.DECRYPT_MODE, secretKey);
            InputStream b64is = MimeUtility.decode(new ByteArrayInputStream(cipherText.getBytes()), "base64");
            byte[] tmp = new byte[cipherText.getBytes().length];
            int size = b64is.read(tmp);
            byte[] res = new byte[size];
            System.arraycopy(tmp, 0, res, 0, size);

            decryptedText = new String(aesCipher.doFinal(res));

            System.out.println("Cipher Data : " + cipherText + " \n Decrypted Data : " + decryptedText);
        }
        catch (Exception ex)
        {
            Logger.getLogger(Encryptor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return decryptedText;
    }
}
