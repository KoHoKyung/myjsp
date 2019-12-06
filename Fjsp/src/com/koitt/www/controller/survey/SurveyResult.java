package com.koitt.www.controller.survey;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.www.controller.MainController;
import com.koitt.www.dao.SurveyDAO;
import com.koitt.www.vo.SurveyVO;

public class SurveyResult implements MainController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/com/koitt/www/survey/surveyResult.jsp";
		System.out.println(view);
		// 파라미터 받고
		String strno = req.getParameter("sno");
		int sno = Integer.parseInt(strno);
		// 데이터베이스 작업하고
		SurveyDAO dao = new SurveyDAO();
		SurveyVO vo = dao.getSrvSno(sno);
		ArrayList<SurveyVO> list1 = dao.getQuest(sno);
		System.out.println(list1.toString());
		ArrayList<ArrayList<SurveyVO>> list2 = dao.getExData(list1);
	
		// 데이터 넘기고
		req.setAttribute("LIST1", list1);
		req.setAttribute("LIST2", list2);
		// 뷰부르고
		return view;
	}

}
