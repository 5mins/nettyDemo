package com.naaisi.nursesite.temperature.domain;

import java.sql.Timestamp;

import com.alibaba.fastjson.annotation.JSONField;

//CREATE TABLE Temperature(
//	    ID INT NOT NULL AUTO_INCREMENT  COMMENT '条目ID' ,
//	    CREATED_TIME DATETIME NOT NULL   COMMENT '创建时间' ,
//	    CREATED_BY VARCHAR(128)   DEFAULT 7 COMMENT '创建人' ,
//	    PATIENT_ID VARCHAR(32)    COMMENT '绑定病人ID' ,
//	    TEMPERATURE DECIMAL(32,10) NOT NULL   COMMENT '温度记录' ,
//	    STATE INT    COMMENT '状态' ,
//	    PRIMARY KEY (ID)
//	) COMMENT = '体温表 ';;



public class Temperature {
	
	@JSONField(name = "ID")
	private int ID;
	
	@JSONField(name = "CREATED_TIME")
	private Timestamp CREATED_TIME;

	@JSONField(name = "CREATED_BY")
	private int CREATED_BY;
	
	@JSONField(name = "PATIENT_ID")
	private int PATIENT_ID;
	
	@JSONField(name = "TEMPERATURE")
	private double TEMPERATURE;

	@JSONField(name = "STATE")
	private int STATE;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
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

	public int getPATIENT_ID() {
		return PATIENT_ID;
	}

	public void setPATIENT_ID(int pATIENT_ID) {
		PATIENT_ID = pATIENT_ID;
	}

	public double getTEMPERATURE() {
		return TEMPERATURE;
	}

	public void setTEMPERATURE(double tEMPERATURE) {
		TEMPERATURE = tEMPERATURE;
	}

	public int getSTATE() {
		return STATE;
	}

	public void setSTATE(int sTATE) {
		STATE = sTATE;
	}

	@Override
	public String toString() {
		return "Temperature [ID=" + ID + ", CREATED_TIME=" + CREATED_TIME + ", CREATED_BY=" + CREATED_BY
				+ ", PATIENT_ID=" + PATIENT_ID + ", TEMPERATURE=" + TEMPERATURE + ", STATE=" + STATE + "]";
	}


///////////



}
