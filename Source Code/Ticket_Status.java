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
import java.util.Date;
/**
 *
 * @author SSN
 */
public class Ticket_Status extends javax.swing.JFrame {
    Connection con;
    Statement st , st1 , st2, st3;
    PreparedStatement ps;
    ResultSet rs , rs1, rs2, rs3;
    /**
     * Creates new form Ticket_Status
     */
    public Ticket_Status() {
        initComponents();
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            //JOptionPane.showMessageDialog(this,"Driver Loaded!");
            try {
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Mega477553");
                //JOptionPane.showMessageDialog(this,"Connected to Oracle database!");
            }
            catch (SQLException ex) {
                Logger.getLogger(Ticket_Status.class.getName()).log(Level.SEVERE,null, ex);
                JOptionPane.showMessageDialog(this,ex.getMessage());
            }
        }
        catch(ClassNotFoundException ex){
            Logger.getLogger(Ticket_Status.class.getName()).log(Level.SEVERE,null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnr = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Tr_No = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Tr_Name = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Ticket_ID = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        No = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        status = new javax.swing.JTextField();
        Back = new javax.swing.JButton();
        clear = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("TICKET STATUS");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(190, 30, 190, 31);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enter PNR No");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(116, 76, 96, 34);

        pnr.setForeground(new java.awt.Color(255, 255, 255));
        pnr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnrActionPerformed(evt);
            }
        });
        getContentPane().add(pnr);
        pnr.setBounds(285, 76, 150, 37);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Train No");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(118, 145, 94, 31);

        Tr_No.setForeground(new java.awt.Color(255, 255, 255));
        Tr_No.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tr_NoActionPerformed(evt);
            }
        });
        getContentPane().add(Tr_No);
        Tr_No.setBounds(285, 146, 150, 31);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Train Name");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(118, 195, 94, 33);

        Tr_Name.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(Tr_Name);
        Tr_Name.setBounds(285, 195, 150, 33);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Ticket No");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(118, 246, 94, 31);

        Ticket_ID.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(Ticket_ID);
        Ticket_ID.setBounds(285, 247, 150, 31);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("No Of Passengers");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(116, 296, 120, 28);

        No.setForeground(new java.awt.Color(255, 255, 255));
        No.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoActionPerformed(evt);
            }
        });
        getContentPane().add(No);
        No.setBounds(285, 296, 150, 28);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Date Of Journey");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(116, 342, 120, 30);

        date.setForeground(new java.awt.Color(255, 255, 255));
        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });
        getContentPane().add(date);
        date.setBounds(285, 342, 150, 27);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ticket Status");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(116, 399, 131, 33);

        status.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(status);
        status.setBounds(285, 400, 150, 33);

        Back.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Back.setText("BACK");
        Back.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back);
        Back.setBounds(420, 460, 88, 34);

        clear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        clear.setText("CLEAR");
        clear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        getContentPane().add(clear);
        clear.setBounds(50, 460, 90, 30);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\SSN\\Downloads\\MP_Images\\10(2).jpeg")); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(-130, 0, 730, 530);

        setSize(new java.awt.Dimension(555, 533));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void refresh(){
        pnr.setText("");
        No.setText("");
        date.setText("");
        Ticket_ID.setText("");
        Tr_No.setText("");
        Tr_Name.setText("");
        status.setText("");
    }
    private void pnrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pnrActionPerformed
        // TODO add your handling code here:
        try{
            String sql1 = "select * from TICKET_BOOKS where TICKET_PNR = '"+pnr.getText()+"'";
            st1 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs1 = st1.executeQuery(sql1);
            if(rs1.next()){
                No.setText(rs1.getString(2));
                Date date1=rs1.getDate(7);
                date.setText(String.valueOf(date1));
                //System.out.println(date1);
                Ticket_ID.setText(pnr.getText());
                Tr_No.setText(rs1.getString(4));
                //System.out.println(date1);
                
                String sql2 = "select Tr_Name from TRAINS where Tr_No = '"+rs1.getString(4)+"'";
                st2 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                rs2 = st2.executeQuery(sql2);
                if(rs2.next()){
                    Tr_Name.setText(rs2.getString(1));
                }
        

                String s1 = "select Ti_Status from TICKET_STATUS where Ticket_PNR = '"+pnr.getText()+"'";
                st3 = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                rs3= st3.executeQuery(s1);
                //System.out.println(rs.getString(1));
                if(rs3.next()){
                    //System.out.println(rs4.getString(2));
                    status.setText(rs3.getString(1));
                }
            }
            else{
                JOptionPane.showMessageDialog(this, "Ticket Not Exists!");
            }
            
           
        }
        catch (SQLException ex) {
            Logger.getLogger(Book_Ticket.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        
    }//GEN-LAST:event_pnrActionPerformed

    private void Tr_NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tr_NoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tr_NoActionPerformed

    private void NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoActionPerformed

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_clearActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        this.dispose();
        User U = new User();
        U.show();
    }//GEN-LAST:event_BackActionPerformed

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
            java.util.logging.Logger.getLogger(Ticket_Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ticket_Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ticket_Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ticket_Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ticket_Status().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JTextField No;
    private javax.swing.JTextField Ticket_ID;
    private javax.swing.JTextField Tr_Name;
    private javax.swing.JTextField Tr_No;
    private javax.swing.JButton clear;
    private javax.swing.JTextField date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField pnr;
    private javax.swing.JTextField status;
    // End of variables declaration//GEN-END:variables
}
