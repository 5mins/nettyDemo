package com.naaisi.nursesite.appservicesApi;

import java.sql.Timestamp;
import java.util.List;


import com.naaisi.nursesite.injection.domain.Injection;
import com.naaisi.nursesite.injection.service.InjectionService;
import com.naaisi.nursesite.injection.service.InjectionServiceImpl;
import com.naaisi.nursesite.uitl.DateTools;

/**
 * @author lizihao
 *
 */
public class SInjection implements IInjection {
	
	private InjectionService service;

	public SInjection() {

		InjectionService service = new InjectionServiceImpl();
		this.service = service;
	}
	
	
	

	@Override
	public boolean addInjection(String pATIENT_ID, String dRUG, String fREQUENCY, String pRE_EXE_TIME) {
		//Timestamp timestamp = new java.sql.Timestamp(Long.parseLong(pRE_EXE_TIME));
		Timestamp timestamp = DateTools.string2Time(pRE_EXE_TIME);
		return service.addInjection(Integer.parseInt(pATIENT_ID), dRUG, fREQUENCY, timestamp);
	}

	@Override
	public boolean setExecutedById(String id) {
		return service.setExecutedByID(Integer.parseInt(id));
	}

	@Override
	public List<Injection> getAll() {
		return service.getAll();
	}

	@Override
	public List<Injection> getAllNotImplemented() {
		return service.getAllNotImplemented();
	}

	@Override
	public Injection getByID(String id) {
		return service.getByID(Integer.parseInt(id));
	}

	@Override
	public List<Injection> getListByPatientID(String patientID) {
		return service.getListByPatientID(Integer.parseInt(patientID));
	}

	@Override
	public List<Injection> getNotImplementedByPatientID(String patientID) {
		return service.getNotImplementedByPatientID(Integer.parseInt(patientID));
	}

}
