package com.koitt.www.controller.board;

import java.util.ArrayList;
import com.koitt.www.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.www.controller.MainController;
import com.koitt.www.dao.ReboardDAO;
import com.koitt.www.vo.ReboardVO;

public class Reboard implements MainController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/com/koitt/www/board/reboard.jsp";
		// 데이터 받고
		String sPage = req.getParameter("nowPage");
		int nowPage = 1;
		if(sPage != null) {
			nowPage = Integer.parseInt(sPage);
		}
		
	
		ReboardDAO dao = new ReboardDAO();
		int total = dao.getTotal();
		PageUtil pUtil = new PageUtil(nowPage, total);
		ArrayList<ReboardVO> list = new ArrayList<ReboardVO>();
		// 댓글게시판 테이블의 모든 데이터를 가져오고
		list = dao.reboardAlllist(pUtil.getStartCont(), pUtil.getEndCont());
		// 데이터 뷰에 넘기고
		req.setAttribute("LIST", list);
		req.setAttribute("PAGE", pUtil);
		// 뷰 부르고
		return view;
	}

}
