package dao;
/**
 *  이 클래스는 회원 관련 데이터베이스 처리를 위한 클래스 이다.
 * @author   user
 * @since   2019.11.11
 * @version   v.1.0
 * @see      DB.DBCP
 *          
 *          작업이력
 *             2019.11.11   - 클래스 제작      -담당자 : 박송림4
 */
import DB.*;
import java.sql.*;
import java.util.ArrayList;

import sql.*;
import vo.VO;

public class MemberDAO {
   /*
    *  이 클래스는 회원에 관련된 데이터 베이스 작업을 전담해서 처리하는 클래스이다.
    *  따라서 서버가 기동하면서 확보해 놓은 커넥션을 하나 얻어와야 한다.
    *  그런데 그 커넥션은 DB.DBCP로 관리하기로 약속 했으므로
    *  DBCP 객체를 확보해야 겠다.
    *  
    */
   DBCP db = null;
   
   Connection con = null;
   
   Statement stmt = null;
   PreparedStatement pstmt = null;
   ResultSet rs = null;
   MemberSQL mSQL;
   
   public MemberDAO() {
      db = new DBCP();
      mSQL = new MemberSQL();
   }
   
   public int getCnt(String sid, String spw) {
      con = db.getCon();
      String sql = mSQL.getSQL(mSQL.SEL_MEMB_CNT);
      int cnt= 0;
      
      //preparedStatement 가져오기
      pstmt = db.getPSTMT(con, sql);
      //데이터 채우고 질의명령 완성
      
      try {
         pstmt.setString(1, sid);
         pstmt.setString(2, spw);
         
         rs = pstmt.executeQuery();
         rs.next();
         cnt = rs.getInt("cnt");
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         db.close(rs);
         db.close(pstmt);
         db.close(con);;
      }
      return cnt;
   }  
   
   // 아이디체크 전담 처리함수
   public int getIdCnt(String sid) {
	   // 커넥션 얻어오고
	      con = db.getCon();
	   // 질의 명령 얻어오고
	      String sql = mSQL.getSQL(mSQL.SEL_ID_CK);
	      int cnt= 0;
	      
	      //preparedStatement 가져오기
	      pstmt = db.getPSTMT(con, sql);
	      //데이터 채우고 질의명령 완성
	      
	      try {
	         pstmt.setString(1, sid);
	         
          // 질의 명령 보내고 결과 받고
	         rs = pstmt.executeQuery();
	      // 데이터 꺼내고
	         rs.next();
	         cnt = rs.getInt("cnt");
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         db.close(rs);
	         db.close(pstmt);
	         db.close(con);;
	      }
	      return cnt;
	   }
   public ArrayList<VO> getlist() {
	   ArrayList<VO> list = new ArrayList<VO>();
	   // 커넥션 얻어오고
	      con = db.getCon();
	   // 질의 명령 얻어오고
	      String sql = mSQL.getSQL(mSQL.SEL_LIST);

	      //preparedStatement 가져오기
	      stmt = db.getSTMT(con);
	     
	      
	      //데이터 채우고 질의명령 완성
	 
	      
	      try {
	    	  rs = stmt.executeQuery(sql);
	    	  while(rs.next()) {
	    		    VO vo = new VO();
	    		  
	    		  vo.setM_No(rs.getInt("m_No"));
	    		  vo.setM_Name(rs.getString("m_Name"));
	    		  vo.setM_Tel(rs.getString("m_Tel"));
	    		  list.add(vo);
	    	  }

	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         db.close(rs);
	         db.close(stmt);
	         db.close(con);
	      }
	      return list;
	   }
   public VO getname(int mno) {
	  
	   // 커넥션 얻어오고
	      con = db.getCon();
	   // 질의 명령 얻어오고
	      String sql = mSQL.getSQL(mSQL.SEL_NAME);

	      
	      //preparedStatement 가져오기
	      pstmt = db.getPSTMT(con, sql);
	      //데이터 채우고 질의명령 완성
	      VO vo = new VO();
	      
	      try {
	    	
	         pstmt.setInt(1, mno);
	         
          // 질의 명령 보내고 결과 받고
	         rs = pstmt.executeQuery();
	      // 데이터 꺼내고
	        rs.next();
	        vo.setM_No(rs.getInt("mno"));
	        vo.setM_Id(rs.getString("id"));
	        vo.setM_Name(rs.getString("name"));
	        vo.setM_Mail(rs.getString("mail"));
	        vo.setM_Tel(rs.getString("tel"));
	        vo.setM_Join(rs.getDate("mdate"));
	        vo.setJoinTime(rs.getTime("mdate"));
	        vo.setsTime();
	        vo.setsDate();
	         
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         db.close(rs);
	         db.close(pstmt);
	         db.close(con);
	      }
	      return vo;
	   }
  
   // 회원가입처리 전담함수
   	public int addMember(VO vo) {
   		int cnt = 0;
   		//할일
   		// 커넥션 얻어오고
   		con = db.getCon();
   		// 질의명령 얻어오고
   		String sql = mSQL.getSQL(mSQL.ADD_MEMB);
   		// PreparedStatement 가져오고
   		pstmt = db.getPSTMT(con, sql);
   		try {
   			// 질의명령 완성하고
   			pstmt.setString(1, vo.getM_Id());
   			pstmt.setString(2, vo.getM_Pw());
   			pstmt.setString(3, vo.getM_Name());
   			pstmt.setString(4, vo.getM_Mail());
   			pstmt.setString(5, vo.getM_Tel());
   			// 질의명령 보내고 반환값 받고
   			cnt = pstmt.executeUpdate();
   	   		// 반환값 내보내고

			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
   		return cnt;
   	}
   
}
