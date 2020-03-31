package project2.ver04;

import java.io.Serializable;

//계좌정보를 나타내는 인터페이스
public abstract class Account implements Serializable{
	
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
	
	public void showAccount() {
		System.out.println("계좌번호 : "+accountNumber);
		System.out.println("이름 : "+name);
		System.out.println("잔액 : "+balance);
		System.out.println("기본이자 : "+add+"%");
	}
}
