package com.naaisi.nursesite.password.domain;

import java.sql.Timestamp;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;
import com.naaisi.nursesite.docadvice.domain.DocAdvice;

//CREATE TABLE `password` (
//		  `ID` int NOT NULL AUTO_INCREMENT,
//		  `NURSE_ID` int NOT NULL,
//		  `PASSWORD` varchar(1024) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
//		  PRIMARY KEY (`ID`),
//		  KEY `NURSEID` (`NURSE_ID`),
//		  CONSTRAINT `password_ibfk_1` FOREIGN KEY (`NURSE_ID`) REFERENCES `nurse` (`ID`)
//		) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
//
//		/*Data for the table `password` */

public class PassWord {

	@JSONField(name = "ID")
	private int ID;

	@JSONField(name = "NURSE_ID")
	private int NURSE_ID;

	@JSONField(name = "PASSWORD")
	private String PASSWORD;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getNURSE_ID() {
		return NURSE_ID;
	}

	public void setNURSE_ID(int nURSE_ID) {
		NURSE_ID = nURSE_ID;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	@Override
	public String toString() {
		return "PassWord [ID=" + ID + ", NURSE_ID=" + NURSE_ID + "]";
	}

}
