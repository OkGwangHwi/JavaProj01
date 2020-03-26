

import java.util.Scanner;

import ver03.PhoneInfo;

public class PhoneBookVer03 {
	Scanner sc = new Scanner(System.in);
	private int count;
	PhoneInfo[] phoneBook;
	
public PhoneBookVer03() {
	phoneBook = new PhoneInfo[100];
	count=0;
}

public static  void printMenu() {
	System.out.println("선택하세요...");
	System.out.println("1.데이터 입력");
	System.out.println("2.데이터 검색");
	System.out.println("3.데이터 삭제");
	System.out.println("4.주소록 출력");
	System.out.println("5.프로그램 종료");
}

public void dataInput() {
	
	String name,phone,birth;
	int[] arr = new int[100]; 
	
    System.out.print("이름:");
    name = sc.nextLine();
    System.out.print("전화번호:");
    phone = sc.nextLine();
    System.out.print("생년월일:");
    birth = sc.nextLine();
    PhoneInfo phoneInfo = new PhoneInfo(name, phone, birth);
    System.out.println("입력된 정보 출력...");
    phoneInfo.showPhoneInfo();
    
    for(int i=0;i<=100;i++) {
    }
}

public void dataSearch() {

	String name,phone,birth;
	System.out.println("데이터 검색을 시작합니다..");
	System.out.println("이름:");
	String search = sc.nextLine();
	for(int i=0;i<=100;i++) {
		if(search.equalsIgnoreCase(search)) {
			System.out.println("name:"+name);
			System.out.println("phone:"+phone);
			System.out.println("birth:"+birth);
		}
	}
}

public void dataDelete() {
	
}

public void dataAllShow() {
	
}

   public static void main(String[] args) {
      
      int input;
      Scanner sc = new Scanner(System.in);
      while(true) {
         printMenu();
         input = sc.nextInt();
         switch(input) {
         case 1:	 
        	 dataInput();
            break;
         case 2:
        	 dataSearch();
        	 break;
         case 3:
        	 dataDelete();
        	 break;
         case 4:
        	 dataAllShow();
        	 break;
         case 5:
        	System.out.println("선택:"+input);
            System.out.println("프로그램 종료");
            return;
         }
      }
   }
}