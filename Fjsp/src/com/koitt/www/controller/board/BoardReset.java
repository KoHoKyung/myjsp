package com.koitt.www.controller.board;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.SessionCookieConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koitt.www.controller.MainController;
import com.koitt.www.dao.FileBoardADao;
import com.koitt.www.vo.FileboardVO;


public class BoardReset implements MainController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		int cnt = 0;
		String sid = req.getParameter("mno");
		String fbb = req.getParameter("fbb");
		FileBoardADao dao = new FileBoardADao();
		
		cnt = dao.boardReset(fbb, sid);
		String view = "/board/boardclick.cls?sid=" + sid + "&cnt=" +cnt;
		if(cnt > 0) {
			req.setAttribute("sid", sid);
		System.out.println("등록완료");
		}
		else {
			System.out.println("등록실패");
		}
//		ArrayList<FileboardVO> list = dao.getfBody(sid);
		req.setAttribute("cnt", cnt);
//		req.setAttribute("body", list);
		req.setAttribute("isRD", true);
		
		return view;
	}

}
