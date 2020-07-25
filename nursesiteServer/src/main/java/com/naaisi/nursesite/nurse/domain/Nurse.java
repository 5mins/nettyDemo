package com.naaisi.nursesite.nurse.domain;

import java.sql.Timestamp;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;
import com.naaisi.nursesite.docadvice.domain.DocAdvice;


//CREATE TABLE Nurse(
//	    ID INT NOT NULL AUTO_INCREMENT  COMMENT '工号ID' ,
//	    NAME VARCHAR(128) NOT NULL   COMMENT '姓名' ,
//	    SEX INT    COMMENT '性别' ,
//	    DEPARTMENT VARCHAR(128)    COMMENT '所属部门' ,
//	    EMAIIL VARCHAR(32)    COMMENT '邮箱' ,
//	    PRIMARY KEY (ID)
//	) COMMENT = '护士 ';;

public class Nurse {
	
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
	
	@JSONField(name = "PASSWORD")
	private String PASSWORD;
	
	
	//private Set<DocAdvice> docAdvices;



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
	
	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

//	public Set<DocAdvice> getDocAdvices() {
//		return docAdvices;
//	}
//
//	public void setDocAdvices(Set<DocAdvice> docAdvices) {
//		this.docAdvices = docAdvices;
//	}

	@Override
	public String toString() {
		return "Nurse [ID=" + ID + ", NAME=" + NAME + ", SEX=" + SEX + ", DEPARTMENT=" + DEPARTMENT + ", EMAIIL="
				+ EMAIIL + "]";
	}


	
	
	






}
