package proj1.member;

import javax.servlet.http.*;

import dao.MemberDAO;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

import vo.*;

/**
 * 이 클래스는 회원가입에 성공한 회원들의 리스트를 보여주는 페이지를 부르는 클래스
 * @author 고호경
 * @since 2019.11.12
 * @version v.1.0
 * 
 * 			변경이력
 * 				2019. 11. 12	-	클래스제작	-	담당자 : 고호경
 *
 */

/*
 	웹 어플리케이션을 제작을 하다보면 
 	자바 클래스들이 다수 작성이 되는데
 	이중에서 클라이언트의 요청을 처리해주는 클래스가 있고
 	그 클래스의 처리를 도와주는 클래스가 있다.
 	여기서 
 		Controller	-	클라이언트의 요청을 처리해주는 클래스
 						(HttpServlet 을 상속받아서 제작한 클래스)
 		일반클래스	-	컨트롤러의 처리를 도와주는 클래스
 */
@WebServlet("/member/name.ck")
public class name extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

		//	할일
		//	1. 데이터베이스에서 조회하고
			MemberDAO dao = new MemberDAO();
			ArrayList<VO> list = dao.getlist();
		// 데이터 넘기고
//			req.getSession().setAttribute("LIST", "");
//		req.getSession().setAttribute("LIST", "ASd");
			
		// 데이터 꺼낼때는
//			request.getAttribute("키값");
			 
			req.setAttribute("LIST", list);
			String view = "/com/koitt/www/member/Name.jsp";
		// 뷰부르고
			req.getRequestDispatcher(view).forward(req, resp);
//		RequestDispatcher rd = req.getRequestDispatcher(view);
//		rd.forward(req, resp);
	}
}
