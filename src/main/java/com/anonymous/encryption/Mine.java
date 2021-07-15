package com.anonymous.encryption;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author AnOnYmOuS
 */
public class Mine extends javax.swing.JFrame {

    
    public Mine() {
        initComponents();
    }


    public void close(){
    WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        encryptButton = new javax.swing.JButton();
        decryptButton = new javax.swing.JButton();
        CloseButton = new javax.swing.JButton();
        BackgroundImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("File Encryption");
        setPreferredSize(new java.awt.Dimension(600, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        encryptButton.setText("Encrypt");
        encryptButton.setCursor(new java.awt.Cursor(java.awt.Cursor.NW_RESIZE_CURSOR));
        encryptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                encryptButtonActionPerformed(evt);
            }
        });
        getContentPane().add(encryptButton);
        encryptButton.setBounds(216, 113, 153, 66);

        decryptButton.setText("Decrypt");
        decryptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decryptButtonActionPerformed(evt);
            }
        });
        getContentPane().add(decryptButton);
        decryptButton.setBounds(216, 316, 153, 67);

        CloseButton.setText("Close");
        CloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });
        getContentPane().add(CloseButton);
        CloseButton.setBounds(470, 440, 90, 50);

        BackgroundImage.setIcon(new javax.swing.ImageIcon("/home/anonymous/Downloads/pexels-pixabay-207580.jpg")); // NOI18N
        getContentPane().add(BackgroundImage);
        BackgroundImage.setBounds(0, 0, 600, 500);

        setSize(new java.awt.Dimension(610, 530));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void encryptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_encryptButtonActionPerformed
        Encrypt encrypt = new Encrypt();
        encrypt.setVisible(true);
        close();
    }//GEN-LAST:event_encryptButtonActionPerformed

    private void decryptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decryptButtonActionPerformed
        Decrypt decrypt = new Decrypt();
        decrypt.setVisible(true);
        close();
    }//GEN-LAST:event_decryptButtonActionPerformed

    private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseButtonActionPerformed
        // TODO add your handling code here:
        ImageIcon icon = new ImageIcon("src/images/exitImage.png");
    int input = JOptionPane.showConfirmDialog(null, "Do you want to exit", "Exit...",
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
    if(input == 0)
        System.exit(0);
    }//GEN-LAST:event_CloseButtonActionPerformed

   
    public static void main(String args[]) {
     
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mine().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BackgroundImage;
    private javax.swing.JButton CloseButton;
    private javax.swing.JButton decryptButton;
    private javax.swing.JButton encryptButton;
    // End of variables declaration//GEN-END:variables
}
