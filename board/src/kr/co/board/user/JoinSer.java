package kr.co.board.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board.db.UserDAO;
import kr.co.board.model.UserVO;

@WebServlet("/join.do")
public class JoinSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/user/join.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPw(pw);
		vo.setName(name);
		int result = UserDAO.doJoin(vo);
		if(result == 1)
			response.sendRedirect("/index");
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/user/join.jsp");
			request.setAttribute("msg","아이디가 중복됐습니다.");
			request.setAttribute("id", id);
			rd.forward(request, response);
		}
		
	}

}
