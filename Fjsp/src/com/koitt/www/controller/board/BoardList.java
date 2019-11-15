package com.koitt.www.controller.board;

import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.http.*;
import java.lang.*;

import com.koitt.www.controller.MainController;
import com.koitt.www.dao.FileBoardADao;
import com.koitt.www.vo.FileboardVO;

public class BoardList implements MainController {

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		// 뷰정하고
		String view = "/com/koitt/www/board/boardlist.jsp";
		// DAO에서 데이터베이스 작업하고
		FileBoardADao fbdao = new FileBoardADao(); 
		ArrayList<FileboardVO> list = fbdao.getFBList();
		
		// 데이터 넘기고
		/*
		 	이 컨트롤러에서 부르는 뷰는
		 	forward 방식으로 부를 것이고
		 	forward 방식은 요청을 유지하면서 뷰만 바꿔서 보여주는 것이므로
		 	요청 객체가 유지가 될 것이고
		 	이 말은 req 데이터가 계속 유지가 된다는 이야기다.
		 	따라서 req 에 데이터를 넣어 둔다면 뷰에서도
		 	넣어둔 그 데이터를 사용할 수 있을 것이다.
		 */

		req.setAttribute("LIST", list);
		
		return view;
	}

}
