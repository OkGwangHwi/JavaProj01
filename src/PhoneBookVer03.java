

import java.util.Scanner;

import ver03.PhoneInfo;

public class PhoneBookVer03 {
	Scanner sc = new Scanner(System.in);
	private int count; //전화번호부에 저장되있는 사람수
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
    phoneBook[count++] = new PhoneInfo(name, phone, birth);
    System.out.println("입력된 정보 출력...");
 
    
}


public void dataSearch() {

	int index;
	String name,phone,birth;
	System.out.println("데이터 검색을 시작합니다..");
	System.out.println("이름:");
	name = sc.nextLine();
	index = search(name);
	if(index<0)
		System.out.println("해당하는 값이 없습니다.");
	else {
		phoneBook[index].showPhoneInfo();
	}
}

public int search(String name) {
	for(int index=0;index<count;index++){
		   if(name.compareTo(phoneBook[index].getName())==0){
		    return index;
		   }
	}
		  return -1;
}


public void dataDelete() {
	int index;
	System.out.println("삭제할 이름 입력:");
	String name = sc.nextLine();
	index = search(name);
	if(index<0)
		System.out.println("해당하는 값이 없습니다.");
	else {
		for(int i=index;i<count-1;i++) {
			phoneBook[i] = phoneBook[i+1];
		}
		count--;
		System.out.println("데이터 삭제 완료");
	}
}

public void dataAllShow() {
	System.out.println("전체 데이터 조회.");
	
}


   public static void main(String[] args) {
	   
	   PhoneBookVer03 pbv = new PhoneBookVer03();
      
      int input;
      Scanner sc = new Scanner(System.in);
      while(true) {
         printMenu();
         input = sc.nextInt();
         switch(input) {
         case 1:
        	 pbv.dataInput();
            break;
         case 2:
        	 pbv.dataSearch();
        	 break;
         case 3:
        	 pbv.dataDelete();
        	 break;
         case 4:
        	 pbv.dataAllShow();
        	 break;
         case 5:
        	System.out.println("선택:"+input);
            System.out.println("프로그램 종료");
            return;
         }
      }
   }
}