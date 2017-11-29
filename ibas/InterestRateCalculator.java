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
        panel = new JPanel (new GridLayout(9,2));
        
        JLabel loanAmountLabel = new JLabel("Loan Amount:");
        JTextField loanAmountInput = new JTextField();
        
        JLabel durationLabel = new JLabel("Duration:");
        JTextField durationInput = new JTextField(); 
        
        JRadioButton monthDurationRadioButton = new JRadioButton("Months");
        JRadioButton yearDurationRadioButton = new JRadioButton("Years");
        ButtonGroup durationButtonGroup = new ButtonGroup();
        durationButtonGroup.add(monthDurationRadioButton);
        durationButtonGroup.add(yearDurationRadioButton);
        
        JLabel interestRateLabel = new JLabel("Interest Rate Percentage:");
        JTextField interestRateInput = new JTextField();            
        
        JComboBox <String> compoundComboBox = new JComboBox <String> ();
        compoundComboBox.addItem("Daily");
        compoundComboBox.addItem("Monthly");
        compoundComboBox.addItem("Quarterly");
        compoundComboBox.addItem("Biannual");
        compoundComboBox.addItem("Annual");
        JLabel compoundLabel = new JLabel("Interest Compound Interval");
        //JTextField compoundInput = new JTextField();         
        
        JButton calculateButton = new JButton("Calculate");
        JLabel blankLabel = new JLabel("");

        JLabel averagePayment = new JLabel("Average Monthly Payment:");
        JTextField averagePaymentOutput = new JTextField();         
        
        JLabel interestOverLifetimeLabel = new JLabel("Interest paid over lifetime:");
        JTextField interestOverLifetimeOutput = new JTextField();         

        JLabel totalAmountLabel = new JLabel("Total Amount Paid: ");
        JTextField totalAmountOutput = new JTextField(); 
        
        panel.add(loanAmountLabel);
        panel.add(loanAmountInput);
        panel.add(durationLabel);
        panel.add(durationInput);
        panel.add(monthDurationRadioButton);
        panel.add(yearDurationRadioButton);        
        panel.add(interestRateLabel);
        panel.add(interestRateInput);      
        panel.add(compoundLabel);
        panel.add(compoundComboBox);   
        panel.add(blankLabel);
        panel.add(calculateButton);     
        panel.add(averagePayment);
        panel.add(averagePaymentOutput);         
        panel.add(interestOverLifetimeLabel);
        panel.add(interestOverLifetimeOutput); 
        panel.add(totalAmountLabel);
        panel.add(totalAmountOutput);          
        
        add(panel, BorderLayout.CENTER);
        setTitle("Interest Rate Calculator");
        //panel.setVisible(true);

        /*
        This is where the calculations take place
        and calculates the interest of the principal based
        on the inputted information.
        
        Everything is tried to made uniform by calculating in terms
        of years and total number of compounds that need to be made
        
        */
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            double loanAmount = Double.parseDouble(loanAmountInput.getText());
            double durationOfLoan = Double.parseDouble(durationInput.getText());
            double interestRate = Double.parseDouble(interestRateInput.getText());
            double decimalInterestRate = interestRate/100;
            
            double durationMultiplier = 0;
            if(monthDurationRadioButton.isSelected()==true){durationMultiplier = 1/12;}
            else if(yearDurationRadioButton.isSelected()==true){durationMultiplier = 1;}            
      
            System.out.println(durationMultiplier);
            
            double durationInYears = durationOfLoan*durationMultiplier;

            System.out.println(durationInYears);

            double compoundMultipler = 0;
            if(compoundComboBox.getSelectedItem() == "Daily"){compoundMultipler = 365;}
            else if(compoundComboBox.getSelectedItem() == "Monthly"){compoundMultipler = 12;}
            else if(compoundComboBox.getSelectedItem() == "Quarterly"){compoundMultipler = 4;}
            else if(compoundComboBox.getSelectedItem() == "Biannual"){compoundMultipler = 2;}
            else if(compoundComboBox.getSelectedItem() == "Annual"){compoundMultipler = 1;}
            
            double numberOfCompounds = durationInYears*compoundMultipler;
            double totalAmountDue = loanAmount;

            for(int i = 0; i<numberOfCompounds; i++)
            {
                totalAmountDue += (totalAmountDue * decimalInterestRate);
            }
            
            double averageMonthlyPayment = totalAmountDue/(durationInYears*12);
            double amountOfTotalInterest = totalAmountDue - loanAmount;
            
            System.out.println(averageMonthlyPayment +" to left is avg month to right is interest " + amountOfTotalInterest);
            
            averagePaymentOutput.setText(Double.toString(averageMonthlyPayment));
            interestOverLifetimeOutput.setText(Double.toString(amountOfTotalInterest));         
            totalAmountOutput.setText(Double.toString(totalAmountDue));         
            
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
    }
    
}
