package com.anonymous.encryption;
import java.io.FileInputStream;
import java.io.FileOutputStream;

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
    public static void main(String[] args) throws Exception {

    String password = "javapapers";
    PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray());
    SecretKeyFactory secretKeyFactory = SecretKeyFactory
        .getInstance("PBEWithMD5AndTripleDES");
    SecretKey secretKey = secretKeyFactory.generateSecret(pbeKeySpec);

    FileInputStream fis = new FileInputStream("/home/anonymous/Desktop/plainfile.desktop");
    byte[] salt = new byte[8];
    fis.read(salt);

    PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt, 100);

    Cipher cipher = Cipher.getInstance("PBEWithMD5AndTripleDES");
    cipher.init(Cipher.DECRYPT_MODE, secretKey, pbeParameterSpec);
    FileOutputStream fos = new FileOutputStream("/home/anonymous/Desktop/plainfile.txt");
    byte[] in = new byte[64];
    int read;
    while ((read = fis.read(in)) != -1) {
      byte[] output = cipher.update(in, 0, read);
      if (output != null)
        fos.write(output);
    }

    byte[] output = cipher.doFinal();
    if (output != null)
      fos.write(output);

    fis.close();
    fos.flush();
    fos.close();
  }
}