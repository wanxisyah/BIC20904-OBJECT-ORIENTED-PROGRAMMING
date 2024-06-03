package OOP;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class JConnection {
    public static Connection ConnectDB(){
        try{
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/project", "root", "");
            System.out.println("Connection Successful!");
            return con;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
}
