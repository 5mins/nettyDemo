package com.naaisi.nursesite.doctor.service;

import java.util.List;

import com.naaisi.nursesite.doctor.dao.DoctorDao;
import com.naaisi.nursesite.doctor.domain.Doctor;

public interface DoctorService {

	void setDoctorDao(DoctorDao dao);

	/**
	 * 获取所有医生
	 * 
	 * @return List<Doctor>
	 */

	List<Doctor> getAll();

	/**
	 * 获取一个医生
	 * 
	 * @param doctor_id
	 * @return Doctor
	 */

	Doctor getByID(int doctor_id);

	/**
	 * 通过姓名获取医生列表
	 * 
	 * @param name
	 * @return List<Doctor>
	 */

	List<Doctor> getByName(String name);

}