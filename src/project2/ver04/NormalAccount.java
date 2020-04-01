package project2.ver04;

import project2.ver04.Account;

public class NormalAccount extends Account{

	public NormalAccount(String accountNumber, String name, int balance, int add) {
		super(accountNumber, name, balance,add);
	}
	
	@Override
	public void balanceAdd(int dep) {
		balance = balance+balance*add/100+dep;
	}
	
	@Override
	public void showAccount() {
		super.showAccount();
	}
}
