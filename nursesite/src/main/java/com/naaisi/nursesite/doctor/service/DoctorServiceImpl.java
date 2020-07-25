package com.naaisi.nursesite.doctor.service;

import java.util.List;

import com.naaisi.nursesite.doctor.dao.DoctorDao;
import com.naaisi.nursesite.doctor.dao.DoctorDaoImpl;
import com.naaisi.nursesite.doctor.domain.Doctor;

//@Service("PatientService")
/**
 * @author lizihao
 *
 */
public class DoctorServiceImpl implements DoctorService {

	private DoctorDao dao;

	public DoctorServiceImpl() {
		super();
		DoctorDao dao = new DoctorDaoImpl();
		this.dao = dao;
	}

	@Override
	public void setDoctorDao(DoctorDao dao) {
		this.dao = dao;
	}

	/**
	 * 获取所有医生
	 * 
	 * @return List<Doctor>
	 */

	@Override
	public List<Doctor> getAll() {
		return dao.findAll();

	}

	/**
	 * 获取一个医生
	 * 
	 * @param doctor_id
	 * @return Doctor
	 */

	@Override
	public Doctor getByID(int doctor_id) {
		return dao.findByID(doctor_id);
	}

	/**
	 * 通过姓名获取医生列表
	 * 
	 * @param name
	 * @return List<Doctor>
	 */

	@Override
	public List<Doctor> getByName(String name) {
		return dao.findByName(name);
	}

}