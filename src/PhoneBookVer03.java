import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import ver03.PhoneInfo;

public class PhoneBookVer03 {
	PhoneInfo[] registPhone = new PhoneInfo[100];
	int cnt = 0;
	Scanner sc = new Scanner(System.in);
	static HashMap phoneBook = new HashMap();
	
public static void printMenu() {
	System.out.println("선택하세요...");
	System.out.println("1.데이터 입력");
	System.out.println("2.데이터 검색");
	System.out.println("3.데이터 삭제");
	System.out.println("4.주소록 출력");
	System.out.println("5.프로그램 종료");
}

public void dataInput() {
	
	String name,phone,birth;
	
    System.out.print("이름:");
    name = sc.nextLine();
    System.out.print("전화번호:");
    phone = sc.nextLine();
    System.out.print("생년월일:");
    birth = sc.nextLine();
    registPhone[cnt] = new PhoneInfo(name, phone, birth);
    System.out.println("입력된 정보 출력...");
    registPhone[cnt].showPhoneInfo();
    cnt++;
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
		registPhone[index].showPhoneInfo();
	}
}

private int search(String name) {
	for(int index=0;index<cnt;index++){
		PhoneInfo pInfo = registPhone[index];
		   if(name.compareToIgnoreCase(name)==0)
		    return index;
	}
		  return -1;
}


public void dataDelete() {
	int index;
	String name;
	System.out.println("삭제할 이름 입력:");
	name = sc.nextLine();
	index = search(name);
	if(index<0)
		System.out.println("해당하는 값이 없습니다.");
	else {
		for(int i=index;i<cnt-1;i++) {
			registPhone[i] = registPhone[i+1];
		}
		cnt--;
		System.out.println("데이터 삭제 완료");
	}
}

public void dataAllShow() {
	Set set = phoneBook.entrySet();
	Iterator iterator = set.iterator();
	
	while(iterator.hasNext()) {
		Map.Entry entry = (Map.Entry) iterator.next();
	}
}


   public static void main(String[] args) {
	   
	   PhoneBookVer03 pbv = new PhoneBookVer03();
       int input;
       Scanner sc = new Scanner(System.in);
       
      while(true) {
         pbv.printMenu();
         input = pbv.sc.nextInt();
         pbv.sc.nextLine();
         
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