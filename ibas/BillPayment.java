/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ibas;

/**
 *
 * @author Nick
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class BillPayment extends JFrame {
    
    JPanel panel;

    public BillPayment()
    {
        panel = new JPanel (new GridLayout(9,2));

        JLabel helloLabel = new JLabel("Hello" + " 'GET USERNAME'");
        JLabel blankLabel = new JLabel("");
        
        JLabel accountToPayLabel = new JLabel("Account to send Payment");
        JTextField accountToPayField = new JTextField();
                
        JLabel accountLabel = new JLabel("Select Account to pay from:");
        JLabel blankLabel2 = new JLabel("");

        JRadioButton savingsRadioButton = new JRadioButton ("Savings Account");
        JRadioButton checkingRadioButton = new JRadioButton ("Checking Account");
        ButtonGroup accountButtonGroup = new ButtonGroup();
        accountButtonGroup.add(savingsRadioButton);
        accountButtonGroup.add(checkingRadioButton);        
        
        JLabel paymentBalanceLabel = new JLabel("Payment Amount:");
        JTextField paymentBalanceField = new JTextField();

        JLabel recurringTypeLabel = new JLabel("Select Frequency:");
        JLabel blankLabel3 = new JLabel("");

        JRadioButton oneTimeRadioButton = new JRadioButton ("One Time Payment");
        JRadioButton recurringRadioButton = new JRadioButton ("Recurring Payment");
        ButtonGroup frequencyButtonGroup = new ButtonGroup();
        frequencyButtonGroup.add(oneTimeRadioButton);
        frequencyButtonGroup.add(recurringRadioButton);        
        
        JLabel recurringDateLabel = new JLabel("Recurring Date: ");
        JTextField recurringDateField = new JTextField();
        
        JLabel blankLabel4 = new JLabel("");
        JButton submitButton = new JButton("Submit");
        
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
        panel.add(recurringTypeLabel);
        panel.add(blankLabel3);         
        panel.add(oneTimeRadioButton);
        panel.add(recurringRadioButton);  
        panel.add(recurringDateLabel);
        panel.add(recurringDateField); 
        panel.add(blankLabel4);
        panel.add(submitButton);         
        

        add(panel, BorderLayout.CENTER);
        setTitle("Bill Payment");           
    }
}
