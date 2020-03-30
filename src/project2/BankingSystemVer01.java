package project2;

import java.util.Scanner;

import oracle.net.ns.MarkerPacket;
import project2.ver01.Account;
import project2.ver01.MenuChoice;
import project2.ver01.MenuChoice.MenuItem;

public class BankingSystemVer01 implements MenuItem{
	
	public static void main(String[] args) {
		
		MenuChoice menu = new MenuChoice();
		Scanner sc = new Scanner(System.in);
		while(true) {
			menu.showMenu();
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case MenuItem.MAKE:
				menu.makeAccount();
				break;
			case MenuItem.DEPOSIT:
				menu.depositMoney();
				break;
			case MenuItem.WITHDRAW:
				menu.withdrawMoney();
				break;
			case MenuItem.INQUIRE:
				menu.showAccInfo();
				break;
			case MenuItem.EXIT:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
		}
	}
}
