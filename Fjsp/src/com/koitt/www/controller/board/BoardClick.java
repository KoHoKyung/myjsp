package com.koitt.www.controller.board;

import java.util.ArrayList;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koitt.www.controller.MainController;
import com.koitt.www.dao.FileBoardADao;
import com.koitt.www.vo.FileboardVO;
public class BoardClick implements MainController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

		String view = "/com/koitt/www/board/boardbody.jsp";
		String sid = req.getParameter("sid");
		String cnt1 = "";
		String cnt = req.getParameter("cnt");


		
		System.out.println(sid);
		FileBoardADao dao = new FileBoardADao();
		
		
		ArrayList<FileboardVO> list = dao.getfBody(sid);

//		req.setAttribute("isRD", true);
		req.setAttribute("body", list);
		req.setAttribute("cnt", cnt);
		return view;
	}

}
