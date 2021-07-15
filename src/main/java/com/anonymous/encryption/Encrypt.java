package com.anonymous.encryption;


import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


/**
 *
 * @author AnOnYmOuS
 */
public class Encrypt extends javax.swing.JFrame {

    private String filePathWithFileName;
    private String passWord;
    private String fileLocation;
    private String fileName;
    private String extension;

    public Encrypt() {
        initComponents();
    }
    private void Encryption() throws Exception{
   boolean sucess = Encryption.Encrypt(fileName,filePathWithFileName,fileLocation,passWord,extension);
   if(sucess){
   Mine mine = new Mine();
        mine.setVisible(true);
        close();
   }
    
    }
    public void close(){
    WindowEvent closeWindow = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }
    
    private static String reverseString(String extension){
        char c[]=extension.toCharArray();
        String reverse="";

        for(int i=c.length-1;i>=0;i--){
            reverse+=c[i];
            }
        return reverse;
    }
    private static String increaseAscii(String extension){
    char c[]=extension.toCharArray();
    String increasedAscii="";
        for(int i =0;i<extension.length();i++){
        increasedAscii += (char)((int)c[i]+1);
        }
        
        return increasedAscii;
    }
    
    public String getExtension(String fileName) {
    int index = fileName.lastIndexOf('.');
    String extension = null;
    if(index > 0) {
      extension = fileName.substring(index + 1);
    }
    extension = extension.trim();
    extension = reverseString(extension);
    extension = increaseAscii(extension);
        return extension;
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        fileSelect = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        password = new javax.swing.JTextField();
        lab = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("File Encryption");
        setAlwaysOnTop(true);
        setPreferredSize(new java.awt.Dimension(600, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        fileSelect.setText("Select File");
        fileSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileSelectActionPerformed(evt);
            }
        });
        getContentPane().add(fileSelect);
        fileSelect.setBounds(211, 102, 177, 54);

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(submitButton);
        submitButton.setBounds(201, 305, 181, 64);

        password.setFont(new java.awt.Font("Open Sans Extrabold", 1, 14)); // NOI18N
        password.setText("Enter Password");
        getContentPane().add(password);
        password.setBounds(174, 211, 239, 68);

        lab.setFont(new java.awt.Font("Open Sans Extrabold", 1, 18)); // NOI18N
        lab.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lab);
        lab.setBounds(217, 162, 155, 43);

        jLabel1.setIcon(new javax.swing.ImageIcon("/home/anonymous/Downloads/pexels-dan-nelson-4973899.jpg")); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 590, 470);

        setSize(new java.awt.Dimension(600, 500));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fileSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileSelectActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            filePathWithFileName = selectedFile.getAbsolutePath();
            fileName = selectedFile.getName();
            fileLocation = selectedFile.getParent();
            extension = getExtension(fileName);
            JOptionPane.showMessageDialog(this, extension);
            lab.setText(fileName);
            
        }
        
    }//GEN-LAST:event_fileSelectActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        passWord = password.getText();
        try {
            Encryption();
        } catch (Exception ex) {
            Logger.getLogger(Encrypt.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new Encrypt().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fileSelect;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lab;
    private javax.swing.JTextField password;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
