package kr.co.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.db.BoardDAO;
import kr.co.board.model.BoardVO;


@WebServlet("/board/comment")
public class BoardCommentSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_pk = request.getParameter("user_pk");
		String board_pk = request.getParameter("board_pk");
		String com_content = request.getParameter("com_content");
		BoardVO vo = new BoardVO();
		int intBoard_pk = Integer.parseInt(board_pk);
		int intUser_pk = Integer.parseInt(user_pk);
		
		vo.setUser_pk(intUser_pk);
		vo.setCom_content(com_content);
		vo.setPk(intBoard_pk);
		
		BoardDAO.writeComment(vo);
		response.sendRedirect("/board/detail?pk="+board_pk);
	}

}
