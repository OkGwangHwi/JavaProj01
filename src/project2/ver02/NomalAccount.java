package project2.ver02;

public class NomalAccount extends Account{
	private double add;

	public NomalAccount(String accountNumber, String name, int balance, int add) {
		super(accountNumber, name, balance);
		this.add = add;
	}
	
	@Override
	public String getAccountNumber() {
		return super.getAccountNumber();
	}
	
	@Override
	public void setAccountNumber(String accountNumber) {
		super.setAccountNumber(accountNumber);
	}
	
	@Override
	public String getName() {
		return super.getName();
	}
	
	@Override
	public void setName(String name) {
		super.setName(name);
	}
	
	@Override
	public int getBalance() {
		return super.getBalance();
	}
	
	@Override
	public void setBalance(int balance) {
		super.setBalance(balance);
	}

	public double getAdd() {
		return add;
	}

	public void setAdd(double add) {
		this.add = add;
	}
	
	
}
