package ver09;

import ver09.IConnectImpl;

public class DeleteQuery extends IConnectImpl {

	@Override
	public void execute() {
		try {
			//1.DB연결
			connect("kosmo", "1234");
			//2.쿼리문 미리 준비
			String query = "DELETE FROM phonebook_tb WHERE name=?";
			//3.prepared객체 생성
			psmt = con.prepareStatement(query);
			//4.인파라미터 값 설정
			psmt.setString(1, scanValue("삭제할 이름"));
			//5.쿼리실행후 결과값 반환
			System.out.println(psmt.executeUpdate() 
					+"행이 삭제되었습니다");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}
	
	public static void main(String[] args) {
		new DeleteQuery().execute();		
	}
}
