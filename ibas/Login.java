package ibas;
/**
* Team Budget: Greg Holden, Raymond Hames, Nicholas McGoogan, Michael Lopez, 
Joshua Kennedy, Jonathan Davies
* Professor: David Castillo
* Course: CMSC 495 7982
* Login.java: The "Login" class contains the main method. When run the GUI interface pops up and 
prompts the user with login information. Once login has been confirmed additional
options appear. JFrame components are used for login and sign up options.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class Login extends JFrame implements ActionListener {
	
        /*
            JButton's SUBMIT & SIGNUP are the buttons in the initial GUI.
            SUBMIT is for existing users so that they can log in to their accounts
            SIGNUP is for new users to set up their account initially.
    
            JLabel's consist of usernameLabel and passwordLabel, these do as 
            their suggest and are the labels for "Username:" and "Password:"
            in the GUI,
    
            JText's usernameText & passwordText, are the fields that the user 
            enters when populating their login information
        */
    
        // Delcare components for uername, password, submit, and signup
        JButton SUBMIT;
	JButton SIGNUP;
	JPanel panel;
	JLabel usernameLabel, passwordLabel;
	final JTextField usernameText, passwordText;

	Login() {
                // Initialize label for username
		usernameLabel = new JLabel();
		usernameLabel.setText("Username:");
                // Initialize text field for username
		usernameText = new JTextField(15);

                // Initialize password label
		passwordLabel = new JLabel();
		passwordLabel.setText("Password:");
                // Password field where password is entered
		passwordText = new JPasswordField(15);

                // Initialize JButtons for submit and sign up options
		SUBMIT = new JButton("SUBMIT");
		SIGNUP = new JButton("SIGN UP");

                // Initialize JPanel with 3 rows and 1 column
                // Add username, password, sign up, and submit
                // components to the panel along
		panel = new JPanel(new GridLayout(3, 1));
		panel.add(usernameLabel);
		panel.add(usernameText);
		panel.add(passwordLabel);
		panel.add(passwordText);
		panel.add(SIGNUP);
		panel.add(SUBMIT);
		add(panel, BorderLayout.CENTER);
                // Add action listener to sibmit and signup
		SUBMIT.addActionListener(this);
		SIGNUP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				RegistrationPage page=new RegistrationPage();
				page.setSize(900, 500);
				page.setVisible(true);
				panel.setVisible(true);
			}
		});
		setTitle("LOGIN FORM");
	}

        /*
        This is where the users credentials are checked against the database
        */
        @Override
	public void actionPerformed(ActionEvent ae) {
		String username = SecurityUtil.sanitize(usernameText.getText());
		String password = SecurityUtil.sanitize(passwordText.getText());
		/**
		 * Username:abc Password:abc Because no connection to database or any
		 * files. so this is just a static application.
		 */
                
                boolean correctLogin = false;
                        correctLogin = DatabaseUtil.checkCredentials(username, password);
                System.out.println(correctLogin);
                
                if (correctLogin == true) {
                        int userID = DatabaseUtil.getUserIDByUsername(username);
                        //System.out.println("user_id is " + userID);
			MainPage page = new MainPage(userID);
			page.setSize(900, 500);
			page.setVisible(true);
			panel.setVisible(false);
		}
                
                /*else if (username.equals("abc") && password.equals("abc")) {
			MainPage page = new MainPage();
			page.setSize(900, 500);
			page.setVisible(true);
			panel.setVisible(false);
		} */
                else {
			System.out.println("enter the valid username and password");
			JOptionPane.showMessageDialog(this, "Incorrect login or password",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}

/*
The main method where the GUI is called.
*/
class LoginDemo {
	public static void main(String args[]) {
		try {
			Login frame = new Login();
			frame.setSize(900, 500);
			frame.setVisible(true);
                        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
                        try {
                            
                            System.out.println("Made it to myConn");
                            //Connect to the DB
                            //Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ibas?zeroDateTimeBehavior=convertToNull","root","Bean1225");
                            
                            Connection myConn = DriverManager.getConnection("jdbc:mysql://den1.mysql6.gear.host:3306/ibas?zeroDateTimeBehavior=convertToNull","ibas","Nc74Gk-!yU4c");
                            
                            System.out.println("Connection established");
                            
                            //create a statement
                            Statement myStmt = myConn.createStatement();
                            //Execute SQL query
                            ResultSet myRs = myStmt.executeQuery("select * from account");
                            // Process the result set
                            
                            // create a Statement from the connection
                            Statement statement = myConn.createStatement();
                            // insert the data
                            //(user_id, first_name, last_name)    
                            //statement.executeUpdate("INSERT INTO account " + "VALUES (1, 'Nick', 'McGoogan')");  //(user_id, first_name, last_name)                         
                            //account_details = details_id, username, password, user_id
                            //statement.executeUpdate("INSERT INTO account_details " + "(details_id, username, password, user_id) " + "VALUES (3, 'nmcgoogan', 'ab', 1)");
                            //account = user_id, firstname, lastname, username, password
                            
                            //DatabaseUtil.populateDatabase();
                            
                            //balance = bal_id, user_id, available_balance
                            //statement.executeUpdate("INSERT INTO balance " + "(bal_id, user_id, available_balance) " + "VALUES (1, 1, 10000)");
                          
                            //String createAccountSQL = "INSERT INTO account " + "(user_id, first_name, last_name, username, password)" + "VALUES ('Raymond','Hames','lastName','"+username+"','"+password+"'";                            
                            //statement.executeUpdate("UPDATE balance " + "(bal_id, user_id, available_balance) " + "VALUES (1, 1, 10000)");                            
                            //String updateBalanceQuery = "update * from balance where bal_id = '"+bal_id+"' and password = '"+password+"'";
                            //String updateBalanceQuery = "update balance where bal_id = '1' set available_balance '7000'";
                            //int testInt = 8000;
                            //statement.executeUpdate("update balance set available_balance = '"+testInt+"' where bal_id = 1 ");                            
                            //DatabaseUtil.updateBalance(1, 12000.75);
                            while (myRs.next()){
                                System.out.println(myRs.getString("first_name") + " , " + myRs.getString("last_name") + " , " + myRs.getString("username"));
                            }
                            
                            Statement myStmt2 = myConn.createStatement();
                            ResultSet myRs2 = myStmt2.executeQuery("SELECT * FROM account_details ");
                            
                            while(myRs2.next()){
                                System.out.println(myRs2.getString("details_id") + " " + myRs2.getString("username") + " , " + myRs2.getString("password") + " , " + myRs2.getString("user_id"));
                            }
                            
                            Statement myStmt3 = myConn.createStatement();
                            ResultSet myRs3 = myStmt3.executeQuery("SELECT * FROM balance ");
                            
                            while(myRs3.next()){
                                System.out.println(myRs3.getString("available_balance") + " , " + myRs3.getString("bal_id"));
                            }                            
                                 
                            double testDouble = DatabaseUtil.getBalanceByBalID(1);
                            System.out.println(testDouble + " this is outputting results of getBalance");
                            System.out.println("Made it through printing");
                            
                            Statement myStmt4 = myConn.createStatement();
                            ResultSet myRs4 = myStmt4.executeQuery("SELECT COUNT(*) FROM account_details ");
                            while(myRs4.next()){
                                System.out.println(myRs4.getInt(1));
                            }                                   
                            
                            
                        }
                        
                        catch (Exception exc) {
                            exc.printStackTrace();
                        }
                        
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}