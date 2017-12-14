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

public class AccountBalance extends JFrame {
    
    JPanel panel;
    
    public AccountBalance(int user_id)
    {
        panel = new JPanel (new GridLayout(3,2));
        
        String customerName = DatabaseUtil.getName(user_id);
        String checking_account = "checking_account";
        double checkingBalance = DatabaseUtil.getCheckingAccountBalance(user_id);
        double savingBalance = DatabaseUtil.getSavingAccountBalance(user_id);
        
        JLabel helloLabel = new JLabel("Hello " + customerName);
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

        checkingTextField.setText(Double.toString(checkingBalance));
        savingsTextField.setText(Double.toString(savingBalance));
        
        
        add(panel, BorderLayout.CENTER);
        setTitle("Account Balance");
        

    }
}
