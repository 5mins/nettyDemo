package com.naaisi.nursesite.skintest.service;

import java.sql.Timestamp;
import java.util.List;

import com.naaisi.nursesite.skintest.dao.SkinTestDao;
import com.naaisi.nursesite.skintest.domain.SkinTest;

public interface SkinTestService {

	void setSkinTestDao(SkinTestDao dao);

	/**
	 * 添加存储一个皮试记录
	 * 
	 * @param
	 * @return
	 */

	boolean addSkinTest(int pATIENT_ID, String sKINTEST, Timestamp pRE_EXE_TIME);

	/**
	 * 通过皮试ID 将状态标记为已执行,并记录当前系统时间为执行时间
	 * 
	 * @param id 皮试ID
	 * @return
	 */

	boolean setExecutedById(int id);

	/**
	 * 获取所有皮试单
	 * 
	 * @return List<SkinTest>
	 */

	List<SkinTest> getAll();

	/**
	 * 获取所有未执行的SkinTest单
	 * 
	 * @return List<SkinTest>
	 */

	List<SkinTest> getAllNotImplemented();

	/**
	 * 通过SkinTestID获取一个SkinTest记录
	 * 
	 * @param ID
	 * @return SkinTest
	 */
	SkinTest getByID(int id);

	/**
	 * 通过SkinTestID获取该病人所有的SkinTest记录
	 * 
	 * @param SkinTestID
	 * @return List<SkinTest>
	 */
	List<SkinTest> getListByPatientID(int patientID);

	/**
	 * 获取该病人所有未执行的SkinTest记录
	 * 
	 * @param patientID
	 * @return List<SkinTest>
	 */

	List<SkinTest> getNotImplementedByPatientID(int patientID);

}