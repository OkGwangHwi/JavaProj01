package project2.ver02;

public class HighCreditAccount extends Account{
	private double dAdd;
	private String sAdd;

	
	
	public HighCreditAccount(String accountNumber, String name, int balance, double dAdd, String sAdd) {
		super(accountNumber, name, balance);
		this.dAdd = dAdd;
		this.sAdd = sAdd;
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
}
