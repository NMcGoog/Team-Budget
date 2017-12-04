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

public class AccountBalance extends JFrame {
    
    JPanel panel;
    
    public AccountBalance()
    {
        panel = new JPanel (new GridLayout(4,2));
        
        
        JLabel helloLabel = new JLabel("Hello" + " 'GET USERNAME'");
        JLabel blankLabel = new JLabel("");
        
        JLabel checkingLabel = new JLabel("Checking Balance:");
        JTextField checkingTextField = new JTextField();
        
        JLabel savingsLabel = new JLabel("Savings Balance: ");
        JTextField savingsTextField = new JTextField();
        

        panel.add(helloLabel);
        panel.add(blankLabel);
        panel.add(checkingLabel);
        panel.add(checkingTextField);
        panel.add(savingsLabel);
        panel.add(savingsTextField);        
        
        
        
        
        
        
        add(panel, BorderLayout.CENTER);
        setTitle("Account Balance");
        

    }
}
