package kr.co.board.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conn {
	
	public static Connection getCon() throws Exception {
		final String dbURL = "jdbc:mysql://localhost:4406/board?serverTimezone=UTC";
		final String dbID = "root";
		final String dbPassword = "dltmdgns1!";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(dbURL,dbID,dbPassword);
		return con;
	}
	//40분에 다시시작할게요 
	
	
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public static void close(Connection con, PreparedStatement ps) {
		close(con, ps,null);
	}
}
