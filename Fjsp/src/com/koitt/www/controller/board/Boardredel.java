package com.koitt.www.controller.board;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.www.controller.MainController;
import com.koitt.www.dao.FileBoardADao;
import com.koitt.www.vo.CommentVO;

public class Boardredel implements MainController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String bno = req.getParameter("bno");
		String fbno = req.getParameter("fbno");
		String view = "/board/boardclick.cls?sid=" + fbno ;
		ArrayList<CommentVO> list = new ArrayList<CommentVO>();
		System.out.println(bno);
		System.out.println(fbno);
		int cnt = new FileBoardADao().delre(bno);
		req.setAttribute("list", list);
		return view;
	}

}
