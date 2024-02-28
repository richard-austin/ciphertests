// Java program to create a
// asymmetric key


import javax.crypto.Cipher;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import java.security.*;
import java.security.spec.MGF1ParameterSpec;

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
        Asymmetric as = new Asymmetric();
        as.decrypt();
        return;
//        KeyPair keypair
//                = generateRSAKkeyPair();
//        String plainText = "This is the PlainText "
//                + "I want to Encrypt using RSA.";
//
//        byte[] cipherText
//                = do_RSAEncryption(
//                plainText,
//                keypair.getPrivate());
//
//        System.out.println(
//                "Public Key is: "
//                        + new String(Hex.encodeHex(keypair.getPublic().getEncoded())));
//
//        System.out.println(
//                "Private Key is: "
//                        + new String(Hex.encodeHex(keypair.getPrivate().getEncoded())));
    }

    /**
     * decrypt: Decrypt data sent from javascript with the code below: -
     * <pre>
     * function testit() {
     *   const publicKeyB64 = `MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAk9jVbHCjk0/dfSHgJ1MKZEMwTQASHgFf/11DrBBGb8xinUazwCefee2vy1SuMchVTpp1HitX5onJPejBBnbgYQKuXMzzY8HK16Ou9sdIIfiiPCZF/h+qWMRRWck2c3my84HpiL80fnr1U/5I5r0CLp+eblhwufpp+u0bFgTmJdhDggHzg2tBPBWkdpeTgBVg9mfwgs1IOQWmpuZvBw9l+aVyyJFz8ZFqAlejG17BvsKHv1IU/Akp9eOcXEnBJL8ZdDfvNXVfFhbdWhkOl1sJI4BEp3f18uC0jepOLiou1gVE3DIiErRBIhX5hMYRKEHnEJ/xk4yeDcqWt3dgvgjj68saMj51TBk4BwuBEVKTVwBaEwSQGI4FUih1gFPUfgNKeVGfoWX8MLHNqJhtCQ/JD+L/v/vW9K3Xxc5tmxAsrWo0GV+b02wpyCyNRLSNfk6UuPShrO28GaDXIQYgIJvFgTwD55u/PKKhdnXBTQsa/Id6K2AigsIskMiyUDvqO31ftP9cqD2HwEmHkMpTB/B6I6f32OYXDKfdJ4hznzmBDt03FlXXQCPKjXwrtg4jGT/vCBP1uM3xdX6I7mS18lyRJNUjJUhBkSRma6815PAvQXTf2GAPNiLyUcTZuqJVeYQNLQeMOu0eWRQt9R/UcR/bQ45dhSv1UEHERd9tlp0QqRcCAwEAAQ==`;
     * //Convert the public key in base 64 (DER encoded) to array buffer
     *   const publicKeyAB = str2ab(atob(publicKeyB64.replace('/\s/g', '')));
     * //import key to encrypt with RSA-OAEP
     *   crypto.subtle.importKey(
     *     "spki",
     *     publicKeyAB,
     *     {name: "RSA-OAEP", hash: {name: "SHA-256"}},
     *     false,
     *     ["encrypt"])
     *     .then(function (key) {
     *       //do something with the key
     *       encryptMessage(key);
     *
     *       function encryptMessage(publicKey: CryptoKey) {
     *         const enc = new TextEncoder();
     *         const encoded = enc.encode("Message to encrypt:P@55wor%$d");
     *         return window.crypto.subtle.encrypt(
     *           {
     *             name: "RSA-OAEP",
     *           },
     *           publicKey,
     *           encoded,
     *         ).then((result: ArrayBuffer) => {
     *           let binary = '';
     *           let bytes = new Uint8Array(result);
     *           let len = bytes.byteLength;
     *           for (let i = 0; i < len; i++) {
     *             binary += String.fromCharCode(bytes[i]);
     *           }
     *           const str = window.btoa(binary);
     *           const y = str.trim();
     *         });
     *       }
     *
     *     }).catch(function (err) {
     *     console.log(err);
     *   });
     *
     * }
     * </pre>
     */
    public String decrypt() {
        try {
            final String base64 = "FNpjYvms+5Fy3XC6RInqixWshz9BsMz1ill1DhYo8T+IkGBLYLsLfqc54wzXPaZK67TRCr38/oCnlDFIENxUVlRrGmStzMp0ohvUjhyvVWWc6PDjTeSfx1zuckOb2DTsn+2BYIo/zZNIot4KlBUZ7TcdVOvu8rrcKMGWUCy067g8H0OgcS/n0/w8eXDXwIvQpkc9pBu8LtqZodFOGDTnyJcr/ia9LH1nu1EGjw10hl1jfJ6vGAQM181UPEqmvZIwt/jXyBb2sR2SiI6Ajz7Mdfgc0i6YlWATJD/DG68rgQggNg1Qn+7xFjBlncTYgw2Im75m4hC46YUejlk6Y6FME4lvEmsiVP3ZhVp+Ysfwb6oQL9TedoxIZjCLtuvNTqV+YwlrTFsgK5/YNmPBbBEmZRJt3Ctmbr6YtMwqpQpQDnZxswDFroriT8ZBpT8iXzf+1NuIDGaKOMNqHSNPv+8IcvxFnxj9rYY3mRKNdNj65aUMVCt+VlRj0TmtjmEL5brcxhymmbNow68rGvnlpErgt2twk8BtFFDD1dd03uNtg373Uo4t9TEHwFWd7FrlSrhBdqQtB8oRopR+hP7EdLKomFRYbjN3oBhYa4iahWLMH6h0KUeoYqoDnSt2au0Gmp9iE3/5e9Xb/haydIB3qmsnHrYBW4JoNkKEAxoC0dphH+c=";
            byte[] bytes = java.util.Base64.getDecoder().decode(base64);
            AsymmetricCryptography ac = new AsymmetricCryptography();
            PrivateKey privateKey = ac.getPrivate("/home/richard/cloud-server/xtrn-files-and-config/privateKey");
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            OAEPParameterSpec oaepParameterSpecJCE = new OAEPParameterSpec("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, PSource.PSpecified.DEFAULT);
            cipher.init(Cipher.DECRYPT_MODE, privateKey, oaepParameterSpecJCE);
            byte[] result = cipher.doFinal(bytes, 0, bytes.length);
            String x = new String(result, "UTF8");
            String y = x;
//        String decryptedId = ac.decryptText(encryptedId, privateKey);
        }
        catch (Exception ex) {
            String msg = ex.getMessage();
            String x = msg;
        }
        return "decryptedId";

    }
}
