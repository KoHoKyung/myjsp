package com.koitt.www.sql;

public class FileBoardSQL {
		
	// SELECT쿼리
	public final int SEL_ALL = 1001;
	public final int SEL_BOARD = 1002;
	public final int SEL_SEARCHT = 1003;
	public final int SEL_SEARCHI = 1004;
	public final int SEL_SEARCHB = 1005;
	public final int SEL_SEARCHA = 1006;
	public final int SEL_MAXPAGE = 1007;
	public final int SEL_MAXPAGEBT = 1008;
	public final int SEL_MAXPAGEBI = 1009;
	public final int SEL_MAXPAGEBB = 1010;
	public final int SEL_MAXPAGEBA = 1011;
	public final int SEL_FBNO = 1012;
	public final int SEL_BOARDRE = 1013;


	// UPDATE 쿼리
	public final int DEL_CONTENT = 2001;
	public final int EDIT_CONTENT = 2002;
	public final int EDIT_RESET = 2003;
	public final int EDIT_DELETE = 2004;
	public final int EDIT_REP = 200;
	public final int DEL_BOARDRE = 2005;
	
	// INSERT 쿼리
	public final int ADD_CONTENT = 3001;
	public final int EDIT_RECONTENT = 3003;
	public final int ADD_FILEINFO = 3002;
	
