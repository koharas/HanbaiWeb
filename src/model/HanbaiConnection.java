package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HanbaiConnection {
	private Connection con=null ;

	public Connection getConnection(){
		try {
			//con = DriverManager.getConnection("jdbc:mysql://localhost/hanbai?useSSL=false", "root", "");
			con = DriverManager.getConnection("jdbc:mysql://localhost/hanbai?useSSL=false", "java", "pass");
		} catch (SQLException e) {
			System.out.println("DBコネクションエラー:" + e.getMessage());
		}
		return con;
	}

	public void close() {
		try {
			if( con != null ) {
				con.close();
			}
		}catch (SQLException e) {
			System.out.println("DBクローズエラー");
		}
	}
}
