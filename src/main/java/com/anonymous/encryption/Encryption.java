package com.anonymous.encryption;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
/**
 *
 * @author AnOnYmOuS
 */



public class Encryption {
    private static String getFileName(String fileName){
    return fileName.substring(0, fileName.lastIndexOf('.'));
    }

    static boolean Encrypt(String fileName,String filePathWithFileName,String fileLocation,String passWord,String extension) throws Exception {
    FileOutputStream outFile;

    try (FileInputStream inFile = new FileInputStream(filePathWithFileName)) {
        outFile = new FileOutputStream(fileLocation+"/"+getFileName(fileName)+"."+extension);
        PBEKeySpec pbeKeySpec = new PBEKeySpec(passWord.toCharArray());
        SecretKeyFactory secretKeyFactory = SecretKeyFactory
                .getInstance("PBEWithMD5AndTripleDES");
        SecretKey secretKey = secretKeyFactory.generateSecret(pbeKeySpec);
        byte[] salt = new byte[8];
        Random random = new Random();
        random.nextBytes(salt);
        PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt, 100);
        Cipher cipher = Cipher.getInstance("PBEWithMD5AndTripleDES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, pbeParameterSpec);
        outFile.write(salt);
        byte[] input = new byte[64];
        int bytesRead;
        while ((bytesRead = inFile.read(input)) != -1) {
            byte[] output = cipher.update(input, 0, bytesRead);
            if (output != null)
                outFile.write(output);
        }   byte[] output = cipher.doFinal();
        if (output != null)
            outFile.write(output);
    }
    outFile.flush();
    outFile.close();
    return true;
    
  }

    
    
}