	// 코드를 입력해서 실행하면 질의명령을 보내주는 함수
	public String getSql(int code) {
		StringBuffer buff = new StringBuffer();
		
		switch (code) {
		case SEL_ALL:
				buff.append("SELECT ROWNUM no, ");
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
				buff.append("  (SELECT  rownum no, fb_no,  fb_writer, fb_title, fb_body, fb_wdate, fb_isshow FROM (SELECT rownum no, fb_no, fb_writer, fb_title, fb_body, fb_wdate,fb_isshow FROM fileboard WHERE fb_isshow = 'Y'  order by fb_no ) ) ");
//				buff.append(" FROM (SELECT * FROM (SELECT ROWNUM no, b. * FROM ");
//				buff.append("  (SELECT * FROM fileboard ");
//				buff.append("  WHERE fb_isshow = 'Y' ");
//				buff.append(" ORDER BY fb_no DESC) b) )");
				buff.append("  WHERE no BETWEEN ? and ?  ");
				
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
			buff.append(" WHERE fb_isshow = 'Y'  ");
			buff.append(" AND fb_no = ? ");
			
			break;

		case SEL_SEARCHI:
			buff.append("SELECT ROWNUM rn, ");
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
			buff.append(" FROM (SELECT ROWNUM no, b. * FROM ");
			buff.append("  (SELECT * FROM fileboard ");
			buff.append("  WHERE fb_isshow = 'Y' ");
			buff.append(" AND (SELECT m_id FROM member  WHERE m_no = fb_writer) like ? ORDER BY fb_no DESC) b) ");
			buff.append("  WHERE no BETWEEN ? and ?  ");
			break;
		case SEL_SEARCHT:
			buff.append("SELECT ROWNUM rn, ");
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
			buff.append(" FROM (SELECT ROWNUM no, b. * FROM ");
			buff.append("  (SELECT * FROM fileboard ");
			buff.append("  WHERE fb_isshow = 'Y' ");
			buff.append(" AND fb_title like ? ORDER BY fb_no DESC) b) ");
			buff.append("  WHERE no BETWEEN ? and ?  ");
			break;
		case SEL_SEARCHB:
			buff.append("SELECT ROWNUM rn, ");
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
			buff.append(" FROM (SELECT ROWNUM no, b. * FROM ");
			buff.append("  (SELECT * FROM fileboard ");
			buff.append("  WHERE fb_isshow = 'Y'  ");
			buff.append(" AND fb_body like ? ORDER BY fb_no DESC) b) ");
			buff.append("  WHERE no BETWEEN ? and ?  ");

			break;
		case SEL_SEARCHA:
			buff.append("SELECT ROWNUM rn, ");
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
			buff.append(" FROM (SELECT ROWNUM no, b. * FROM ");
			buff.append("  (SELECT * FROM fileboard ");
			buff.append("  WHERE fb_isshow = 'Y' ");
			buff.append(" AND fb_body like ? ");
			buff.append(" or fb_body like ? ORDER BY fb_no DESC) b) ");
			buff.append("  WHERE no BETWEEN ? and ?  ");

			break;
		case SEL_FBNO:
			buff.append("SELECT ");
			buff.append("	MAX(fb_no) bno ");
			buff.append("FROM ");
			buff.append("	fileboard ");
			buff.append("WHERE ");
			buff.append("	fb_isshow = 'Y' ");
			buff.append("	AND fb_writer = ( ");
			buff.append(" SELECT ");
			buff.append("	m_no ");
			buff.append("	FROM ");
			buff.append("	member ");
			buff.append("	WHERE ");
			buff.append("	m_id= ? ");
			buff.append("	) ");
			// 여기서부터는 없어도 되는 부분
			buff.append("	AND fb_wdate = ");
			buff.append(" ( ");
			buff.append("	SELECT ");
			buff.append("	MAX(fb_wdate) ");
			buff.append("	FROM ");
			buff.append("	fileboard ");
			buff.append("	WHERE ");
			buff.append("	fb_writer = ( ");
			buff.append("	SELECT ");
			buff.append("	m_no ");
			buff.append("	FROM ");
			buff.append("	member ");
			buff.append("	WHERE ");
			buff.append("	m_id= ? ");
			buff.append("	) ");
			buff.append("	) ");
			// 여기까지는...
			break;
		case SEL_MAXPAGE:
			buff.append("SELECT count(fb_no) max ");
			buff.append(" FROM fileboard  ");
			buff.append(" WHERE ");
			buff.append(" fb_isshow = 'Y' ");
			break;
		case SEL_MAXPAGEBT:
			buff.append("SELECT count(fb_no) max ");
			buff.append(" FROM fileboard  ");
			buff.append(" WHERE ");
			buff.append(" fb_isshow = 'Y' ");
			buff.append(" AND fb_title like ? ");
			break;
		case SEL_MAXPAGEBI:
			buff.append("SELECT count(fb_no) max ");
			buff.append(" FROM  ");
			buff.append(" (SELECT * FROM (SELECT fb_no, (SELECT m_id FROM member where m_no = fb_writer) ");
			buff.append(" FROM fileboard WHERE fb_isshow='Y' AND (SELECT m_id FROM member  WHERE m_no = fb_writer) like ?) ) ");
			break;
		case SEL_MAXPAGEBB:
			buff.append("SELECT count(fb_no) max ");
			buff.append(" FROM fileboard  ");
			buff.append(" WHERE ");
			buff.append(" fb_isshow = 'Y' ");
			buff.append(" AND fb_body like ? ");
			break;
		case SEL_MAXPAGEBA:
			buff.append("SELECT count(fb_no) max ");
			buff.append(" FROM fileboard  ");
			buff.append(" WHERE ");
			buff.append(" fb_isshow = 'Y' ");
			buff.append(" AND fb_body like ? or fb_title like ? ");
			break;
			
		case DEL_CONTENT:
				
			break;
		
		case EDIT_CONTENT:
			buff.append("INSERT INTO ");
			buff.append("  fileboard (fb_no, fb_writer, fb_title, fb_body) VALUES ( ");
			buff.append(" (select max(fb_no)+1 from fileboard) , ");
			buff.append(" (SELECT m_no from member where m_id = ? ) , ");
			buff.append(" ?, ?) ");
			break;
		case EDIT_RECONTENT:
			buff.append("INSERT INTO ");
			buff.append("  fileboardre (frb_bno, frb_MNO , frb_fbno, frb_body, frb_date) VALUES ( ");
			buff.append(" (select max(frb_bno)+1 from fileboardre) , ");
			buff.append(" (SELECT m_no from member where m_id = ? ), ");
			buff.append(" ?, ?, sysdate) ");
			break;
			
		case EDIT_RESET:
			buff.append("UPDATE ");
			buff.append(" fileboard ");
			buff.append(" SET ");
			buff.append("  fb_body = ? ");
			buff.append("WHERE ");
			buff.append(" fb_no = ? ");
			break;
			
		case EDIT_DELETE:
			buff.append("UPDATE ");
			buff.append(" fileboard ");
			buff.append(" SET ");
			buff.append("  fb_isshow = 'N' ");
			buff.append("WHERE ");
			buff.append(" fb_no = ? ");
			break;
			
		case EDIT_REP:
			buff.append("INSERT INTO ");
			buff.append(" fileboard ");
			buff.append(" SET ");
			buff.append("  fb_rep = ? ");
			
			break;
			
		case ADD_FILEINFO:
			buff.append("INSERT INTO ");
			buff.append("	fileinfo( ");
			buff.append("	f_no, f_fbno, f_oname, f_sname, f_dir, f_len ");
			buff.append("	) ");
			buff.append("VALUES( ");
			buff.append("	( ");
			buff.append("		SELECT ");
			buff.append("			NVL(MAX(f_no) + 1, 10001) ");
			buff.append("		FROM ");
			buff.append("			fileinfo ");
			buff.append("	), ");
			buff.append("	?, ?, ?, ?, ? ");
			buff.append(") ");
			break;
			
		case SEL_BOARDRE:
			buff.append("SELECT ");
			buff.append(" FRB_BNO bno, (SELECT m_id FROM member WHERE m_no = FRB_MNO) id, frb_body body, frb_date wdate, frb_fbno fbno ");
			buff.append(" FROM ");
			buff.append(" fileboardre ");
			buff.append("  WHERE frb_isshow = 'Y' ");
			buff.append("  AND frb_fbno = ? ");
			break;
		case DEL_BOARDRE:
			buff.append(" UPDATE ");
			buff.append(" fileboardre ");
			buff.append(" SET ");
			buff.append(" frb_isshow = 'N' ");
			buff.append(" WHERE ");
			buff.append(" frb_bno = ? ");
			break;
		default:
			break;
		}
		
		return buff.toString();
		
	}
}
