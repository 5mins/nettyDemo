package com.naaisi.nursesite.eat.dao;

import java.util.List;

import com.naaisi.nursesite.eat.domain.Eat;

public interface EatDao {

	boolean save(Eat eat);

	boolean update(Eat eat);

	List<Eat> findAll();

	//通过状态查找所有的injection单
	List<Eat> findAllByState(int state);

	Eat findByID(int ID);
	//

	List<Eat> findByPatientID(int patientID);

	List<Eat> findEatByPatientIDAndState(int patientID, int state);

	boolean delete(Eat eat);

}