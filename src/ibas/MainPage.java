package ibas;

import javax.swing.*;

import java.awt.*;

public class MainPage extends JFrame {
	JPanel panel;
	JLabel label1;
	JTextField text1;
	JButton btn1, btn2, btn3, btn4, btn5;

	public MainPage() {

		panel = new JPanel(new GridLayout(4, 4));

		btn1 = new JButton("Interest Rate Calculator");
		btn2 = new JButton("Overall Account Balance");
		btn3 = new JButton("Create Login");
		btn4 = new JButton("Direct Deposit Information");
		btn5 = new JButton("Bill Payment Information");


		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);

		add(panel, BorderLayout.CENTER);
		setTitle("Main Page");

	}
}
