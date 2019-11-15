package com.koitt.www.controller.member;

import java.io.IOException;

import javax.servlet.http.*;


import com.koitt.www.controller.MainController;
import com.koitt.www.dao.MemberDao;
import com.koitt.www.vo.MemberVO;

public class Join implements MainController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("isRD", true);
		int cnt = 0;
		String view = "/main";
		
		String sid = req.getParameter("id");
		String spw = req.getParameter("pw");
		String sname = req.getParameter("name");
		String smail = req.getParameter("mail");
		String stel = req.getParameter("tel");
		
		MemberVO vo = new MemberVO();
		vo.setM_Id(sid);
		vo.setM_Pw(spw);
		vo.setM_Name(sname);
		vo.setM_Mail(smail);
		vo.setM_Tel(stel);
		
		MemberDao dao = new MemberDao();
		cnt = dao.AddMem(vo);
		
		if(cnt > 0 ) {
				HttpSession session = req.getSession();
				session.setAttribute("SID", sid);
		}else {
			
			try {
				view = "join.cls";
				resp.sendRedirect(view);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return view;
	}

}
