package project2;

import java.util.Scanner;

import project2.ver02.Account;
import project2.ver02.AccountManager;
import project2.ver02.AccountManager.MenuItem;

public class BankingSystemVer02 implements MenuItem{
	
	public static void main(String[] args) {
		
		AccountManager manager = new AccountManager();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			manager.showMenu();
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case MenuItem.MAKE:
				manager.makeAccount();
				break;
			case MenuItem.DEPOSIT:
				manager.depositMoney();
				break;
			case MenuItem.WITHDRAW:
				manager.withdrawMoney();
				break;
			case MenuItem.INQUIRE:
				manager.showAccInfo();
				break;
			case MenuItem.EXIT:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}
