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
public class Insert_Station extends javax.swing.JFrame {
    Connection con;
    Statement st;
    PreparedStatement ps;
    ResultSet rs;
    /**
     * Creates new form Insert_Station
     */
    public Insert_Station() {
        initComponents();
         try{
            Class.forName("oracle.jdbc.OracleDriver");
            //JOptionPane.showMessageDialog(this,"Driver Loaded!");
            try {
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","Mega477553");
                //JOptionPane.showMessageDialog(this,"Connected to Oracle database!");
            }
            catch (SQLException ex) {
                Logger.getLogger(Insert_Station.class.getName()).log(Level.SEVERE,null, ex);
                JOptionPane.showMessageDialog(this,ex.getMessage());
            }
        }
        catch(ClassNotFoundException ex){
            Logger.getLogger(Insert_Station.class.getName()).log(Level.SEVERE,null, ex);
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
        T_No = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Tr_No = new javax.swing.JTextField();
        St_Name = new javax.swing.JTextField();
        St_No = new javax.swing.JTextField();
        Dept_Time = new javax.swing.JTextField();
        Arr_Time = new javax.swing.JTextField();
        Insert = new javax.swing.JButton();
        Clear = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("INSERT STATION");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(160, 0, 154, 35);

        T_No.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        T_No.setText("Train No");
        getContentPane().add(T_No);
        T_No.setBounds(96, 47, 118, 29);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Station Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(96, 141, 118, 29);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Station No");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(96, 94, 118, 29);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Departure Time");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(96, 235, 118, 29);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Arrival Time");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(96, 188, 118, 29);
        getContentPane().add(Tr_No);
        Tr_No.setBounds(261, 47, 108, 29);
        getContentPane().add(St_Name);
        St_Name.setBounds(261, 141, 108, 29);
        getContentPane().add(St_No);
        St_No.setBounds(261, 94, 108, 29);
        getContentPane().add(Dept_Time);
        Dept_Time.setBounds(261, 235, 108, 29);
        getContentPane().add(Arr_Time);
        Arr_Time.setBounds(261, 188, 108, 29);

        Insert.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Insert.setText("Insert");
        Insert.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertActionPerformed(evt);
            }
        });
        getContentPane().add(Insert);
        Insert.setBounds(181, 295, 103, 32);

        Clear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Clear.setText("Clear");
        Clear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });
        getContentPane().add(Clear);
        Clear.setBounds(60, 345, 100, 32);

        Back.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Back.setText("Back");
        Back.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });
        getContentPane().add(Back);
        Back.setBounds(305, 345, 100, 32);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\SSN\\Downloads\\MP_Images\\18.jpeg")); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-180, 0, 710, 430);

        setSize(new java.awt.Dimension(474, 422));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void refresh(){
        Tr_No.setText("");
        St_No.setText("");
        St_Name.setText("");
        Arr_Time.setText("");
        Dept_Time.setText("");
    }
    private void InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertActionPerformed
        // TODO add your handling code here:
        try{
            String sql1 = "select * from STATIONS where tr_No = '"+Tr_No.getText()+"' and St_No = '"+St_No.getText()+"'";
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery(sql1);
            if(rs.next()){
                JOptionPane.showMessageDialog(this, "Train and Station Already Exists!");
            }
            else{
                if(Tr_No.getText().equals("") || St_No.getText().equals("") ||  St_Name.getText().equals("") || Arr_Time.getText().equals("")  || Dept_Time.getText().equals("") ){
                        JOptionPane.showMessageDialog(this,"Invalid Input!");
                }
                else{
                    try{
                        String sql ="insert into STATIONS values(?,?,?,?,?)";
                        ps=con.prepareStatement(sql);
                        ps.setString(1,Tr_No.getText());
                        ps.setString(2,St_No.getText());
                        ps.setString(3,St_Name.getText());
                        ps.setString(4,Arr_Time.getText());
                        ps.setString(5,Dept_Time.getText());
                        ps.execute();
                        JOptionPane.showMessageDialog(this,"STATION Inserted");
                    }
                    catch(SQLException ex){
                        Logger.getLogger(Insert_Station.class.getName()).log(Level.SEVERE,null, ex);
                        JOptionPane.showMessageDialog(this,ex.getMessage());
                    }
                    refresh(); 
                }
                
            }
        }
        catch(Exception ex){
           Logger.getLogger(Insert_User_Details.class.getName()).log(Level.SEVERE, null, ex);
           JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_InsertActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_ClearActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Admin Ad = new Admin();
        Ad.show();
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
            java.util.logging.Logger.getLogger(Insert_Station.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Insert_Station.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Insert_Station.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Insert_Station.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Insert_Station().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Arr_Time;
    private javax.swing.JButton Back;
    private javax.swing.JButton Clear;
    private javax.swing.JTextField Dept_Time;
    private javax.swing.JButton Insert;
    private javax.swing.JTextField St_Name;
    private javax.swing.JTextField St_No;
    private javax.swing.JLabel T_No;
    private javax.swing.JTextField Tr_No;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    // End of variables declaration//GEN-END:variables
}
