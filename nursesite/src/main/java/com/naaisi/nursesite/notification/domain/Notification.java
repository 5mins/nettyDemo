package com.naaisi.nursesite.notification.domain;

import java.sql.Timestamp;

import com.alibaba.fastjson.annotation.JSONField;


//CREATE TABLE Notification(
//	    ID INT NOT NULL AUTO_INCREMENT  COMMENT '通知ID' ,
//	    TITLE VARCHAR(128) NOT NULL   COMMENT '标题' ,
//	    CONTENT VARCHAR(3072)    COMMENT '内容' ,
//	    TYPE INT   DEFAULT 0 COMMENT '分类' ,
//	    STATE INT NOT NULL  DEFAULT 0 COMMENT '状态' ,
//	    CREATED_TIME DATETIME    COMMENT '创建时间' ,
//	    CREATED_BY VARCHAR(128) NOT NULL  DEFAULT 007 COMMENT '创建人' ,
//	    PRIMARY KEY (ID)
//	) COMMENT = '通知 ';;


public class Notification {
	
	@JSONField(name = "ID")
	private int ID;

	@JSONField(name = "TITLE")
	private String TITLE;

	@JSONField(name = "CONTENT")
	private String CONTENT;

	@JSONField(name = "TYPE")
	private int TYPE;

	@JSONField(name = "STATE")
	private int STATE;

	@JSONField(name = "CREATED_TIME")
	private Timestamp CREATED_TIME;

	@JSONField(name = "CREATED_BY")
	private int CREATED_BY;
///////////

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTITLE() {
		return TITLE;
	}

	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}

	public String getCONTENT() {
		return CONTENT;
	}

	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}

	public int getTYPE() {
		return TYPE;
	}

	public void setTYPE(int tYPE) {
		TYPE = tYPE;
	}

	public int getSTATE() {
		return STATE;
	}

	public void setSTATE(int sTATE) {
		STATE = sTATE;
	}

	public Timestamp getCREATED_TIME() {
		return CREATED_TIME;
	}

	public void setCREATED_TIME(Timestamp cREATED_TIME) {
		CREATED_TIME = cREATED_TIME;
	}

	public int getCREATED_BY() {
		return CREATED_BY;
	}

	public void setCREATED_BY(int cREATED_BY) {
		CREATED_BY = cREATED_BY;
	}

	@Override
	public String toString() {
		return "Notification [ID=" + ID + ", TITLE=" + TITLE + ", CONTENT=" + CONTENT + ", TYPE=" + TYPE + ", STATE="
				+ STATE + ", CREATED_TIME=" + CREATED_TIME + ", CREATED_BY=" + CREATED_BY + "]";
	}



}
