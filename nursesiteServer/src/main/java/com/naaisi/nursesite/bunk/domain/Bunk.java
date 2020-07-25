package com.naaisi.nursesite.bunk.domain;

import java.sql.Timestamp;

import com.alibaba.fastjson.annotation.JSONField;


//CREATE TABLE Bunk(
//	    ID INT NOT NULL AUTO_INCREMENT  COMMENT '床位ID' ,
//	    WARD VARCHAR(32)    COMMENT '所属病区' ,
//	    PATIENT_ID INT    COMMENT '绑定病人ID' ,
//	    STATE INT NOT NULL  DEFAULT 0 COMMENT '状态 0空闲，1已使用，2其他' ,
//	    PRIMARY KEY (ID)
//	) COMMENT = '床位 ';;


public class Bunk {
	
	@JSONField(name = "ID")
	private int ID;

	@JSONField(name = "WARD")
	private String WARD;

	@JSONField(name = "PATIENT_ID")
	private int PATIENT_ID;

	@JSONField(name = "STATE")
	private int STATE;
///////////
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getWARD() {
		return WARD;
	}

	public void setWARD(String wARD) {
		WARD = wARD;
	}

	public int getPATIENT_ID() {
		return PATIENT_ID;
	}

	public void setPATIENT_ID(int pATIENT_ID) {
		PATIENT_ID = pATIENT_ID;
	}

	public int getSTATE() {
		return STATE;
	}

	public void setSTATE(int sTATE) {
		STATE = sTATE;
	}

	@Override
	public String toString() {
		return "Bunk [ID=" + ID + ", WARD=" + WARD + ", PATIENT_ID=" + PATIENT_ID + ", STATE=" + STATE + "]";
	}







}
