package ibas;

// Imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
* Team Budget: Greg Holden, Raymond Hames, Nicholas McGoogan, Michael Lopez, 
Joshua Kennedy, Jonathan Davies
* Professor: David Castillo
* Course: CMSC 495 7982
* MainPage.java: The "MainPage" class is the method where the user has 
successfully logged in and is accessing the function of ibas. It adds JFrame 
components to JPanel that allow the customer to choose between interest rate
calculator, account balance, create login, direct deposit, and bill payment.
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

	//public MainPage(int user_id) {
        
	public MainPage(int user_id) {

                // Initialize JPanel with 4 rows and 4 columns
		panel = new JPanel(new GridLayout(4, 4));

                // Initialize JButtons for Interest rate calculator, 
                // overall account balance, create login, direct 
                // deposit information, and bill payment information
		interestRateButton = new JButton("Interest Rate Calculator");
		accountBalanceButton = new JButton("Overall Account Balance");
		createLoginButton = new JButton("Create Login");
		directDepositButton = new JButton("Direct Deposit Information");
		billPaymentButton = new JButton("Bill Payment Information");


                // Add JButtons to panel for Interest rate calculator, 
                // overall account balance, create login, direct 
                // deposit information, and bill payment information		
                panel.add(interestRateButton);
		panel.add(accountBalanceButton);
		panel.add(createLoginButton);
		panel.add(directDepositButton);
		panel.add(billPaymentButton);

                // Add panel to JFrame
		add(panel, BorderLayout.CENTER);
                // Set title of panel as "Main Page"
		setTitle("Main Page");
                
                // Add action listener to interest rate calculator button
                // Set size and visibility
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
                
                // Add action listener to account balance button
                // Set size and visibility
                accountBalanceButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        AccountBalance balancePage = new AccountBalance(user_id);
				balancePage.setSize(400, 400);
				balancePage.setVisible(true);
				//panel.setVisible(false);                        
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });   
                
                // Add action listener to create login button
                // Set size and visibility
                createLoginButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        UpdateLogin updateLoginInfo = new UpdateLogin(user_id);
				updateLoginInfo.setSize(600, 400);
				updateLoginInfo.setVisible(true);
				//panel.setVisible(false);                        
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });      
                
                // Add action listener to direct deposit button
                // Set size and visibility
                directDepositButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DirectDeposit depositInfo = new DirectDeposit(user_id);
				depositInfo.setSize(400, 400);
				depositInfo.setVisible(true);
				//panel.setVisible(false);                        
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });        
                
                    // Add action listener to bill payment button
                    // Set size and visibility                
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
