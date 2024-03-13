package org.example;

import javax.crypto.*;
import java.io.File;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Crypt {
    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IllegalStateException {
        File file = new File("C:\\Users\\User\\Downloads\\glfw-3.4");
        Cipher encryptcipher = Cipher.getInstance("AES");
        KeyGenerator key = KeyGenerator.getInstance("AES");
        key.init(128); // как я понял 128 байт
        SecretKey secretKey = key.generateKey();
        encryptcipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] bytes = encryptcipher.doFinal(file.getPath().getBytes());
        for (byte a : bytes) {
            System.out.print(a);
            }
            Cipher decryptcipher = Cipher.getInstance("AES");
            decryptcipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptB = decryptcipher.doFinal(bytes);
            System.out.println();
            for (byte a : decryptB) {
                System.out.print((char) a);
            }
        }
    }
