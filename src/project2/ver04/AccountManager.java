package project2.ver04;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import project2.ver04.HighCreditAccount;


public class AccountManager {

	HashSet<Account> hs = new HashSet<Account>();
	
	public AccountManager() {
		try {
			ObjectInputStream in = 
					new ObjectInputStream(
							new FileInputStream(
									"src/project2.ver04/customerAccount.obj"));
			
		}
		catch(Exception e) {
			System.out.println("파일을 찾을 수 없습니다.");
		}
	}
	
	public void saveAccountCustomer() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("src/project2.ver04/customerAccount.obj"));
			out.writeObject(hs);
					
		}catch(Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}
	}
	
	public void showMenu() { //메뉴출력
		System.out.println("1.계좌개설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.전체계좌정보출력");
		System.out.println("5.프로그램 종료");
	}
	
	public void OverlapAccNum(String accountNumber,String name,Account account) {
		Scanner sc = new Scanner(System.in);
		boolean it = hs.add(account);
		
		if(it == false) {
			System.out.println("중복된 계좌번호입니다.새로 만드시겠습니까? YES = 1 , NO = 2");
			int choice = sc.nextInt();
			if(choice == 1) {
				hs.remove(account);
				hs.add(account);
			}
			else {
				makeAccount();
			}
		}
	}
	
	public void makeAccount() {
		Scanner sc = new Scanner(System.in);
		String newAccountNumber,newName;
		int newBalance,add;

		System.out.println("***신규계좌개설***");
		System.out.println("----계좌선택----");
		System.out.println("보통계좌");
		System.out.println("신용신뢰계좌");
		System.out.print("선택 : ");
		int choice = sc.nextInt();
		sc.nextLine();
		
		switch(choice) {
		case 1:
			System.out.print("계좌번호 : ");
			newAccountNumber = sc.nextLine();
			
			System.out.print("고객이름 : ");
			newName = sc.nextLine();
			
			System.out.print("잔고 : ");
			newBalance = sc.nextInt();
			sc.nextLine();
			
			System.out.print("기본이자%(정수형태로입력) : ");
			add = sc.nextInt();
			sc.nextLine();
			
			NormalAccount noAccount = new NormalAccount(newAccountNumber, newName, newBalance, add);
			OverlapAccNum(newAccountNumber,newName,noAccount);
			System.out.println("계좌가 개설되었습니다.");
			break;
		case 2:
			System.out.print("계좌번호 : ");
			newAccountNumber = sc.nextLine();
			
			System.out.print("고객이름 : ");
			newName = sc.nextLine();
			
			System.out.print("잔고 : ");
			newBalance = sc.nextInt();
			sc.nextLine();
			
			System.out.print("기본이자%(정수형태로입력) : ");
			add = sc.nextInt();
			sc.nextLine();
			
			System.out.print("신용등급(A,B,C등급) : ");
			int gradeAdd=0;
			String gAdd = sc.nextLine();
			switch(gAdd) {
			case "A":
				gradeAdd = 7;
				break;
			case "B":
				gradeAdd = 4;
				break;
			case "C":
				gradeAdd = 2;
				break;
			}
			
			HighCreditAccount hiAccount = new HighCreditAccount(newAccountNumber, newName, newBalance, add, gradeAdd);
			OverlapAccNum(newAccountNumber,newName,hiAccount);
			System.out.println("계좌가 개설되었습니다.");
			break;
		}
			
	}
	
	public void showAccInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("***계좌정보출력***");
		for(Account acc : hs) {
			acc.showAccount();
		}
		System.out.println("전체정보 출력완료");
	}
	
	public void depositMoney() {
		Scanner sc = new Scanner(System.in);
		System.out.println("***입금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		System.out.print("계좌번호 : ");
		String newAccountNumber = sc.next();
		System.out.print("예금액 : ");
		try {
			int dep = sc.nextInt();
			sc.nextLine();
			if(dep%500 != 0) {
				System.out.println("500원 단위로 입금이 가능합니다.");
			}
			else if(dep < 0) {
				System.out.println("음수값은 입금할 수 없습니다.");
			}
			
			Iterator<Account> iter = hs.iterator();
			while(iter.hasNext()) {
				Account account = iter.next();
				if(newAccountNumber.equals(account.accountNumber)) {
					account.balanceAdd(dep);
				}
				else {
					System.out.println("입력한 계좌를 찾지 못했습니다.");
				}
			}
		}
		catch(InputMismatchException e) {
			System.out.println("문자를 입력할 수 없습니다.");
			}
		}
	
	public void withdrawMoney() {
		Scanner sc = new Scanner(System.in);
		System.out.println("***출금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요");
		System.out.print("계좌번호 : ");
		String newAccountNumber = sc.next();
		System.out.print("출금액 : ");
		try {
		int wit = sc.nextInt();
		sc.nextLine();
		if(wit%1000 != 0) {
			System.out.println("1000원 단위로 입금이 가능합니다.");
		}
		if(wit < 0) {
			System.out.println("음수값은 입금할 수 없습니다.");
		}
		
		Iterator<Account> itr = hs.iterator();
		while(itr.hasNext()) {
			Account account = itr.next();
			if(newAccountNumber.equals(account.accountNumber)) {
				if(account.balance < wit) {
					
					System.out.println("잔고가 부족합니다. 금액전체를 출금할까요?");
					System.out.println("yes : 금액전체 출금처리, no : 출금요청취소");
					String choice = sc.nextLine();
					
					if(choice.equals("yes")) {
						account.balance = 0;
					}
					else if(choice.equals("no")) {
						System.out.println("출금요청을 취소합니다.");
					}
				}
				else {
					account.balance -= wit;
					System.out.println("출금이 완료되었습니다.");
				}
			}
		}
	}
	catch(InputMismatchException e) {
		System.out.println("문자형태로 입력하면 안되요.");
		}
	}
}
