package com.anonymous.encryption;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AnOnYmOuS
 */

public class Main implements classExtending {
    public static void main(String[] args) throws IOException, Exception{
   BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       System.out.println("Enter encrypt or decrypt");
       String input = bufferedReader.readLine().trim();
       classExtending obj = new Main();
       obj.Page(input);
       
    }

    @Override
    public void Page(String s) {
        if(s.equals("encrypt")){
            try {
                Encryption.Encrypt();
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        else{
            try {
                Decryption.Decrypt();
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
