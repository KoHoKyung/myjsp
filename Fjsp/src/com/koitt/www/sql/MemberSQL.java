package com.koitt.www.sql;

/**
 * 이 클래스는 회원 정보 조회에 관련된 질의명령을 관리할 클래스
 * 
 * @author 고호경
 * @since 2019.11.13
 * @version v.1.0
 * @see 변경이력 2019.11.13 - MemberSQL 클래스 제작 담당자 : 고호경
 *
 */

public class MemberSQL {
	public final int GET_LOG = 1001;
	public final int GET_LIST = 1002;
	public final int SEL_ID_TO_MNO = 1003;
	public final int MEMB_INFO = 2001;	
	public final int ID_CHECK = 2002;
	public final int ADD_MEMB = 3001;
	public final int ADD_PIC = 3002;

	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();

		// 코드를 입력하면 질의명령을 반환해주는 함수
		switch (code) {
		case GET_LOG:
			buff.append("SELECT ");
			buff.append(" Count(*) cnt ");
			buff.append("FROM ");
			buff.append(" member ");
			buff.append("WHERE ");
			buff.append(" m_id = ? ");
			buff.append(" AND m_pw = ? ");
			break;

		case GET_LIST:
			buff.append("SELECT ");
			buff.append(" m_no mno, m_id, m_name, m_mail, m_tel, m_join ");
			buff.append("FROM ");
			buff.append(" member ");
			buff.append("WHERE ");
			buff.append(" m_id = ? ");
			break;
			
		case MEMB_INFO:
				buff.append("UPDATE ");
				buff.append(" member ");
				buff.append("SET ");
				buff.append("  ### ");
				buff.append("WHERE ");
				buff.append(" m_no = ? ");
			break;
			
		case ID_CHECK:
			buff.append("SELECT ");
			buff.append(" count(*) cnt ");
			buff.append("FROM ");
			buff.append(" member ");
			buff.append("WHERE ");
			buff.append(" m_id = ? ");
			break;

		case SEL_ID_TO_MNO:
			buff.append("SELECT ");
			buff.append(" m_no mno ");
			buff.append(" FROM ");
			buff.append(" member ");
			buff.append(" WHERE ");
			buff.append(" m_id = ? ");
			break;
		
		case ADD_MEMB:
			buff.append("INSERT INTO ");
			buff.append("  member ");
			buff.append("VALUES( ");
			buff.append("  (SELECT NVL(MAX(m_no) +1, 1001) FROM member), ");
			buff.append("  ?, ?, ?, ?, ?, sysdate, ? , ? )");
			break;

		case ADD_PIC:
			buff.append("INSERT INTO ");
			buff.append("  m_photo(p_no, p_mno, p_oriname, p_savename, p_len, p_dir) ");
			buff.append("VALUES( ");
			buff.append("  (SELECT NVL(MAX(p_no) +1, 1000001) FROM m_photo), ");
			buff.append("  ?, ?, ?, ?, ?)");
			break;
			
		default:
			break;
		}
		return buff.toString();
	}
}
