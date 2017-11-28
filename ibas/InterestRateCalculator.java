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

/*
This is the implementation of the interest rate calculator
*/
public class InterestRateCalculator extends JFrame {
    
    JPanel panel;
   
    public InterestRateCalculator() {
        /*
        Currently it takes a loan amount and gives you the amount of 
        interest you will end up paying
        
        functionality and calculations pending.
        */
        panel = new JPanel (new GridLayout(7,2));
        
        JLabel loanAmountLabel = new JLabel("Loan Amount:");
        JTextField loanAmountInput = new JTextField();
        
        JLabel durationLabel = new JLabel("Duration:");
        JTextField durationInput = new JTextField();    
        
        JLabel interestRateLabel = new JLabel("Interest Rate:");
        JTextField interestRateInput = new JTextField();            
        
        JLabel compoundLabel = new JLabel("Interest Compound Interval");
        JTextField compoundInput = new JTextField();         
        
        JButton calculateButton = new JButton("Calculate");
        JLabel blankLabel = new JLabel("");
        
        JLabel interestOverLifetimeLabel = new JLabel("Interest paid over lifetime:");
        JTextField interestOverLifetimeOutput = new JTextField();         
        
        panel.add(loanAmountLabel);
        panel.add(loanAmountInput);
        panel.add(durationLabel);
        panel.add(durationInput);
        panel.add(interestRateLabel);
        panel.add(interestRateInput);      
        panel.add(compoundLabel);
        panel.add(compoundInput);   
        panel.add(blankLabel);
        panel.add(calculateButton);           
        panel.add(interestOverLifetimeLabel);
        panel.add(interestOverLifetimeOutput);          
        
        
        
        add(panel, BorderLayout.CENTER);
        setTitle("Interest Rate Calculator");
        //panel.setVisible(true);
    }
    
}
