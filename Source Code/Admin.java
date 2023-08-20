/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;
import javax.swing.*;
import java.sql.*;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author SSN
 */
public class Admin extends javax.swing.JFrame {
    Connection con;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
    /**
     * Creates new form Admin
     */
    public Admin() {
        initComponents();
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            //JOptionPane.showMessageDialog(this,"Driver Loaded!");
            try {
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Mega477553");
                //JOptionPane.showMessageDialog(this,"Connected to Oracle database!");
            }
            catch (SQLException ex) {
                Logger.getLogger(Admin.class.getName()).log(Level.SEVERE,null, ex);
                JOptionPane.showMessageDialog(this,ex.getMessage());
            }
        }
        catch(ClassNotFoundException ex){
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE,null, ex);
            JOptionPane.showMessageDialog(this,ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Insert_Address = new javax.swing.JButton();
        Insert_Train = new javax.swing.JButton();
        Delete_Train = new javax.swing.JButton();
        Insert_Station = new javax.swing.JButton();
        Delete_Station = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        Insert_Address.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Insert_Address.setText("Insert Address");
        Insert_Address.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Insert_Address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Insert_AddressActionPerformed(evt);
            }
        });
        getContentPane().add(Insert_Address);
        Insert_Address.setBounds(300, 250, 149, 38);

        Insert_Train.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Insert_Train.setText("Insert Train");
        Insert_Train.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Insert_Train.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Insert_TrainActionPerformed(evt);
            }
        });
        getContentPane().add(Insert_Train);
        Insert_Train.setBounds(50, 80, 149, 37);

        Delete_Train.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Delete_Train.setText("Delete Train");
        Delete_Train.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Delete_Train.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_TrainActionPerformed(evt);
            }
        });
        getContentPane().add(Delete_Train);
        Delete_Train.setBounds(300, 80, 149, 38);

        Insert_Station.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Insert_Station.setText("Insert Station");
        Insert_Station.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Insert_Station.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Insert_StationActionPerformed(evt);
            }
        });
        getContentPane().add(Insert_Station);
        Insert_Station.setBounds(50, 170, 145, 31);

        Delete_Station.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Delete_Station.setText("Delete Station");
        Delete_Station.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Delete_Station.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Delete_StationActionPerformed(evt);
            }
        });
        getContentPane().add(Delete_Station);
        Delete_Station.setBounds(300, 170, 149, 31);

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Insert Amount");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(50, 250, 157, 38);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("ADMIN");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(200, 20, 100, 37);

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setText("BACK");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(300, 340, 149, 36);

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setText("Display");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(50, 340, 157, 36);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\SSN\\Downloads\\MP_Images\\4.jpg")); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-3, 0, 510, 410);

        setSize(new java.awt.Dimension(513, 417));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Insert_AddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Insert_AddressActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Insert_User_Address UA = new Insert_User_Address();
        UA.show();
    }//GEN-LAST:event_Insert_AddressActionPerformed

    private void Insert_TrainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Insert_TrainActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Train_Insert Ti = new Train_Insert();
        Ti.show();
    }//GEN-LAST:event_Insert_TrainActionPerformed

    private void Delete_TrainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_TrainActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Delete_Train DT = new Delete_Train();
        DT.show();
    }//GEN-LAST:event_Delete_TrainActionPerformed

    private void Insert_StationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Insert_StationActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Insert_Station IS= new Insert_Station();
        IS.show();
    }//GEN-LAST:event_Insert_StationActionPerformed

    private void Delete_StationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Delete_StationActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Delete_Station DS= new Delete_Station();
        DS.show();
    }//GEN-LAST:event_Delete_StationActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Insert_Amount IA =new Insert_Amount();
        IA.show();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Login l = new Login();
        l.show();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Display D = new Display();
        D.call();
        D.show();
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Delete_Station;
    private javax.swing.JButton Delete_Train;
    private javax.swing.JButton Insert_Address;
    private javax.swing.JButton Insert_Station;
    private javax.swing.JButton Insert_Train;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}