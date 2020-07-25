package com.naaisi.nursesite.appservicesApi;

import java.util.List;

import com.naaisi.nursesite.docadvice.domain.DocAdvice;

/**
 * @author lizihao
 *
 */
public interface IDocAdvice {

	/**
	 * 添加一张医嘱 （管理端使用）
	 * 
	 * @param pATIENT_ID   病人ID
	 * @param eXECUTOU     指定执行护士ID
	 * @param aDVICE       医嘱内容
	 * @param pRE_EXE_TIME 预计执行时间 （格式为Timestamp）
	 * @return
	 */
	boolean addAdvice(String pATIENT_ID, String eXECUTOU, String aDVICE, String pRE_EXE_TIME);

	/**
	 * 通过ID 将状态标记为已执行,记录执行护士，并记录当前系统时间为执行时间
	 * 
	 * @param adviceID 医嘱ID
	 * @param eXECUTOU 执行护士ID
	 * @return
	 */
	boolean setExecutedById(String adviceID, String eXECUTOU);

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
	DocAdvice getByAdviceID(String adviceID);

	/**
	 * 获取病人的所有医嘱
	 * 
	 * @param patientID
	 * @return List<DocAdvice>
	 */
	List<DocAdvice> getAdviceListByPatientID(String patientID);

	/**
	 * 获取病人的所有未执行医嘱
	 * 
	 * @param patientID
	 * @return List<DocAdvice>
	 */
	List<DocAdvice> getNewAdvoiceListByPatientID(String patientID);

	/**
	 * 获取护士的所有医嘱
	 * 
	 * @param nurseID
	 * @return List<DocAdvice>
	 */
	List<DocAdvice> getListByNurseID(String nurseID);

	/**
	 * 查找护士的所有未执行医嘱
	 * 
	 * @param nurseID
	 * @return List<DocAdvice>
	 */
	List<DocAdvice> getNewAdvoiceListByNurseID(String nurseID);

	/**
	 * 删除改病人所有医嘱 （管理端使用）
	 * 
	 * @param patient_id
	 * @return 
	 */
	boolean delAdviceByPatientId(String patient_id);

	/**
	 * 删除一张医嘱 （管理端使用）
	 * 
	 * @param adviceID
	 * @return 
	 */
	boolean deleteAdvice(String adviceID);

}