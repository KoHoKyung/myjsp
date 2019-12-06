package com.koitt.www.controller.survey;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koitt.www.controller.MainController;
import com.koitt.www.dao.SurveyDAO;
import com.koitt.www.vo.SurveyVO;

public class SurveyDetail implements MainController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		String view = "/com/koitt/www/survey/surveyDetail.jsp";

		String strsno = req.getParameter("sno");
		if(strsno != null) {
		
		int sno = Integer.parseInt(strsno);

		String title = req.getParameter("title");
		System.out.println(title);
//		String sid = req.getParameter("sid");
		
		SurveyDAO dao = new SurveyDAO();
		ArrayList<SurveyVO> list = dao.getSDetaillist(sno);
		
		req.setAttribute("LIST", list);
		req.setAttribute("SNO", sno);
		req.setAttribute("TITLE", title);
		} else {
			view = "/survey/survey.cls";
		}
		return view;
	}

}
