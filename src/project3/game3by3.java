package project3;

public class game3by3 {
   
   int maxCount = 9;   
   char puzzle[] = new char[]{'1', '2', '3' , '4', '5', '6', '7', '8', 'X'};
   
   public void init() {

      
      
      for(int i = 0; i < maxCount; i++) {
         //배열에 1~8, X 대입
      }
   }
   
   public static void main(String[] args) {
   
      game3by3 game = new game3by3(); 
      
      game.init();
      
      game.shufle();
      
      game.printScreen();         
      
      
      
      do
      {
         game.standby();
      
         int key = -1;
         
         //key에 사용자가 입력한 키가 무엇인지 저장
         
         game.switchPosition(key);
      
      }while(false == game.checkComplete());
      
   }
   

   public void shufle() {
      
      int loopCount = 3;
      for(int i = 0; i < loopCount; i++) {
         int random = 0;
         
//         random = //1~4 사이의 랜덤값.
         if(false == switchPosition(random)) {
            i--;
         }
      }
   }

   public void printScreen() {
      //화면 출력
      //puzzle에 있는걸 3x3으로 출력
   }
   
   public void standby() {
      //키입력대기
   }
   
   
   public boolean switchPosition(int key /*???*/) {      
      //입력된 키값에 따라 위치변경
      
      printScreen();
      return true;
   }
   
   public boolean checkComplete() {
      //게임이 끝났는지 검사.
      return true;
   }
   
   
}