package project2.ver05;

import java.sql.SQLException;

public class SelectSQL1 extends ConnectDB {

	//생성자메소드
	public SelectSQL1() {
		super("kosmo", "1234");
	}

/*
ResultSet 클래스
	: select문 실행시 쿼리의 실행결과가 ResultSet객체에 저장된다. 
	결과로 반환된 레코드의 처음부터 마지막까지 next()메소드를 통해
	확인후 반복하면서 추출하게 된다.

	-getXXX()계열의 메소드
	오라클의 자료형이
		number타입 : getInt() 
		char/varchar2타입 : getString()
		date타입 : getDate()
		메소드로 각 컬럼의 데이터를 추출한다. 
	-인자는 select절의 컬럼순서대로 인덱스(1부터시작)를 사용하거나
	컬럼명을 사용할 수 있다. 
	-자료형에 상관없이 getString()으로 모든 데이터를 추출할 수 있다.		
 */
	@Override
	public void execute() {
		try {
			st = con.createStatement();
			
//			String query = "SELECT accountNumber, name, balance"
//					+ " FROM banking_tb";
			
			String query = "SELECT * FROM banking_tb "
					//	+ " WHERE name LIKE '%?%'";//부적합한 열 인덱스
						+ " WHERE name LIKE '%'||?||'%'";
			 
			rs = st.executeQuery(query);
			while(rs.next()) {
				String accountNumber = rs.getString(1);
				String name = rs.getString("name");
				String balance = rs.getString("balance");				
				/*
				오라클의 date타입을 getDate()로 추출하면
					2020-03-25 형태로 출력된다. 이경우 date형 자료가 되기
					때문에 java.sql.Date클래스의 참조변수로 저장해야한다.
				 */

				System.out.printf("%-10s %-10s %-13s\n",
						accountNumber, name, balance);
			}
		}
		catch(SQLException e) {
			System.out.println("쿼리오류발생");
			e.printStackTrace();
		}
		finally {
			close();//DB 자원반납
		}
	}
	public static void main(String[] args) {
		SelectSQL1 selectSQL = new SelectSQL1();
		selectSQL.execute();
	}

	
}
