package com.naaisi.nursesite.injection.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.naaisi.nursesite.injection.dao.InjectionDao;
import com.naaisi.nursesite.injection.dao.InjectionDaoImpl;
import com.naaisi.nursesite.injection.domain.Injection;
import com.naaisi.nursesite.uitl.DateTools;

/**
 * @author lizihao
 *
 */

public class InjectionServiceImpl implements InjectionService {

	private InjectionDao dao;

	public InjectionServiceImpl() {
		super();
		InjectionDao dao = new InjectionDaoImpl();
		this.dao = dao;
	}

	@Override
	public void setInjectionDao(InjectionDao dao) {
		this.dao = dao;
	}

	/**
	 * 添加存储一个注射药物记录
	 * 
	 * @param pATIENT_ID
	 * @param dRUG         注射药物名称
	 * @param fREQUENCY    频次
	 * @param pRE_EXE_TIME 预计执行时间
	 * @return
	 */
	@Override
	public boolean addInjection(int pATIENT_ID, String dRUG, String fREQUENCY, Timestamp pRE_EXE_TIME) {
		Injection domain = new Injection();
		domain.setPATIENT_ID(pATIENT_ID);
		domain.setDRUG(dRUG);
		domain.setFREQUENCY(fREQUENCY);
		domain.setPRE_EXE_TIME(pRE_EXE_TIME);
		Timestamp dateTimeNow = DateTools.getNowDateTime();
		domain.setPUBLISH_TIME(dateTimeNow);
		
		domain.setSTATE(0);
		return dao.save(domain);
	}

	/**
	 * 通过注射药物ID 将状态标记为已执行,并记录当前系统时间为执行时间
	 * 
	 * @param id 注射药物ID
	 * @return
	 */
	@Override
	public boolean setExecutedByID(int id) {
		Injection domain = dao.findByID(id);
		Timestamp dateTimeNow = DateTools.getNowDateTime();
		domain.setEXE_TIME(dateTimeNow);
		domain.setSTATE(1);// 0未执行，1已执行
		return dao.update(domain);

	}

	/**
	 * 获取所有注射药物单
	 * 
	 * @return List<Injection>
	 */
	@Override
	public List<Injection> getAll() {
		return dao.findAll();

	}

	/**
	 * 获取所有未执行的注射药物单
	 * 
	 * @return List<Injection>
	 */
	@Override
	public List<Injection> getAllNotImplemented() {
		return dao.findAllByState(0);

	};

	/**
	 * 通过EatID获取一个注射药物记录
	 * 
	 * @param ID
	 * @return Injection
	 */
	@Override
	public Injection getByID(int id) {

		return dao.findByID(id);

	};

	/**
	 * 通过EatID获取该病人所有的注射药物记录
	 * 
	 * @param InjectionID
	 * @return List<Injection>
	 */
	@Override
	public List<Injection> getListByPatientID(int patientID) {

		return dao.findByPatientID(patientID);

	};

	/**
	 * 获取该病人所有未执行的注射药物记录
	 * 
	 * @param patientID
	 * @return List<Injection>
	 */
	@Override
	public List<Injection> getNotImplementedByPatientID(int patientID) {

		return dao.findInjectionByPatientIDAndState(patientID, 0);

	};

}