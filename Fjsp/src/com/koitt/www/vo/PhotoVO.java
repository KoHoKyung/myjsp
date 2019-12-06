package com.koitt.www.vo;

import java.sql.Date;
import java.sql.Time;
import java.text.*;
/**
 * 이 클래스는 한장의 프로필 사진 데이터를 기억하고
 * 그 데이터를 전달할 목적으로 제작된 클래스
 * 
 * @author 고호경
 * @since 2019.12.04
 * @version v.1.0
 * @see
 * 
 * 			변경이력		클래스 제작 		담당자	-	고호경
 *
 */

public class PhotoVO {
	private int p_no;
	private int p_mno;
	private String p_oriname;
	private String p_savename;
	private long p_len;
	private String p_dir;
	private Date pDate;
	private Time pTime;
	private String sDate;
	private String sTime;
	private boolean p_isshow;
	
	public int getP_no() {
		return p_no;
	}
	public void setP_no(int p_no) {
		this.p_no = p_no;
	}
	public int getP_mno() {
		return p_mno;
	}
	public void setP_mno(int p_mno) {
		this.p_mno = p_mno;
	}
	public String getP_oriname() {
		return p_oriname;
	}
	public void setP_oriname(String p_oriname) {
		this.p_oriname = p_oriname;
	}
	public String getP_savename() {
		return p_savename;
	}
	public void setP_savename(String p_savename) {
		this.p_savename = p_savename;
	}
	public long getP_len() {
		return p_len;
	}
	public void setP_len(long p_len) {
		this.p_len = p_len;
	}
	public String getP_dir() {
		return p_dir;
	}
	public void setP_dir(String p_dir) {
		this.p_dir = p_dir;
	}
	public Date getpDate() {
		return pDate;
	}
	public void setpDate(Date pDate) {
		this.pDate = pDate;
		setsDate();
	}
	public Time getpTime() {
		return pTime;
	}
	public void setpTime(Time pTime) {
		this.pTime = pTime;
		setsTime();
	}
	public String getsDate() {
		return sDate;
	}
	public void setsDate(String sDate) {
		this.sDate = sDate;
	}
	public void setsDate() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy년 MM월 dd일");
		this.sDate = form.format(pDate);
	}
	public String getsTime() {
		return sTime;
	}
	public void setsTime(String sTime) {
		this.sTime = sTime;
	}
	public void setsTime() {
		SimpleDateFormat form = new SimpleDateFormat("HH:mm:ss");
		this.sTime = form.format(pTime);
	}
	public boolean isP_isshow() {
		return p_isshow;
	}
	public void setP_isshow(boolean p_isshow) {
		this.p_isshow = p_isshow;
	}
	
}
