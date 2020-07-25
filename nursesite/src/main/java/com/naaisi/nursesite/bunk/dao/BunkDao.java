package com.naaisi.nursesite.bunk.dao;

import java.util.List;

import com.naaisi.nursesite.bunk.domain.Bunk;

public interface BunkDao {

	boolean save(Bunk domain);

	boolean update(Bunk domain);
	
	List<Bunk> findByPatientID(int pATIENT_ID);

	List<Bunk> findAll();

	List<Bunk> findAllByState(int state);

	List<Bunk> findLastBunkByState(int state, int num);

	Bunk findByID(int id);

	//boolean deleteById(int id);
	//	
	//	

	boolean delete(Bunk domain);

}