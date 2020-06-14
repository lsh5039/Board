package kr.co.board.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.board.db.UserDAO;
import kr.co.board.model.UserVO;

@WebServlet("/login.do")	
public class LoginSer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/user/login.jsp");
   		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 데이터를 받는다.
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println("id: "+id);
		System.out.println("pw: "+pw);
		
		//2.객체화해서 메서드를 실행한다.
		UserVO vo =new UserVO();
		vo.setId(id);
		vo.setPw(pw);
		int result = UserDAO.doLogin(vo);//알 수 없는 에러:0, 로그인성공 : 1, 아이디 x: -1,  아이디비밀번호 불일치:-2 
		
		System.out.println("result : "+result);
		//3.메서드의 리턴값에따라 페이지를 나뉘어준다.
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/user/login.jsp");
		switch(result) {
			case 0:
				request.setAttribute("msg", "알 수없는 오류로 로그인 실패");
				break;
			case 1:
				HttpSession hs = request.getSession();
				hs.setAttribute("loginUser", vo);
				response.sendRedirect("/write");
				return;
			case-1:
				request.setAttribute("msg", "존재하지 않는 계정입니다.");
				break;
			case-2:	
				request.setAttribute("msg", "아이디 비밀번호가 일치하지 않습니다.");
				break;
		}
		rd.forward(request, response);		
	}

}
