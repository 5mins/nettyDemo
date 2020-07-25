package com.naaisi.nursesite.blood.service;

import java.sql.Timestamp;
import java.util.List;

import com.naaisi.nursesite.blood.dao.BloodDao;
import com.naaisi.nursesite.blood.domain.Blood;

public interface BloodService {

	void setBloodDao(BloodDao dao);

	/**
	 * 添加存储一个blood记录
	 * 
	 * @param
	 * @return
	 */

	boolean addBlood(int pATIENT_ID, String bLOOD, Timestamp pRE_EXE_TIME);

	/**
	 * 通过采血单ID 将状态标记为已执行,并记录当前系统时间为执行时间
	 * 
	 * @param id 采血单ID
	 * @return
	 */

	boolean setExecutedByID(int id);

	/**
	 * 获取所有采血单
	 * 
	 * @return List<Blood>
	 */

	List<Blood> getAll();

	/**
	 * 获取所有未执行的采血单
	 * 
	 * @return List<Blood>
	 */

	List<Blood> getAllNotImplemented();

	/**
	 * 通过bloodID获取一个blood记录
	 * 
	 * @param ID
	 * @return Blood
	 */

	Blood getByID(int id);

	/**
	 * 通过bloodID获取该病人所有的blood记录
	 * 
	 * @param patientID
	 * @return List<Blood>
	 */

	List<Blood> getBloodListByPatientID(int patientID);

	/**
	 * 获取该病人所有未执行的blood记录
	 * 
	 * @param patientID
	 * @return List<Blood>
	 */

	List<Blood> getNotImplementedByPatientID(int patientID);

}