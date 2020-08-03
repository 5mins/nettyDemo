package com.naaisi.nursesite.appservicesApi;

import java.util.List;

import com.naaisi.nursesite.bunk.domain.Bunk;

public interface IBunk {
	/**
	 * // 新增一张床位
	 * 
	 * @param ward 所属病区
	 * @return
	 */

	boolean addBunk(String ward);
	
	/**
	 * // 绑定床位给病人。
	 * 
	 * @param 
	 * @return
	 */

	boolean bindBunkToPatient(String bunkID,String patientID);

	/**
	 * // 获取所有床位
	 * 
	 * @return
	 */

	List<Bunk> getAll();

	/**
	 * // 查找所有空闲的床位
	 * 
	 * @return
	 */

	List<Bunk> getAllNotImplemented();

	/**
	 * //通过ID获取一个床位记录
	 * 
	 * @param ID
	 * @return
	 */
	Bunk getByID(String id);

	/**
	 * //获取一张空闲的床位记录
	 * 
	 * @param
	 * @return
	 */
	Bunk getNotUseBunk();

	/**
	 * //通过该病人所有的床位记录
	 * 
	 * @param patientID
	 * @return List<Bunk>
	 */

	List<Bunk> getListByPatientID(String patientID);

	/**
	 * //将床位设定为已使用
	 * 
	 * @param ID
	 * 
	 * @return
	 */

	boolean setBunkUsed(String id);

	/**
	 * //将床位设定为未使用
	 * 
	 * @param ID
	 * 
	 * @return
	 */
	boolean setBunkNotUsed(String id);
}
