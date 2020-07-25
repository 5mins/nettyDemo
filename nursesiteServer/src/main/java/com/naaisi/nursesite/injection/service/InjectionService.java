package com.naaisi.nursesite.injection.service;

import java.sql.Timestamp;
import java.util.List;

import com.naaisi.nursesite.injection.dao.InjectionDao;
import com.naaisi.nursesite.injection.domain.Injection;

public interface InjectionService {

	void setInjectionDao(InjectionDao dao);

	/**
	 * 添加存储一个注射药物记录
	 * 
	 * @param pATIENT_ID
	 * @param dRUG         注射药物名称
	 * @param fREQUENCY    频次
	 * @param pRE_EXE_TIME 预计执行时间
	 * @return
	 */
	boolean addInjection(int pATIENT_ID, String dRUG, String fREQUENCY, Timestamp pRE_EXE_TIME);

	/**
	 * 通过注射药物ID 将状态标记为已执行,并记录当前系统时间为执行时间
	 * 
	 * @param id 注射药物ID
	 * @return
	 */
	boolean setExecutedByID(int id);

	/**
	 * 获取所有注射药物单
	 * 
	 * @return List<Injection>
	 */
	List<Injection> getAll();

	/**
	 * 获取所有未执行的注射药物单
	 * 
	 * @return List<Injection>
	 */
	List<Injection> getAllNotImplemented();

	/**
	 * 通过EatID获取一个注射药物记录
	 * 
	 * @param ID
	 * @return Injection
	 */
	Injection getByID(int id);

	/**
	 * 通过EatID获取该病人所有的注射药物记录
	 * 
	 * @param InjectionID
	 * @return List<Injection>
	 */
	List<Injection> getListByPatientID(int patientID);

	/**
	 * 获取该病人所有未执行的注射药物记录
	 * 
	 * @param patientID
	 * @return List<Injection>
	 */
	List<Injection> getNotImplementedByPatientID(int patientID);

}