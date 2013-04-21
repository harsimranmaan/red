/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adg.red.encryptor;

/**
 *
 * @author harsimran.maan
 */
public class EnDec
{

    private EnDec()
    {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        if (args.length == 2)
        {
            if (args[0].equals("-se"))
            {
                System.out.println(Encryptor.encryptSHA(args[1]));
            }
            else if (args[0].equals("-ae"))
            {
                System.out.println(Encryptor.encryptAES(args[1]));
            }
            else if (args[0].equals("-ad"))
            {
                System.out.println(Encryptor.decryptAES(args[1]));
            }
            else
            {
                System.out.println("Use -se, -ad or -ae switch followed by the string");
            }

        }
        else
        {
            System.out.println("Use -se, -ad or -ae switch followed by the string");
        }
    }
}
