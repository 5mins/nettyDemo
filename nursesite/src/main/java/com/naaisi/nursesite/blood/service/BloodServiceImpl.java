package com.naaisi.nursesite.blood.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.naaisi.nursesite.blood.dao.BloodDao;
import com.naaisi.nursesite.blood.dao.BloodDaoImpl;
import com.naaisi.nursesite.blood.domain.Blood;
import com.naaisi.nursesite.uitl.DateTools;

/**
 * @author lizihao
 *
 */
//@Service("PatientService")
public class BloodServiceImpl implements BloodService {

	private BloodDao dao;

	public BloodServiceImpl() {
		super();
		BloodDao dao = new BloodDaoImpl();
		this.dao = dao;
	}

	@Override
	public void setBloodDao(BloodDao dao) {
		this.dao = dao;
	}

	/**
	 * 添加存储一个blood记录
	 * 
	 * @param
	 * @return
	 */

	@Override
	public boolean addBlood(int pATIENT_ID, String bLOOD, Timestamp pRE_EXE_TIME) {
		Blood domain = new Blood();
		domain.setPATIENT_ID(pATIENT_ID);
		domain.setBLOOD(bLOOD);
		domain.setPRE_EXE_TIME(pRE_EXE_TIME);
		Timestamp dateTimeNow = DateTools.getNowDateTime();
		domain.setPUBLISH_TIME(dateTimeNow);
		domain.setSTATE(0);
		return dao.save(domain);
	}

	/**
	 * 通过采血单ID 将状态标记为已执行,并记录当前系统时间为执行时间
	 * 
	 * @param id 采血单ID
	 * @return
	 */

	@Override
	public boolean setExecutedByID(int id) {
		Blood blood = dao.findByID(id);
		Timestamp dateTimeNow = DateTools.getNowDateTime();
		blood.setEXE_TIME(dateTimeNow);
		blood.setSTATE(1);// 0未执行，1已执行
		return dao.update(blood);

	}

	/**
	 * 获取所有采血单
	 * 
	 * @return List<Blood>
	 */

	@Override
	public List<Blood> getAll() {
		return dao.findAll();

	}

	/**
	 * 获取所有未执行的采血单
	 * 
	 * @return List<Blood>
	 */

	@Override
	public List<Blood> getAllNotImplemented() {
		return dao.findAllByState(0);

	};

	/**
	 * 通过bloodID获取一个blood记录
	 * 
	 * @param ID
	 * @return Blood
	 */

	@Override
	public Blood getByID(int id) {

		return dao.findByID(id);

	};

	/**
	 * 通过bloodID获取该病人所有的blood记录
	 * 
	 * @param patientID
	 * @return List<Blood>
	 */

	@Override
	public List<Blood> getBloodListByPatientID(int patientID) {

		return dao.findByPatientID(patientID);

	};

	/**
	 * 获取该病人所有未执行的blood记录
	 * 
	 * @param patientID
	 * @return List<Blood>
	 */

	@Override
	public List<Blood> getNotImplementedByPatientID(int patientID) {

		return dao.findBloodByPatientIDAndState(patientID, 0);

	};

}