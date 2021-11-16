package mms.member.db;

//1. DB관련 공통 기능 클래스
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	
	static {
	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
		}
	}
	
	//메모리에 있는 메소드 호출이 일어나야 실행
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","javalink","javalink");
			con.setAutoCommit(true);
			
		} catch (SQLException e) {
		}
		return con;
	}
	
	public static void close(Connection con){
		try{
			con.close();
		}
		catch(SQLException e){
		}
	}

	public static void close(Statement stmt){
		try{
			stmt.close();
		}
		catch(SQLException e){
		}
	}
	
	public static void close (PreparedStatement pstmt){
		try{
			pstmt.close();
		}
		catch(SQLException e){
		}
	}

	public static void close(ResultSet rs){
		try{
			rs.close();
		}
		catch(SQLException e){
		}
	}

 
 
 
	
	
	//transaction 처리 메소드
	public static void commit(Connection con) {
		try {
			con.commit();//insert, update, delete
		} catch (SQLException e) {
			
			
		}
	}
	public static void rollback (Connection con) {
		try {
			con.rollback();
		} catch (SQLException e) {
		}
	}
	
	static{
		//클래스가 로딩될 때 단 한번 호출되는 영역
		//Class.forName : 특정 클래스를 메모리로 로딩하는 메소드

		
	}

 
	//transaction 처리 메소드
 
 
 

	}
