package com.anonymous.encryption;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
/**
 *
 * @author AnOnYmOuS
 */

public class Decryption {
    private static String getFileName(String fileName){
    return fileName.substring(0, fileName.lastIndexOf('.'));
    }

    public static boolean Decrypt(String fileName,String filePathWithFileName,String fileLocation,String passWord,String extension) throws Exception {
    PBEKeySpec pbeKeySpec = new PBEKeySpec(passWord.toCharArray());
    SecretKeyFactory secretKeyFactory = SecretKeyFactory
        .getInstance("PBEWithMD5AndTripleDES");
    SecretKey secretKey = secretKeyFactory.generateSecret(pbeKeySpec);

    FileOutputStream fos;
        try (FileInputStream fis = new FileInputStream(filePathWithFileName)) {
            byte[] salt = new byte[8];
            fis.read(salt);
            PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt, 100);
            Cipher cipher = Cipher.getInstance("PBEWithMD5AndTripleDES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, pbeParameterSpec);
            fos = new FileOutputStream(fileLocation+"/"+getFileName(fileName)+"."+extension);
            byte[] in = new byte[64];
            int read;
            while ((read = fis.read(in)) != -1) {
                byte[] output = cipher.update(in, 0, read);
                if (output != null)
                    fos.write(output);
            }       byte[] output = cipher.doFinal();
            if (output != null)
                fos.write(output);
        }
    fos.flush();
    fos.close();
    System.out.println("Decrypted Sucessfully");
    return true;
  }
}