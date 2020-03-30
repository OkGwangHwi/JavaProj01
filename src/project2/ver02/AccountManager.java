package project2.ver02;

import java.util.Scanner;

public class AccountManager {
	
	

	static Account[] accountArray = new Account[50];
	static HighCreditAccount[] hcAccount = new HighCreditAccount[50];
	static Scanner sc = new Scanner(System.in);
	
	
	public static void showMenu() { //메뉴출력
		System.out.println("1.계좌개설");
		System.out.println("2.입금");
		System.out.println("3.출금");
		System.out.println("4.전체계좌정보출력");
		System.out.println("5.프로그램 종료");
	}
	
	public static void makeAccount() {
		Scanner sc = new Scanner(System.in);

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
			String accNum = sc.nextLine();
			
			System.out.print("고객이름 : ");
			String cusName = sc.nextLine();
			
			System.out.print("잔고 : ");
			int money = sc.nextInt();
			sc.nextLine();
			
			System.out.print("기본이자%(정수형태로입력) : ");
			int plus = sc.nextInt();
			sc.nextLine();
			
			for(int i=0;i<accountArray.length;i++) {
				if(accountArray[i] == null) {
					accountArray[i] = new NomalAccount(accNum, cusName, money, plus);
					System.out.println("계좌개설이 완료되었습니다. ");
					break;
				}
			}
			break;
		case 2:
			System.out.print("계좌번호 : ");
			String accNum2 = sc.nextLine();
			
			System.out.print("고객이름 : ");
			String cusName2 = sc.nextLine();
			
			System.out.print("잔고 : ");
			int money2 = sc.nextInt();
			sc.nextLine();
			
			System.out.print("기본이자%(정수형태로입력) : ");
			int plus2 = sc.nextInt();
			sc.nextLine();
			
			System.out.print("신용등급(A,B,C등급) : ");
			int gPlus=0;
			String gradePlus = sc.nextLine();
			switch(gradePlus) {
			case "A":
				gPlus = 7;
				break;
			case "B":
				gPlus = 4;
				break;
			case "C":
				gPlus = 2;
				break;
			}
			
			for(int i=0;i<hcAccount.length;i++) {
				if(hcAccount[i] == null) {
					hcAccount[i] = 
							new HighCreditAccount(
									accNum2, cusName2, money2, plus2,gPlus);
					System.out.println("계좌개설이 완료되었습니다. ");
					break;
			}
		}
			break;
	}
}
	
	public static void showAccInfo() {
		System.out.println("***계좌정보출력***");
		for(int i =0; i<accountArray.length+hcAccount.length;i++) {
			if(accountArray[i] ==null) {
				if(hcAccount[i] == null) {
					break;
				}
				else {
					System.out.print("계좌번호 : ");
					System.out.println(hcAccount[i].getAccountNumber());
					System.out.print("고객이름 : ");
					System.out.println(hcAccount[i].getName());
					System.out.print("잔고 : ");
					System.out.println(hcAccount[i].getBalance());
					System.out.print("기본이자 : ");
					System.out.println(hcAccount[i].getAdd());
					System.out.print("신용등급 : ");
					if(hcAccount[i].getGradeAdd()==7) {
						System.out.println("A");
					}
					else if(hcAccount[i].getGradeAdd()==4) {
						System.out.println("B");
					}
					else {
						System.out.println("C");
					}
					break;
				}
			}
			System.out.print("계좌번호 : ");
			System.out.println(accountArray[i].getAccountNumber());
			System.out.print("고객이름 : ");
			System.out.println(accountArray[i].getName());
			System.out.print("잔고 : ");
			System.out.println(accountArray[i].getBalance());
			System.out.print("기본이자 : ");
			System.out.println(accountArray[i].getAdd());
		}
	}
	
	public static Account findAccount(String ano) {
		for(int i=0;i<accountArray.length;i++) {
			if(accountArray[i] == null) {
				break;
			}
			if(accountArray[i].getAccountNumber().equals(ano)) {
				return accountArray[i];
			}
		}
		return null;
	}
	
	public static HighCreditAccount findAccountt(String ano) {
		for(int i=0;i<hcAccount.length;i++) {
			if(hcAccount[i] == null) {
				break;
			}
			if(hcAccount[i].getAccountNumber().equals(ano)) {
				return hcAccount[i];
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
			if(findAccountt(ano) == null) {
				System.out.println("입력한 계좌번호를 찾지 못했습니다.");
			}
			else {
				findAccountt(ano).setBalance(
						findAccountt(ano).getBalance()
						+findAccountt(ano).getBalance()*findAccountt(ano).getAdd()/100
						+findAccountt(ano).getBalance()*findAccountt(ano).getGradeAdd()/100
						+dep);
			}
		}
		else {
			findAccount(ano).setBalance(
			findAccount(ano).getBalance()
					+findAccount(ano).getBalance()*findAccount(ano).getAdd()/100
					+dep);
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
			if(findAccountt(ano) == null) {
				System.out.println("입력한 계좌번호를 찾지 못했습니다.");
			}
			else {
				if(wit > findAccountt(ano).getBalance()) {
					System.out.println("잔액보다 큰 액수입니다.");
				}
				else {
					findAccountt(ano).setBalance(
							findAccountt(ano).getBalance() -  wit);
					System.out.println("출금이 완료되었습니다.");
				}
			}
		}
		else {
			if(wit > findAccount(ano).getBalance()) {
				System.out.println("잔액보다 큰 액수입니다.");
			}
			else {
				findAccount(ano).setBalance(
						findAccount(ano).getBalance() -  wit);
				System.out.println("출금이 완료되었습니다.");
			}
		}
	}
	public interface MenuItem{
		int MAKE = 1,DEPOSIT = 2,WITHDRAW = 3,INQUIRE = 4,EXIT = 5;
	}
	
	public interface subMenuItem{
		int A = 7, B = 4, C = 2;
	}

}
