package kr.co.board.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.board.model.BoardVO;

public class BoardDAO {
	public static int doWrite(BoardVO param) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into board(title,content) values(?, ?)";
		
		try {
			con = Conn.getCon();
			ps = con.prepareStatement(sql);
			ps.setString(1, param.getTitle());
			ps.setString(2, param.getContent());
			result = ps.executeUpdate();//쿼리가 성공했다면 1리턴
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			Conn.close(con, ps);
		}
		return result;
	}
	
	
	public static List<BoardVO> getList(){
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from board";
		
		try {
			con = Conn.getCon();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setPk(rs.getInt("pk"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setHits(rs.getString("hits"));
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Conn.close(con, ps, rs);
		}
		return list;
	
	}
	
	
	
}
