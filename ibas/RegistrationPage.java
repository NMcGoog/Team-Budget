package ibas;

// Imports
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
* Team Budget: Greg Holden, Raymond Hames, Nicholas McGoogan, Michael Lopez, 
Joshua Kennedy, Jonathan Davies
* Professor: David Castillo
* Course: CMSC 495 7982
* RegistrationPage.java: The "RegistrationPage" class adds JFrame components to JPanel that
allows a new user to be entered into the system.  The GUI variables used are JLabels and JTexts where the variable names correspond
to their function. The program checks to make sure that the "repeat" answers are matching so there
are no discrepancies.
*/

public class RegistrationPage extends JFrame {

        // Declare components
	JPanel panel;
	JLabel usernameLabel, passwordLabel, repeatPasswordLabel;
        JLabel securityQuestionLabel, securityAnswerLabel, repeatSecurityAnswerLabel;
	final JTextField usernameText, passwordText, repeatPasswordText;
        final JTextField securityQuestionText, securityAnswerText, repeatSecurityAnswerText;
	JButton SIGNUP;

	public RegistrationPage() {

                // Prompt user to enter username
		usernameLabel = new JLabel();
		usernameLabel.setText("Username:");
		usernameText = new JTextField(15);

                JLabel firstNameLabel = new JLabel("First Name:");
                JTextField firstNameText = new JTextField();
                
                JLabel lastNameLabel = new JLabel("Last Name:");
                JTextField lastNameText = new JTextField();                
                
                
                // Prompt user to enter password
		passwordLabel = new JLabel();
		passwordLabel.setText("Password:");
		passwordText = new JPasswordField(15);

                // Prompt user to re-enter password
		repeatPasswordLabel = new JLabel();
		repeatPasswordLabel.setText("Repeat Password:");
		repeatPasswordText = new JPasswordField(15);

                // Prompt user to enter security question
		securityQuestionLabel = new JLabel();
		securityQuestionLabel.setText("Security Question:");
		securityQuestionText = new JPasswordField(15);

                // Prompt user to enter answer to security question
		securityAnswerLabel = new JLabel();
		securityAnswerLabel.setText("Security Answer:");
		securityAnswerText = new JPasswordField(15);

                // Prompt user to re-enter answer to security question
		repeatSecurityAnswerLabel = new JLabel();
		repeatSecurityAnswerLabel.setText("Repeat Security Answer:");
		repeatSecurityAnswerText = new JPasswordField(15);

                // JButton that initiates registration
		SIGNUP = new JButton("Create Login");

                // Initialize JPanel "panel" with 4 rows and 4 columns
		panel = new JPanel(new GridLayout(5, 4));
                panel.add(firstNameLabel);
                panel.add(firstNameText);
                panel.add(lastNameLabel);
                panel.add(lastNameText);
		panel.add(usernameLabel);
		panel.add(usernameText);
		panel.add(passwordLabel);
		panel.add(passwordText);
		panel.add(repeatPasswordLabel);
		panel.add(repeatPasswordText);
		panel.add(securityQuestionLabel);
		panel.add(securityQuestionText);
		panel.add(securityAnswerLabel);
		panel.add(securityAnswerText);
		panel.add(repeatSecurityAnswerLabel);
		panel.add(repeatSecurityAnswerText);
		panel.add(SIGNUP);
                
                
                // Add action to "Create Login" button
		SIGNUP.addActionListener(new ActionListener() {

                        // During password re-entry, if passwords are not 
                        // identical, display error
			@Override
			public void actionPerformed(ActionEvent arg0) {
                                               
                                //usernameText
				String enteredUsername = SecurityUtil.sanitize(usernameText.getText());
                                String enteredFirstName = SecurityUtil.sanitize(firstNameText.getText());
                                String enteredLastName = SecurityUtil.sanitize(lastNameText.getText());
                                
                                boolean usernameExists = DatabaseUtil.checkForDuplicateUsername(enteredUsername);
                                if(usernameExists == true){
					JOptionPane.showMessageDialog(panel, "Username already exists",
							"Warning", JOptionPane.WARNING_MESSAGE);

					return;                                    
                                }
                                String enteredPassword = SecurityUtil.sanitize(passwordText.getText());
				String repeatPassword = SecurityUtil.sanitize(repeatPasswordText.getText());
				if (!enteredPassword.equals(repeatPassword)) {
					// Invalid input.
					JOptionPane.showMessageDialog(panel, "Passwords do not match",
							"Warning", JOptionPane.WARNING_MESSAGE);

					return;
				}
                                
                                if(enteredUsername.equals("")||enteredPassword.equals("")||enteredFirstName.equals("")||enteredLastName.equals(""))// || enteredPassword == null)
                                {
					JOptionPane.showMessageDialog(panel, "All information must be provided",
							"Warning", JOptionPane.WARNING_MESSAGE);

					return;                                    
                                }
                                else {
                                    System.out.println("Account Created");
                                }
			}
		});

                // Add panel to JFrame
		add(panel, BorderLayout.CENTER);
                // Title of panel is "Registration Form"
		setTitle("Registration Form");

	}

}
