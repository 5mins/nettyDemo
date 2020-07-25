package com.naaisi.nursesite.skintest.dao;

import java.util.List;

import com.naaisi.nursesite.skintest.domain.SkinTest;

public interface SkinTestDao {

	boolean save(SkinTest domain);

	boolean update(SkinTest domain);

	List<SkinTest> findAll();
	//通过状态查找所有的injection单

	List<SkinTest> findAllByState(int state);

	SkinTest findByID(int ID);
	//

	List<SkinTest> findByPatientID(int patientID);

	List<SkinTest> findSkinTestByPatientIDAndState(int patientID, int state);

	boolean delete(SkinTest domain);

}