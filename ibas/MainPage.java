package ibas;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                
                interestRateButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        InterestRateCalculator calculator = new InterestRateCalculator();
				calculator.setSize(400, 400);
				calculator.setVisible(true);
				//panel.setVisible(false);                        
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });
                
                accountBalanceButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        AccountBalance balancePage = new AccountBalance();
				balancePage.setSize(400, 400);
				balancePage.setVisible(true);
				//panel.setVisible(false);                        
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });   
                
                createLoginButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CreateLogin updateLoginInfo = new CreateLogin();
				updateLoginInfo.setSize(600, 400);
				updateLoginInfo.setVisible(true);
				//panel.setVisible(false);                        
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });      
                
                directDepositButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DirectDeposit depositInfo = new DirectDeposit();
				depositInfo.setSize(400, 400);
				depositInfo.setVisible(true);
				//panel.setVisible(false);                        
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });        
                
                billPaymentButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        BillPayment billingInfo = new BillPayment();
				billingInfo.setSize(400, 400);
				billingInfo.setVisible(true);
				//panel.setVisible(false);                        
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });                      
                

	}
}
