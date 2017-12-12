/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Nick
 */
public class DatabaseUtil {
    
    public static boolean checkCredentials(String username, String password) 
    {
        try{
        Connection myConn = DriverManager.getConnection("jdbc:mysql://den1.mysql6.gear.host:3306/ibas?zeroDateTimeBehavior=convertToNull","ibas","Nc74Gk-!yU4c");
        Statement myStmt = myConn.createStatement();
        ResultSet myRs = myStmt.executeQuery("select * from account_details where username = '"+username+"' and password = '"+password+"'");

        if(myRs.first())
        {
            return true;
        } else {
        return false;
        }
    }
    catch (Exception exc) {
            exc.printStackTrace();
        }
    return false;
    }
}
