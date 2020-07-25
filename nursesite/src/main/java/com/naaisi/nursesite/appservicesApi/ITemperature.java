package com.naaisi.nursesite.appservicesApi;

import java.util.List;

import com.naaisi.nursesite.temperature.domain.Temperature;

/**
 * @author lizihao
 *
 */
public interface ITemperature {
	
	
	/**添加一条体温记录
	 * @param tEMPERATURE  温度记录
	 * @param pATIENT_ID   病人ID
	 * @param cREATED_BY  创建护士ID （权限管理未完成，默认由07创建）
	 * @return  
	 */
	boolean addTemperature(String tEMPERATURE, String pATIENT_ID);
	
	/**添加一条体温记录 （带返回代码）
	 * @param tEMPERATURE  温度记录
	 * @param pATIENT_ID   病人ID
	 * @param cREATED_BY  创建护士ID （权限管理未完成，默认由07创建）
	 * @return   TemperatureID  错误返回-1
	 */
	String addTemperature1(String tEMPERATURE, String pATIENT_ID);
	

	/**
	 *  将体温记录修改为无效。
	 * 
	 * @param  id Temperature id 
	 * @return
	 */
	boolean setTemperatureInvalid(String id);

	/**
	 *  将体温记录修改为有效。
	 * 
	 * @param  id Temperature id 
	 * @return
	 */
	boolean setTemperatureValid(String id);

	/**
	 * 获取病人所有体温记录
	 * 
	 * @param patient_Id
	 * @return List<Memo>
	 */
	List<Temperature> getTemperatureList(String patientId);

	/**
	 * 获取病人最近15条体温记录
	 * 
	 * @param patient_Id
	 * @return List<Memo>
	 */
	List<Temperature> getLast15Temperature(String patientId);
	
	/**修改一条体温记录
	 * @param tEMPERATURE  温度记录
	 * @param tEMPERATURE_ID   ID
	 * @return 
	 */ 
	boolean updateTemperature(String tEMPERATURE,String tEMPERATURE_ID);
	

	
	/**删除一条体温记录
	 * @param TemperatureID  
	 * @return   
	 */
	boolean deleteTemperature(String TemperatureID);
	
	/**删除一个病人全部的体温记录
	 * @param pATIENT_ID  
	 * @return   
	 */
	boolean deleteAllTemperatureByPatientID(String pATIENT_ID);
}
