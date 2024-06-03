package OOP;
//iman

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Vector;
import javax.swing.JOptionPane;
import java.awt.print.*;
import java.text.*;

import OOP.UserHome;
import OOP.UserBook;
import java.text.MessageFormat;
import javax.swing.JTable;

public class UserViewBook extends javax.swing.JFrame {
    
    String username;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    public UserViewBook() {
        initComponents();
        con=dbConnection.con();
        this.setLocationRelativeTo(null);
        
    }

    UserViewBook(String username) {
        // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
       this();
       this.username = username; //assign data
   
     
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myButton1 = new Project.MyButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        usertable = new javax.swing.JTable();
        myButton2 = new Project.MyButton();
        cuba = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        myButton1.setText("show data");
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 620, -1, -1));

        usertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "username", "name", "email", "phone_number", "checkin", "checkout", "room", "address"
            }
        ));
        jScrollPane1.setViewportView(usertable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1130, 530));

        myButton2.setText("BACK");
        myButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(myButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 90, 20));

        cuba.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        cuba.setForeground(new java.awt.Color(255, 255, 255));
        cuba.setText("MyReservation");
        getContentPane().add(cuba, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 340, 70));

        jLabel1.setBackground(new java.awt.Color(55, 71, 79));
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 1180, 705));

        setSize(new java.awt.Dimension(1199, 750));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
      
      //try to run the task
      try{
          
          Class.forName("com.mysql.jdbc.Driver");
          Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root",""); //connection
          Statement st = con.createStatement(); //create Statement
             //take data from database
             String sql = ("select *from  guestbook where username ='"+username+"'"); //take data from dbase
          ResultSet rs = st.executeQuery(sql);
          
          //data into table
          while(rs.next())
          {
              String username = rs.getString(2);
              String name = rs.getString(3);
              String email = rs.getString(4);
              String phone = rs.getString(5);
              String checkin = rs.getString(6);
              String checkout = rs.getString(7);
              String room = rs.getString(8);
              String address = rs.getString(9);
              
              String tbData[] = {username,name,email,phone,checkin,checkout,room,address}; //set table
              DefaultTableModel tblModel = (DefaultTableModel)usertable.getModel();
              
              tblModel.addRow(tbData);
          }
        
      //error message if try error    
      }catch(Exception e)
      {
          JOptionPane.showMessageDialog(this, e);
      }
      
    }//GEN-LAST:event_myButton1ActionPerformed

    private void myButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton2ActionPerformed
        this.setVisible(false);
        new UserHome().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_myButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(UserViewBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserViewBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserViewBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserViewBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserViewBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cuba;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private Project.MyButton myButton1;
    private Project.MyButton myButton2;
    private javax.swing.JTable usertable;
    // End of variables declaration//GEN-END:variables
}
