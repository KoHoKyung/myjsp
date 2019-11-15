package com.koitt.www.controller.member;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;

import com.koitt.www.dao.MemberDao;
import com.koitt.www.vo.MemberVO;


@WebServlet("/member/memberInfo.ck")
public class MemberInfo extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		//할일
		// 1. 데이터 받고
		String mid = req.getParameter("mid");
		// 2. 데이터베이스 작업으로 데이터가져오고
		MemberDao dao = new MemberDao();
		MemberVO vo = dao.getList(mid);
		

		// 3. 응답 문서(json) 만들고
		PrintWriter pw = resp.getWriter();

		pw.print("{");
		pw.print("	\"m_no\" : " + vo.getM_No() + " , " );
		pw.print("	\"m_id\" : \"" + vo.getM_Id() + "\" , " );
		pw.print("	\"m_name\" : \"" + vo.getM_Name() + "\" , " );
		pw.print("	\"m_mail\" : \"" + vo.getM_Mail() + "\" , " );
		pw.print("	\"m_tel\" : \"" + vo.getM_Tel() + "\" , " );
		pw.print("	\"m_join\" : \"" + vo.getM_Join() + "\" " );
		pw.print("}");
	}
}
