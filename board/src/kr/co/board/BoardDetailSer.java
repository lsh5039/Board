package kr.co.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.board.db.BoardDAO;
import kr.co.board.model.BoardVO;
import kr.co.board.model.UserVO;

@WebServlet("/board/detail")
public class BoardDetailSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String pk = request.getParameter("pk");
    	HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO)hs.getAttribute("loginUser");
		if(loginUser ==null || pk==null) {
			response.sendRedirect("/login.do");
			return;
		}
		
		int intPk = Integer.parseInt(pk);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/board/detail.jsp");
		request.setAttribute("one", BoardDAO.getOne(intPk));
	
		BoardVO vo = new BoardVO();
		
		vo.setPk(intPk);
		BoardDAO.updHits(vo);
		request.setAttribute("commentAll", BoardDAO.getCommentAll(vo));
		
		
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
