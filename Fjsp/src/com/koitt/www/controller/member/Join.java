package com.koitt.www.controller.member;

import java.io.*;



import javax.servlet.http.*;


import com.koitt.www.controller.MainController;
import com.koitt.www.dao.MemberDao;
import com.koitt.www.vo.MemberVO;
import com.koitt.www.vo.PhotoVO;
import com.oreilly.servlet.MultipartRequest;
import com.koitt.www.util.*;
/**
 *  이 클래스는 회원가입 처리요청을 처리할 컨트롤러 클래스
 * @author 고호경
 * @since 2019.12.04
 * @version v.1.0
 * @see
 * 
 * 			변경이력		클래스제작		담당자 :	고호경
 */
public class Join implements MainController {
	MemberDao dao = new MemberDao();
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("isRD", true);
		int cnt = 0;
		String view = "/main";
		// 1. 데이터 받고 <== 스트림 방식으로 넘어오는 데이터를 일단 서버의 파일로 저장하고
		MultipartRequest multi = null;
		String sPath = req.getSession().getServletContext().getRealPath("img/profile");
		
		try {
			multi = new MultipartRequest(req, sPath, 1024*1024*10, "UTF-8", new MyFileRenamePolicy());
			// 회원 정보를 입력하고
			cnt = insertMemb(multi);
			
			if(cnt != 1) {
				return "/member/joinform.cls";
			}
			System.out.println("가입완료");
			// 프로필 사진 정보를 입력해준다.
			
			cnt = insertPic(multi);
			
		}catch (Exception e) {
			System.out.println("###업로드 처리 에러 ###");
			e.printStackTrace();
		}
			
		return view;
	}
	public int insertMemb(MultipartRequest multi) {
		int cnt = 0;
		// 데이터 뽑아내고
		String sid = multi.getParameter("id");
		String spw = multi.getParameter("pw");
		String sname = multi.getParameter("name");
		String smail = multi.getParameter("mail");
		String stel = multi.getParameter("tel");
		String gen = multi.getParameter("gen");
		String savt = multi.getParameter("avt");
		int avt = Integer.parseInt(savt);
		MemberVO vo = new MemberVO();
		vo.setM_Id(sid);
		vo.setM_Pw(spw);
		vo.setM_Name(sname);
		vo.setM_Mail(smail);
		vo.setM_Tel(stel);
		vo.setM_gen(gen);
		vo.setM_avt(avt);
		cnt = dao.AddMem(vo);
		return cnt;
	}
	// 프로필 사진 정보를 입력 전담 처리함수
	public int insertPic(MultipartRequest multi) {
		int cnt = 0;
		int mno = 0;
		String id = multi.getParameter("id");
		String oriname = multi.getOriginalFileName("prof");
		if(oriname == null) {
			return cnt;
		}
		String savename = multi.getFilesystemName("prof");
		File file = multi.getFile("prof"); 
		long len = file.length();
		String dir = "/img/profile";
		mno = dao.getMno(id);
		// 한번에 처리하기로 했으니 VO 담아서 함수를 호출한다.
		PhotoVO vo = new PhotoVO();
		vo.setP_oriname(oriname);
		vo.setP_savename(savename);
		vo.setP_len(len);
		vo.setP_dir(dir);
		vo.setP_mno(mno);
		
		cnt = dao.AddPic(vo);
		System.out.println("사진등록 완료");
		return cnt;
	}
}
