package project2.ver02;

public class HighCreditAccount extends Account{
	private int gradeAdd;

	public HighCreditAccount(String accountNumber, String name, int balance, int add, int gradeAdd) {
		super(accountNumber, name, balance,add);
		this.gradeAdd = gradeAdd;
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
	
	@Override
	public int getAdd() {
		return super.getAdd();
	}
	
	@Override
	public void setAdd(int add) {
		super.setAdd(add);
	}
	
	public int getGradeAdd() {
		return gradeAdd;
	}
	
	public void setGradeAdd(int gradeAdd) {
		this.gradeAdd = gradeAdd;
	}
}
