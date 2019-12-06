package com.koitt.www.controller.board;

import java.util.ArrayList;

import java.util.Collections;

import javax.servlet.http.*;
import java.lang.*;

import com.koitt.www.controller.MainController;
import com.koitt.www.dao.FileBoardADao;
import com.koitt.www.vo.FileboardVO;

public class BoardList implements MainController {
	
	
	private final int PAGE_SIZE = 5;
	private final int PAGE_GROUP = 5; 
	

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		int cnt = 0;
		// 뷰정하고
		String view = "/com/koitt/www/board/boardlist.jsp";
		// DAO에서 데이터베이스 작업하고
		
		String st = req.getParameter("st");
		String sel = req.getParameter("select");
		String pageNum = req.getParameter("pageNum");
		
		
		FileBoardADao dao = new FileBoardADao();
		

		
		
		if(pageNum == null) {
			pageNum = "1";
		}
		int currentPage = Integer.parseInt(pageNum);
		int startRow = (currentPage*PAGE_SIZE) - PAGE_SIZE +1;
		int endRow = startRow + PAGE_SIZE -1;

	
//		---------------------------------------------------------------------------------------------
		/* st += "%"; */
		
		if(st != null && sel != null) {

			int ser = Integer.parseInt(sel);
			System.out.println(ser);
			// 제목
			if(ser == 1003 ) {
				cnt = dao.getMAXPAGEBT(st) ;
				ArrayList<FileboardVO> list1 = dao.getFBSER(startRow, endRow, st, ser);
				req.setAttribute("LIST", list1);
			
			// ID
			} else if(ser == 1004){
				cnt = dao.getMAXPAGEBI(st) ;
				ArrayList<FileboardVO> list = dao.getFBSER(startRow, endRow, st, ser);
				req.setAttribute("LIST", list);
		
			// 내용
			} else if(ser == 1005) {
				cnt = dao.getMAXPAGEBB(st) ;
				ArrayList<FileboardVO> list = dao.getFBSER(startRow, endRow, st, ser);
				req.setAttribute("LIST", list);
			
			// 제목 + 내용  	
			} else {
				cnt = dao.getMAXPAGEBA(st);
				ArrayList<FileboardVO> list = dao.getFBSA(startRow, endRow, st);
			
				req.setAttribute("LIST", list);
				
			}
			int totalPage = cnt / PAGE_SIZE + (cnt % PAGE_SIZE != 0 ? 1 : 0);
			int startPage = ((currentPage-1)/PAGE_GROUP)*PAGE_GROUP +1;
			int endPage = startPage + PAGE_GROUP -1;
			if(endPage > totalPage) {
				endPage = totalPage;
			}
		req.setAttribute("st", st);
		req.setAttribute("sel", sel);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("cur", currentPage);
		req.setAttribute("pageGroup", PAGE_GROUP);
//		---------------------------------------------------------------------------------------------
		} else {

			cnt = dao.getMAXPAGE();
		
		ArrayList<FileboardVO> list = dao.getFBList(startRow, endRow);
		st= null;
		sel = null;


		
		
		
		
		// 현재 페이지에 해당하는 게시 글 리스트를 가져오기 위해서 현재 페이지가 넘어왔는지 확인
		// 요청된 페이지가 없으면 무조건 1페이지로 하겠다. 있으면 요청 페이지에 해당하는 게시글을 DB로 부터 읽어오면됨
		// 요청 페이지 Request객체에서 읽어옴
		
		
		/*
		// 페이징 처리면 현재 요청된 페이지에 해당하는 게시글 리스트만 있으면 된다.
		// 3페이지에 해당하는 게시글을 읽어 올라면
		예를 들어 한 페이지에 3페이지라면 3페이지는 조회한 리스트에서 
		1페이지 : 1 ~ 3
		2페이지 : 4 ~ 6
		3페이지 : 7 ~ 9
		 
		  DAO에서 fbdao.getFBList(7, 9) 메서드 호출시 시간 행의 번호와 끝 행의 번호를 넘겨줘야함
		 * 
		 */
		
		
		

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
		
		// 페이지 네이게이션에 대한 처리				
		int totalPage = cnt / PAGE_SIZE + (cnt % PAGE_SIZE != 0 ? 1 : 0);
			
			int startPage = ((currentPage-1)/PAGE_GROUP) * PAGE_GROUP + 1;		
			int endPage = startPage + PAGE_GROUP -1 ;

		
		if(endPage > totalPage) {
			endPage = totalPage;
		}


		req.setAttribute("cur", currentPage);
		req.setAttribute("totalPage", totalPage);
		req.setAttribute("LIST", list);
		req.setAttribute("pageGroup", PAGE_GROUP);
		req.setAttribute("startPage", startPage);
		req.setAttribute("endPage", endPage);
		
		}
		return view;
	}

}
