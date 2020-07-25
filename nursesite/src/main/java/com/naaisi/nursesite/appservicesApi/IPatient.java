package com.naaisi.nursesite.appservicesApi;

import java.util.List;

import com.naaisi.nursesite.patient.domain.Patient;

/**
 * @author lizihao
 *
 */
public interface IPatient {
	/**
	 * 添加一个病人
	 * 
	 * @param nAME
	 * @param sEX
	 * @param aGE
	 * @return
	 */
	boolean addPatient(String nAME, String sEX, String aGE);

	/**
	 * 通过patient_id 更新一个病人的信息，姓名，性别，年龄
	 * 
	 * @param patient_id
	 * @param nAME
	 * @param sEX
	 * @param aGE
	 * @return
	 */
	boolean updatePatient(String patient_id, String nAME, String sEX, String aGE);

	/**
	 * 通过patient_id 更新一个病人的信息，床位（string）自己改名字
	 * 
	 * @param patient_id
	 * @param bED
	 * @return
	 */
	boolean updatePatient(String patient_id, String bED);

	/**
	 * 获取所有病人
	 * 
	 * @return List<Patient>
	 */
	List<Patient> getAll();

	/**
	 * 获取一个病人
	 * 
	 * @param patient_id
	 * @return Patient
	 */
	Patient getById(String patient_id);

	/**
	 * 通过姓名获取病人列表
	 * 
	 * @param patient_name
	 * @return List<Patient>
	 */
	List<Patient> getByPatientName(String patient_name);

	/**
	 * 删除一个病人
	 * 
	 * @param patient_id
	 * @return
	 */
	boolean deletePatientById(String patient_id);

	/**
	 * 通过护士ID获取病人列表
	 * 
	 * @param nurseID
	 * @return List<Patient>
	 */
	List<Patient> getByNurseID(String nurseID);
}
