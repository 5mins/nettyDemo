package com.naaisi.nursesite.appservicesApi;

import java.util.List;

import com.naaisi.nursesite.bunk.domain.Bunk;
import com.naaisi.nursesite.bunk.service.BunkService;
import com.naaisi.nursesite.bunk.service.BunkServiceImpl;

/**
 * @author lizihao
 *
 */
public class SBunk implements IBunk {

	private BunkService service;

	public SBunk() {

		BunkService service = new BunkServiceImpl();
		this.service = service;
	}

	@Override
	public boolean addBunk(String ward) {
		return service.addBunk(ward);
	}

	@Override
	public boolean bindBunkToPatient(String bunkID,String patientID) {
		

		return service.bindBunkToPatient(Integer.parseInt(patientID), Integer.parseInt(bunkID));

	}

	@Override
	public List<Bunk> getAll() {
		return service.getAll();
	}

	@Override
	public List<Bunk> getAllNotImplemented() {
		return service.getAllNotImplemented();
	}

	@Override
	public Bunk getByID(String id) {
		return service.getByID(Integer.parseInt(id));
	}

	@Override
	public Bunk getNotUseBunk() {
		return service.getNotUseBunk();
	}

	@Override
	public List<Bunk> getListByPatientID(String patientID) {
		return service.getListByPatientID(Integer.parseInt(patientID));
	}

	@Override
	public boolean setBunkUsed(String id) {
		return service.setBunkUsed(Integer.parseInt(id));
	}

	@Override
	public boolean setBunkNotUsed(String id) {
		return service.setBunkNotUsed(Integer.parseInt(id));
	}

}
