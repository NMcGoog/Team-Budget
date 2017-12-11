package ibas;

/**
* Team Budget: Greg Holden, Raymond Hames, Nicholas McGoogan, Michael Lopez, 
Joshua Kennedy, Jonathan Davies
* Course: CMSC 495 7982
* Professor: David Castillo
* Account.java: The "Account" class retrieves and stores all relevant information for 
the customers account.  This includes the account number, balance, and information.
Get and set methods are used for each variable allowing the customer information to be used in other code elements.
*/

public class Account extends User {
	// Declare String variable "accountNumber"
	private String accountNumber;
	// Declare double variable "accountBalance"
	private double accountBalance;
	// Declare String variable "information"
	private String information;

	// Retrieve String value of account number "accountNumber"
	public String getAccountNumber() {
		return accountNumber;
	}

	// Store account number variable "accountNumber"
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	// Retrieve double value of account balance "accountBalance"
	public double getAccountBalance() {
		return accountBalance;
	}

	// Store account balance variable "accountBalance"
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	// Retrieve String value of "getInformation"
	public String getInformation() {
		return information;
	}

	// Store information variable
	public void setInformation(String information) {
		this.information = information;
	}
}
