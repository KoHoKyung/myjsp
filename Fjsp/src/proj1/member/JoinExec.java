package proj1.member;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import dao.MemberDAO;
import vo.*;


@WebServlet("/member/joinExec.nop")
public class JoinExec extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//할일
		// 1. 데이터 받고
		String tid = req.getParameter("id");
		String tpw = req.getParameter("pw");
		String tname = req.getParameter("name");
		String tmail = req.getParameter("mail");
		String tel = req.getParameter("tel");
		
		
		// 데이터 여러개를 각각 넘겨주는 방법도 있지만 불편하므로
		// 하나로 넘겨줄 수 있는 VO에 데이터를 담아서 넘겨주자
		VO vo = new VO();
		vo.setM_Id(tid);
		vo.setM_Pw(tpw);
		vo.setM_Name(tname);
		vo.setM_Mail(tmail);
		vo.setM_Tel(tel);
		// 2. 데이터베이스 작업하고
		int cnt = new MemberDAO().addMember(vo);
		String view = "/";
		
		if(cnt > 0 ) {
			// 이 경우는 회원가입에 성공한 경우
			// 이 경우는 로그인 처리도 같이 해주자.
			
			// 우리는 로그인 처리를 새션에 아이디를 입력하는 방법으로 처리하기로 했으므로
			// 세션에 아이디를 입력해 두자.
			req.getSession().setAttribute("SID", tid);
			
			resp.sendRedirect(view);
		}else {
			// 이 경우는 회원가입에 실패한 경우이므로
			// 다시 회원가입 페이지로 이동하기로하자.
			System.out.println("실패");
			view = "/member/join.nop";
			resp.sendRedirect(view);
		}
	}
}
