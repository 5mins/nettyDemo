package com.naaisi.nursesite.appservicesApi;

import java.sql.Timestamp;
import java.util.List;

import com.naaisi.nursesite.eat.domain.Eat;
import com.naaisi.nursesite.eat.service.EatService;
import com.naaisi.nursesite.eat.service.EatServiceImpl;
import com.naaisi.nursesite.uitl.DateTools;

/**
 * @author lizihao
 *
 */
public class SEat implements IEat {

	private EatService service;

	public SEat() {

		EatService service = new EatServiceImpl();
		this.service = service;
	}

	@Override
	public boolean addEat(String pATIENT_ID, String dRUG, String fREQUENCY, String pRE_EXE_TIME) {
		
		//Timestamp timestamp = new java.sql.Timestamp(Long.parseLong(pRE_EXE_TIME));
		Timestamp timestamp = DateTools.string2Time(pRE_EXE_TIME);
		return service.addEat(Integer.parseInt(pATIENT_ID), dRUG, fREQUENCY, timestamp);
	}

	@Override
	public boolean setExecutedById(String id) {
		return service.setExecutedByID(Integer.parseInt(id));
	}

	@Override
	public List<Eat> getAll() {
		return service.getAll();
	}

	@Override
	public List<Eat> getAllNotImplemented() {
		return service.getAllNotImplemented();
	}

	@Override
	public Eat getByID(String id) {
		return service.getByID(Integer.parseInt(id));
	}

	@Override
	public List<Eat> getListByPatientID(String patientID) {
		return service.getListByPatientID(Integer.parseInt(patientID));
	}

	@Override
	public List<Eat> getNotImplementedByPatientID(String patientID) {
		return service.getNotImplementedByPatientID(Integer.parseInt(patientID));
	}

}
