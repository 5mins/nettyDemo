package com.naaisi.nursesite.blood.dao;

import java.util.List;

import com.naaisi.nursesite.blood.domain.Blood;

public interface BloodDao {

	boolean save(Blood domain);

	boolean update(Blood domain);

	List<Blood> findAll();
	//通过状态查找所有的injection单

	List<Blood> findAllByState(int state);

	Blood findByID(int ID);
	//

	List<Blood> findByPatientID(int patientID);

	List<Blood> findBloodByPatientIDAndState(int patientID, int state);

	boolean delete(Blood domain);

}