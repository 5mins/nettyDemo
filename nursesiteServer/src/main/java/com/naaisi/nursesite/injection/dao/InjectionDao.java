package com.naaisi.nursesite.injection.dao;

import java.util.List;

import com.naaisi.nursesite.injection.domain.Injection;

public interface InjectionDao {

	boolean save(Injection injection);

	boolean update(Injection injection);

	List<Injection> findAll();

	public List<Injection> findAllByState(int state);

	Injection findByID(int ID);

	List<Injection> findByPatientID(int patientID);

	public List<Injection> findInjectionByPatientIDAndState(int patientID,int state);


	boolean delete(Injection injection);

}