package project1;

import ver05.MenuItem;
import ver05.PhoneBookManager;
import ver05.PhoneInfo;
import ver05.SubMenuItem;
import java.util.Scanner;

public class PhoneBookVer05 implements MenuItem,SubMenuItem{
   
   public static void main(String[] args) {
      
      PhoneBookManager manager = new PhoneBookManager(100);
      Scanner scan = new Scanner(System.in);
      while(true) {
         manager.printMenu();
         int choice = scan.nextInt();
         scan.nextLine();
         
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
   }
}