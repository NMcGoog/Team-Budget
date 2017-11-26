package ibas;

/*
The Account class pulls and sets all the relevant information for 
the customers account, such as the account number, balance, and information.
The methods for this are gets and sets of each variable to be used in other code 
elements
*/


public class Account extends User {
	private String accountNumber;
	private double accountBalance;
	private String information;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}
}
