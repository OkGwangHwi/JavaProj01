package project1;

import java.util.Scanner;
import ver02.PhoneInfo;

public class PhoneBookVer02 {
   
public static void showMenu() {
   System.out.println("1.데이터 입력");
   System.out.println("2.프로그램 종료");
}

public static void addAdress() {
    
    Scanner scan = new Scanner(System.in);
    String name,phone,birth;
    
    System.out.print("이름:");
    name = scan.nextLine();
    System.out.print("전화번호:");
    phone = scan.nextLine();
    System.out.print("생년월일:");
    birth = scan.nextLine();
    PhoneInfo phoneInfo = new PhoneInfo(name, phone, birth);
    System.out.println("입력된 정보 출력...");
    phoneInfo.showPhoneInfo();
}
   public static void main(String[] args) {
      
      int input;
      Scanner scan = new Scanner(System.in);
      while(true) {
         showMenu();
         input = scan.nextInt();
         switch(input) {
         case 1:
            addAdress();
            break;
         case 2:
            System.out.println("프로그램을 종료합니다.");
            return;
         }
      }
   }
}