package com.naaisi.nursesite.docadvice.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.naaisi.nursesite.docadvice.dao.DocAdviceDao;
import com.naaisi.nursesite.docadvice.dao.DocAdviceDaoImpl;
import com.naaisi.nursesite.docadvice.domain.DocAdvice;
import com.naaisi.nursesite.uitl.DateTools;

//@Service("PatientService")
/**
 * @author lizihao
 *
 */

public class DocAdviceServiceImpl implements  DocAdviceService {

	private DocAdviceDao dao;

	public DocAdviceServiceImpl() {
		super();
		DocAdviceDaoImpl dao = new DocAdviceDaoImpl();
		this.dao = dao;
	}

	@Override
	public void setDocAdviceDao(DocAdviceDao dao) {
		this.dao = dao;
	}

	/**
	 * 添加一张医嘱 （管理端使用）
	 * 
	 * @param pATIENT_ID   病人ID
	 * @param eXECUTOU     指定执行护士ID
	 * @param aDVICE       医嘱内容
	 * @param pRE_EXE_TIME 预计执行时间 （格式为Timestamp）
	 * @return
	 */
	@Override
	public boolean addAdvice(int pATIENT_ID, int eXECUTOU, String aDVICE, Timestamp pRE_EXE_TIME) {
		DocAdvice docAdvice = new DocAdvice();
		docAdvice.setPATIENT_ID(pATIENT_ID);
		docAdvice.setADVICE(aDVICE);
		docAdvice.setPRE_EXE_TIME(pRE_EXE_TIME);
		Timestamp dateTimeNow = DateTools.getNowDateTime();
		docAdvice.setPUBLISH_TIME(dateTimeNow);
		return dao.save(docAdvice);
		

	}

	/**
	 * 通过ID 将状态标记为已执行,记录执行护士，并记录当前系统时间为执行时间
	 * 
	 * @param adviceID 医嘱ID
	 * @param eXECUTOU 执行护士ID
	 * @return
	 */
	@Override
	public boolean setExecutedByID(int adviceID, int eXECUTOU) {
		DocAdvice domain = dao.findByID(adviceID);
		Timestamp dateTimeNow = DateTools.getNowDateTime();
		domain.setEXE_TIME(dateTimeNow);
		domain.setSTATE(1);
		domain.setEXECUTOU(eXECUTOU);
		return dao.update(domain);

	}

	/**
	 * 获取所有的医嘱
	 * 
	 * 
	 * @return List<DocAdvice>
	 */
	@Override
	public List<DocAdvice> getAll() {

		return dao.findAll();
	}

	/**
	 * 获取所有未执行的医嘱
	 * 
	 * 
	 * @return List<DocAdvice>
	 */
	@Override
	public List<DocAdvice> getAllNew() {
		return dao.findAllByState(0);
	}

	/**
	 * 获取一张医嘱
	 * 
	 * @param adviceID
	 * @return DocAdvice
	 */
	@Override
	public DocAdvice getByAdviceID(int adviceID) {

		return dao.findByID(adviceID);
	}

	/**
	 * 获取病人的所有医嘱
	 * 
	 * @param patientID
	 * @return List<DocAdvice>
	 */
	@Override
	public List<DocAdvice> getAdviceListByPatientID(int patientID) {
		return dao.findByPatientID(patientID);
	}

	/**
	 * 获取病人的所有未执行医嘱
	 * 
	 * @param patientID
	 * @return List<DocAdvice>
	 */
	@Override
	public List<DocAdvice> getNewAdvoiceListByPatientID(int patientID) {
		return dao.findDocAdviceByPatientIDAndState(patientID, 0);
	}

	/**
	 * 获取护士的所有医嘱
	 * 
	 * @param nurseID
	 * @return List<DocAdvice>
	 */
	@Override
	public List<DocAdvice> getListByNurseID(int nurseID) {
		return dao.findByNurseID(nurseID);
	}

	/**
	 * 查找护士的所有未执行医嘱
	 * 
	 * @param nurseID
	 * @return List<DocAdvice>
	 */
	@Override
	public List<DocAdvice> getNewAdvoiceListByNurseID(int nurseID) {
		return dao.findAdvoiceByNurseIDAndState(nurseID, 0);
	}

	/**
	 * 删除改病人所有医嘱 （管理端使用）
	 * 
	 * @param patient_id
	 * @return 
	 */
	@Override
	public boolean delAdviceByPatientID(int patient_id) {

		List<DocAdvice> findByPatientID = dao.findByPatientID(patient_id);
		for (DocAdvice docAdvice : findByPatientID) {
			dao.delete(docAdvice);
		}
		return true;
	}

	/**
	 * 删除一张医嘱 （管理端使用）
	 * 
	 * @param adviceID
	 * @return 
	 */
	@Override
	public boolean deleteAdvice(int adviceID) {
		DocAdvice docAdvice = dao.findByID(adviceID);
		return dao.delete(docAdvice);
	}

}