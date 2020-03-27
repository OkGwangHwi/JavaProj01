package project1;


import ver04.PhoneBookManager;
import ver04.PhoneInfo;
import java.util.Scanner;

public class PhoneBookVer04 {
   
   public static void main(String[] args) {
      
      PhoneBookManager manager = new PhoneBookManager(100);
      Scanner scan = new Scanner(System.in);
      while(true) {
         manager.printMenu();
         int choice = scan.nextInt();
         scan.nextLine();
         
         switch(choice) {
         case 1:
        	 System.out.print("1.일반,2.대학,3.회사");
        	 int input = scan.nextInt();
        	 scan.nextLine();
        	 
        	 switch(input) {
        	 case 1:
        		 manager.dataInput1();
        		 break;
        	 case 2:
        		 manager.dataInput2();
        		 break;
        	 case 3:
        		 manager.dataInput3();
        		 break;
        	 }
        	 break;
         case 2:
            manager.dataSearch();
            break;
         case 3:
            manager.deleteInfo();
            break;
         case 4:
            manager.dataAllShow();
            break;
         case 5:
            System.out.println("프로그램을 종료합니다.");
            return;
         }
      }
   }
}