package OOP;
//iman

import java.awt.HeadlessException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.util.Date;
import java.text.*;

public class UserBook extends javax.swing.JFrame {
Connection con = null;
ResultSet rs = null;
PreparedStatement pst = null;
   String username;

    public UserBook() {
        initComponents();
        con=dbConnection.con();
        updateRoom();
        
        this.setLocationRelativeTo(null);
    }

    //use to get data username from UserHome frame
    UserBook(String username) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        this();
        this.username = username;
        jusername.setText(username);
    }
    
    //get available room from database
    private void updateRoom()
    {
        String sql = "select * from properties_listings where Availability = 'Yes' and Status = 'Not Booked' ";
        try
        {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next())
              jrumah.addItem(rs.getString("House_Name"));
        }catch(Exception e)
        {
            
        }
    }

public void name()
{
    
        String username = jusername.getText();
        String name = jname.getText();
        String email = jemail.getText();
        String phone = jphone.getText();
        String rumah = (String) jrumah.getSelectedItem();
        String ddate = null;
        String status = "Not Booked";
        String address = jalamat.getText();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String datein = sdf.format(jdatein.getDate());
        String dateout = sdf.format(jdateout.getDate()); 
         if(jname.getText().isEmpty() ||jemail.getText().isEmpty() ||jphone.getText().isEmpty())
                {
        JOptionPane.showMessageDialog(rootPane, "Fill in the detail");
        }
        else if(datein.equals(dateout))
        {
            
             JOptionPane.showMessageDialog(rootPane, "Choose other check out date");
             
        }else if (dateout.compareTo(datein)<0)
        {
            JOptionPane.showMessageDialog(rootPane, "Choose other check out date");
        }
                
        else
        { 
            
            try{
                String sql = " INSERT INTO guestbook (username,name, email, phone_number, checkin, checkout, room,address, status)" 
                        +"VALUES ('"+username+"','"+name+"','"+email+"','"+phone+"','"+datein+"','"+dateout+"','"+rumah+"','"+address+"','"+status+"')";
                pst = con.prepareStatement(sql);
                
               pst.executeUpdate();
              
              
            JOptionPane.showMessageDialog(rootPane, "Booked Succefully");
              this.setVisible(false);
              new UserHome(username).setVisible(true); //go to customer login page
                
            } catch(HeadlessException | SQLException e){
                System.out.println("Room not available ");
            }
               
        }  
         

}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jalamat = new javax.swing.JTextField();
        jusername = new javax.swing.JTextField();
        jrumah = new javax.swing.JComboBox<>();
        jdateout = new com.toedter.calendar.JDateChooser();
        myButton3 = new Project.MyButton();
        myButton2 = new Project.MyButton();
        jdatein = new com.toedter.calendar.JDateChooser();
        myButton1 = new Project.MyButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jphone = new javax.swing.JTextField();
        jemail = new javax.swing.JTextField();
        jname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setText("USERNAME");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 70, 30));

        jalamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jalamatActionPerformed(evt);
            }
        });
        getContentPane().add(jalamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 420, 70));

        jusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jusernameActionPerformed(evt);
            }
        });
        getContentPane().add(jusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 270, -1));

        jrumah.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-SELECT-" }));
        jrumah.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jrumahPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        jrumah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrumahActionPerformed(evt);
            }
        });
        getContentPane().add(jrumah, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 380, -1));
        getContentPane().add(jdateout, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 130, -1));

        myButton3.setText("BACK");
        myButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 680, 70, 30));

        myButton2.setText("AUTO FILL IN");
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, -1, -1));
        getContentPane().add(jdatein, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 280, 130, -1));

        myButton1.setText("BOOK");
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 530, 110, 30));

        jLabel10.setText("ROOM");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 70, 30));

        jLabel9.setText("CHECK OUT");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 70, 30));

        jLabel8.setText("CHECK IN");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 70, 30));

        jLabel7.setText("PHONE NUMBER");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 110, 30));

        jphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jphoneActionPerformed(evt);
            }
        });
        getContentPane().add(jphone, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 270, -1));
        getContentPane().add(jemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 270, -1));
        getContentPane().add(jname, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 270, -1));

        jLabel4.setText("EMAIL");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 70, 30));

        jLabel6.setText("NAME");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 70, 30));

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 850, 610));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BOOK YOUR GUESTHOUSE");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 200, 40));

        jLabel2.setBackground(new java.awt.Color(55, 71, 79));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrumahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrumahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrumahActionPerformed

    private void jphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jphoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jphoneActionPerformed

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
      
           name(); 
    }//GEN-LAST:event_myButton1ActionPerformed

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
       String username = jusername.getText();
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //driver connector
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root",""); //connect with table
            Statement st = con.createStatement(); //create Statement
            ResultSet rs = st.executeQuery("select *from customerregister where username ='"+username+"'"); //take data from database
            
            if(rs.next())
            {
                jname.setText(rs.getString(2));
                jemail.setText(rs.getString(4));
                jphone.setText(rs.getString(5));
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Please write correct Username");
                con.close();
                rs.close();
            }
            
        }catch (ClassNotFoundException | SQLException e)
        {
           JOptionPane.showMessageDialog(null, e); 
        }   
    }//GEN-LAST:event_myButton2ActionPerformed

    private void jusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jusernameActionPerformed

     
    }//GEN-LAST:event_jusernameActionPerformed

    private void jrumahPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jrumahPopupMenuWillBecomeInvisible
      //show address of guesthouse that user choose
        
        String tmp = (String)jrumah.getSelectedItem();
        String sql = "select * from properties_listings where House_Name=?";
        try{
            pst = con.prepareStatement(sql);
            pst.setString(1, tmp);
            rs = pst.executeQuery();
            if(rs.next())
            {
                String add1 = rs.getString("House_Address");
                jalamat.setText(add1);
            }
            
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Wrong dude"); 
        }
    }//GEN-LAST:event_jrumahPopupMenuWillBecomeInvisible

    private void jalamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jalamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jalamatActionPerformed

    private void myButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton3ActionPerformed
        this.setVisible(false);
        new UserHome().setVisible(true);
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
            java.util.logging.Logger.getLogger(UserBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jalamat;
    private com.toedter.calendar.JDateChooser jdatein;
    private com.toedter.calendar.JDateChooser jdateout;
    private javax.swing.JTextField jemail;
    private javax.swing.JTextField jname;
    private javax.swing.JTextField jphone;
    private javax.swing.JComboBox<String> jrumah;
    private javax.swing.JTextField jusername;
    private Project.MyButton myButton1;
    private Project.MyButton myButton2;
    private Project.MyButton myButton3;
    // End of variables declaration//GEN-END:variables
}
