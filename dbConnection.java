package OOP;
import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.SQLException;


public class dbConnection {
    
   
    public static Connection con(){
        Connection con = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root","");
             
        }catch (ClassNotFoundException | SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return con;
    }
}