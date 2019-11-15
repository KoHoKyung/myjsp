package proj1.member;



import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.omg.CORBA.Request;

import dao.*;
import vo.*;

/**
 *  
 *  이 클래스는 회원 리스트에서 회원을 선택했을 때
 *  해당 회원의 정보 요청을 처리하는 클래스
 *  
 * @author 고호경
 * @since 2019.11.12
 * @version v.1.0
 * 
 * 		변경이력
 * 				2019.11.12	-	클래스작성		-	담당자 : 고호경
 */

@WebServlet("/member/nameDetail.nop")
public class NameDetail extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		// 할일
		// 데이터 받고
		String sno = req.getParameter("mno");

		System.out.println(sno);
		int mno = Integer.parseInt(sno);
		// 데이터베이스에서 데이터 가져오고
		
		VO vo = new MemberDAO().getname(mno);
		// Json 문서 만들어주고
		// PrintWriter 객체를 받아서 처리한다.
	
		PrintWriter pw = resp.getWriter();
		pw.println("{");
		pw.println("	\"mno\" : " + vo.getM_No() + "," );
		pw.println("	\"mid\" : \"" + vo.getM_Id() + "\"," );
		pw.println("	\"mname\" : \"" + vo.getM_Name() + "\"," );
		pw.println("	\"mmail\" : \"" + vo.getM_Mail() + "\"," );
		pw.println("	\"mtel\" : \"" + vo.getM_Tel() + "\"," );
		pw.println("	\"mdate\" : \"" + vo.getsDate() + "  " + vo.getsTime() + "\"" );
		pw.println("}");
	}
}
