package med.voll.api.services;

import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class CryptoService {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";
    private static final byte[] KEY = "1234567890123456".getBytes(); // 16 bytes key
    private static final byte[] IV = "1234567890123456".getBytes();  // 16 bytes IV
    public String decrypt(String encryptedData) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(KEY, ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(IV);

        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);

        byte[] decodedValue = Base64.getDecoder().decode(encryptedData);
        byte[] decryptedVal = cipher.doFinal(decodedValue);

        return new String(decryptedVal, "UTF-8");
    }
    public String encrypt(String data) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(KEY, ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(IV);

        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);

        byte[] encryptedVal = cipher.doFinal(data.getBytes("UTF-8"));
        return Base64.getEncoder().encodeToString(encryptedVal);
    }
}
