package com.naaisi.nursesite.eat.service;

import java.sql.Timestamp;
import java.util.List;

import com.naaisi.nursesite.eat.dao.EatDao;
import com.naaisi.nursesite.eat.domain.Eat;

public interface EatService {

	void setEatDao(EatDao dao);

	/**添加存储一个口服药物记录
	 * @param pATIENT_ID
	 * @param dRUG    			口服药名称
	 * @param fREQUENCY			频次
	 * @param pRE_EXE_TIME     预计执行时间
	 * @return
	 */
	boolean addEat(int pATIENT_ID, String dRUG, String fREQUENCY, Timestamp pRE_EXE_TIME);

	/**
	 * 通过口服药物ID 将状态标记为已执行,并记录当前系统时间为执行时间
	 * 
	 * @param id 口服药物ID
	 * @return
	 */
	boolean setExecutedByID(int id);

	/**
	 * 获取所有口服药物单
	 * 
	 * @return List<Eat>
	 */
	List<Eat> getAll();

	/**
	 * 获取所有未执行的Eat单
	 * 
	 * @return List<Eat>
	 */

	List<Eat> getAllNotImplemented();

	/**
	 * 通过EatID获取一个Eat记录
	 * 
	 * @param ID
	 * @return Eat
	 */
	Eat getByID(int id);

	/**
	 * 通过EatID获取该病人所有的Eat记录
	 * 
	 * @param EatID
	 * @return List<Eat>
	 */

	List<Eat> getListByPatientID(int patientID);

	/**
	 * 获取该病人所有未执行的Eat记录
	 * 
	 * @param patientID
	 * @return List<Eat>
	 */

	List<Eat> getNotImplementedByPatientID(int patientID);

}