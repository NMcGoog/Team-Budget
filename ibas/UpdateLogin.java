
package ibas;

/**
* Team Budget: Greg Holden, Raymond Hames, Nicholas McGoogan, Michael Lopez, 
Joshua Kennedy, Jonathan Davies
* Professor: David Castillo
* Course: CMSC 495 7982
* CreateLogin.java: The "CreateLogin" class adds components to JPanel that
allows customer to enter new password, security question, and answer to 
security question.
*/

// Imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UpdateLogin extends JFrame{
    
    JPanel panel;
    
    public UpdateLogin(int user_id)
    {
        // New JPanel "panel" with 7 rows and 2 columns
        panel = new JPanel (new GridLayout(5,2));
        
        String customerName = DatabaseUtil.getName(user_id);
        
        String username = DatabaseUtil.getUsername(user_id);
        
        
        
        // JLabel that will display greeting to customer
        JLabel helloLabel = new JLabel("Hello " + customerName);
        // JLabel will ask user what information to update
        JLabel queryLabel = new JLabel("Would you like to update your password?");
        
        
        // JLabel displaying where to enter current password
        JLabel currentPasswordLabel = new JLabel("Please enter current password:");
        // JTextField where currrent password is entered
        JTextField currentPasswordField = new JTextField();
        
        // JLabel displaying where to enter new password
        JLabel newPasswordLabel = new JLabel("Enter New Password:");
        // JTextField where password is entered
        JTextField newPasswordField = new JTextField();
        
        // JLabel displaying where new password is re-entered
        JLabel newRepeatPasswordLabel = new JLabel("Repeat New Password:");
        // JTextField where new password is re-entered
        JTextField newRepeatPasswordField = new JTextField();        
        
        // JLabel displaying where to enter new security question
        JLabel securityQuestionLabel = new JLabel("New Secuity Question:");
        // JTextField where new security question is entered
        JTextField securityQuestionField = new JTextField();
        
        // Create JLabel showing customer where to enter
        // answer to security question
        JLabel newSecurityAnswerLabel = new JLabel("New Security Answer:");
        // Create JTextField where security answer will be entered
        JTextField newSecurityAnswerField = new JTextField();
        
        // Create JLabel showing customer where to re-enter
        // answer to security question
        JLabel newRepeatSecurityAnswerLabel = new JLabel("Repeat Security Answer:");
        // Create JTextField where security answer will be re-entered
        JTextField newRepeatSecurityAnswerField = new JTextField();        
        
        // Initialize blank JLabel
        JLabel blankLabel = new JLabel ("");
        // Create new JButton allowing an customer to update elements
        JButton updateButton = new JButton("Update");

        // Add components to panel
        panel.add(helloLabel);
        panel.add(queryLabel);
        panel.add(currentPasswordLabel);
        panel.add(currentPasswordField);        
        panel.add(newPasswordLabel);
        panel.add(newPasswordField);
        panel.add(newRepeatPasswordLabel);
        panel.add(newRepeatPasswordField);  
        //panel.add(securityQuestionLabel);
        //panel.add(securityQuestionField);       
        //panel.add(newSecurityAnswerLabel);
        //panel.add(newSecurityAnswerField); 
        //panel.add(newRepeatSecurityAnswerLabel);
        //panel.add(newRepeatSecurityAnswerField);      
        panel.add(blankLabel);
        panel.add(updateButton);          
                
        // Add panel to layout of JFrame
        add(panel, BorderLayout.CENTER);
        // Set title of panel to "Update Login Info"
        setTitle("Update Login Info");
        
        
        //Button action
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                String currentPassword = SecurityUtil.sanitize(currentPasswordField.getText());
                boolean correctLogin = DatabaseUtil.checkCredentials(username, currentPassword);        
                
                if(correctLogin == false){
                    JOptionPane.showMessageDialog(panel, "Current password entered is incorrect",
                                    "Warning", JOptionPane.WARNING_MESSAGE);
 
                return;                                    
                }
                String enteredPassword = SecurityUtil.sanitize(newPasswordField.getText());
                String repeatPassword = SecurityUtil.sanitize(newRepeatPasswordField.getText());
                if (!enteredPassword.equals(repeatPassword)) {
                        // Invalid input.
                        JOptionPane.showMessageDialog(panel, "Passwords do not match",
                                        "Warning", JOptionPane.WARNING_MESSAGE);

                        return;
                }
                
                if(currentPassword.equals("")||enteredPassword.equals("")||repeatPassword.equals(""))
                {
                        JOptionPane.showMessageDialog(panel, "All information must be provided",
                                        "Warning", JOptionPane.WARNING_MESSAGE);

                        return;                                    
                }         
                
                else {
                    System.out.println("Password updated");
                    //DatabaseUtil.createAccount(user_id, enteredFirstName, enteredLastName, enteredUsername, enteredPassword);
                    //UpdatePassword
                    DatabaseUtil.updatePassword(user_id, enteredPassword);
                }                
                

            }
            
        });
    }
}
