package project2.ver04;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import javax.security.auth.login.AccountNotFoundException;

import project2.ver04.HighCreditAccount;


public class AccountManager implements MenuChoice{

	HashSet<Account> set;
	Scanner sc = new Scanner(System.in);
	
	public void showMenu() { //메뉴출력
		while(true) {
			try {
				System.out.println("1.계좌개설");
				System.out.println("2.입금");
				System.out.println("3.출금");
				System.out.println("4.전체계좌정보출력");
				System.out.println("5.프로그램 종료");
				
				int select = sc.nextInt();
				sc.nextLine();
				if(!(select >= 1 && select <= 5)) {
					MenuSelectException menuEx = new MenuSelectException();
					throw menuEx;
				}
				
				switch(select) {
				case MenuChoice.MAKE:
					makeAccount();
					break;
				case MenuChoice.DEPOSIT:
					depositMoney();
					break;
				case MenuChoice.WITHDRAW:
					withdrawMoney();
					break;
				case MenuChoice.INQUIRE:
					showAccInfo();
					break;
				case MenuChoice.EXIT:
					saveAccount();
					System.out.println("프로그램을 종료합니다.");
					return;
					}
			}
			catch(MenuSelectException e) {
				System.out.println(e.getMessage());
			}
			catch(InputMismatchException e) {
				System.out.println("정수를 입력하세요.");
			}
		}
	}
	
private void checkOverlap(Account acc) {
		
		if(!set.add(acc)) {
			System.out.println("값이 중복 됩니다.");
			System.out.println("덮어쓰기 ==> 1번 재입력 ==> 0번");
			int num = sc.nextInt();
			sc.nextLine();
			if(num==1) {
				set.remove(acc);
				set.add(acc);	
				acc.showAccInfo();
				System.out.println("계좌개설이 완료되었습니다.");
			}
		}
		else {
			System.out.println("계좌개설이 완료되었습니다.");
			acc.showAccInfo();
		}
	}
	
	public void makeAccount() {
		int newAdd,newBalance,ratingAdd;
		String accountNumber,newName,rating;
		
		System.out.println("보통계좌 ==> 1번");
		System.out.println("신용신뢰계좌 ==> 2번");
		System.out.print("선택 : ");
		int select2 = sc.nextInt();
		sc.nextLine();
		
		System.out.print("계좌번호 : ");
		accountNumber = sc.nextLine(); 
		
		System.out.print("계좌주 : ");
		newName = sc.nextLine();
		System.out.print("잔고 : ");
		newBalance = sc.nextInt();
		sc.nextLine();
		switch(select2) {
		case 1:
			System.out.print("기본이자(%) : ");
			newAdd = sc.nextInt();
			sc.nextLine();
			
			NormalAccount normalAccount = 
					new NormalAccount(accountNumber, newName, newBalance, newAdd);
			checkOverlap(normalAccount);
			break;
		case 2:
			System.out.print("기본이자(%) : ");
			newAdd = sc.nextInt();
			sc.nextLine();
			System.out.println("신용등급 : ");
			rating = sc.nextLine();
			
			HighCreditAccount highCreditAccount =
					new HighCreditAccount(accountNumber, newName, newBalance, newAdd, rating);
			checkOverlap(highCreditAccount);
			break;
		}
	}
	
	public void depositMoney() {
		Scanner sc = new Scanner(System.in);
		System.out.print("계좌번호 : ");
		String newAccountNumber = sc.next();
		System.out.print("예금액 : ");
		try {
			int dep = sc.nextInt();
			sc.nextLine();
			if(dep%500 != 0) {
				System.out.println("500원 단위로 입금이 가능합니다.");
				return;
			}
			if(dep < 0) {
				System.out.println("음수값은 입금할 수 없습니다.");
				return;
			}
			
			Iterator<Account> iter = set.iterator();
			while(iter.hasNext()) {
				Account account = (Account) iter.next();
				if(newAccountNumber.equals(account.accountNumber)) {
					account.balanceAdd(dep);
					System.out.println("입금완료");
				}
			}
		}
		catch(InputMismatchException e) {
			System.out.println("문자를 입력할 수 없습니다.");
			}
		}
	
	public void withdrawMoney() {
		Scanner sc = new Scanner(System.in);
		System.out.print("계좌번호 : ");
		String newAccountNumber = sc.next();
		System.out.print("출금액 : ");
		try {
		int wit = sc.nextInt();
		sc.nextLine();
		if(wit%1000 != 0) {
			System.out.println("1000원 단위로 출금이 가능합니다.");
			return;
		}
		if(wit < 0) {
			System.out.println("음수값은 출금할 수 없습니다.");
			return;
		}
		
		Iterator<Account> itr = set.iterator();
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
	
	//전체계좌정보출력
	public void showAccInfo() {
		System.out.println("***계좌정보출력***");
		System.out.println("----------------");
			
		for(Account accountinfo : set) {
				
			accountinfo.showAccInfo();
			System.out.println("----------------");
		}
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
	}
	
	public AccountManager() {
		try {
			ObjectInputStream in = 
					new ObjectInputStream(
							new FileInputStream("src/project2/Customer.obj"));
			
			set = (HashSet<Account>)in.readObject();
		}
		catch (Exception e) {
			System.out.println("파일을 찾을수 없습니다.");
			set = new HashSet<Account>();
	    }
	}
	
	public void saveAccount() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("src/project2/Customer.obj"));
			
			out.writeObject(set);
					
		}catch(Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
		}
	}
	
}
