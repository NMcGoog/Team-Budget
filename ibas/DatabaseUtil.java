/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
        //Statement myStmt = myConn.createStatement();
        
        String passwordQuerySql = "select * from account_details where username = '"+username+"' and password = '"+password+"'";
        
        PreparedStatement passwordPreparedStatement = myConn.prepareStatement(passwordQuerySql);
        
        ResultSet myRs = passwordPreparedStatement.executeQuery(passwordQuerySql);
        //ResultSet myRs = myStmt.executeQuery("select * from account_details where username = '"+username+"' and password = '"+password+"'");

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
    
    public static boolean checkForDuplicateUsername(String username) 
    {
        try{
        Connection myConn = DriverManager.getConnection("jdbc:mysql://den1.mysql6.gear.host:3306/ibas?zeroDateTimeBehavior=convertToNull","ibas","Nc74Gk-!yU4c");
        //Statement myStmt = myConn.createStatement();
        
        String duplicateUsernameQuery = "select * from account_details where username = '"+username+"'";
        
        PreparedStatement passwordPreparedStatement = myConn.prepareStatement(duplicateUsernameQuery);
        
        ResultSet myRs = passwordPreparedStatement.executeQuery(duplicateUsernameQuery);
        //ResultSet myRs = myStmt.executeQuery("select * from account_details where username = '"+username+"' and password = '"+password+"'");

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
    
    //updateBalance to include 
    //public static void updateBalance(int bal_id, int user_id, double available_balance, double transaction)
    public static void updateBalance(int bal_id, double new_balance)    
    {
        try{
        Connection myConn = DriverManager.getConnection("jdbc:mysql://den1.mysql6.gear.host:3306/ibas?zeroDateTimeBehavior=convertToNull","ibas","Nc74Gk-!yU4c");
        
        //statement.executeUpdate("update balance set available_balance = '"+testInt+"' where bal_id = 1 ");                            
        String updateBalanceSQL = "update balance set available_balance = '"+new_balance+"' where bal_id = '"+bal_id+"' ";
        
        PreparedStatement balanceUpdatePreparedStatement = myConn.prepareStatement(updateBalanceSQL);
        
        balanceUpdatePreparedStatement.executeUpdate(updateBalanceSQL);

    }
    catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    
    public static double getBalanceByBalID(int bal_id)
    {
        try{
        Connection myConn = DriverManager.getConnection("jdbc:mysql://den1.mysql6.gear.host:3306/ibas?zeroDateTimeBehavior=convertToNull","ibas","Nc74Gk-!yU4c");
        //Statement myStmt = myConn.createStatement();
        
        String getBalanceSQL = "SELECT * FROM balance where bal_id = '"+bal_id+"'";
        
        PreparedStatement getBalancePreparedStatement = myConn.prepareStatement(getBalanceSQL);
        
        ResultSet myRs = getBalancePreparedStatement.executeQuery(getBalanceSQL);
        //ResultSet myRs = myStmt.executeQuery("select * from account_details where username = '"+username+"' and password = '"+password+"'");
      
        
        //System.out.println("THIS IS IN GET BALANCE" + myRs.getDouble("available_balance"));
        //return Double.parseDouble(myRs.getString("available_balance"));
        //String output = myRs.getString("available_balance");
            while(myRs.next()){
                return myRs.getDouble("available_balance");
            }             
        }
        
        catch (Exception exc) {
            exc.printStackTrace();
        }
        return 0;
    }
    
    public static double getBalanceByUserID(int user_id)
    {
        try{
        Connection myConn = DriverManager.getConnection("jdbc:mysql://den1.mysql6.gear.host:3306/ibas?zeroDateTimeBehavior=convertToNull","ibas","Nc74Gk-!yU4c");
        //Statement myStmt = myConn.createStatement();
        
        String getBalanceSQL = "SELECT * FROM balance where user_id = '"+user_id+"'";
        
        PreparedStatement getBalancePreparedStatement = myConn.prepareStatement(getBalanceSQL);
        
        ResultSet myRs = getBalancePreparedStatement.executeQuery(getBalanceSQL);

            while(myRs.next()){
                return myRs.getDouble("available_balance");
            }             
        }
        
        catch (Exception exc) {
            exc.printStackTrace();
        }
        return 0;
    }    
    
    public static int getUserIDByUsername(String username)
        {
            try{
                Connection myConn = DriverManager.getConnection("jdbc:mysql://den1.mysql6.gear.host:3306/ibas?zeroDateTimeBehavior=convertToNull","ibas","Nc74Gk-!yU4c");
                String getUserIDByUsernameSQL = "SELECT * FROM account_details where username = '"+username+"'";

                PreparedStatement getBalancePreparedStatement = myConn.prepareStatement(getUserIDByUsernameSQL);

                ResultSet myRs = getBalancePreparedStatement.executeQuery(getUserIDByUsernameSQL);
                
                    while(myRs.next()){
                        return myRs.getInt("user_id");
                    }             
                }

            catch (Exception exc) {
                exc.printStackTrace();
            }

        return 0;
    }
    
    public static String getName(int user_id)
        {
            try{
                Connection myConn = DriverManager.getConnection("jdbc:mysql://den1.mysql6.gear.host:3306/ibas?zeroDateTimeBehavior=convertToNull","ibas","Nc74Gk-!yU4c");
                String getNameSQL = "SELECT * FROM account where user_id = '"+user_id+"'";

                PreparedStatement getBalancePreparedStatement = myConn.prepareStatement(getNameSQL);

                ResultSet myRs = getBalancePreparedStatement.executeQuery(getNameSQL);
 
                    while(myRs.next()){
                        String name = myRs.getString("first_name").concat(" ").concat(myRs.getString("last_name"));
                        return name;
                    }             
                }

            catch (Exception exc) {
                exc.printStackTrace();
            }

        return null;
    }
    public static boolean createAccount(String username) 
    {
        try{
        Connection myConn = DriverManager.getConnection("jdbc:mysql://den1.mysql6.gear.host:3306/ibas?zeroDateTimeBehavior=convertToNull","ibas","Nc74Gk-!yU4c");
        //Statement myStmt = myConn.createStatement();
        
        String duplicateUsernameQuery = "select * from account_details where username = '"+username+"'";
        
        PreparedStatement passwordPreparedStatement = myConn.prepareStatement(duplicateUsernameQuery);
        
        ResultSet myRs = passwordPreparedStatement.executeQuery(duplicateUsernameQuery);
        //ResultSet myRs = myStmt.executeQuery("select * from account_details where username = '"+username+"' and password = '"+password+"'");

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
