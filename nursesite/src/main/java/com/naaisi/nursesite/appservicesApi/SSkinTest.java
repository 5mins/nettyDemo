package com.naaisi.nursesite.appservicesApi;

import java.sql.Timestamp;
import java.util.List;

import com.naaisi.nursesite.skintest.domain.SkinTest;
import com.naaisi.nursesite.skintest.service.SkinTestService;
import com.naaisi.nursesite.skintest.service.SkinTestServiceImpl;
import com.naaisi.nursesite.uitl.DateTools;

/**
 * @author lizihao
 *
 */
public class SSkinTest implements ISkinTest {

	private SkinTestService service;

	public SSkinTest() {
		SkinTestService service = new SkinTestServiceImpl();
		this.service = service;
	}

	@Override
	public boolean addSkinTest(String pATIENT_ID, String sKINTEST, String pRE_EXE_TIME) {
		//Timestamp timestamp = new java.sql.Timestamp(Long.parseLong(pRE_EXE_TIME));
		Timestamp timestamp = DateTools.string2Time(pRE_EXE_TIME);
		return service.addSkinTest(Integer.parseInt(pATIENT_ID), sKINTEST, timestamp);
	}

	@Override
	public boolean setExecutedById(String id) {

		return service.setExecutedById(Integer.parseInt(id));
	}

	@Override
	public List<SkinTest> getAll() {

		return service.getAll();
	}

	@Override
	public List<SkinTest> getAllNotImplemented() {

		return service.getAllNotImplemented();
	}

	@Override
	public SkinTest getByID(String id) {

		return service.getByID(Integer.parseInt(id));
	}

	@Override
	public List<SkinTest> getListByPatientID(String patientID) {

		return service.getListByPatientID(Integer.parseInt(patientID));
	}

	@Override
	public List<SkinTest> getNotImplementedByPatientID(String patientID) {

		return service.getNotImplementedByPatientID(Integer.parseInt(patientID));
	}

}
