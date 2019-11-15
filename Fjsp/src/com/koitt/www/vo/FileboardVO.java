package com.koitt.www.vo;

import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * 		이 클래스는 파일 업로드 게시판의 정보를 저장할 클래스
 * @author 고호경
 * @since 2019.11.15
 * @version v.1.0
 * @see
 * 
 * 		변경이력
 * 			2019.11.15		-	클래스 제작		-	담당자	:	고호경
 *
 */
public class FileboardVO {
	private int fb_no;
	private String fb_id;
	private String fb_title;
	private String fb_body;
	private int fb_fno;
	private Date wdate;
	private Time wtime;
	private String stime;
	private String sdate;
	private String isshow;
	public int getFb_no() {
		return fb_no;
	}
	public void setFb_no(int fb_no) {
		this.fb_no = fb_no;
	}
	public String getFb_id() {
		return fb_id;
	}
	public void setFb_id(String fb_id) {
		this.fb_id = fb_id;
	}
	public String getFb_title() {
		return fb_title;
	}
	public void setFb_title(String fb_title) {
		this.fb_title = fb_title;
	}
	public String getFb_body() {
		return fb_body;
	}
	public void setFb_body(String fb_body) {
		this.fb_body = fb_body;
	}
	public int getFb_fno() {
		return fb_fno;
	}
	public void setFb_fno(int fb_fno) {
		this.fb_fno = fb_fno;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public Time getWtime() {
		return wtime;
	}
	public void setWtime(Time wtime) {
		this.wtime = wtime;
		setStime();
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public void setSdate() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy년 MM월 dd일");
		this.sdate = form.format(wdate);
	}
	
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public void setStime() {
		SimpleDateFormat form = new SimpleDateFormat(" HH:mm:ss");
		this.stime = form.format(wtime);
	}
	public String getIsshow() {
		return isshow;
	}
	public void setIsshow(String isshow) {
		this.isshow = isshow;
	}
public String toString() {
	String str = " **************** " + fb_no + " - " +  fb_id  +  "\n\t ###" + fb_title + "-------------" + "\n\t" + sdate + " " + stime + " ***************** " + fb_body ;
	
		return  str;
}
}
