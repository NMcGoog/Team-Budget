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

public class CreateLogin extends JFrame{
    
    JPanel panel;
    
    public CreateLogin()
    {
        panel = new JPanel (new GridLayout(7,2));
        
        
        JLabel helloLabel = new JLabel("Hello" + " 'GET USERNAME'");
        JLabel queryLabel = new JLabel("What would you like to update?");
        
        JLabel newPasswordLabel = new JLabel("Enter New Password:");
        JTextField newPasswordField = new JTextField();
        
        JLabel newRepeatPasswordLabel = new JLabel("Repeat New Password:");
        JTextField newRepeatPasswordField = new JTextField();        
        
        JLabel securityQuestionLabel = new JLabel("New Secuity Question:");
        JTextField securityQuestionField = new JTextField();
        
        JLabel newSecurityAnswerLabel = new JLabel("New Secuity Answer:");
        JTextField newSecurityAnswerField = new JTextField();
        
        JLabel newRepeatSecurityAnswerLabel = new JLabel("Repeat Secuity Answer:");
        JTextField newRepeatSecurityAnswerField = new JTextField();        
        
        JLabel blankLabel = new JLabel ("");
        JButton updateButton = new JButton("Update");
        
        
        panel.add(helloLabel);
        panel.add(queryLabel);
        panel.add(newPasswordLabel);
        panel.add(newPasswordField);
        panel.add(newRepeatPasswordLabel);
        panel.add(newRepeatPasswordField);  
        panel.add(securityQuestionLabel);
        panel.add(securityQuestionField);       
        panel.add(newSecurityAnswerLabel);
        panel.add(newSecurityAnswerField); 
        panel.add(newRepeatSecurityAnswerLabel);
        panel.add(newRepeatSecurityAnswerField);      
        panel.add(blankLabel);
        panel.add(updateButton);          
        
        
        
        
        
        
        
        add(panel, BorderLayout.CENTER);
        setTitle("Update Login Info");
    }
}
