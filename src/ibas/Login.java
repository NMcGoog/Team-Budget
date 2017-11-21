package ibas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Login extends JFrame implements ActionListener {
	JButton SUBMIT;
	JButton SIGNUP;
	JPanel panel;
	JLabel label1, label2;
	final JTextField text1, text2;

	Login() {
		label1 = new JLabel();
		label1.setText("Username:");
		text1 = new JTextField(15);

		label2 = new JLabel();
		label2.setText("Password:");
		text2 = new JPasswordField(15);

		SUBMIT = new JButton("SUBMIT");
		SIGNUP = new JButton("SIGN UP");

		panel = new JPanel(new GridLayout(3, 1));
		panel.add(label1);
		panel.add(text1);
		panel.add(label2);
		panel.add(text2);
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

	public void actionPerformed(ActionEvent ae) {
		String value1 = text1.getText();
		String value2 = text2.getText();
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

class LoginDemo {
	public static void main(String args[]) {
		try {
			Login frame = new Login();
			frame.setSize(900, 500);
			frame.setVisible(true);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}