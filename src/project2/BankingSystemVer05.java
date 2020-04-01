package project2;

import project2.ver05.InsertQuery;
import project2.ver05.SelectSQL1;
import project2.ver05.UpdateQuery;

public class BankingSystemVer05 {
	
	public static void main(String[] args) {
		
		new InsertQuery().execute();
		new UpdateQuery().execute();
		new SelectSQL1().execute();
		
//		MenuChoice menu = new MenuChoice();
//		Scanner sc = new Scanner(System.in);
//		while(true) {
//			menu.showMenu();
//			int choice = sc.nextInt();
//			sc.nextLine();
//			switch(choice) {
//			case MenuItem.MAKE:
//				menu.makeAccount();
//				break;
//			case MenuItem.DEPOSIT:
//				menu.depositMoney();
//				break;
//			case MenuItem.WITHDRAW:
//				menu.withdrawMoney();
//				break;
//			case MenuItem.INQUIRE:
//				menu.showAccInfo();
//				break;
//			case MenuItem.EXIT:
//				System.out.println("프로그램을 종료합니다.");
//				return;
//			}
//		}
	}
}
