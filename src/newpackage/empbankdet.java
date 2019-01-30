
import javax.swing.*;

import java.sql.*;
public class empbankdet extends javax.swing.JFrame {

    /** Creates new form saldetails */
    public empbankdet() {
        initComponents();
        try
       {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/paysquare","root","");
           ResultSet rs;
           Statement stmt = con.createStatement();
           rs = stmt.executeQuery("select * from emp ");
           int chk=0;
           while(rs.next())
           {
                choice3.add(rs.getString("id")); 
           }
           rs.close();
           stmt.close();
           con.close();           
       }
       catch(Exception e)
       {
           System.out.println("Exception occured " + e);
       }
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        choice3 = new java.awt.Choice();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Salary Details");
        setPreferredSize(new java.awt.Dimension(680, 460));
        getContentPane().setLayout(null);

        jLabel4.setText("Branch");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(122, 214, 42, 16);

        jLabel3.setText("Bank Name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(122, 154, 70, 16);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(285, 282, 110, 26);
        getContentPane().add(jTextField7);
        jTextField7.setBounds(285, 209, 110, 26);

        jLabel5.setText("IFSC CODE");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(122, 287, 67, 16);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2);
        jTextField2.setBounds(285, 88, 110, 26);

        jLabel1.setText("Id");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(122, 47, 12, 16);

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField3);
        jTextField3.setBounds(285, 145, 110, 26);

        jLabel2.setText("Account No");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(122, 90, 74, 16);

        jButton3.setText("Home");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(352, 375, 81, 29);

        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(262, 375, 78, 29);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(140, 375, 75, 29);
        getContentPane().add(choice3);
        choice3.setBounds(285, 43, 110, 20);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel13.setText("Employee Bank Details");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(189, 6, 263, 28);

        jLabel6.setIcon(new javax.swing.ImageIcon("/Users/Vineeth/Downloads/Webp.net-resizeimage-15.jpg")); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 0, 680, 460);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        setVisible(false);
        HomePage hp= new HomePage();
        hp.setVisible(true);
}//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String id=choice3.getSelectedItem();
            String acno=jTextField2.getText();
            String bn=jTextField3.getText();
            String br=jTextField7.getText();
            String ifs=jTextField4.getText();
            
            if(acno.equals("" )|| bn.equals("") || br.equals("")|| ifs.equals("")) {
                JOptionPane.showMessageDialog(null,"Fields Cannot be empty");
            } 
            else {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/paysquare","root",""); 
                Statement stmt = con.createStatement();
                
                PreparedStatement pstmt=con.prepareStatement("insert into saldetails values(?,?,?,?,?)");
                pstmt.setString(1,id);
                pstmt.setString(2,acno);
                pstmt.setString(3,bn);
                pstmt.setString(4,br);
                pstmt.setString(5,ifs);   
                    
                pstmt.executeUpdate();
                pstmt.close();              
                JOptionPane.showMessageDialog(null,"Saved Successfully");
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
}//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField7.setText("");
        jTextField4.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new empbankdet().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Choice choice3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}