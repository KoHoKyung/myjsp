package com.koitt.www.sql;

/**
 * 	이 클래스는 댓글게시판 질의명을 모아놓은 클래스
 * 
 * 
 * @author 고호경
 * @since 2019.12.03
 * @version v.1.0
 * @see
 * 
 *  				변경이력
 *  					2019.12.03 	-	클래스제작	-	담당자	:	고호경
 *
 *
 */
public class ReboardSQL {
	public final int SEL_ALL = 1001;
	public final int SEL_CNT = 1002;
	
	// 코드를 입력해서 호출하면 질의명령을 반환해주는 함수
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch (code) {
		case SEL_ALL:			
			buff.append(" SELECT ");
			buff.append(" * ");
			buff.append(" FROM ");
			buff.append(" (SELECT ");
			buff.append("   ROWNUM RNO, m_id, avt, rb_no, rb_body, rb_date, rb_upno, (level -1) lvl ");
			buff.append(" 	FROM ");
			buff.append(" (SELECT  m_id, avt, rb_body, rb_date, rb_upno, rb_no ");
			buff.append(" FROM reboard, ");
			buff.append(" (SELECT m_no, m_id, ");
			buff.append(" (SELECT a_img ");
			buff.append("  FROM avatar ");
			buff.append(" WHERE a_no =m_avt) avt ");
			buff.append(" FROM member )  ");
			buff.append(" WHERE ");
			buff.append(" RB_ISSHOW='Y' ");
			buff.append(" AND m_no= rb_mno ) ");
			buff.append(" start with ");
			buff.append(" rb_upno is null ");
			buff.append(" connect by ");
			buff.append(" PRIOR RB_NO = RB_UPNO ");
			buff.append(" ORDER SIBLINGS BY ");
			buff.append("  rb_date desc) ");			       
			buff.append("  WHERE ");			       
			buff.append("  RNO BETWEEN ? AND ? ");			       
			break;
			
		case SEL_CNT:			
			buff.append(" SELECT ");
			buff.append(" count(*) cnt ");
			buff.append(" FROM ");
			buff.append(" reboard ");
			buff.append(" WHERE ");
			buff.append(" rb_isshow = 'Y' ");
			    
			break;

		default:
			break;
		}
		return buff.toString();
	}
}
