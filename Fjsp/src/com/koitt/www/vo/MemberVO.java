package com.koitt.www.vo;
/**
 * 이 클래스는 회원정보에 대한 데이터를 저장해서
 * 넘겨주는 용도로 사용할 클랫( DTO 또는 VO)
 * @return 고호경
 * @since 2019.11.12
 * @version v.1.0
 * 
 * 		변경이력
 * 			2019.11.12		-	클래스 제작		-	담당자	:	고호경
 */

	import java.sql.*;
	
	import java.text.*;

public class MemberVO {
	private int m_No;
	private String m_Id;
	private String m_Pw;
	private String m_Name;
	private String m_Mail;
	private String m_Tel;
	private Date m_Join;
	private String sDate;
	private String sTime;
	private Time joinTime;
	private int m_avt;
	private String m_gen;
	private String avatar;
	private boolean isshow;
	
	
	public boolean isIsshow() {
		return isshow;
	}
	public void setIsshow(boolean isshow) {
		this.isshow = isshow;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	

	public int getM_No() {
		return m_No;
	}
	public void setM_No(int m_No) {
		this.m_No = m_No;
	}
	public String getM_Id() {
		return m_Id;
	}
	public void setM_Id(String m_Id) {
		this.m_Id = m_Id;
	}
	public String getM_Pw() {
		return m_Pw;
	}
	public void setM_Pw(String m_Pw) {
		this.m_Pw = m_Pw;
	}
	public String getM_Name() {
		return m_Name;
	}
	public void setM_Name(String m_Name) {
		this.m_Name = m_Name;
	}
	public String getM_Mail() {
		return m_Mail;
	}
	public void setM_Mail(String m_Mail) {
		this.m_Mail = m_Mail;
	}
	public String getM_Tel() {
		return m_Tel;
	}
	public void setM_Tel(String m_Tel) {
		this.m_Tel = m_Tel;
	}
	public Date getM_Join() {
		return m_Join;
	}
	public void setM_Join(Date m_Join) {
		this.m_Join = m_Join;
	}
	public String getsDate() {
		return sDate;
	}
	public void setsDate(String sDate) {
		this.sDate = sDate;
	}
	public void setsDate() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy-mm-dd");
		
//		this.sDate = form1.format(m_Join) + form2.format(joinTime) ;
		
		this.sDate = form1.format(m_Join);
	}
	public String getsTime() {
		return sTime;
	}
	public void setsTime() {
		SimpleDateFormat form = new SimpleDateFormat("HH:mm:ss");
		this.sTime = form.format(joinTime);
	}
	public Time getJoinTime() {
		return joinTime;
	}
	public void setJoinTime(Time joinTime) {
		this.joinTime = joinTime;
	}
	public int getM_avt() {
		return m_avt;
	}
	public void setM_avt(int m_avt) {
		this.m_avt = m_avt;
	}
	public String getM_gen() {
		return m_gen;
	}
	public void setM_gen(String m_gen) {
		this.m_gen = m_gen;
	}
	
	

}