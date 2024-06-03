package OOP;
//iman

import java.awt.HeadlessException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CustomerSignUp extends javax.swing.JFrame {
Connection con = null;
ResultSet rs = null;
PreparedStatement pst = null;

    public CustomerSignUp() {
        initComponents();
        con=dbConnection.con();
        this.setLocationRelativeTo(null);
         
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jAnswer = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jCheckPass = new javax.swing.JCheckBox();
        jSQuestion = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jPhone = new javax.swing.JTextField();
        jEmail = new javax.swing.JTextField();
        jUName = new javax.swing.JTextField();
        jName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jCPassword = new javax.swing.JPasswordField();
        jPassword = new javax.swing.JPasswordField();
        jCheckPass2 = new javax.swing.JCheckBox();
        btnSignUp = new Project.MyButton();
        btnBackToCustomerLogin = new Project.MyButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jAnswer.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAnswerActionPerformed(evt);
            }
        });
        getContentPane().add(jAnswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 580, 310, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("ANSWER");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 580, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("SECURITY QUESTION");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 530, -1, -1));

        jCheckPass.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckPass.setText("View Password");
        jCheckPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckPassMouseClicked(evt);
            }
        });
        jCheckPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckPassActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, -1, -1));

        jSQuestion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is your nick name?", "What is  your school name?", "What is your mother tongue", "What is your hobby?", " " }));
        jSQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSQuestionActionPerformed(evt);
            }
        });
        getContentPane().add(jSQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 530, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("USERNAME");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 80, 40));

        jPhone.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPhoneActionPerformed(evt);
            }
        });
        getContentPane().add(jPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 470, 310, 30));

        jEmail.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        getContentPane().add(jEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 310, 30));

        jUName.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        getContentPane().add(jUName, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, 310, 30));

        jName.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        getContentPane().add(jName, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 310, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("CONFIRM PASSWORD");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("PASSWORD");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("PHONE NUMBER");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("EMAIL");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("NAME");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 50, 40));

        jCPassword.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jCPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(jCPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 400, 310, 30));

        jPassword.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(jPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, 310, 30));

        jCheckPass2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCheckPass2.setText("View Password");
        jCheckPass2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckPass2MouseClicked(evt);
            }
        });
        jCheckPass2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckPass2ActionPerformed(evt);
            }
        });
        getContentPane().add(jCheckPass2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 430, -1, -1));

        btnSignUp.setText("SIGN UP");
        btnSignUp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSignUpMouseClicked(evt);
            }
        });
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });
        getContentPane().add(btnSignUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 630, -1, -1));

        btnBackToCustomerLogin.setText("BACK");
        btnBackToCustomerLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackToCustomerLoginMouseClicked(evt);
            }
        });
        getContentPane().add(btnBackToCustomerLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Frame 7 (1).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jSQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSQuestionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSQuestionActionPerformed

    private void jCheckPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckPassActionPerformed

    private void jCheckPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckPassMouseClicked
        //to see password
        if(jCheckPass.isSelected()){
            jPassword.setEchoChar((char)0);
        }
        else
        {
            jPassword.setEchoChar('*');
        }        // 
    }//GEN-LAST:event_jCheckPassMouseClicked

    private void btnBackToCustomerLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackToCustomerLoginMouseClicked
        this.setVisible(false);
        new CustomerLogin().setVisible(true);
        // go back to customer login
    }//GEN-LAST:event_btnBackToCustomerLoginMouseClicked

    private void jCPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCPasswordActionPerformed

    private void jCheckPass2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckPass2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckPass2ActionPerformed

    private void jCheckPass2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckPass2MouseClicked
        //to see confirm password
        if(jCheckPass2.isSelected()){
            jCPassword.setEchoChar((char)0);
        }
        else
        {
            jCPassword.setEchoChar('*');
        }          
    }//GEN-LAST:event_jCheckPass2MouseClicked

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void btnSignUpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSignUpMouseClicked

        // Customer sign up
        String nam = jName.getText();
        String u_nam = jUName.getText();
        String email = jEmail.getText();
        String phone = jPhone.getText();
        String pass = jPassword.getText();
        String pass2 = jCPassword.getText();
        String security = (String)jSQuestion.getSelectedItem();
        String answer = jAnswer.getText();
        
         if(jName.getText().isEmpty() || jUName.getText().isEmpty() ||  jEmail.getText().isEmpty() || jPhone.getText().isEmpty() || jPassword.getText().isEmpty() ||
                 jCPassword.getText().isEmpty() ||jAnswer.getText().isEmpty() || !jPassword.getText().equals(jCPassword.getText()))
          {
              JOptionPane.showMessageDialog(null, "Fill in empty space or check your password");
              //check if there is any blank field
              //make sure password with confirm password is same
          }

         else // no empty space or password  matched
        {
            try{
                String sql = " INSERT INTO customerregister (Name, username, email, password, phonenumber, securityQ, answer)" 
                        +"VALUES ('"+nam+"','"+u_nam+"','"+email+"','"+pass+"','"+phone+"','"+security+"','"+answer+"')"; //insert data base on database
                pst = con.prepareStatement(sql);
 
                pst.executeUpdate(); //insert data into database
                JOptionPane.showMessageDialog(rootPane, "Your Account Created");

                this.setVisible(false); //this page close
                new CustomerLogin().setVisible(true); //go to customer login page

            } catch(Exception e){
                
                JOptionPane.showMessageDialog(rootPane, "Username already registed");
            }
        } 
    }//GEN-LAST:event_btnSignUpMouseClicked

    private void jAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAnswerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jAnswerActionPerformed

    private void jPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPhoneActionPerformed

    private void jPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerSignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Project.MyButton btnBackToCustomerLogin;
    private Project.MyButton btnSignUp;
    private javax.swing.JTextField jAnswer;
    private javax.swing.JPasswordField jCPassword;
    private javax.swing.JCheckBox jCheckPass;
    private javax.swing.JCheckBox jCheckPass2;
    private javax.swing.JTextField jEmail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jName;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField jPhone;
    private javax.swing.JComboBox<String> jSQuestion;
    private javax.swing.JTextField jUName;
    // End of variables declaration//GEN-END:variables
}
