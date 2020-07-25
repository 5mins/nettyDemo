package com.naaisi.nursesite.patient.dao;

import java.util.List;

import com.naaisi.nursesite.patient.domain.Patient;

public interface PatientDao {
	
	public boolean save(Patient patient);

	public boolean update(Patient patient) ;
	
	public List<Patient> findAll() ;
	
	public Patient findByID(int patient_id);
	
	public List<Patient> findByName(String patient_name);
	
	//public boolean deleteByID(int patient_id);//停用
	public boolean delete(Patient patient);
	
	 List<Patient> findByNurseID(int nurseID);
	
	
}
