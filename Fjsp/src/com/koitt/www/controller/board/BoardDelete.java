package com.koitt.www.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.www.controller.MainController;
import com.koitt.www.dao.FileBoardADao;

public class BoardDelete implements MainController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		
		int cnt = 0;
		String view = "/board/boardlist.cls";
		String fbno = req.getParameter("fbno");
	
		FileBoardADao dao = new FileBoardADao();
		cnt = dao.boardDelete(fbno);
		if (cnt > 0) {
			System.out.println("삭제성공");
			req.setAttribute("isRD", true);
		} else {
			System.out.println("오류");
		}
		return view;
	}

}
