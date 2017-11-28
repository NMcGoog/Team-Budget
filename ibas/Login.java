package ibas;

/*
This is the main Java application. When run the GUI interface pops up and 
prompts the user with login information. Once login has been confirmed additional
options appear.
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


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
    
        JButton SUBMIT;
	JButton SIGNUP;
	JPanel panel;
	JLabel usernameLabel, passwordLabel;
	final JTextField usernameText, passwordText;

	Login() {
		usernameLabel = new JLabel();
		usernameLabel.setText("Username:");
		usernameText = new JTextField(15);

		passwordLabel = new JLabel();
		passwordLabel.setText("Password:");
		passwordText = new JPasswordField(15);

		SUBMIT = new JButton("SUBMIT");
		SIGNUP = new JButton("SIGN UP");

		panel = new JPanel(new GridLayout(3, 1));
		panel.add(usernameLabel);
		panel.add(usernameText);
		panel.add(passwordLabel);
		panel.add(passwordText);
		panel.add(SIGNUP);
		panel.add(SUBMIT);
		add(panel, BorderLayout.CENTER);
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
                        
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}