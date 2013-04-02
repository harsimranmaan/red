/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author harsimran.maan
 */
public class Encryptor {

    private static String getString(byte[] digest) {
        StringBuilder hexString = new StringBuilder();

        for (int looper = 0; looper < digest.length; looper++) {
            String hex = Integer.toHexString(0xff & digest[looper]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

    public static String encrypt(String password) {
        String hash = password;
        try {
            MessageDigest md = md = MessageDigest.getInstance("SHA-1");
            md.update(password.getBytes());
            hash = getString(md.digest());

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Encryptor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hash;
    }
}
