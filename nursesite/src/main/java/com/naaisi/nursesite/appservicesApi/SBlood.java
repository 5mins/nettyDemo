package com.naaisi.nursesite.appservicesApi;

import java.sql.Timestamp;
import java.util.List;

import com.naaisi.nursesite.blood.domain.Blood;
import com.naaisi.nursesite.blood.service.BloodService;
import com.naaisi.nursesite.blood.service.BloodServiceImpl;
import com.naaisi.nursesite.uitl.DateTools;

/**
 * @author lizihao
 *
 */
public class SBlood implements IBlood {

	private BloodService service;

	public SBlood() {

		BloodService service = new BloodServiceImpl();
		this.service = service;
	}

	@Override
	public boolean addBlood(String pATIENT_ID, String bLOOD, String pRE_EXE_TIME) {
		
		//Timestamp timestamp = new java.sql.Timestamp(Long.parseLong(pRE_EXE_TIME));
		Timestamp timestamp = DateTools.string2Time(pRE_EXE_TIME);
		return service.addBlood(Integer.parseInt(pATIENT_ID), bLOOD, timestamp);

	}

	@Override
	public boolean setExecutedById(String id) {
		return service.setExecutedByID(Integer.parseInt(id));
	}

	@Override
	public List<Blood> getAll() {
		return service.getAll();
	}

	@Override
	public List<Blood> getAllNotImplemented() {
		return service.getAllNotImplemented();
	}

	@Override
	public Blood getByID(String id) {
		return service.getByID(Integer.parseInt(id));
	}

	@Override
	public List<Blood> getBloodListByPatientID(String patientID) {
		return service.getBloodListByPatientID(Integer.parseInt(patientID));
	}

	@Override
	public List<Blood> getNotImplementedByPatientID(String patientID) {
		return service.getNotImplementedByPatientID(Integer.parseInt(patientID));
	}



}
