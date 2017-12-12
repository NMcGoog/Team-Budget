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
				panel.setVisible(false);
			}
		});
		setTitle("LOGIN FORM");
	}

        /*
        This is where the users credentials are checked against the database
        */
	public void actionPerformed(ActionEvent ae) {
		String value1 = usernameText.getText();
		String value2 = passwordText.getText();
		/**
		 * Username:abc Password:abc Because no connection to database or any
		 * files. so this is just a static application.
		 */
		if (value1.equals("abc") && value2.equals("abc")) {
			MainPage page = new MainPage();
			page.setSize(900, 500);
			page.setVisible(true);
			panel.setVisible(false);
		} else {
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
                            //statement.executeUpdate("INSERT INTO account_details " + "VALUES (1, 'nick', 'nick', 1)");
                            
                            
                            while (myRs.next()){
                                System.out.println(myRs.getString("first_name") + " , " + myRs.getString("last_name"));
                            }
                            System.out.println("Made it through printing");
                            
                            
                        }
                        
                        catch (Exception exc) {
                            exc.printStackTrace();
                        }
                        
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}