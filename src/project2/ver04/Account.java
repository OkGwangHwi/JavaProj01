package project2.ver04;


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
}
