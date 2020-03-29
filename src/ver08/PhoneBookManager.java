package ver08;

import ver08.PhoneSchoolInfo;
import ver08.PhoneCompanyInfo;
import ver08.PhoneInfo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.util.Scanner;


public class PhoneBookManager implements Serializable{
   
   public  PhoneBookManager(int num) {
      myAddress = new PhoneInfo[num];
      numOfAddress = 0;
   }

   private PhoneInfo[] myAddress;   
   private int numOfAddress;
   HashSet<String> hs = new HashSet<String>();
   
   
   public static void printMenu() {
      System.out.println("선택하세요...");
      System.out.println("1.데이터 입력");
      System.out.println("2.데이터 검색");
      System.out.println("3.데이터 삭제");
      System.out.println("4.전체 출력");
      System.out.println("5.프로그램 종료");
      System.out.println("선택 :");
}
   
   public void dataInput1() {
       
       Scanner scan = new Scanner(System.in);
       String Name,Phone;
       System.out.println("데이터 입력을 시작합니다...");
       System.out.print("이름:");
       Name = scan.nextLine();
       
       if(hs.add(Name)){
    	   System.out.print("전화번호:");
	       Phone = scan.nextLine();
	       myAddress[numOfAddress++] = new PhoneInfo(Name, Phone);
	       
		}
		else{
		  System.out.print("중복저장하시겠습니까? 1번:yes 2번:no");
       	  int overlap = scan.nextInt();
       	  scan.nextLine();
       	  switch(overlap) {
       	  case 1:
       		  for(int i=0; i < myAddress.length; i++)
   			  {       			  
       			  if(myAddress[i].name.equals(Name))
       			  {
	       		       System.out.print("전화번호:");
	       		       Phone = scan.nextLine();
	       		    myAddress[i] = new PhoneInfo(Name, Phone);
	       		       System.out.println("중복저장하였습니다.");
	       		    break;
       			  }
       			  else
       			  {
       				  System.out.println("이름이 없습니다.");
       				  break;
       			  }
   			  }      
       	  case 2:
       		  break;
       	  }
		}
   }

public void dataInput2() {
       
       Scanner scan = new Scanner(System.in);
       String Name,Phone,Major;
       int Grade;

       System.out.println("데이터 입력을 시작합니다...");
       System.out.print("이름:");
       Name = scan.nextLine();
       if(hs.add(Name)){
    	   System.out.print("전화번호 : ");
	       Phone = scan.nextLine();
	       System.out.print("전공 : ");
	       Major = scan.nextLine();
	       System.out.print("학년 : ");
	       Grade = scan.nextInt();
	       	       
	       myAddress[numOfAddress++] = new PhoneSchoolInfo(Name, Phone, Major, Grade);
		}
       	else{
		  System.out.print("중복저장하시겠습니까? 1번:yes 2번:no");
      	  int overlap = scan.nextInt();
      	  scan.nextLine();
      	  switch(overlap) {
      	  case 1:
      		  for(int i=0; i < myAddress.length; i++)
  			  {
      			
      			  if(myAddress[i].name.equals(Name))
      			  {
	       		       System.out.print("전화번호:");
	       		       Phone = scan.nextLine();
	       		       System.out.println("전공:");
	       		       Major = scan.nextLine();
	       		       System.out.print("학년:");
	       		       Grade = scan.nextInt();	       		              		       
	       		       
	       		       myAddress[i] = new PhoneSchoolInfo(Name, Phone, Major, Grade);
	       		       
	       		    System.out.println("중복저장하였습니다.");
	       		    break;
      			  }
      			  else
      			  {
      				  System.out.println("이름이 없습니다.");
      				  break;
      			  }
		  }      
  	  case 2:
  		  break;
  	  }
	}
  }       
   

public void dataInput3() {
    
    Scanner scan = new Scanner(System.in);
    String Name,Phone,Company;

    System.out.println("데이터 입력을 시작합니다...");
    System.out.print("이름:");
    Name = scan.nextLine();
    if(hs.add(Name)){
	   System.out.print("전화번호 : ");
       Phone = scan.nextLine();
       System.out.print("회사명 : ");
       Company = scan.nextLine();       
       
       myAddress[numOfAddress++] = new PhoneCompanyInfo(Name, Phone, Company);
	}
    else{
	  System.out.print("중복저장하시겠습니까? 1번:yes 2번:no");
  	  int overlap = scan.nextInt();
  	  scan.nextLine();
  	  switch(overlap) {
  	  case 1:
  		  for(int i=0; i < myAddress.length; i++)
			  {
  			
  			  if(myAddress[i].name.equals(Name))
  			  {
       		       System.out.print("전화번호:");
       		       Phone = scan.nextLine();
       		       System.out.println("회사명:");
       		       Company = scan.nextLine();
       		       
       		       myAddress[i] = new PhoneCompanyInfo(Name, Phone, Company);
       		       
       		    System.out.println("중복저장하였습니다.");
       		    break;
  			  }
  			  else
  			  {
  				  System.out.println("이름이 없습니다.");
  				  break;
  			  }
	  }      
	  case 2:
		  break;
	  }
}

    System.out.println("데이터 입력이 완료되었습니다.");
    
}
   
   public void dataSearch() {
      Scanner scan = new Scanner(System.in);
      System.out.println("데이터 검색을 시작합니다..");
      System.out.print("이름:");
      String searchName = scan.nextLine();
      
      for(int i=0 ; i<numOfAddress ; i++) {
          if(searchName.compareTo(myAddress[i].name)!=0) {
          }
          else {
        	  myAddress[i].showPhoneInfo();
              System.out.println("데이터 검색이 완료되었습니다.");
          		}
      		}
	   	}   

   
   public void deleteInfo() {
      Scanner scan = new Scanner(System.in);
      System.out.print("삭제를 시작합니다.");
      String deleteName = scan.nextLine();
      
      int deleteIndex = -1;
      
      for(int i=0 ; i<numOfAddress ; i++) {
         if(deleteName.compareTo(myAddress[i].name)==0) {
            myAddress[i] = null;
            deleteIndex = i;
            numOfAddress--;
         }
      }
      if(deleteIndex==-1) {
         System.out.println("삭제할 데이터가 없습니다.");
      }
      else {
         for(int i=deleteIndex ; i<numOfAddress ; i++) {
            myAddress[i] = myAddress[i+1];
         }
         System.out.println("데이터삭제가 완료되었습니다.");
      }
   }
   
   public void dataAllShow() {
	      for(int i=0 ; i<numOfAddress ; i++) {
	         myAddress[i].showPhoneInfo();
	      }
	      System.out.println("전체정보가 출력되었습니다.");
   }
   
   
   public void saveInfo() {
	   
	   
	   try {
    	   ObjectOutputStream out = 
    			   new ObjectOutputStream(
    					   new FileOutputStream("src/ver08/PhoneBook.txt")
    					   );
    	   for(int i=0 ; i<numOfAddress ; i++) {
				//객체배열의 i번째 요소를 파일로 저장
				out.writeObject(myAddress[i]);
				out.close();
    	   }
    	   FileInputStream fis = new FileInputStream("src/ver08/PhoneBook.txt");
    	   ObjectInputStream ois = new ObjectInputStream(fis);
    	   for(int i=0;i<numOfAddress;i++) {
    		   myAddress[i] = 
				in.close();
    	   }
	   }
	   catch (Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();
	   		}
   		}
   }
   