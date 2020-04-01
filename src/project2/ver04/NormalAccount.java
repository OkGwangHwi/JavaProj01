package project2.ver04;

import project2.ver04.Account;

public class NormalAccount extends Account{

	private int add;
	
	public NormalAccount(String accountNumber, String name, int balance, int add) {
		super(accountNumber, name, balance);
		this.add = add;
	}
	
	public void balanceAdd(int deposit) {
		balance = balance + (balance * add)/100 + deposit;
	}
	
	@Override
	public void showAccInfo() {
		super.showAccInfo();
		System.out.println("기본이자 : "+add+"%");
	}

	
}
