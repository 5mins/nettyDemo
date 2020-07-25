package com.naaisi.nursesite.docadvice.dao;

import java.util.List;

import com.naaisi.nursesite.docadvice.domain.DocAdvice;

public interface DocAdviceDao {
	
	boolean save(DocAdvice docAdvice);//无需实现

	boolean update(DocAdvice docAdvice) ;
	
	List<DocAdvice> findAll() ;//查找所有的医嘱，管理端
	
	List<DocAdvice> findAllByState(int state);

	DocAdvice findByID(int adviceID);//
	
	List<DocAdvice> findByPatientID(int patientID);//app
	
	List<DocAdvice> findDocAdviceByPatientIDAndState(int patientID,int state);
	
	List<DocAdvice> findByNurseID(int nurseID);//通过护士ID 查找护士负责的所有的医嘱。
	
	List<DocAdvice> findAdvoiceByNurseIDAndState(int nurseID,int state);
	
	boolean delete(DocAdvice docAdvice);//


	
	
}
