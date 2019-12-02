package com.koitt.www.controller.board;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import com.koitt.www.controller.MainController;
import com.koitt.www.dao.FileBoardADao;

public class BoardWriteProc implements MainController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		
		String view = "boardlist.cls";
		
		
		String sid = req.getParameter("id");

		String fbname = req.getParameter("fbname");
		String fbbody = req.getParameter("fbbody");

		int cnt = 0;
		FileBoardADao dao = new FileBoardADao();
		cnt = dao.getwrite(sid, fbname, fbbody);
		
		if(cnt > 0 ) {
			System.out.println("등록완료");
			req.setAttribute("cnt", cnt);
		}else {
			System.out.println("실패");
			view = "boardwrite.cls";
		}
		return view;
	}

}
