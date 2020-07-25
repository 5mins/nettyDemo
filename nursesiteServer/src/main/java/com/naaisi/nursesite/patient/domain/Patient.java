package com.naaisi.nursesite.patient.domain;

import java.sql.Timestamp;

import com.alibaba.fastjson.annotation.JSONField;

//CREATE TABLE Patient(
//	    ID INT NOT NULL AUTO_INCREMENT  COMMENT 'Id' ,
//	    NAME VARCHAR(128) NOT NULL   COMMENT '姓名' ,
//	    SEX INT    COMMENT '性别' ,
//	    AGE INT    COMMENT '年龄 0男1女' ,
//	    WARD VARCHAR(128)    COMMENT '病区' ,
//	    BED VARCHAR(32)    COMMENT '床号' ,
//	    DISEASE VARCHAR(128)    COMMENT '病名' ,
//	    DOCTOR INT    COMMENT '主治医师ID' ,
//	    NURSE INT    COMMENT '负责护士ID' ,
//	    DIET VARCHAR(512)    COMMENT '饮食要求' ,
//	    IN_TIME DATETIME    COMMENT '入院时间' ,
//	    OUT_TIME DATETIME    COMMENT '出院时间' ,
//	    PRIMARY KEY (ID)
//	) COMMENT = '病人 所有病人的信息，病人ID作为主键';;

public class Patient {

	@JSONField(name = "ID")
	private int ID;

	@JSONField(name = "NAME")
	private String NAME;

	@JSONField(name = "SEX")
	private int SEX;

	@JSONField(name = "AGE")
	private int AGE;

	@JSONField(name = "WARD")
	private String WARD;

	@JSONField(name = "BED")
	private String BED;

	@JSONField(name = "DISEASE")
	private String DISEASE;

	@JSONField(name = "DOCTOR")
	private int DOCTOR;

	@JSONField(name = "NURSE")
	private int NURSE;

	@JSONField(name = "DIET")
	private String DIET;

	@JSONField(name = "IN_TIME")
	private Timestamp IN_TIME;

	@JSONField(name = "OUT_TIME")
	private Timestamp OUT_TIME;

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

	public int getAGE() {
		return AGE;
	}

	public void setAGE(int aGE) {
		AGE = aGE;
	}

	public String getWARD() {
		return WARD;
	}

	public void setWARD(String wARD) {
		WARD = wARD;
	}

	public String getBED() {
		return BED;
	}

	public void setBED(String bED) {
		BED = bED;
	}

	public String getDISEASE() {
		return DISEASE;
	}

	public void setDISEASE(String dISEASE) {
		DISEASE = dISEASE;
	}

	public int getDOCTOR() {
		return DOCTOR;
	}

	public void setDOCTOR(int dOCTOR) {
		DOCTOR = dOCTOR;
	}

	public int getNURSE() {
		return NURSE;
	}

	public void setNURSE(int nURSE) {
		NURSE = nURSE;
	}

	public String getDIET() {
		return DIET;
	}

	public void setDIET(String dIET) {
		DIET = dIET;
	}

	public Timestamp getIN_TIME() {
		return IN_TIME;
	}

	public void setIN_TIME(Timestamp iN_TIME) {
		IN_TIME = iN_TIME;
	}

	public Timestamp getOUT_TIME() {
		return OUT_TIME;
	}

	public void setOUT_TIME(Timestamp oUT_TIME) {
		OUT_TIME = oUT_TIME;
	}

	@Override
	public String toString() {
		return "Patient [ID=" + ID + ", NAME=" + NAME + ", SEX=" + SEX + ", AGE=" + AGE + ", WARD=" + WARD + ", BED="
				+ BED + ", DISEASE=" + DISEASE + ", DOCTOR=" + DOCTOR + ", NURSE=" + NURSE + ", DIET=" + DIET
				+ ", IN_TIME=" + IN_TIME + ", OUT_TIME=" + OUT_TIME + "]";
	}

}
