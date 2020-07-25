package com.naaisi.nursesite.nurse.dao;

import java.util.List;

import com.naaisi.nursesite.nurse.domain.Nurse;

public interface NurseDao {

	String save(Nurse domain);

	boolean update(Nurse domain);

	List<Nurse> findAll();

	Nurse findByID(int id);

	List<Nurse> findByName(String name);
	
	Nurse findByEmail(String email);

	//boolean deleteByID(int id);

	boolean delete(Nurse domain);

}