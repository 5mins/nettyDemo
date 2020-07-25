package com.naaisi.nursesite.appservicesApi;

import java.util.List;

import com.naaisi.nursesite.patient.domain.Patient;
import com.naaisi.nursesite.patient.service.PatientService;
import com.naaisi.nursesite.patient.service.PatientServiceImpl;

/**
 * @author lizihao
 *
 */
public class SPatient implements IPatient {

	private PatientService service;

	public SPatient() {

		PatientService service = new PatientServiceImpl();
		this.service = service;
	}

	@Override
	public boolean addPatient(String nAME, String sEX, String aGE) {

		return service.addPatient(nAME, Integer.parseInt(sEX), Integer.parseInt(aGE));
	}

	@Override
	public boolean updatePatient(String patient_id, String nAME, String sEX, String aGE) {

		return service.updatePatient(Integer.parseInt(patient_id), nAME, Integer.parseInt(sEX), Integer.parseInt(aGE));
	}

	@Override
	public boolean updatePatient(String patient_id, String bED) {

		return service.updatePatient(Integer.parseInt(patient_id), Integer.parseInt(bED));
	}

	@Override
	public List<Patient> getAll() {

		return service.getAll();
	}

	@Override
	public Patient getById(String patient_id) {

		return service.getByID(Integer.parseInt(patient_id));
	}

	@Override
	public List<Patient> getByPatientName(String patient_name) {

		return service.getByPatientName(patient_name);
	}

	@Override
	public boolean deletePatientById(String patient_id) {

		return service.deletePatientByID(Integer.parseInt(patient_id));
	}

	@Override
	public List<Patient> getByNurseID(String nurseID) {
		
		return service.getByNurseID(Integer.parseInt(nurseID));
	}

}
