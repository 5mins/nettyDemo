package com.naaisi.nursesite.password.dao;

import java.util.List;

import com.naaisi.nursesite.password.domain.PassWord;

public interface PassWordDao {

	boolean save(PassWord domain);

	boolean update(PassWord domain);

	List<PassWord> findAll();

	PassWord findByID(int id);
	
	PassWord findByNurseID(int nurseID);

	boolean delete(PassWord domain);
	//
	//	public static void main(String[] arg) {
	//
	//
	//	}

}