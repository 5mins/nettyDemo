package com.naaisi.nursesite.skintest.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.naaisi.nursesite.skintest.dao.SkinTestDao;
import com.naaisi.nursesite.skintest.dao.SkinTestDaoImpl;
import com.naaisi.nursesite.skintest.domain.SkinTest;
import com.naaisi.nursesite.uitl.DateTools;

/**
 * @author lizihao
 *
 */

public class SkinTestServiceImpl implements SkinTestService {

	private SkinTestDao dao;

	public SkinTestServiceImpl() {
		super();
		SkinTestDao dao = new SkinTestDaoImpl();
		this.dao = dao;
	}

	@Override
	public void setSkinTestDao(SkinTestDao dao) {
		this.dao = dao;
	}

	/**
	 * 添加存储一个皮试记录
	 * 
	 * @param
	 * @return
	 */

	@Override
	public boolean addSkinTest(int pATIENT_ID, String sKINTEST, Timestamp pRE_EXE_TIME) {
		SkinTest domain = new SkinTest();
		domain.setPATIENT_ID(pATIENT_ID);
		domain.setSKINTEST(sKINTEST);
		domain.setPRE_EXE_TIME(pRE_EXE_TIME);
		Timestamp dateTimeNow = DateTools.getNowDateTime();
		domain.setPUBLISH_TIME(dateTimeNow);
		domain.setSTATE(0);
		return dao.save(domain);
	}

	/**
	 * 通过皮试ID 将状态标记为已执行,并记录当前系统时间为执行时间
	 * 
	 * @param id 皮试ID
	 * @return
	 */

	@Override
	public boolean setExecutedById(int id) {
		SkinTest domain = dao.findByID(id);
		Timestamp dateTimeNow = DateTools.getNowDateTime();
		domain.setEXE_TIME(dateTimeNow);
		domain.setSTATE(1);// 0未执行，1已执行
		return dao.update(domain);

	}

	/**
	 * 获取所有皮试单
	 * 
	 * @return List<SkinTest>
	 */

	@Override
	public List<SkinTest> getAll() {
		return dao.findAll();

	}

	/**
	 * 获取所有未执行的SkinTest单
	 * 
	 * @return List<SkinTest>
	 */

	@Override
	public List<SkinTest> getAllNotImplemented() {
		return dao.findAllByState(0);

	};

	/**
	 * 通过SkinTestID获取一个SkinTest记录
	 * 
	 * @param ID
	 * @return SkinTest
	 */
	@Override
	public SkinTest getByID(int id) {

		return dao.findByID(id);

	};

	/**
	 * 通过SkinTestID获取该病人所有的SkinTest记录
	 * 
	 * @param SkinTestID
	 * @return List<SkinTest>
	 */
	@Override
	public List<SkinTest> getListByPatientID(int patientID) {

		return dao.findByPatientID(patientID);

	};

	/**
	 * 获取该病人所有未执行的SkinTest记录
	 * 
	 * @param patientID
	 * @return List<SkinTest>
	 */

	@Override
	public List<SkinTest> getNotImplementedByPatientID(int patientID) {

		return dao.findSkinTestByPatientIDAndState(patientID, 0);

	};

}