package com.koitt.www.controller.board;

import java.util.ArrayList;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koitt.www.controller.MainController;
import com.koitt.www.dao.FileBoardADao;
import com.koitt.www.vo.CommentVO;
import com.koitt.www.vo.FileboardVO;
public class BoardClick implements MainController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

		String view = "/com/koitt/www/board/boardbody.jsp";
		String sid = req.getParameter("sid");

		String cnt = req.getParameter("cnt");


		
		System.out.println(sid);
		FileBoardADao dao = new FileBoardADao();
		ArrayList<CommentVO> list = dao.getboardre(sid);
		
		ArrayList<FileboardVO> body = dao.getfBody(sid);
		System.out.println(list);
		System.out.println(body);
//		req.setAttribute("isRD", true);
		req.setAttribute("list", list);
		req.setAttribute("body", body);
		req.setAttribute("cnt", cnt);
		return view;
	}

}
