package project2.ver05;

public interface IConnect {

	String ORACLE_DRIVER = "oracle.jdbc.OracleDriver";
	String ORACLE_URL = "jdbc:oracle:thin://@localhost:1521:orcl";
	
	void connect(String id,String pw);
}
