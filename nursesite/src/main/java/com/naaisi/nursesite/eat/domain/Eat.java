package com.naaisi.nursesite.eat.domain;

import java.sql.Timestamp;

import com.alibaba.fastjson.annotation.JSONField;

//CREATE TABLE Eat(
//	    ID INT NOT NULL   COMMENT '任务ID' ,
//	    PATIENT_ID INT NOT NULL   COMMENT '病人ID' ,
//	    DRUG VARCHAR(32) NOT NULL   COMMENT '药物名称' ,
//	    PRE_EXE_TIME DATETIME    COMMENT '预计执行时间' ,
//	    EXE_TIME DATETIME    COMMENT '实际执行时间' ,
//	    STATE INT   DEFAULT 0 COMMENT '完成状态' ,
//	    FREQUENCY VARCHAR(32)    COMMENT '频次' ,
//	    PRIMARY KEY (ID)
//	) COMMENT = '口服药物 ';;

public class Eat {
	@JSONField(name = "ID")
	private int ID;

	@JSONField(name = "PATIENT_ID")
	private int PATIENT_ID;

	@JSONField(name = "DRUG")
	private String DRUG;

	@JSONField(name = "PRE_EXE_TIME")
	private Timestamp PRE_EXE_TIME;

	@JSONField(name = "EXE_TIME")
	private Timestamp EXE_TIME;
	
	@JSONField(name = "PUBLISH_TIME")
	private Timestamp PUBLISH_TIME;

	@JSONField(name = "STATE")
	private int STATE;

	@JSONField(name = "FREQUENCY")
	private String FREQUENCY;

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

	public String getDRUG() {
		return DRUG;
	}

	public void setDRUG(String dRUG) {
		DRUG = dRUG;
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

	public String getFREQUENCY() {
		return FREQUENCY;
	}

	public void setFREQUENCY(String fREQUENCY) {
		FREQUENCY = fREQUENCY;
	}

	public Timestamp getPUBLISH_TIME() {
		return PUBLISH_TIME;
	}

	public void setPUBLISH_TIME(Timestamp pUBLISH_TIME) {
		PUBLISH_TIME = pUBLISH_TIME;
	}

	@Override
	public String toString() {
		return "Eat [ID=" + ID + ", PATIENT_ID=" + PATIENT_ID + ", DRUG=" + DRUG + ", PRE_EXE_TIME=" + PRE_EXE_TIME
				+ ", EXE_TIME=" + EXE_TIME + ", PUBLISH_TIME=" + PUBLISH_TIME + ", STATE=" + STATE + ", FREQUENCY="
				+ FREQUENCY + "]";
	}



}
