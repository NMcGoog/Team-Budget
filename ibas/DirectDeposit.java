
package ibas;

/**
* Team Budget: Greg Holden, Raymond Hames, Nicholas McGoogan, Michael Lopez, 
Joshua Kennedy, Jonathan Davies
* Professor: David Castillo
* Course: CMSC 495 7982
* DirectDeposit.java: The "DirectDeposit" class adds JFrame components to JPanel that
allows the customer to select savings/checking account for deposit, frequency 
of deposit, and the recurring date of deposit.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class DirectDeposit extends JFrame {
    // Declare JPanel "panel"
    JPanel panel;

    public DirectDeposit()
    {

        // Initialize JPanel with 8 rows and 2 columns
        panel = new JPanel (new GridLayout(8,2));

        // Initialize JLabel to display greeting to customer
        JLabel helloLabel = new JLabel("Hello" + " 'GET USERNAME'");
        JLabel blankLabel = new JLabel("");
        
        // JLabel prompting user to select account type
        JLabel accountLabel = new JLabel("Select Account Type");
        JLabel blankLabel2 = new JLabel("");

        // JButtons allowing user to select saving or checking account
        JRadioButton savingsRadioButton = new JRadioButton ("Savings Account");
        JRadioButton checkingRadioButton = new JRadioButton ("Checking Account");
        // Form checking and savings account buttons into button group
        ButtonGroup accountButtonGroup = new ButtonGroup();
        accountButtonGroup.add(savingsRadioButton);
        accountButtonGroup.add(checkingRadioButton);        
        
        // Prompt user to enter deposit amount
        JLabel depositBalanceLabel = new JLabel("Deposit Amount:");
        JTextField depositBalanceField = new JTextField();

        // Prompt user to select frequency of deposit
        JLabel recurringTypeLabel = new JLabel("Select Frequency:");
        JLabel blankLabel3 = new JLabel("");

        // Allow user to choose between one time deposit or recurring deposit
        JRadioButton oneTimeRadioButton = new JRadioButton ("One Time Deposit");
        JRadioButton recurringRadioButton = new JRadioButton ("Recurring Deposit");
        // Create button group for these two options
        ButtonGroup frequencyButtonGroup = new ButtonGroup();
        frequencyButtonGroup.add(oneTimeRadioButton);
        frequencyButtonGroup.add(recurringRadioButton);        
        
        // Prompt customer to enter recurring date for deposit
        JLabel recurringDateLabel = new JLabel("Recurring Date: ");
        JTextField recurringDateField = new JTextField();
        
        // Allow user to submit deposit via submit button
        JLabel blankLabel4 = new JLabel("");
        JButton submitButton = new JButton("Submit");
        
        // Add components to panel
        panel.add(helloLabel);
        panel.add(blankLabel);  
        panel.add(accountLabel);
        panel.add(blankLabel2);           
        panel.add(savingsRadioButton);
        panel.add(checkingRadioButton);
        panel.add(depositBalanceLabel);
        panel.add(depositBalanceField);
        panel.add(recurringTypeLabel);
        panel.add(blankLabel3);         
        panel.add(oneTimeRadioButton);
        panel.add(recurringRadioButton);  
        panel.add(recurringDateLabel);
        panel.add(recurringDateField); 
        panel.add(blankLabel4);
        panel.add(submitButton);         

        // Add panel to JFrame
        add(panel, BorderLayout.CENTER);
        // Title of panel is "Direct Deposit"
        setTitle("Direct Deposit");    
    }

}