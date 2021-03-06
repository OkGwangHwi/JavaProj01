package project2.ver03;


//계좌정보를 나타내는 인터페이스
public abstract class Account {
	
	private String accountNumber;
	private String name;
	private int balance;
	private int add;
	
	public Account() {}
	
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
