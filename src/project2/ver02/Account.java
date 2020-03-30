package project2.ver02;

public class Account {
	
	private String accountNumber;
	private String name;
	private int balance;
	private int add;
	
	public Account(String accountNumber, String name, 
			int balance,int add) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
		this.add = add;
	}
	

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getAdd() {
		return add;
	}

	public void setAdd(int add) {
		this.add = add;
	}
	
	
}
