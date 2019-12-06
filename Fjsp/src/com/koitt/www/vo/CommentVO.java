package com.koitt.www.vo;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

public class CommentVO {
	private int frb_bno;
	private String frb_id;
	private int frb_mno;
	private int frb_fbno;
	private String frb_body;
	private Date wdate;
	private Time wtime;
	private String stime;
	private String sdate;
	
	public String getFrb_id() {
		return frb_id;
	}
	public void setFrb_id(String frb_id) {
		this.frb_id = frb_id;
	}
	public int getFrb_bno() {
		return frb_bno;
	}
	public void setFrb_bno(int frb_bno) {
		this.frb_bno = frb_bno;
	}
	public int getFrb_mno() {
		return frb_mno;
	}
	public void setFrb_mno(int frb_mno) {
		this.frb_mno = frb_mno;
	}
	public int getFrb_fbno() {
		return frb_fbno;
	}
	public void setFrb_fbno(int frb_fbno) {
		this.frb_fbno = frb_fbno;
	}
	public String getFrb_body() {
		return frb_body;
	}
	public void setFrb_body(String frb_body) {
		this.frb_body = frb_body;
	}

	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
		setSdate();
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
	public String toString() {
		String str = frb_mno +" *** " + frb_id + " - " +  frb_fbno  +  "\n\t ###" + frb_body + "-------------" + "\n\t" +  wdate + wtime+ " ***************** "  ;
		
			return  str;
	}
}
