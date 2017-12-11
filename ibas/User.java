package ibas;

/**
* Team Budget: Greg Holden, Raymond Hames, Nicholas McGoogan, Michael Lopez, 
Joshua Kennedy, Jonathan Davies
* Professor: David Castillo
* Course: CMSC 495 7982
* User.java: The "Account" class retrieves and stores customer information 
relevant to username, password, and security questions. Get and set methods 
are used for each variable allowing the customer information to be used 
in other code elements.
*/

public class User {
        // Declare String variable "username"
	private String username;
        // Declare String variable "password"
	private String password;
        // Declare String variable "sercurityQuestionAnswer"
	private String securityQuestionAnswer;

	public User() {

	}

        // Store variables username, password, and securityQuestionAnswer
	public User(String username, String password, String securityQuestionAnswer) {
		super();
		this.username = username;
		this.password = password;
		this.securityQuestionAnswer = securityQuestionAnswer;
	}

        // Retrieve String value of username
	public String getUsername() {
		return username;
	}

        // Store user name variable "username"
	public void setUsername(String username) {
		this.username = username;
	}

        // Retrieve String value of password
	public String getPassword() {
		return password;
	}

        // Store password variable "password"
	public void setPassword(String password) {
		this.password = password;
	}

        // Retieve String value of answer to security question 
        // "securityQuestionAnswer"
	public String getSecurityQuestionAnswer() {
		return securityQuestionAnswer;
	}

        // Store answer to security question variable "securityQuestionAnswer"
	public void setSecurityQuestionAnswer(String securityQuestionAnswer) {
		this.securityQuestionAnswer = securityQuestionAnswer;
	}
}
