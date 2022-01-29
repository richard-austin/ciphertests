// Java program to create a
// asymmetric key

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import java.security.*;

// Class to create an asymmetric key
public class Asymmetric {

    private static final String RSA
            = "RSA";

    // Generating public and private keys
    // using RSA algorithm.
    public static KeyPair generateRSAKkeyPair()
            throws Exception
    {
        SecureRandom secureRandom
                = new SecureRandom();

        KeyPairGenerator keyPairGenerator
                = KeyPairGenerator.getInstance(RSA);

        keyPairGenerator.initialize(
                2048, secureRandom);

        return keyPairGenerator
                .generateKeyPair();
    }

    // Encryption function which converts
    // the plainText into a cipherText
    // using private Key.
    public static byte[] do_RSAEncryption(
            String plainText,
            PrivateKey privateKey)
            throws Exception
    {
        Cipher cipher
                = Cipher.getInstance(RSA);

        cipher.init(
                Cipher.ENCRYPT_MODE, privateKey);

        return cipher.doFinal(
                plainText.getBytes());
    }
    // De
    // cryption function which converts
    // the ciphertext back to the
    // original plaintext.
    public static String do_RSADecryption(
            byte[] cipherText,
            PublicKey publicKey)
            throws Exception
    {
        Cipher cipher
                = Cipher.getInstance(RSA);

        cipher.init(Cipher.DECRYPT_MODE,
                publicKey);
        byte[] result
                = cipher.doFinal(cipherText);

        return new String(result);
    }

    // Driver code
    public static void main(String args[])
            throws Exception
    {
        KeyPair keypair
                = generateRSAKkeyPair();
        String plainText = "This is the PlainText "
                + "I want to Encrypt using RSA.";

        byte[] cipherText
                = do_RSAEncryption(
                plainText,
                keypair.getPrivate());

        System.out.println(
                "Public Key is: "
                        + new String(Hex.encodeHex(keypair.getPublic().getEncoded())));

        System.out.println(
                "Private Key is: "
                        + new String(Hex.encodeHex(keypair.getPrivate().getEncoded())));
    }
}
