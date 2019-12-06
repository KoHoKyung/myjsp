package com.koitt.www.dao;

import java.sql.*;
import java.util.ArrayList;

import com.koitt.www.sql.SurveySQL;
import com.koitt.www.vo.SurveyVO;

import DB.*;

/**
 *  이 클래스는 설문조사 관련 데이터베이스 작업 전담 처리 클래스
 * @author 고호경
 * @since 2019.12.05
 * @version v.1.0
 * @see	DB>DBCP, com.koitt.www.survey.Survey
 * 
 * 			변경이력
 * 					2019.12.05			클래스제작			담당자	고호경
 *
 */
public class SurveyDAO {
	DBCP db = null;
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	SurveySQL sSQL = null;
	
	public SurveyDAO(){
		db = new DBCP();
		sSQL = new SurveySQL();
	}
	
	//  현재 진행중인 설문 데이터 조회 전담 처리함수
	
	public ArrayList<SurveyVO> getCurLIST(String id){
		ArrayList<SurveyVO> list = new ArrayList<SurveyVO>();
		// 커넥션 가져오고
		con = db.getCon();
		// 질의명령 가져오고
		String sql = sSQL.getSQL(sSQL.SEL_SRV_CUR);
		// preparedstatement 얻어오고
		pstmt = db.getPSTMT(con, sql);
		try {
			// 질의명령 완성하고
			pstmt.setString(1, id);
			//  질의명령 보내고 결과받고
			
			rs = pstmt.executeQuery();

			// 데이터 vo에 담고
			while(rs.next()) {
				SurveyVO vo = new SurveyVO();
				vo.setSno(rs.getInt("sno"));
				vo.setTitle(rs.getString("title"));
				vo.setStartDate(rs.getDate("startDate"));
				vo.setEndDate(rs.getDate("endDate"));
				vo.setCheck(rs.getString("count"));
				vo.setId(id);
				list.add(vo);
			}
			// vo 리스트에 담고
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		// list 보내기
		return list;
	}
	
	// 설문조사 상세내용 가져오기 전담 처리함수
	public ArrayList<SurveyVO> getSDetaillist(int sno){
		ArrayList<SurveyVO> list = new ArrayList<SurveyVO>();
		// 커넥션 얻어오고
			con = db.getCon();
		// 질의명령 가져오고
			String sql = sSQL.getSQL(sSQL.SEL_QNO_LIST);
		// PreparedStatement 얻어오고
		pstmt = db.getPSTMT(con, sql);
		ArrayList<Integer> qnoList = new ArrayList<Integer>();
		// 질의명령 완성하고
		try {
			// 질의명령 보내고 결과 받고 리스트에 담고
			pstmt.setInt(1, sno);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				qnoList.add(rs.getInt("qno"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
			
		
		con = db.getCon();
		sql = sSQL.getSQL(sSQL.SEL_QUEST_LIST);
		// 질의명령 또 가져오고
		pstmt = db.getPSTMT(con, sql);
		// 질의명령 완성
		try {
			// 보내고 결과받고 vo에담고
			for(int i = 0; i <qnoList.size(); i++) {
				pstmt.setInt(1, sno);
				System.out.println(qnoList.get(i));
				pstmt.setInt(2, qnoList.get(i));
				rs = pstmt.executeQuery();
				ArrayList<SurveyVO> sList = new ArrayList<SurveyVO>();
				SurveyVO vo = new SurveyVO(); // 문항 데이터 저장할 vo
				int j = 0;
				while (rs.next()) {
					if(j++ == 0) {
						vo.setSno(rs.getInt("sno"));
						vo.setQno(rs.getInt("qno"));
						vo.setBody(rs.getString("body"));
					}
					SurveyVO svo =new SurveyVO(); // 보기데이터 저장할 vo
					svo.setSeno(rs.getInt("seno"));
					svo.setEbody(rs.getString("ebody"));
					sList.add(svo);
				}
				// list에 담고
				vo.setList(sList);

				
				// list에 또 담고
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return list;
	}
}
