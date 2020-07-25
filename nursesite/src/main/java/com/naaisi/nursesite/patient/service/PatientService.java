package com.naaisi.nursesite.patient.service;

import java.util.List;

import com.naaisi.nursesite.patient.dao.PatientDao;
import com.naaisi.nursesite.patient.domain.Patient;

public interface PatientService {

	void setPatientDao(PatientDao patientDao);

	/**添加一个病人
	 * @param nAME
	 * @param sEX
	 * @param aGE
	 * @return
	 */
	boolean addPatient(String nAME, int sEX, int aGE);

	/**通过patient_id 更新一个病人的信息，姓名，性别，年龄
	 * @param patient_id
	 * @param nAME
	 * @param sEX
	 * @param aGE
	 * @return
	 */
	boolean updatePatient(int patient_id, String nAME, int sEX, int aGE);

	/**通过patient_id 更新一个病人的信息，负责护士
	 * @param patient_id
	 * @param nURSE_id
	 * @return
	 */
	boolean updatePatient(int patient_id, int nURSE_id);

	/**通过patient_id 更新一个病人的信息，床位（string）自己改名字
	 * @param patient_id
	 * @param bED
	 * @return
	 */
	boolean updatePatient(int patient_id, String bED);

	/**获取所有病人
	 * @return List<Patient>
	 */
	List<Patient> getAll();

	/**获取一个病人
	 * @param patient_id
	 * @return Patient
	 */
	Patient getByID(int patient_id);

	/**通过姓名获取病人列表
	 * @param patient_name
	 * @return List<Patient>
	 */
	List<Patient> getByPatientName(String patient_name);
	
	/**通过护士ID获取病人列表
	 * @param nurseID
	 * @return List<Patient>
	 */
	 List<Patient> getByNurseID(int nurseID);
	

	/**删除一个病人
	 * @param patient_id
	 * @return
	 */
	boolean deletePatientByID(int patient_id);

}