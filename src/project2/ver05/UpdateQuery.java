package project2.ver05;

import java.sql.SQLException;

import project2.ver05.ConnectDB;

public class UpdateQuery extends ConnectDB {

	//생성자에서 DB연결
	public UpdateQuery() {
		super("kosmo","1234");
	}

	@Override
	public void execute() 
	{
		String sql = "UPDATE banking_tb "
				+ "SET balance=? "
				+ "WHERE accountNumber=?";
		try {
			psmt = con.prepareStatement(sql);
			/*
			사용자 입력시 exit를 입력할때까지는 계속 실행되는 형태로 구성
			 */
			while(true) {	
				//인파라미터 설정시 해당 인덱스만 맞으면 순서는 상관없다. 
				psmt.setString(1, scanValue("계좌번호:"));
				psmt.setString(3, scanValue("잔고:"));
				

				int affected = psmt.executeUpdate();
				System.out.println(affected +"행이 업데이트 되었습니다.");
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
	}

	public static void main(String[] args) {
		new UpdateQuery().execute();
	}
}
