package com.naaisi.nursesite.memo.domain;

import java.sql.Timestamp;

import com.alibaba.fastjson.annotation.JSONField;


//CREATE TABLE Memo(
//	    ID INT NOT NULL AUTO_INCREMENT  COMMENT '备忘条目ID' ,
//	    TITLE VARCHAR(128)    COMMENT '标题' ,
//	    CONTENT VARCHAR(3072)    COMMENT '内容' ,
//	    STATE INT    COMMENT '状态' ,
//	    CREATED_TIME DATETIME    COMMENT '创建时间' ,
//	    CREATED_BY VARCHAR(128) NOT NULL  DEFAULT 007 COMMENT '创建人' ,
//	    PRIMARY KEY (ID)
//	) COMMENT = '备忘录 最好是每一个医生/护士有自己的备忘录表';;


public class Memo {
	
	@JSONField(name = "ID")
	private int ID;

	@JSONField(name = "TITLE")
	private String TITLE;

	@JSONField(name = "CONTENT")
	private String CONTENT;

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
		return "Memo [ID=" + ID + ", TITLE=" + TITLE + ", CONTENT=" + CONTENT + ", STATE=" + STATE + ", CREATED_TIME="
				+ CREATED_TIME + ", CREATED_BY=" + CREATED_BY + "]";
	}




}
