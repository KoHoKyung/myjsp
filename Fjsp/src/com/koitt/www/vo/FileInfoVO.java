package com.koitt.www.vo;

import java.sql.*;
import java.text.*;

public class FileInfoVO {
	private int fno;
	private int bno;
	private int mno;
	private String id;
	private String oriname;
	private String savename;
	private String dir;
	private long len;
	private Date fdate;
	private String sdate;
	private Time ftime;
	private String stime;
	private int cnt;
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOriname() {
		return oriname;
	}
	public void setOriname(String oriname) {
		this.oriname = oriname;
	}
	public String getSavename() {
		return savename;
	}
	public void setSavename(String savename) {
		this.savename = savename;
	}
	public String getDir() {
		return dir;
	}
	public void setDir(String dir) {
		this.dir = dir;
	}
	public long getLen() {
		return len;
	}
	public void setLen(long len) {
		this.len = len;
	}
	public Date getFdate() {
		return fdate;
	}
	public void setFdate(Date fdate) {
		this.fdate = fdate;
		setSdate();
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public Time getFtime() {
		return ftime;
	}
	public void setFtime(Time ftime) {
		this.ftime = ftime;
		setStime();
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public void setSdate() {
		SimpleDateFormat form = new SimpleDateFormat("yyyy년 MM월 dd일");
		this.sdate = form.format(fdate);
	}
	public void setStime() {
		SimpleDateFormat form = new SimpleDateFormat("HH:mm:ss");
		this.stime = form.format(ftime);
	}
}