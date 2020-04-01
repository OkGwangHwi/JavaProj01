package project2;

import java.util.InputMismatchException;
import java.util.Scanner;

import project2.ver04.AccountManager;
import project2.ver04.MenuChoice;
import project2.ver04.MenuSelectException;

public class BankingSystemVer04 implements MenuChoice{
	
	public static void main(String[] args) {
		
		AccountManager manager = new AccountManager();
		
		while(true) {
			try {
			Scanner scan = new Scanner(System.in);
			manager.showMenu();
	         
	        int choice = scan.nextInt();
	        scan.nextLine();
	        
	        if(choice<1 || choice>5) {
	        	throw new MenuSelectException("1~5사이의 값을 입력하세요.");
	        }
	        else
			switch(choice) {
			case MenuChoice.MAKE:
				manager.makeAccount();
				break;
			case MenuChoice.DEPOSIT:
				manager.depositMoney();
				break;
			case MenuChoice.WITHDRAW:
				manager.withdrawMoney();
				break;
			case MenuChoice.INQUIRE:
				manager.showAccInfo();
				break;
			case MenuChoice.EXIT:
				manager.saveAccountCustomer();
				System.out.println("프로그램을 종료합니다.");
				return;
				}
			}
			catch(InputMismatchException e) {
				System.out.println("숫자를 입력하세요.");
				break;
			} 
			catch(MenuSelectException e) {
				e.printStackTrace();
			}
		}
	}
}