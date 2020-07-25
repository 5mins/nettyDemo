package com.naaisi.nursesite.skintest.domain;

import java.sql.Timestamp;

import com.alibaba.fastjson.annotation.JSONField;


//CREATE TABLE SkinTest(
//	    ID INT NOT NULL AUTO_INCREMENT  COMMENT '任务ID' ,
//	    PATIENT_ID INT NOT NULL   COMMENT '病人ID' ,
//	    SKINTEST VARCHAR(128) NOT NULL   COMMENT '皮试项目' ,
//	    PRE_EXE_TIME DATETIME    COMMENT '预计执行时间' ,
//	    EXE_TIME DATETIME    COMMENT '实际执行时间' ,
//	    STATE INT   DEFAULT 0 COMMENT '完成状态' ,
//	    PRIMARY KEY (ID)
//	) COMMENT = '皮试 ';;


public class SkinTest {
	
	@JSONField(name = "ID")
	private int ID;

	@JSONField(name = "PATIENT_ID")
	private int PATIENT_ID;

	@JSONField(name = "SKINTEST")
	private String SKINTEST;

	@JSONField(name = "PRE_EXE_TIME")
	private Timestamp PRE_EXE_TIME;

	@JSONField(name = "EXE_TIME")
	private Timestamp EXE_TIME;
	
	@JSONField(name = "PUBLISH_TIME")
	private Timestamp PUBLISH_TIME;

	@JSONField(name = "STATE")
	private int STATE;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getPATIENT_ID() {
		return PATIENT_ID;
	}

	public void setPATIENT_ID(int pATIENT_ID) {
		PATIENT_ID = pATIENT_ID;
	}

	public String getSKINTEST() {
		return SKINTEST;
	}

	public void setSKINTEST(String sKINTEST) {
		SKINTEST = sKINTEST;
	}

	public Timestamp getPRE_EXE_TIME() {
		return PRE_EXE_TIME;
	}

	public void setPRE_EXE_TIME(Timestamp pRE_EXE_TIME) {
		PRE_EXE_TIME = pRE_EXE_TIME;
	}

	public Timestamp getEXE_TIME() {
		return EXE_TIME;
	}

	public void setEXE_TIME(Timestamp eXE_TIME) {
		EXE_TIME = eXE_TIME;
	}

	public int getSTATE() {
		return STATE;
	}

	public void setSTATE(int sTATE) {
		STATE = sTATE;
	}

	public Timestamp getPUBLISH_TIME() {
		return PUBLISH_TIME;
	}

	public void setPUBLISH_TIME(Timestamp pUBLISH_TIME) {
		PUBLISH_TIME = pUBLISH_TIME;
	}

	@Override
	public String toString() {
		return "SkinTest [ID=" + ID + ", PATIENT_ID=" + PATIENT_ID + ", SKINTEST=" + SKINTEST + ", PRE_EXE_TIME="
				+ PRE_EXE_TIME + ", EXE_TIME=" + EXE_TIME + ", PUBLISH_TIME=" + PUBLISH_TIME + ", STATE=" + STATE + "]";
	}






}
