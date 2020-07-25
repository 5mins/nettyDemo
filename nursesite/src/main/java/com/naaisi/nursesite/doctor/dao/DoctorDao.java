package com.naaisi.nursesite.doctor.dao;

import java.util.List;

import com.naaisi.nursesite.doctor.domain.Doctor;

public interface DoctorDao {

	boolean save(Doctor domain);

	boolean update(Doctor domain);

	List<Doctor> findAll();

	Doctor findByID(int id);

	List<Doctor> findByName(String name);

	//boolean deleteByID(int id);

	boolean delete(Doctor domain);

}