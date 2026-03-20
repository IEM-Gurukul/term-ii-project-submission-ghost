package security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class EncryptionService {

    public static SecretKey generateKey() throws Exception{

        KeyGenerator generator=KeyGenerator.getInstance("AES");

        generator.init(128);

        return generator.generateKey();
    }

    public static String encrypt(String data,SecretKey key) throws Exception{

        Cipher cipher=Cipher.getInstance("AES");

        cipher.init(Cipher.ENCRYPT_MODE,key);

        byte[] encrypted=cipher.doFinal(data.getBytes());

        return Base64.getEncoder().encodeToString(encrypted);
    }
}