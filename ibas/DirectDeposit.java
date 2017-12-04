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


public class DirectDeposit extends JFrame {
    
    JPanel panel;

    public DirectDeposit()
    {

        panel = new JPanel (new GridLayout(8,2));

        JLabel helloLabel = new JLabel("Hello" + " 'GET USERNAME'");
        JLabel blankLabel = new JLabel("");
        
        JLabel accountLabel = new JLabel("Select Account Type");
        JLabel blankLabel2 = new JLabel("");

        
        JRadioButton savingsRadioButton = new JRadioButton ("Savings Account");
        JRadioButton checkingRadioButton = new JRadioButton ("Checking Account");
        ButtonGroup accountButtonGroup = new ButtonGroup();
        accountButtonGroup.add(savingsRadioButton);
        accountButtonGroup.add(checkingRadioButton);        
        
        JLabel depositBalanceLabel = new JLabel("Deposit Amount:");
        JTextField depositBalanceField = new JTextField();

        JLabel recurringTypeLabel = new JLabel("Select Frequency:");
        JLabel blankLabel3 = new JLabel("");

        JRadioButton oneTimeRadioButton = new JRadioButton ("One Time Deposit");
        JRadioButton recurringRadioButton = new JRadioButton ("Recurring Deposit");
        ButtonGroup frequencyButtonGroup = new ButtonGroup();
        frequencyButtonGroup.add(oneTimeRadioButton);
        frequencyButtonGroup.add(recurringRadioButton);        
        
        JLabel recurringDateLabel = new JLabel("Recurring Date: ");
        JTextField recurringDateField = new JTextField();
        
        JLabel blankLabel4 = new JLabel("");
        JButton submitButton = new JButton("Submit");
        
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
        
        
        






        add(panel, BorderLayout.CENTER);
        setTitle("Direct Deposit");    
    }

}