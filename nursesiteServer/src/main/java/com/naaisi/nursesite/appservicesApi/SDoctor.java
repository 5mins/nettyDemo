package com.naaisi.nursesite.appservicesApi;

import java.util.List;

import com.naaisi.nursesite.doctor.domain.Doctor;
import com.naaisi.nursesite.doctor.service.DoctorService;
import com.naaisi.nursesite.doctor.service.DoctorServiceImpl;

/**
 * @author lizihao
 *
 */
public class SDoctor implements IDoctor {

	private DoctorService service;

	public SDoctor() {

		DoctorService service = new DoctorServiceImpl();
		this.service = service;
	}

	@Override
	public List<Doctor> getAll() {
		return service.getAll();
	}

	@Override
	public Doctor getById(String doctor_id) {
		return service.getByID(Integer.parseInt(doctor_id));
	}

	@Override
	public List<Doctor> getByName(String name) {
		return service.getByName(name);

	}

}
