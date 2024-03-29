package com.koitt.www.sql;

/**
 *  이클래스는 설문조사에 관련된 질의명령을 저장하고
 *  반환해주는 클래스
 * @author 고호경
 * @since
 * @version v.1.0
 * @see
 * 			변경이력
 * 					2019.12.05		클래스제작			담당자	:	고호경
 *
 */
public class SurveySQL {
	public final int SEL_SRV_CUR	=	1001;	//	현재 조사중인 설문 데이터 가져오는 질의명령
	public final int SEL_QNO_LIST	=	1002;	// 현재 조사중인 설문 문항번호 가져오는 질의명령
	public final int SEL_QUEST_LIST	=	1003;	// 현재 조사중인 설문 문항 데이터 가져오는 질의명령
	public final int SEL_SRV_SNO	=	1004;	// 설문번호로 설문 데이터 가져오는 질의명령
	public final int SEL_QUEST_SNO	=	1005;	// 설문번호로 설문문항 데이터를 가져오는 질의명령  
	public final int SEL_SRVEX_QNO	=	1006;	// 문항번호로 설문 문항 보기데이터를 가져오는 질의명령  
	
	public final int UPDATE_CNT	=		2001;	// 설문 결과 카운트 올리는 질의명령
	
	public final int ADD_CHECK	=		3001;	// 설문 결과 카운트 올리는 질의명령 
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch (code) {
		case SEL_SRV_CUR:
			buff.append("SELECT");
			buff.append(" s_no sno, s_title title, s_start startDate, s_end endDate, ");
			buff.append(" decode( ");
			buff.append(" ( SELECT ");
			buff.append(" COUNT(*) cnt ");
			buff.append(" FROM ");
			buff.append(" SRV_CK ");
			buff.append(" WHERE ");
			buff.append(" SCK_SNO = s_no ");
			buff.append(" AND sck_mid = ? ");
			buff.append(" ), 0, 'N', ");
			buff.append(" 'Y') count ");
			buff.append(" FROM ");
			buff.append(" survey ");
			buff.append(" WHERE ");
			buff.append(" sysdate BETWEEN s_start AND s_end");
			break;
			
			case SEL_QNO_LIST:
				buff.append("SELECT ");
				buff.append(" sq_no qno ");
				buff.append(" FROM ");
				buff.append(" srv_quest ");
				buff.append(" WHERE ");
				buff.append(" sq_sno = ? ");
				break;

		case SEL_QUEST_LIST:
			buff.append("SELECT ");
			buff.append("  sq_sno sno, sq_no qno, sq_cont body,  se_no seno, se_body ebody ");
			buff.append(" FROM ");
			buff.append(" srv_quest, srv_ex ");
			buff.append(" WHERE ");
			buff.append(" sq_no = se_qno ");
			buff.append(" AND sq_sno = ? ");
			buff.append(" AND sq_no = ? ");
			break;
			
		case SEL_SRV_SNO:
			buff.append("SELECT ");
			buff.append(" s_no sno, s_title title, s_start startDate, s_end endDate ");
			buff.append(" FROM ");
			buff.append(" survey ");
			buff.append(" WHERE ");
			buff.append(" s_no = ? ");		
			break;
			
		case SEL_QUEST_SNO:
			buff.append("SELECT ");
			buff.append(" sq_sno sno, sq_no qno, sq_cont body ");
			buff.append(" FROM ");
			buff.append(" srv_quest ");
			buff.append(" WHERE ");
			buff.append(" sq_sno = ? ");		
			break;
			
		case SEL_SRVEX_QNO:
			buff.append(" SELECT ");
			buff.append("   se_no seno, se_qno qno, se_body ebody,  se_count count, ");
			buff.append(" (SELECT SUM(se_count) total FROM SRV_EX WHERE se_qno = s.se_qno) total, ");
			buff.append(" ROUND(se_count / (SELECT ");
			buff.append("   SUM(se_count) ");
			buff.append(" FROM ");
			buff.append(" SRV_EX ");
			buff.append(" WHERE ");
			buff.append(" se_qno = s.se_qno  ");
			buff.append("  ) * 100) per ");
			buff.append(" FROM  ");
			buff.append("  srv_ex s ");
			buff.append(" WHERE  ");
			buff.append(" se_qno = ?  ");
			break;
			
		case UPDATE_CNT:
			buff.append("UPDATE ");
			buff.append(" srv_ex ");
			buff.append(" SET ");
			buff.append("se_count = se_count + 1 ");
			buff.append(" WHERE ");
			buff.append(" se_no IN (?###) ");
			break;
			
		case ADD_CHECK:
			buff.append("INSERT INTO ");
			buff.append(" srv_ck ");
			buff.append(" VALUES( ");
			buff.append(" (SELECT NVL(max(sck_no)+1, 1000001) from srv_ck), ?, ?, sysdate ");
			buff.append(" ) ");
			break;

			
			
			  
		default:
			break;
		}
		
		return buff.toString();
	}
	
}
