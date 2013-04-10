/*
 * The Encryptor class is responsible for encrypt and decrypt input string.
 *
 */
package adg.red.utils;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.internet.MimeUtility;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * The Encryptor class is responsible for encrypt and decrypt input string.
 * <p/>
 * @author harsimran.maan
 */
public class Encryptor
{

    private static SecretKey key;

    static
    {

        try
        {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
            String pass1 = "adgRedSecretKeyForEncryptionSOMEadgRedSecretKeyForEncryptionSOME";
            byte[] pass = pass1.getBytes();
            key = factory.generateSecret(new DESKeySpec(pass));
        }
        catch (Exception ex)
        {
            Logger.getLogger(Encryptor.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            Cipher aesCipher = Cipher.getInstance("DES");
            aesCipher.init(Cipher.ENCRYPT_MODE, key);
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
            Cipher aesCipher = Cipher.getInstance("DES");
            aesCipher.init(Cipher.DECRYPT_MODE, key, aesCipher.getParameters());
            byte[] byteDecryptedText = aesCipher.doFinal(cipherText.getBytes());
            decryptedText = new String(byteDecryptedText);
            System.out.println("Cipher Data : " + cipherText + " \n Decrypted Data : " + decryptedText);
        }
        catch (Exception ex)
        {
            Logger.getLogger(Encryptor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return decryptedText;
    }
}
