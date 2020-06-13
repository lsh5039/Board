package kr.co.board.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.board.model.UserVO;

public class UserDAO {
	public static int doJoin(UserVO param) {
		int result=0;//
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into user(id,pw,name) values(?,?,?)";
		try {			
			con = Conn.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getId());
			ps.setString(2, param.getPw());
			ps.setString(3, param.getName());
			result = ps.executeUpdate();//성공시 1리턴
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			Conn.close(con, ps);
		}
		return result;//실패했다면 0, 성공시 1리턴
	}
	
	public static int doLogin(UserVO param) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql =" select * from user where id = ? and pw = ?";
		
		try {
			con = Conn.getCon();//db연결
			ps = con.prepareStatement(sql);//쿼리실행
			ps.setString(1, param.getId());
			ps.setString(2, param.getPw());
			rs = ps.executeQuery();//쿼리문이 실행한 결과리턴(객체, 투플, 한 줄)
			
			if(rs.next()) {
				result = 1;//로그인 성공
			}else {
				result = -1;//로그인 실패
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			Conn.close(con, ps, rs);
		}
		return result;
	}
	
	
}
