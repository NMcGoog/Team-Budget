
package ibas;

/**
* Team Budget: Greg Holden, Raymond Hames, Nicholas McGoogan, Michael Lopez, 
Joshua Kennedy, Jonathan Davies
* Professor: David Castillo
* Course: CMSC 495 7982
* InterestRateCalculator.java: The "InterestRateCalculator" class allows 
customer to enter loan amount, duration, percentage of interest rate, and 
compound frequency. This information is used to calculate the average 
monthly payment, interest paid over lifetime, and total amount paid. 
*/

// Imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

/*
This is the implementation of the interest rate calculator
*/
public class InterestRateCalculator extends JFrame {
    // Declare JPanel "panel" 
    JPanel panel;
    DecimalFormat TwoDigitFormat = new DecimalFormat("$ #.00");
   
    public InterestRateCalculator() {
        /*
        Currently it takes a loan amount and gives you the amount of 
        interest you will end up paying
        
        functionality and calculations pending.
        */
        
        // Initialize JPanel "panel" with 9 rows and 2 columns
        panel = new JPanel (new GridLayout(9,2));
        
        // Prompt customer to enter loan amount
        JLabel loanAmountLabel = new JLabel("Loan Amount:");
        JTextField loanAmountInput = new JTextField();
        
        // Prompt customer to enter duration of loan
        JLabel durationLabel = new JLabel("Duration:");
        JTextField durationInput = new JTextField(); 
        
        // JRadioButtons will allow customer to choose months or years
        JRadioButton monthDurationRadioButton = new JRadioButton("Months");
        JRadioButton yearDurationRadioButton = new JRadioButton("Years");
        yearDurationRadioButton.setSelected(true);
        // Add buttons "Months" and "Years" to duration group
        ButtonGroup durationButtonGroup = new ButtonGroup();
        durationButtonGroup.add(monthDurationRadioButton);
        durationButtonGroup.add(yearDurationRadioButton);
        
        // Prompt user to enter percentage of interest rate
        JLabel interestRateLabel = new JLabel("Interest Rate Percentage:");
        JTextField interestRateInput = new JTextField();            
        
        // JComboBox allows customer to choose compound frequency between 
        // daily, monthly, quaterly, biannual, and annual.
        JComboBox <String> compoundComboBox = new JComboBox <String> ();
        compoundComboBox.addItem("Daily");
        compoundComboBox.addItem("Monthly");
        compoundComboBox.addItem("Quarterly");
        compoundComboBox.addItem("Biannual");
        compoundComboBox.addItem("Annual");
        JLabel compoundLabel = new JLabel("Interest Compound Interval");
        //JTextField compoundInput = new JTextField();         
        
        // Customer can perform calculator of interest using "Calculate" button
        JButton calculateButton = new JButton("Calculate");
        JLabel blankLabel = new JLabel("");

        // Displays average monthly payment amount
        JLabel averagePayment = new JLabel("Average Monthly Payment:");
        JTextField averagePaymentOutput = new JTextField();         
        
        // Displays interest paid over lifetime
        JLabel interestOverLifetimeLabel = new JLabel("Interest paid over lifetime:");
        JTextField interestOverLifetimeOutput = new JTextField();         

        // Displays total amound paid
        JLabel totalAmountLabel = new JLabel("Total Amount Paid: ");
        JTextField totalAmountOutput = new JTextField(); 
        
        // Add components to panel
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
        
        // Add panel to JFrame
        add(panel, BorderLayout.CENTER);
        // Set title of panel to "Interest Rate Calculator"
        setTitle("Interest Rate Calculator");
        //panel.setVisible(true);

        /*
        Add action listener to calculate button. This is where the calculations 
        take place and calculate the interest of the principal based
        on the inputted information.
        
        Everything is made uniform by calculating in terms
        of years and total number of compounds that need to be made
        */
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            // Initialize double variables for loan amount, duration of loan
            // interest rate, and decimal interest rate
            double loanAmount = Double.parseDouble(loanAmountInput.getText());
            double durationOfLoan = Double.parseDouble(durationInput.getText());
            double interestRate = Double.parseDouble(interestRateInput.getText());
            double decimalInterestRate = interestRate/100;
                       
            // Initialize duration double variable "durationInYears"
            double durationInYears =  0;
            // Format duration time frame
            if(monthDurationRadioButton.isSelected()==true){durationInYears = durationOfLoan/12;}
            else if(yearDurationRadioButton.isSelected()==true){durationInYears = durationOfLoan;}    

            // Display duration in years
            System.out.println(durationInYears);

            double compoundMultipler = 0;
            // Identify which compound time frame was selected
            if(compoundComboBox.getSelectedItem() == "Daily"){compoundMultipler = 365;}
            else if(compoundComboBox.getSelectedItem() == "Monthly"){compoundMultipler = 12;}
            else if(compoundComboBox.getSelectedItem() == "Quarterly"){compoundMultipler = 4;}
            else if(compoundComboBox.getSelectedItem() == "Biannual"){compoundMultipler = 2;}
            else if(compoundComboBox.getSelectedItem() == "Annual"){compoundMultipler = 1;}
            
            // Initialize double variables for number of compounds
            // and total amount due
            double numberOfCompounds = durationInYears*compoundMultipler;
            double totalAmountDue = loanAmount;

            // Add up the total amount due based on interest rate
            for(int i = 0; i<numberOfCompounds; i++)
            {
                totalAmountDue += (totalAmountDue * decimalInterestRate);
            }
            
            // Initialize double variables for average monthly payment 
            // and amount of total interest
            double averageMonthlyPayment = totalAmountDue/(durationInYears*12);
            double amountOfTotalInterest = totalAmountDue - loanAmount;
            
            // Display average monthly payment and amount of total interest
            System.out.println(averageMonthlyPayment +" to left is avg month to right is interest " + amountOfTotalInterest);
            
            // Retrieve average payment, interest over lifetime, and total amount
            // for output
            averagePaymentOutput.setText((TwoDigitFormat.format(averageMonthlyPayment)));
            interestOverLifetimeOutput.setText(TwoDigitFormat.format(amountOfTotalInterest));         
            totalAmountOutput.setText(TwoDigitFormat.format(totalAmountDue));         
            
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
    }
    
}
