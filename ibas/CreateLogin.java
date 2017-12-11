
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

public class CreateLogin extends JFrame{
    
    JPanel panel;
    
    public CreateLogin()
    {
        // New JPanel "panel" with 7 rows and 2 columns
        panel = new JPanel (new GridLayout(7,2));
        
        // JLabel that will display greeting to customer
        JLabel helloLabel = new JLabel("Hello" + " 'GET USERNAME'");
        // JLabel will ask user what information to update
        JLabel queryLabel = new JLabel("What would you like to update?");
        
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
        
        // Add panel to layout of JFrame
        add(panel, BorderLayout.CENTER);
        // Set title of panel to "Update Login Info"
        setTitle("Update Login Info");
    }
}
