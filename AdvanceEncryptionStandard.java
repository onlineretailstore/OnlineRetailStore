import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AdvanceEncryptionStandard {

	private static SecretKeySpec secretKeys;
    private static byte[] key;
 
    public static void setKey(String myKey) 
    {
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); 
            secretKeys = new SecretKeySpec(key, "AES");
        } 
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } 
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
 
    public static String encryptDetails(String encryptString, String secretKey) 
    {
        try
        {
            setKey(secretKey);
            Cipher cipherCode = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipherCode.init(Cipher.ENCRYPT_MODE, secretKeys);
            return Base64.getEncoder().encodeToString(cipherCode.doFinal(encryptString.getBytes("UTF-8")));
        } 
        catch (Exception e) 
        {
            System.out.println("Encryption error: " + e.toString());
        }
        return null;
    }
 
    public static String decryptDetails(String decryptString, String secretKey) 
    {
        try
        {
            setKey(secretKey);
            Cipher cipherCode = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipherCode.init(Cipher.DECRYPT_MODE, secretKeys);
            return new String(cipherCode.doFinal(Base64.getDecoder().decode(decryptString)));
        } 
        catch (Exception e) 
        {
            System.out.println("Decryption error: " + e.toString());
        }
        return null;
    }
}
