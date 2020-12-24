/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement;

/**
 *
 * @author Phanasorn's PC
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class library {
    
    public static Connection con = null;
    public static int ID;
    
    
     public static Connection getConnection(){
     
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/librarymanagement", "root", "");
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(null, "Database Connection Failure, Please try again later,", "Alert",JOptionPane.WARNING_MESSAGE);
            System.exit(0);

        }
        
        return con;
    }
    
}
