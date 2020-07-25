package com.naaisi.nursesite.doctor.domain;

import java.sql.Timestamp;

import com.alibaba.fastjson.annotation.JSONField;


//CREATE TABLE Doctor(
//	    ID INT NOT NULL AUTO_INCREMENT  COMMENT '工号ID' ,
//	    NAME VARCHAR(128) NOT NULL   COMMENT '姓名' ,
//	    SEX INT    COMMENT '性别' ,
//	    DEPARTMENT VARCHAR(32)    COMMENT '所属部门' ,
//	    EMAIIL VARCHAR(128)    COMMENT '邮箱' ,
//	    PRIMARY KEY (ID)
//	) COMMENT = '医生 ';;

public class Doctor {
	
	@JSONField(name = "ID")
	private int ID;

	@JSONField(name = "NAME")
	private String NAME;

	@JSONField(name = "SEX")
	private int SEX;

	@JSONField(name = "DEPARTMENT")
	private String DEPARTMENT;

	@JSONField(name = "EMAIIL")
	private String EMAIIL;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public int getSEX() {
		return SEX;
	}

	public void setSEX(int sEX) {
		SEX = sEX;
	}

	public String getDEPARTMENT() {
		return DEPARTMENT;
	}

	public void setDEPARTMENT(String dEPARTMENT) {
		DEPARTMENT = dEPARTMENT;
	}

	public String getEMAIIL() {
		return EMAIIL;
	}

	public void setEMAIIL(String eMAIIL) {
		EMAIIL = eMAIIL;
	}

	@Override
	public String toString() {
		return "Doctor [ID=" + ID + ", NAME=" + NAME + ", SEX=" + SEX + ", DEPARTMENT=" + DEPARTMENT + ", EMAIIL="
				+ EMAIIL + "]";
	}









}
