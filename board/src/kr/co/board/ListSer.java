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
import kr.co.board.model.UserVO;

@WebServlet("/board/list")
public class ListSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO)hs.getAttribute("loginUser");
		if(loginUser ==null) {
			response.sendRedirect("/login.do");
			return;
		}
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/board/boardList.jsp");
		
		request.setAttribute("list", BoardDAO.getList());
		
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
