package ver09;

import java.sql.SQLException;

import ver09.IConnectImpl;

public class SelectQuery extends IConnectImpl{

	public SelectQuery() {
		super("kosmo", "1234");
	}

	@Override
	public void execute() {
		try
		{
			while(true)
			{
				String sql = "SELECT * FROM phonebook_tb "
				//	+ " WHERE name LIKE '%?%'";//부적합한 열 인덱스
					+ " WHERE name LIKE '%'||?||'%'";
	
				
				psmt = con.prepareStatement(sql);
				psmt.setString(1, scanValue("찾는이름"));
				rs = psmt.executeQuery();
				while(rs.next()) {
					String name = rs.getString(1);
					String phone = rs.getString(2);
					String birth = rs.getString(3);
					
					System.out.printf("%s %s %s\n",
							name, phone, birth);
				}
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
		new SelectQuery().execute();
	}
}
