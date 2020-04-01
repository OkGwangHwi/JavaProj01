package project2.ver05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//객체생성의 목적이 아닌 상속의 목적으로 정의된 추상클래스
public class IConnectImpl implements IConnect{
	
	//동적쿼리 처리를 위한 객체 
	public PreparedStatement psmt;
	public Connection conn;
	public ResultSet rs;
	public Statement stmt;

	public IConnectImpl() {
		System.out.println("IConnectImpl 기본생성자 호출");
	}
	
	public IConnectImpl(String id,String pw) {
		try {
			//드라이버
			Class.forName(ORACLE_DRIVER);
			//DB
			connect(id,pw);
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//오라클 DB에 실제 접속
	@Override
	public void connect(String id, String pw) {
		try {
			conn = DriverManager.getConnection(ORACLE_URL, id, pw);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	오버라이딩의 목적으로만 정의한 메소드. 쿼리실행은 각 클래스에서
	진행한다. 
	 */
	public void execute() {
		//하는일 없음
	}

	public void close() {
		try {
			if(stmt!=null) stmt.close();
			if(conn!=null) conn.close();
			if(psmt!=null) psmt.close();
			if(rs!=null) rs.close();
			System.out.println("자원 반납 완료");
		}
		catch(Exception e) {
			System.out.println("자원 반납시 오류발생");
			e.printStackTrace();
		}
	}
}
