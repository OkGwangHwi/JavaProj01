package project2.ver04;

import java.io.Serializable;

//계좌정보를 나타내는 인터페이스
public abstract class Account implements Serializable{
	
	String accountNumber;
	String name;
	int balance;
	int add;
	
	public Account() {}
	
	public void balanceAdd(int dep) {
		
	}
	
	public Account(String accountNumber, String name, 
			int balance,int add) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
		this.add = add;
	}
	
	public void showAccount() {
		System.out.println("계좌번호 : "+accountNumber);
		System.out.println("이름 : "+name);
		System.out.println("잔액 : "+balance);
		System.out.println("기본이자 : "+add+"%");
	}
	
	//equals()가 true인 두 Object를 HashMap에 put을 할 때 동일한 Key로 인식하고 싶은 경우
	@Override
	public int hashCode() {
		final int prime = 31;
		int hashCode = 1;

		hashCode = prime * hashCode + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		return hashCode;
	}
	
	@Override
	public boolean equals(Object obj) {
		Account account = (Account)obj;
		if(account.accountNumber==accountNumber) {
			return true;
		}
		else {
			return false;
		}
	}
}
