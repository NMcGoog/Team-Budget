package ibas;

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
/*
    RegistrationPage class takes the information for a new user in the system.

    The GUI variables used are JLabels and JTexts where the variable names correspond
    to their function.

    The program checks to make sure that the "repeat" answers are matching so there
    are no discrepancies.
*/

public class RegistrationPage extends JFrame {

	JPanel panel;
	JLabel usernameLabel, passwordLabel, repeatPasswordLabel;
        JLabel securityQuestionLabel, securityAnswerLabel, repeatSecurityAnswerLabel;
	final JTextField usernameText, passwordText, repeatPasswordText;
        final JTextField securityQuestionText, securityAnswerText, repeatSecurityAnswerText;
	JButton SIGNUP;

	public RegistrationPage() {

		usernameLabel = new JLabel();
		usernameLabel.setText("Username:");
		usernameText = new JTextField(15);

		passwordLabel = new JLabel();
		passwordLabel.setText("Password:");
		passwordText = new JPasswordField(15);

		repeatPasswordLabel = new JLabel();
		repeatPasswordLabel.setText("Repeat Password:");
		repeatPasswordText = new JPasswordField(15);

		securityQuestionLabel = new JLabel();
		securityQuestionLabel.setText("Security Question:");
		securityQuestionText = new JPasswordField(15);

		securityAnswerLabel = new JLabel();
		securityAnswerLabel.setText("Security Answer:");
		securityAnswerText = new JPasswordField(15);

		repeatSecurityAnswerLabel = new JLabel();
		repeatSecurityAnswerLabel.setText("Repeat Security Answer:");
		repeatSecurityAnswerText = new JPasswordField(15);

		SIGNUP = new JButton("Create Login");

		panel = new JPanel(new GridLayout(4, 4));
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

		SIGNUP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String value1 = passwordText.getText();
				String value2 = repeatPasswordText.getText();
				if (!value1.equals(value2)) {
					// Invalid input.
					JOptionPane.showMessageDialog(panel, "Invalid information",
							"Inane warning", JOptionPane.WARNING_MESSAGE);

					return;
				}
			}
		});

		add(panel, BorderLayout.CENTER);
		setTitle("Registration Form");

	}

}
