package com.koitt.www.controller.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.www.controller.MainController;
import com.koitt.www.dao.FileBoardADao;
import com.koitt.www.vo.CommentVO;

public class BoardRe implements MainController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String sid = req.getParameter("sid");
		String rep = req.getParameter("rep");
		String fbno = req.getParameter("fbno");
		req.setAttribute("isRD", true);
		int cnt = 0;
		System.out.println(sid);
		System.out.println(rep);
		System.out.println(fbno);
		String view = "/board/boardclick.cls?sid=" + fbno ;
		ArrayList<CommentVO> list = new ArrayList<CommentVO>();
		
		FileBoardADao dao = new FileBoardADao();
		cnt = dao.addboardre(sid, rep, fbno);
		System.out.println(cnt);
		req.setAttribute("list", list);
		System.out.println(list);
		return view;
	}

}
