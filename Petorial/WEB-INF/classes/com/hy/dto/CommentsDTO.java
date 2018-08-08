package com.hy.dto;

import java.sql.Date;

public class CommentsDTO {

	private int cm_no;
	private String cm_nick;
	private String cm_text;
	private int id_no;
	private Date cm_date;
	private int tm_no;

	public int getCm_no() {
		return cm_no;
	}
	public void setCm_no(int cm_no) {
		this.cm_no = cm_no;
	}
	public String getCm_nick() {
		return cm_nick;
	}
	public void setCm_nick(String cm_nick) {
		this.cm_nick = cm_nick;
	}
	public String getCm_text() {
		return cm_text;
	}
	public void setCm_text(String cm_text) {
		this.cm_text = cm_text;
	}
	public int getId_no() {
		return id_no;
	}
	public void setId_no(int id_no) {
		this.id_no = id_no;
	}
	public Date getCm_date() {
		return cm_date;
	}
	public void setCm_date(Date cm_date) {
		this.cm_date = cm_date;
	}
	public int getTm_no() {
		return tm_no;
	}
	public void setTm_no(int tm_no) {
		this.tm_no = tm_no;
	}


}
