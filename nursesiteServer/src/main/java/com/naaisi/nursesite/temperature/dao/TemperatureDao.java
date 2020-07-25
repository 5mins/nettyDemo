package com.naaisi.nursesite.temperature.dao;

import java.util.List;

import com.naaisi.nursesite.temperature.domain.Temperature;

public interface TemperatureDao {

	boolean save(Temperature domain);
	
	int save1(Temperature domain);

	boolean update(Temperature domain);

	List<Temperature> findAll();

	List<Temperature> findAllByPatientID(int patientId);

	//查找病人ID 最近num条数据
	List<Temperature> findLastByPatientID(int patientId, int num);

	Temperature findByID(int id);

	//boolean deleteById(int id);
	//	
	//	

	boolean delete(Temperature domain);
	
	boolean deleteAllTemperatureByPatientID(int pATIENT_ID);

}