package com.naaisi.nursesite.memo.dao;

import java.util.List;

import com.naaisi.nursesite.memo.domain.Memo;

public interface MemoDao {

	boolean save(Memo domain);
	
	int save1(Memo domain);

	boolean update(Memo domain);

	List<Memo> findAll();
	
	List<Memo> findAllByNurseID(int nurseId);

	List<Memo> findAllByState(int nurseId, int state);

	List<Memo> findLastMemoByState(int nurseId,int state, int num);

	Memo findByID(int id);

	//boolean deleteById(int id);
	//	
	//	

	boolean delete(Memo domain);

}