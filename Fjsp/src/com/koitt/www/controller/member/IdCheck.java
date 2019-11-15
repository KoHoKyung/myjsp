package com.koitt.www.controller.member;

import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.koitt.www.dao.MemberDao;

@WebServlet("/member/idCheck.mmo")
public class IdCheck extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cnt = 0;
		String sid = req.getParameter("id");
		
		MemberDao dao = new MemberDao();
		cnt = dao.getCnt(sid);
		
		PrintWriter pw = resp.getWriter();
		
		pw.print("{");
		pw.print(" \"cnt\" : " + cnt);
		pw.print("}");
		
	}
}
