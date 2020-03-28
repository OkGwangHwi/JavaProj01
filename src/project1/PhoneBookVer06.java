package project1;

import ver06.MenuItem;
import ver06.MenuSelectException;
import ver06.PhoneBookManager;
import ver06.SubMenuItem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PhoneBookVer06 implements MenuItem,SubMenuItem{
   
   public static void main(String[] args) {
      
	  PhoneBookManager manager = new PhoneBookManager(100);
	  
      while(true) {
    	  try {
    	  Scanner scan = new Scanner(System.in);
         manager.printMenu();
         
         int choice = scan.nextInt();
         scan.nextLine();
        if(choice<1 || choice>5) {
        	throw new MenuSelectException("1~5사이의 값을 입력하세요.");
        }
        else 
		switch(choice) {
         case MenuItem.INPUT:
        	 System.out.print("1.일반,2.대학,3.회사");
        	 int input = scan.nextInt();
        	 scan.nextLine();
        	 
        	 switch(input) {
        	 case SubMenuItem.NOMAL:
        		 manager.dataInput1();
        		 break;
        	 case SubMenuItem.SCHOOL:
        		 manager.dataInput2();
        		 break;
        	 case SubMenuItem.COMPANY:
        		 manager.dataInput3();
        		 break;
        	 }
        	 break;
         case MenuItem.SEARCH:
            manager.dataSearch();
            break;
         case MenuItem.DELETE:
            manager.deleteInfo();
            break;
         case MenuItem.EXIT:
            System.out.println("프로그램을 종료합니다.");
            return;
			}
        }
		catch(InputMismatchException e) {
			System.out.println("숫자만 입력하세요.");
    	}
    	catch(MenuSelectException e) {
    		System.out.println("예외발생:"+e.getMessage());
    		
    	}
      }
   }
}