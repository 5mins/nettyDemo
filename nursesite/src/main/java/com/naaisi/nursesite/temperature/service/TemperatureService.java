package com.naaisi.nursesite.temperature.service;

import java.sql.Timestamp;
import java.util.List;

import com.naaisi.nursesite.temperature.domain.Temperature;

public interface TemperatureService {

	/**添加一条体温记录
	 * @param tEMPERATURE  温度记录
	 * @param pATIENT_ID   病人ID
	 * @param cREATED_BY  创建护士ID
	 * @return 
	 */ 
	boolean addTemperature(double tEMPERATURE,int pATIENT_ID,int cREATED_BY);
	
	/**添加一条体温记录
	 * @param tEMPERATURE  温度记录
	 * @param pATIENT_ID   病人ID
	 * @param cREATED_BY  创建护士ID
	 * @return ID
	 */ 
	int addTemperature1(double tEMPERATURE,int pATIENT_ID,int cREATED_BY);

	/**
	 *  将体温记录修改为无效。
	 * 
	 * @param  id Temperature id 
	 * @return
	 */
	boolean setTemperatureInvalid(int id);

	/**
	 *  将体温记录修改为有效。
	 * 
	 * @param  id Temperature id 
	 * @return
	 */
	boolean setTemperatureValid(int id);

	/**
	 * 获取病人所有体温记录
	 * 
	 * @param patient_Id
	 * @return List<Memo>
	 */
	List<Temperature> getTemperatureList(int patientId);

	/**
	 * 获取病人最近15条体温记录
	 * 
	 * @param patient_Id
	 * @return List<Memo>
	 */
	List<Temperature> getLast15Temperature(int patientId);
	
	/**修改一条体温记录
	 * @param tEMPERATURE  温度记录
	 * @param tEMPERATURE_ID   ID
	 * @return 
	 */ 
	boolean updateTemperature(double tEMPERATURE,int tEMPERATURE_ID);
	
	/**删除一条体温记录
	 * @param TemperatureID  
	 * @return   
	 */
	boolean deleteTemperature(int tEMPERATURE_ID);
	
	/**删除一个病人全部的体温记录
	 * @param pATIENT_ID  
	 * @return   
	 */
	boolean deleteAllTemperatureByPatientID(int pATIENT_ID);
	
	

}