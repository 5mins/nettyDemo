package com.naaisi.nursesite.appservicesApi;

import java.util.List;

import com.naaisi.nursesite.blood.domain.Blood;

/**
 * @author lizihao
 *
 */
public interface IBlood {

	/**
	 *  添加存储一个blood记录
	 * 
	 * @param 
	 * @return
	 */

	boolean addBlood(String pATIENT_ID, String bLOOD, String pRE_EXE_TIME);

	/**
	 *  通过采血单ID 将状态标记为已执行,并记录当前系统时间为执行时间
	 * 
	 * @param id 采血单ID
	 * @return
	 */

	boolean setExecutedById(String id);

	/**
	 *  获取所有采血单
	 * 
	 * @return List<Blood>
	 */

	List<Blood> getAll();

	/**
	 *  获取所有未执行的采血单
	 * 
	 * @return List<Blood>
	 */

	List<Blood> getAllNotImplemented();

	/**
	 * 通过bloodID获取一个blood记录
	 * @param ID
	 * @return Blood
	 */

	Blood getByID(String id);

	/**
	 * 通过bloodID获取该病人所有的blood记录
	 * 
	 * @param patientID
	 * @return List<Blood>
	 */

	List<Blood> getBloodListByPatientID(String patientID);

	/**
	 * 获取该病人所有未执行的blood记录
	 * 
	 * @param patientID
	 * @return  List<Blood>
	 */

	List<Blood> getNotImplementedByPatientID(String patientID);

}
