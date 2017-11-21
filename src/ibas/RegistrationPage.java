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

public class RegistrationPage extends JFrame {

	JPanel panel;
	JLabel label1, label2, label3, label4, label5, label6;
	final JTextField text1, text2, text3, text4, text5, text6;
	JButton SIGNUP;

	public RegistrationPage() {

		label1 = new JLabel();
		label1.setText("Username:");
		text1 = new JTextField(15);

		label2 = new JLabel();
		label2.setText("Password:");
		text2 = new JPasswordField(15);

		label3 = new JLabel();
		label3.setText("Repeat Password:");
		text3 = new JPasswordField(15);

		label4 = new JLabel();
		label4.setText("Security Question:");
		text4 = new JPasswordField(15);

		label5 = new JLabel();
		label5.setText("Security Answer:");
		text5 = new JPasswordField(15);

		label6 = new JLabel();
		label6.setText("Repeat Security Answer:");
		text6 = new JPasswordField(15);

		SIGNUP = new JButton("Create Login");

		panel = new JPanel(new GridLayout(4, 4));
		panel.add(label1);
		panel.add(text1);
		panel.add(label2);
		panel.add(text2);
		panel.add(label3);
		panel.add(text3);
		panel.add(label4);
		panel.add(text4);
		panel.add(label5);
		panel.add(text5);
		panel.add(label6);
		panel.add(text6);
		panel.add(SIGNUP);

		SIGNUP.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String value1 = text2.getText();
				String value2 = text3.getText();
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
