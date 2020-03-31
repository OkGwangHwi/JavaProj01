package project2.ver04;

public class HighCreditAccount extends Account{
	
	private int gradeAdd;

	public HighCreditAccount(String accountNumber, String name, int balance, int add, int gradeAdd) {
		super(accountNumber, name, balance,add);
		this.gradeAdd = gradeAdd;
	}

	@Override
	public void showAccount() {
		super.showAccount();
		System.out.println("신용등급 : "+gradeAdd);
	}
}