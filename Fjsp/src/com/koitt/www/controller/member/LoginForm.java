package com.koitt.www.controller.member;

import javax.servlet.http.*;

import com.koitt.www.controller.MainController;

public class LoginForm implements MainController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {

			String view = "/com/koitt/www/member/login.jsp";
			// 만약 이 요청의 겨로가가 리다이렉트인 경우는
			// 요청객체에 저장된 "isRD" 의 데이터를 true로 변경해주면 될 것이다.
			
		return view;
	}

}
