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

//controller
@WebServlet("/write")
public class WriteSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		UserVO loginUser = (UserVO)hs.getAttribute("loginUser");
		if(loginUser ==null) {
			response.sendRedirect("/login.do");
			return;
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/board/write.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String user_pk = request.getParameter("user_pk");
		BoardVO vo = new BoardVO();
		//캡슐화된 객체 접근방법
		//값을 셋팅 하는방법 2가지 -> 메서드(set), 생성자
		//값을 쓰는방법은 1가지 -> 메서드(get)
		int intUser_pk = Integer.parseInt(user_pk);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setUser_pk(intUser_pk);
		int result = BoardDAO.doWrite(vo);
		if(result !=1) {//글쓰기 실패
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/board/write.jsp");
			request.setAttribute("msg", "글 작성에 실패했습니다.");
			rd.forward(request, response);
		}else {
			response.sendRedirect("/board/list");
		}
		
	}

}
