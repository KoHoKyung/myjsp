package com.koitt.www.dao;

/**
 * 	이 클래스는 회원에 관련된 데이터베이스 작업을 처리할 클래스
 * 
 * @author 고호경
 * @since 2019.11.13
 * @version v.1.0
 * @see
 * 		변경이력
 * 			2019.11.13		-	MemberDao 클래스 제작		담당자 : 고호경
 * 			2019.11.13		-	MemberVO  클래스 복사		담당자 : 고호경
 *					vo 패키지에서 com.koitt.www.vo로 복사
 */

import java.io.*;
import java.sql.*;
import java.util.*;

import DB.*;
import com.koitt.www.sql.*;
import com.koitt.www.vo.*;
public class MemberDao {
	DBCP db = null;
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	MemberSQL mSQL;
	MemberVO mVO;
	public MemberDao() {
		db = new DBCP();
		mSQL = new MemberSQL();
	}
	public int getLog(String sid, String spw) {
		int cnt = 0;
		con = db.getCon();
		
		String sql = mSQL.getSQL(mSQL.GET_LOG);
		pstmt = db.getPSTMT(con, sql);
		
		try {
			pstmt.setString(1, sid);
			pstmt.setString(2, spw);
			// 5. 질의 명령 보내고 결과받고
			rs = pstmt.executeQuery();
			// 한줄내리고
			rs.next();
			// 6. 데이터 받고
			cnt= rs.getInt("cnt");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	public MemberVO getList(String mid) {
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.GET_LIST);
		pstmt = db.getPSTMT(con, sql);
		MemberVO vo = new MemberVO();
		try {
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			rs.next();
			vo.setM_No(rs.getInt("mno"));
			vo.setM_Id(rs.getString("m_id"));
			vo.setM_Name(rs.getString("m_name"));
			vo.setM_Mail(rs.getString("m_mail"));
			vo.setM_Tel(rs.getString("m_tel"));
			vo.setM_Join(rs.getDate("m_join"));
			vo.setJoinTime(rs.getTime("m_join"));
			vo.setsDate();
			vo.setsTime();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		
		return vo;
	}
	
	// 회원정보 수정 전담 처리 함수
	public int memberEdit(MemberVO vo, String scode) {
		int cnt = 0;
		// 할일
		// 1.커넥션 얻어오고
		con = db.getCon();
		// 2. 질의명령 얻어오고
		String sql = mSQL.getSQL(mSQL.MEMB_INFO);
		System.out.println(sql);
		// 2-1.  질의명령 수정하고 <-- 질의명령중 변경되는 부분을 ### 으로 처리를 해놓았으므로
		String tmp = "";
		switch (scode) {
		case "1":
			tmp = "m_mail = ?, m_tel = ?";
			break;
		case "2":
			tmp = "m_mail = ?";
			break;
		case "3":
			tmp = "m_tel = ?";
			break;
		default:
			break;
		}

		sql = sql.replace("###", tmp);
		// 3. PreparedStatement 가져오고
		pstmt = db.getPSTMT(con, sql);
		System.out.println(sql);
		// 4. 질의 명령 완성하고
			try {
				if(scode.equals("1")) {
				pstmt.setString(1, vo.getM_Mail());
				pstmt.setString(2, vo.getM_Tel());
				pstmt.setInt(3, vo.getM_No());
				} else {
					String val = "";
					if(scode.equals("2")) {
						val = vo.getM_Mail();
					} else {
						val = vo.getM_Tel();
					}
					pstmt.setString(1, val);	
					pstmt.setInt(2, vo.getM_No());
				}
				cnt = pstmt.executeUpdate();
				// 5. 질의명령 보내고 결과 받고
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				db.close(pstmt);
				db.close(con);
			}

		// 6. 결과 내보내기
		return cnt;
	}
	
	public int getCnt(String sid) {
		int cnt = 0;
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.ID_CHECK);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 회원가입 처리 전담 함수
	public int AddMem(MemberVO vo) {
		int cnt = 0;
		// 커넥션 얻어오고
		con = db.getCon();
		// 질의명령 가져오고
		String sql = mSQL.getSQL(mSQL.ADD_MEMB);
		//PreparedStatement 가져오고
		pstmt = db.getPSTMT(con, sql);
		try {
			// 질의 명령 완성하고
			pstmt.setString(1, vo.getM_Id());
			pstmt.setString(2, vo.getM_Pw());
			pstmt.setString(3, vo.getM_Name());
			pstmt.setString(4, vo.getM_Mail());
			pstmt.setString(5, vo.getM_Tel());
			pstmt.setInt(6, vo.getM_avt());
			pstmt.setString(7, vo.getM_gen());
			// 보내고 결과받고
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.close(pstmt);
			db.close(con);
		}
		// 결과보내기
		return cnt;
	}

	public int AddPic(PhotoVO vo) {
		int cnt = 0;
		// 커넥션 얻어오고
		con = db.getCon();
		// 질의명령 가져오고
		String sql = mSQL.getSQL(mSQL.ADD_PIC);
		//PreparedStatement 가져오고
		pstmt = db.getPSTMT(con, sql);
		try {
			// 질의 명령 완성하고
			pstmt.setInt(1, vo.getP_mno());
			pstmt.setString(2, vo.getP_oriname());
			pstmt.setString(3, vo.getP_savename());
			pstmt.setLong(4, vo.getP_len());
			pstmt.setString(5, vo.getP_dir());
			// 보내고 결과받고
			cnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			db.close(pstmt);
			db.close(con);
		}
		// 결과보내기
		return cnt;
	}
	
	// 아이디를 입력하면 회원번호를 가져오는 함수
	public int getMno(String id) {
		int mno = 0;
		
		// 커넥션 얻어오고
		con = db.getCon();
		String sql = mSQL.getSQL(mSQL.SEL_ID_TO_MNO);
		pstmt = db.getPSTMT(con, sql);
		
		try {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			mno = rs.getInt("mno");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return mno;
	}
}
