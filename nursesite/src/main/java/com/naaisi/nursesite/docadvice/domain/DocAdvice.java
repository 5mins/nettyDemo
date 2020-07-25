package com.naaisi.nursesite.docadvice.domain;

import java.sql.Timestamp;

import com.alibaba.fastjson.annotation.JSONField;
import com.naaisi.nursesite.nurse.domain.Nurse;

//CREATE TABLE DocAdvice(
//	    ID INT NOT NULL AUTO_INCREMENT  COMMENT '任务ID' ,
//	    PATIENT_ID INT NOT NULL   COMMENT '病人ID' ,
//	    ADVICE VARCHAR(3072) NOT NULL   COMMENT '医嘱内容' ,
//	    PRE_EXE_TIME DATETIME    COMMENT '预计执行时间' ,
//	    EXE_TIME DATETIME    COMMENT '实际执行时间' ,
//	    STATE INT   DEFAULT 0 COMMENT '完成状态 0未完成，1已执行，2归档' ,
//	    EXECUTOU INT    COMMENT '执行护士' ,
//	    COMMENT VARCHAR(3072)    COMMENT '备注' ,
//	    TYPE INT    COMMENT '医嘱类型 0临时，1长期' ,
//	    PRIMARY KEY (ID)
//	) COMMENT = '医嘱 ';;

public class DocAdvice {

	@JSONField(name = "ID")
	private int ID;

	@JSONField(name = "PATIENT_ID")
	private int PATIENT_ID;

	@JSONField(name = "ADVICE")
	private String ADVICE;

	@JSONField(name = "PRE_EXE_TIME")
	private Timestamp PRE_EXE_TIME;

	@JSONField(name = "EXE_TIME")
	private Timestamp EXE_TIME;
	
	@JSONField(name = "PUBLISH_TIME")
	private Timestamp PUBLISH_TIME;

	@JSONField(name = "STATE")
	private int STATE;

	@JSONField(name = "EXECUTOU")
	private int EXECUTOU;

	@JSONField(name = "COMMENT")
	private String COMMENT;

	@JSONField(name = "TYPE")
	private int TYPE;
	
//	private Nurse nurse;


	///////////////////////////
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

	public String getADVICE() {
		return ADVICE;
	}

	public void setADVICE(String aDVICE) {
		ADVICE = aDVICE;
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

	public int getEXECUTOU() {
		return EXECUTOU;
	}

	public void setEXECUTOU(int eXECUTOU) {
		EXECUTOU = eXECUTOU;
	}

	public String getCOMMENT() {
		return COMMENT;
	}

	public void setCOMMENT(String cOMMENT) {
		COMMENT = cOMMENT;
	}

	public int getTYPE() {
		return TYPE;
	}

	public void setTYPE(int tYPE) {
		TYPE = tYPE;
	}

	public Timestamp getPUBLISH_TIME() {
		return PUBLISH_TIME;
	}

	public void setPUBLISH_TIME(Timestamp pUBLISH_TIME) {
		PUBLISH_TIME = pUBLISH_TIME;
	}

	@Override
	public String toString() {
		return "DocAdvice [ID=" + ID + ", PATIENT_ID=" + PATIENT_ID + ", ADVICE=" + ADVICE + ", PRE_EXE_TIME="
				+ PRE_EXE_TIME + ", EXE_TIME=" + EXE_TIME + ", PUBLISH_TIME=" + PUBLISH_TIME + ", STATE=" + STATE
				+ ", EXECUTOU=" + EXECUTOU + ", COMMENT=" + COMMENT + ", TYPE=" + TYPE + "]";
	}
	
//	public Nurse getNurse() {
//		return nurse;
//	}
//
//	public void setNurse(Nurse nurse) {
//		this.nurse = nurse;
//	}




	

}
