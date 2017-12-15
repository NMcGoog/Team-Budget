package ibas;

/**
* Team Budget: Greg Holden, Raymond Hames, Nicholas McGoogan, Michael Lopez, 
Joshua Kennedy, Jonathan Davies
* Professor: David Castillo
* Course: CMSC 495 7982
* BillPayment.java: The "BillPayment" class adds bill payment components 
to the JPanel. This allows the customer to select the account to send 
payment to and from, frequency of payment, and submit option for payment.
*/

// Imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class BillPayment extends JFrame {
    // Declare JPanel "panel"
    JPanel panel;

    public BillPayment(int user_id)
    {
        // Initialize panel to set 9 rows and 2 columns
        panel = new JPanel (new GridLayout(6,2));
	
        
	// Initialize JLabel 'helloLabel" to display greeting message
        String customerName = DatabaseUtil.getName(user_id);
        JLabel helloLabel = new JLabel("Hello " + customerName);
        JLabel blankLabel = new JLabel("");
        
	// Initialize JLabel "accountToPayLabel" to display
        // "Account to send Payment" message
        JLabel accountToPayLabel = new JLabel("Account to send Payment");
        // Initialize JTextField "accountToPayField"
        JTextField accountToPayField = new JTextField();
                
        
        JLabel accountLabel = new JLabel("Select Account to pay from:");
        JLabel blankLabel2 = new JLabel("");

        // Initialize JRadioButtons for checking and savings account options
        // Create button group or these options
        JRadioButton savingsRadioButton = new JRadioButton ("Savings Account");
        JRadioButton checkingRadioButton = new JRadioButton ("Checking Account");
        ButtonGroup accountButtonGroup = new ButtonGroup();
        accountButtonGroup.add(savingsRadioButton);
        accountButtonGroup.add(checkingRadioButton);    
        savingsRadioButton.setSelected(true);
        
        // Initialize JLabel for payment amount
        JLabel paymentBalanceLabel = new JLabel("Payment Amount:");
        // Initialize JTextField where payment balance will be displayed
        JTextField paymentBalanceField = new JTextField();

        // Initialize JLabel for payment frequency selection
        JLabel recurringTypeLabel = new JLabel("Select Frequency:");
        JLabel blankLabel3 = new JLabel("");

        // Initialize JRadioButton for one time payment
        JRadioButton oneTimeRadioButton = new JRadioButton ("One Time Payment");
        // Initialize JRadioButton for recurring payment
        JRadioButton recurringRadioButton = new JRadioButton ("Recurring Payment");
        // Create button group for payment frequency
        ButtonGroup frequencyButtonGroup = new ButtonGroup();
        frequencyButtonGroup.add(oneTimeRadioButton);
        frequencyButtonGroup.add(recurringRadioButton);        
        
        // Initialize JLabel and JTextField for the recurring payment date
        JLabel recurringDateLabel = new JLabel("Recurring Date: ");
        JTextField recurringDateField = new JTextField();
        
        JLabel blankLabel4 = new JLabel("");
        // Initialize JButton to submit payment
        JButton submitButton = new JButton("Submit");
        
        // Add elements to panel
        panel.add(helloLabel);
        panel.add(blankLabel); 
        panel.add(accountToPayLabel);
        panel.add(accountToPayField);        
        panel.add(accountLabel);
        panel.add(blankLabel2);           
        panel.add(savingsRadioButton);
        panel.add(checkingRadioButton);
        panel.add(paymentBalanceLabel);
        panel.add(paymentBalanceField);
        //panel.add(recurringTypeLabel);
        //panel.add(blankLabel3);         
        //panel.add(oneTimeRadioButton);
        //panel.add(recurringRadioButton);  
        //panel.add(recurringDateLabel);
        //panel.add(recurringDateField); 
        panel.add(blankLabel4);
        panel.add(submitButton);         
        
        // Add panel to frame
        add(panel, BorderLayout.CENTER);
        // Set title of panel as "Bill Payment"
        setTitle("Bill Payment");  
        
        submitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String accountToPayFieldString = accountToPayField.getText();
                String paymentBalanceFieldString = paymentBalanceField.getText();
                
                
                if(accountToPayFieldString.equals("")||paymentBalanceFieldString.equals(""))
                {
                    JOptionPane.showMessageDialog(panel, "Please fill in all information, account and balance required",
                                    "Warning", JOptionPane.WARNING_MESSAGE);
                    return;                         
                }
                
                if(savingsRadioButton.isSelected()) {
                   
                    double currentBalance = DatabaseUtil.getSavingAccountBalance(user_id);
                    double paymentAmount = Double.parseDouble(paymentBalanceFieldString);
                    
                    if(paymentAmount>currentBalance){
                        JOptionPane.showMessageDialog(panel, "Insufficient funds, please try again with an appropriate amount",
                                        "Warning", JOptionPane.WARNING_MESSAGE);
                        return;                             
                    }
                    
                    double newBalance = currentBalance - paymentAmount;
                    DatabaseUtil.updateSavingBalance(user_id, newBalance);
                    System.out.println("Payment of $" + paymentAmount + " has been sent from your Savings Account to account " + accountToPayFieldString);
                }
                
                if(checkingRadioButton.isSelected()) {
                   
                    double currentBalance = DatabaseUtil.getCheckingAccountBalance(user_id);
                    double paymentAmount = Double.parseDouble(paymentBalanceFieldString);
                    
                    if(paymentAmount>currentBalance){
                        JOptionPane.showMessageDialog(panel, "Insufficient funds, please try again with an appropriate amount",
                                        "Warning", JOptionPane.WARNING_MESSAGE);
                        return;                             
                    }
                    
                    double newBalance = currentBalance - paymentAmount;
                    DatabaseUtil.updateCheckingBalance(user_id, newBalance);
                    System.out.println("Payment of $" + paymentAmount + " has been sent from your Checking Account to account " + accountToPayFieldString);
                }                
            }
        });
    }
}
