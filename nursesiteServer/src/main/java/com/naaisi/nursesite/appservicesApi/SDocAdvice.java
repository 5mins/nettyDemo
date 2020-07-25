package com.naaisi.nursesite.appservicesApi;

import java.sql.Timestamp;
import java.util.List;

import com.naaisi.nursesite.docadvice.domain.DocAdvice;
import com.naaisi.nursesite.docadvice.service.DocAdviceService;
import com.naaisi.nursesite.docadvice.service.DocAdviceServiceImpl;
import com.naaisi.nursesite.uitl.DateTools;

/**
 * @author lizihao
 *
 */
public class SDocAdvice implements IDocAdvice {

	private DocAdviceService service;

	public SDocAdvice() {

		DocAdviceService service = new DocAdviceServiceImpl();
		this.service = service;
	}

	@Override
	public boolean addAdvice(String pATIENT_ID, String eXECUTOU, String aDVICE, String pRE_EXE_TIME) {
//		long parseLong = Long.parseLong(pRE_EXE_TIME);
//		System.out.println("longparselong  "+parseLong);
//		Timestamp timestamp = new java.sql.Timestamp(parseLong);
//		System.out.println(timestamp.toString());
		Timestamp timestamp = DateTools.string2Time(pRE_EXE_TIME);
		return service.addAdvice(Integer.parseInt(pATIENT_ID), Integer.parseInt(eXECUTOU), aDVICE, timestamp);
	}

	@Override
	public boolean setExecutedById(String adviceID, String eXECUTOU) {
		return service.setExecutedByID(Integer.parseInt(adviceID), Integer.parseInt(eXECUTOU));
	}

	@Override
	public List<DocAdvice> getAll() {
		return service.getAll();
	}

	@Override
	public List<DocAdvice> getAllNew() {
		return service.getAllNew();
	}

	@Override
	public DocAdvice getByAdviceID(String adviceID) {
		return service.getByAdviceID(Integer.parseInt(adviceID));
	}

	@Override
	public List<DocAdvice> getAdviceListByPatientID(String patientID) {
		return service.getAdviceListByPatientID(Integer.parseInt(patientID));
	}

	@Override
	public List<DocAdvice> getNewAdvoiceListByPatientID(String patientID) {
		return service.getNewAdvoiceListByPatientID(Integer.parseInt(patientID));
	}

	@Override
	public List<DocAdvice> getListByNurseID(String nurseID) {
		return service.getListByNurseID(Integer.parseInt(nurseID));
	}

	@Override
	public List<DocAdvice> getNewAdvoiceListByNurseID(String nurseID) {
		return service.getNewAdvoiceListByNurseID(Integer.parseInt(nurseID));
	}

	@Override
	public boolean delAdviceByPatientId(String patient_id) {
		return service.delAdviceByPatientID(Integer.parseInt(patient_id));
	}

	@Override
	public boolean deleteAdvice(String adviceID) {
		return service.deleteAdvice(Integer.parseInt(adviceID));
	}

}
