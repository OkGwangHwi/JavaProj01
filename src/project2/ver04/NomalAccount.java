package project2.ver04;

import project2.ver04.Account;

public class NomalAccount extends Account{

	public NomalAccount(String accountNumber, String name, int balance, int add) {
		super(accountNumber, name, balance,add);
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
	
	
}
