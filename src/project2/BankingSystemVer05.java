package project2;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;

import project2.ver05.IConnectImpl;
import project2.ver05.MenuChoice;

public class BankingSystemVer05 extends IConnectImpl implements MenuChoice{
	
	public BankingSystemVer05() {
		super("kosmo","1234");
	}
	
	public void showMenu() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("1.계좌개설");
			System.out.println("2.입금");
			System.out.println("3.출금");
			System.out.println("4.전체계좌정보 출력");
			System.out.println("5.3by3게임");
			System.out.println("6.프로그램 종료");
			
			int choice = sc.nextInt();
			switch(choice) {
			case MenuChoice.MAKE:
				makeAccount();
				break;
			case MenuChoice.DEPOSIT:
				depositMoney();
				break;
			case MenuChoice.WITHDRAW:
				withdrawMoney();
				break;
			case MenuChoice.INQUIRE:
				showAccInfo();
				break;
			case MenuChoice.PUZZLE:
				break;
			case MenuChoice.EXIT:
				return;
			}
		}
	}
	
	public void makeAccount() {
		Scanner sc = new Scanner(System.in);
		String accNum,name;
		int balance;
		
		System.out.println("계좌번호:");
		accNum = sc.nextLine();
		System.out.println("계좌주:");
		name = sc.nextLine();
		System.out.println("잔고:");
		balance = sc.nextInt();
		
		try {
			//쿼리문
			String query = "INSERT INTO banking_tb VALUES(?,?,?)";
			psmt = conn.prepareStatement(query);
			
			//인파라미터
			psmt.setString(1, accNum);
			psmt.setString(2, name);
			psmt.setInt(3, balance);
			
			int affected = psmt.executeUpdate();
			System.out.println(affected+"행이 입력 완료");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
		System.out.println("계좌개설 완료");
	}
	
	public void depositMoney() {
		Scanner sc = new Scanner(System.in);
		String accNum,name;
		int deposit;
		
		System.out.println("계좌번호:");
		accNum = sc.nextLine();
		System.out.println("입금:");
		deposit = sc.nextInt();
		
		try {
			//쿼리문
			String query = "UPDATE banking_tb "
			+ "SET balance=balance+? "
					+ "WHERE account=?";
			psmt = conn.prepareStatement(query);
			
			//인파라미터
			psmt.setString(2, accNum);
			psmt.setInt(1, deposit);
			
			int affected = psmt.executeUpdate();
			System.out.println(affected+"행이 입력 완료");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
		System.out.println("입금 완료");
	}
	
	public void withdrawMoney() {
		Scanner sc = new Scanner(System.in);
		String accNum,name;
		int withdraw;
		
		System.out.println("계좌번호:");
		accNum = sc.nextLine();
		System.out.println("출금:");
		withdraw = sc.nextInt();
		
		try {
			//쿼리문
			String query = "UPDATE banking_tb "
			+ "SET balance=balance-? "
					+ "WHERE account=?";
			psmt = conn.prepareStatement(query);
			
			//인파라미터
			psmt.setString(2, accNum);
			psmt.setInt(1, withdraw);
			
			int affected = psmt.executeUpdate();
			System.out.println(affected+"행이 입력 완료");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			close();
		}
		System.out.println("출금 완료");
	}
	
	public void showAccInfo() {
		String account,name;
		int balance;
		System.out.println("Account    Name      Balance");
		System.out.println("==============================");
		try {
			String query = "SELECT account,name,balance "
		+ "FROM banking_tb ";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				account = rs.getString("account");
				name = rs.getString("name");
				balance = rs.getInt("balance");
				System.out.printf("%-10s %-10s %-10s \n", account, name, balance);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("출력완료");
	}
	
	public void searchAccount(String accountNumber) {
		Scanner sc = new Scanner(System.in);
		String account,name;
		int balance;
		System.out.println("Account       Name       Balance");
		
		try {
			String query = "SELECT * FROM banking_tb "
					+"WHERE accNum like '%" + accountNumber + "%'";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			while(true) {
				account = rs.getString(1);
				name = rs.getString(2);
				balance = rs.getInt(3);
				System.out.printf("%-10s %-10s %-10s \n", account, name, balance);

			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("출력완료");
	}
	
	public static void main(String[] args) {
		BankingSystemVer05 bankSys = new BankingSystemVer05();
		bankSys.showMenu();
	}
}
