package OOP;
//iman

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LoginForAdmin extends javax.swing.JFrame {
Connection con = null;
ResultSet rs = null;
PreparedStatement pst = null;

    /**
     * Creates new form LoginForAdmin
     */
    public LoginForAdmin() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        con=dbConnection.con();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myButton3 = new Project.MyButton();
        ckbox = new javax.swing.JCheckBox();
        myButton2 = new Project.MyButton();
        myButton1 = new Project.MyButton();
        jPass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        myButton3.setText("BACK");
        myButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, -1));

        ckbox.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ckbox.setText("View Password");
        ckbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ckboxMouseClicked(evt);
            }
        });
        getContentPane().add(ckbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 490, -1, -1));

        myButton2.setText("FORGOT PASSWORD");
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 550, -1, 30));

        myButton1.setText("LOGIN");
        myButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myButton1MouseClicked(evt);
            }
        });
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 550, 80, 30));
        getContentPane().add(jPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, 340, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("PASSWORD");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, 110, 50));
        getContentPane().add(jUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 340, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("USERNAME");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 110, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/adminlogin.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 919, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ckboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ckboxMouseClicked
 
        //view password
        if(ckbox.isSelected()){
            jPass.setEchoChar((char)0);
        }
        else
        {
            jPass.setEchoChar('*');
        }
    }//GEN-LAST:event_ckboxMouseClicked

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
        
        String un = jUsername.getText(); //field for username
        String ps = jPass.getText(); //field for password
        
        try{
            String sql = "SELECT * FROM adminlogin WHERE username=? AND password=? "; //compare username and password form database
            pst = con.prepareCall(sql); //callable statement. Allow us to get stored data from database
            pst.setString(1, un); //give data to username
            pst.setString(2,ps);  //give data to password

            rs=pst.executeQuery(); //take data from table

            if(rs.next()) //succes login
            {
                JOptionPane.showMessageDialog(rootPane, "Your Succefully Login ...");
                new OOPPanel().setVisible(true); // go to admin home
                this.setVisible(false);
                

            }else //error message
            {
                JOptionPane.showMessageDialog(rootPane, "Wrong Username or Password. Try again...");

            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginForAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_myButton1ActionPerformed

    private void myButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myButton1MouseClicked
    this.setVisible(false);
    new OOPPanel().setVisible(true);        //go to adminpage
    }//GEN-LAST:event_myButton1MouseClicked

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
       this.setVisible(true);
    new AdminForgotPassword().setVisible(true);     //admin forgot password
    }//GEN-LAST:event_myButton2ActionPerformed

    private void myButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton3ActionPerformed
      this.setVisible(false);
    new Welcome().setVisible(true); //go to welcome page
    }//GEN-LAST:event_myButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ckbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPass;
    private javax.swing.JTextField jUsername;
    private Project.MyButton myButton1;
    private Project.MyButton myButton2;
    private Project.MyButton myButton3;
    // End of variables declaration//GEN-END:variables
}
