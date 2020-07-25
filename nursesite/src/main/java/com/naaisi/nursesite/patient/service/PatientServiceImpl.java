package com.naaisi.nursesite.patient.service;

import java.util.List;


import com.naaisi.nursesite.patient.dao.PatientDao;
import com.naaisi.nursesite.patient.dao.PatientDaoImpl;
import com.naaisi.nursesite.patient.domain.Patient;

//@Service("PatientService")
/**
 * @author lizihao
 *
 */
public class PatientServiceImpl implements  PatientService {
	
	private PatientDao dao;
	

	public PatientServiceImpl() {
		super();
		PatientDao dao = new PatientDaoImpl();
		this.dao = dao;
	}


	
	@Override
	public void setPatientDao(PatientDao patientDao) {
		this.dao = patientDao;
	}

	

	/**添加一个病人
	 * @param nAME
	 * @param sEX
	 * @param aGE
	 * @return
	 */
	@Override
	public boolean addPatient(String nAME,int sEX,int aGE) {
		Patient patient = new Patient();
		patient.setNAME(nAME);
		patient.setSEX(sEX);
		patient.setAGE(aGE);
		return dao.save(patient);
		

	}

	/**通过patient_id 更新一个病人的信息，姓名，性别，年龄
	 * @param patient_id
	 * @param nAME
	 * @param sEX
	 * @param aGE
	 * @return
	 */
	@Override
	public boolean updatePatient(int patient_id,String nAME,int sEX,int aGE) {
		Patient patient = dao.findByID(patient_id);
		patient.setNAME(nAME);
		patient.setSEX(sEX);
		patient.setAGE(aGE);
		return dao.update(patient);
		
	}



	/**通过patient_id 更新一个病人的信息，负责护士
	 * @param patient_id
	 * @param nURSE_id
	 * @return
	 */
	@Override
	public boolean updatePatient(int patient_id,int nURSE_id) {
		Patient patient = dao.findByID(patient_id);
		patient.setNURSE(nURSE_id);
		return dao.update(patient);
		
	}


	/**通过patient_id 更新一个病人的信息，床位（string）自己改名字
	 * @param patient_id
	 * @param bED
	 * @return
	 */
	@Override
	public boolean updatePatient(int patient_id,String bED) {
		Patient patient = dao.findByID(patient_id);
		patient.setBED(bED);
		return dao.update(patient);
		
	}

	
	/**获取所有病人
	 * @return List<Patient>
	 */
	@Override
	public List<Patient> getAll() {
		return  dao.findAll();
		
	}



	
	/**获取一个病人
	 * @param patient_id
	 * @return Patient
	 */
	@Override
	public Patient getByID(int patient_id) {
		return  dao.findByID(patient_id);
	}
	
	
	/**通过姓名获取病人列表
	 * @param patient_name
	 * @return List<Patient>
	 */
	@Override
	public List<Patient> getByPatientName(String patient_name) {
		return  dao.findByName(patient_name);
	}
		
	/**通过护士ID获取病人列表
	 * @param nurseID
	 * @return List<Patient>
	 */
	@Override
	public List<Patient> getByNurseID(int nurseID) {
		return  dao.findByNurseID(nurseID);
	}



	
	/**删除一个病人
	 * @param patient_id
	 * @return
	 */
	@Override
	public boolean deletePatientByID(int patient_id) {	
		Patient domain = dao.findByID(patient_id);
		
	return dao.delete(domain);
				
		
	}


public static void main(String[] args) {
	PatientServiceImpl imp = new PatientServiceImpl();
	imp.getAll();
	List<Patient> byNurseID = imp.getByNurseID(3);
	System.out.println(byNurseID);
	
}

	
	

}