package com.koitt.www.sql;

public class FileBoardSQL {
		
	// SELECT쿼리
	public final int SEL_ALL = 1001;
	public final int SEL_BOARD = 1002;
	
	// UPDATE 쿼리
	public final int DEL_CONTENT = 2001;
	public final int EDIT_CONTENT = 2002;
	
	// INSERT 쿼리
	public final int ADD_CONTENT = 3001;
	
	// 코드를 입력해서 실행하면 질의명령을 보내주는 함수
	public String getSql(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch (code) {
		case SEL_ALL:
				buff.append("SELECT ");
				buff.append("  fb_no bno, ");
				buff.append(" ( ");
				buff.append(" SELECT ");
				buff.append(" m_id id ");
				buff.append(" FROM ");
				buff.append(" member ");
				buff.append(" WHERE ");
				buff.append(" m_no = fb_writer ");
				buff.append(" ) writer, ");
				buff.append(" fb_wdate wdate, fb_title title ");
				buff.append(" FROM ");
				buff.append(" fileboard ");
				buff.append(" WHERE ");
				buff.append(" fb_isshow = 'Y' ");
				buff.append(" order by fb_no  ");
			break;
			
		case SEL_BOARD:
			buff.append("SELECT ");
			buff.append("  fb_no bno, ");
			buff.append(" ( ");
			buff.append(" SELECT ");
			buff.append(" m_id id ");
			buff.append(" FROM ");
			buff.append(" member ");
			buff.append(" WHERE ");
			buff.append(" m_no = fb_writer ");
			buff.append(" ) writer, ");
			buff.append(" fb_wdate wdate, fb_title title, fb_body body ");
			buff.append(" FROM ");
			buff.append(" fileboard ");
			buff.append(" WHERE ");
			buff.append(" fb_no = ? ");
			
			break;

		case DEL_CONTENT:
				
			break;
		
		case EDIT_CONTENT:
			buff.append("INSERT INTO ");
			buff.append("  fileboard (fb_no, fb_writer, fb_title, fb_body, fb_fno) VALUES ( ");
			buff.append(" (select max(fb_no)+1 from fileboard) , ");
			buff.append(" (SELECT m_no from member where m_id = ? ) , ");
			buff.append(" ?, ?, null) ");
			break;
			
		case ADD_CONTENT:
			
			break;

		default:
			break;
		}
		
		return buff.toString();
		
	}
}
