package com.naaisi.nursesite.docadvice.service;

import java.sql.Timestamp;
import java.util.List;

import com.naaisi.nursesite.docadvice.dao.DocAdviceDao;
import com.naaisi.nursesite.docadvice.domain.DocAdvice;

public interface DocAdviceService {
	
	void setDocAdviceDao(DocAdviceDao dao);
	

	/**
	 * 添加一张医嘱 （管理端使用）
	 * 
	 * @param pATIENT_ID   病人ID
	 * @param eXECUTOU     指定执行护士ID
	 * @param aDVICE       医嘱内容
	 * @param pRE_EXE_TIME 预计执行时间 （格式为Timestamp）
	 * @return
	 */
	boolean addAdvice(int pATIENT_ID, int eXECUTOU, String aDVICE, Timestamp pRE_EXE_TIME);

	/**
	 * 通过ID 将状态标记为已执行,记录执行护士，并记录当前系统时间为执行时间
	 * 
	 * @param adviceID 医嘱ID
	 * @param eXECUTOU 执行护士ID
	 * @return
	 */
	boolean setExecutedByID(int adviceID, int eXECUTOU);

	/**
	 * 获取所有的医嘱
	 * 
	 * 
	 * @return List<DocAdvice>
	 */
	List<DocAdvice> getAll();

	/**
	 * 获取所有未执行的医嘱
	 * 
	 * 
	 * @return List<DocAdvice>
	 */
	List<DocAdvice> getAllNew();

	/**
	 * 获取一张医嘱
	 * 
	 * @param adviceID
	 * @return DocAdvice
	 */
	DocAdvice getByAdviceID(int adviceID);

	/**
	 * 获取病人的所有医嘱
	 * 
	 * @param patientID
	 * @return List<DocAdvice>
	 */
	List<DocAdvice> getAdviceListByPatientID(int patientID);

	/**
	 * 获取病人的所有未执行医嘱
	 * 
	 * @param patientID
	 * @return List<DocAdvice>
	 */
	List<DocAdvice> getNewAdvoiceListByPatientID(int patientID);

	/**
	 * 获取护士的所有医嘱
	 * 
	 * @param nurseID
	 * @return List<DocAdvice>
	 */
	List<DocAdvice> getListByNurseID(int nurseID);

	/**
	 * 查找护士的所有未执行医嘱
	 * 
	 * @param nurseID
	 * @return List<DocAdvice>
	 */
	List<DocAdvice> getNewAdvoiceListByNurseID(int nurseID);

	/**
	 * 删除改病人所有医嘱 （管理端使用）
	 * 
	 * @param patient_id
	 * @return 
	 */
	boolean delAdviceByPatientID(int patient_id);

	/**
	 * 删除一张医嘱 （管理端使用）
	 * 
	 * @param adviceID
	 * @return 
	 */
	boolean deleteAdvice(int adviceID);

}