package project2.ver01;

import java.util.Scanner;
import project2.BankingSystemVer01;;

public class MenuChoice {
	
	static Account[] accountArray = new Account[50];
	static Scanner sc = new Scanner(System.in);
	
	public static void showMenu() { //메뉴출력
		System.out.println("1.계좌계설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.전체계좌정보출력");
		System.out.println("5.프로그램 종료");
	}
	
	public static void makeAccount() {
		Scanner sc = new Scanner(System.in);

		System.out.println("***신규계좌개설***");
		System.out.print("계좌번호 : ");
		String accNum = sc.nextLine();
		
		System.out.print("고객이름 : ");
		String cusName = sc.nextLine();
		
		System.out.println("잔고 : ");
		int money = sc.nextInt();
		sc.nextLine();
		
		for(int i=0;i<accountArray.length;i++) {
			if(accountArray[i] == null) {
				accountArray[i] = new Account(accNum, cusName, money);
				System.out.println("계좌개설이 완료되었습니다. ");
				break;
			}
		}
	}
	public static void showAccInfo() {
		System.out.println("***계좌정보출력***");
		for(int i =0; i<accountArray.length;i++) {
			if(accountArray[i] ==null) {
				break;
			}
			System.out.println(accountArray[i].getAccountNumber());
			System.out.println(accountArray[i].getName());
			System.out.println(accountArray[i].getBalance());
		}
	}
	public static Account findAccount(String ano) {
		for(int i=0;i<accountArray.length;i++) {
			if(accountArray[i] ==null) {
				break;
			}
			if(accountArray[i].getAccountNumber().equals(ano)) {
				return accountArray[i];
			}
		}
		return null;
	}
	public static void depositMoney() {
		System.out.println("***입금***");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		System.out.print("계좌번호 : ");
		String ano = sc.next();
		System.out.print("예금액 : ");
		int dep = sc.nextInt();
		sc.nextLine();
		
		if(findAccount(ano) == null) {
			System.out.println("입력한 계좌번호를 찾지 못했습니다.");
		}
		else {
			findAccount(ano).setBalance(findAccount(ano).getBalance()+dep);
			System.out.println("입금이 완료되었습니다.");
		}
	}
	public static void withdrawMoney() {
		System.out.println("***출금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요");
		System.out.print("계좌번호 : ");
		String ano = sc.next();
		System.out.print("출금액 : ");
		int wit = sc.nextInt();
		sc.nextLine();

		if(findAccount(ano) == null) {
			System.out.println("입력한 계좌번호를 찾지 못했습니다.");
		}
		else {
			if(wit > findAccount(ano).getBalance()) {
				System.out.println("잔액보다 큰 액수입니다.");
			}
			else {
				findAccount(ano).setBalance(findAccount(ano).getBalance() -  wit);
				System.out.println("출금이 완료되었습니다.");
			}
		}
	}
	public interface MenuItem{
		int MAKE = 1,DEPOSIT = 2,WITHDRAW = 3,INQUIRE = 4,EXIT = 5;
	}
}
