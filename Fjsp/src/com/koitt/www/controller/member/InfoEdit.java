package com.koitt.www.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.koitt.www.dao.*;
import com.koitt.www.vo.*;

@WebServlet("/member/infoEdit.ck")
public class InfoEdit extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 할일
		// 1. 데이터 받고 VO 담고
		int cnt = 0;
		String scode = req.getParameter("code");
		String sno = req.getParameter("mno");
		int mno = Integer.parseInt(sno);
		String smail = "";
		String stel = "";
		System.out.println(scode);
		switch (scode) {
		case "1":
			smail = req.getParameter("mail");
			stel =  req.getParameter("tel");
			break;
		case "2":		
			smail = req.getParameter("mail");
			break;
		case "3":
			stel =  req.getParameter("tel");
			break;

		default:
			break;
		}
		MemberVO vo = new MemberVO();
		vo.setM_No(mno);
		vo.setM_Mail(smail);
		vo.setM_Tel(stel);
		// 2. 데이터 넘겨서 데이터베이스 작업하고
		MemberDao dao = new MemberDao();
		cnt = dao.memberEdit(vo, scode);
		// 3. 받은 결과 넘겨주고
		PrintWriter pw = resp.getWriter();
		
		pw.println("{");
		pw.println(" \"cnt\" :" + cnt );
		pw.print("}");
	}
}
