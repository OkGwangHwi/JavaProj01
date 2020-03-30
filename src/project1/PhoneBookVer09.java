package project1;

import ver09.DeleteQuery;
import ver09.InsertQuery;
import ver09.SelectQuery;

public class PhoneBookVer09 {
   
   public static void main(String[] args) {
	   
	   new InsertQuery().execute();
	   
	   new DeleteQuery().execute();
	   
	   new SelectQuery().execute();
      
//      PhoneBookManager manager = new PhoneBookManager(100);
//      
//      Scanner scan = new Scanner(System.in);
//      while(true) {
//         manager.printMenu();
//         int choice = scan.nextInt();
//         switch(choice) {
//         case 1:
//            manager.dataInput();
//            break;
//         case 2:
//            manager.dataSearch();
//            break;
//         case 3:
//            manager.deleteInfo();
//            break;
//         case 4:
//            manager.dataAllShow();
//            break;
//         case 5:
//            System.out.println("프로그램을 종료합니다.");
//            return;
//         }
//      }
   }
}