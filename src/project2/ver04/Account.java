package project2.ver04;

import java.io.Serializable;

//계좌정보를 나타내는 인터페이스
public abstract class Account implements Serializable{
	
	String accountNumber;
	 String name;
	 int balance;
	
	
	public Account(String accountNumber, String name, int balance) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	}
	
	public void showAccInfo() {
		System.out.println("계좌번호 : "+accountNumber);
		System.out.println("이름 : "+name);
		System.out.println("잔고 : "+balance);
	}

	
	public void balanceAdd(int depMoney) { //돈 입금받음
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + balance;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Account account = (Account) obj;
		if(account.accountNumber.equals(this.accountNumber)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
