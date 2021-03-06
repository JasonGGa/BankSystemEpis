import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {
	private String accountName;
	private String password;
	private BigDecimal accountBalance;
	private Long sessionKey = (long) 0;
	private List<Transaction> transactions = new ArrayList<Transaction>();
	private int accountNumber = ++lastAssignedNumber;
	private static int lastAssignedNumber;
	
	public Account(String accountName, String password, BigDecimal accountBalance) {
		this.accountName = accountName;
		this.password = password;
		this.accountBalance = accountBalance;
	}

	public void withdraw(String description, BigDecimal amount){
		if(this.accountBalance.compareTo(amount) != -1){
			this.accountBalance = this.accountBalance.subtract(amount);
		}
		this.createTransaction(description, amount);	
		System.out.println("Withdrawl Successful! \nAccount Balance is now " + this.accountBalance);

	}
	
	public void deposit(String description, BigDecimal amount){
		this.accountBalance = this.accountBalance.add(amount);
		this.createTransaction(description, amount);
		System.out.println("Deposit Successful! \nAccount Balance is now " + this.accountBalance);
	}
	
	public void createTransaction(String description, BigDecimal amount) {	
		Transaction transaction = new Transaction(description, amount);
		this.transactions.add(transaction);	
	}
	
	//	Getters & Setters
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getSessionKey() {
		return sessionKey;
	}

	public void setSessionKey(Long sessionKey) {
		this.sessionKey = sessionKey;
	}	
	
	@Override
	public String toString() {
		return "Account [accountName=" + accountName + ", password=" + password + ", accountBalance=" + accountBalance
				+ ", sessionKey=" + sessionKey + ", transactions=" + transactions + ", accountNumber=" + accountNumber
				+ "]";
	}
}
