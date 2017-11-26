package ibas;

import javax.swing.*;

import java.awt.*;

/*
MainPage is the method where the user has successfully logged in and is accessing
the function of ibas.
*/

public class MainPage extends JFrame {
	JPanel panel;
	//JLabel label1;
	//JTextField text1;
        
        /*
        Button's are named after their function and will evenutally lead to 
        other functionality. Currently they are placeholders.
        */
	JButton interestRateButton, accountBalanceButton, createLoginButton, directDepositButton, billPaymentButton;

	public MainPage() {

		panel = new JPanel(new GridLayout(4, 4));

		interestRateButton = new JButton("Interest Rate Calculator");
		accountBalanceButton = new JButton("Overall Account Balance");
		createLoginButton = new JButton("Create Login");
		directDepositButton = new JButton("Direct Deposit Information");
		billPaymentButton = new JButton("Bill Payment Information");


		panel.add(interestRateButton);
		panel.add(accountBalanceButton);
		panel.add(createLoginButton);
		panel.add(directDepositButton);
		panel.add(billPaymentButton);

		add(panel, BorderLayout.CENTER);
		setTitle("Main Page");

	}
}
