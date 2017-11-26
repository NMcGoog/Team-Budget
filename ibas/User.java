package ibas;

/*
This class is defining the Users information, username, password, and security
question information.

Contains gets and sets of each username that are used elsewhere in the program.
*/
public class User {
	private String username;
	private String password;
	private String securityQuestionAnswer;

	public User() {

	}

	public User(String username, String password, String securityQuestionAnswer) {
		super();
		this.username = username;
		this.password = password;
		this.securityQuestionAnswer = securityQuestionAnswer;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSecurityQuestionAnswer() {
		return securityQuestionAnswer;
	}

	public void setSecurityQuestionAnswer(String securityQuestionAnswer) {
		this.securityQuestionAnswer = securityQuestionAnswer;
	}
}
