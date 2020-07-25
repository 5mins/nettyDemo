package com.naaisi.nursesite.eat.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.naaisi.nursesite.eat.dao.EatDao;
import com.naaisi.nursesite.eat.dao.EatDaoImpl;
import com.naaisi.nursesite.eat.domain.Eat;
import com.naaisi.nursesite.uitl.DateTools;



/**
 * @author lizihao
 *
 */

public class EatServiceImpl implements EatService {

	private EatDao dao;

	public EatServiceImpl() {
		super();
		EatDao dao = new EatDaoImpl();
		this.dao = dao;
	}

	
	@Override
	public void setEatDao(EatDao dao) {
		this.dao = dao;
	}



	/**添加存储一个口服药物记录
	 * @param pATIENT_ID
	 * @param dRUG    			口服药名称
	 * @param fREQUENCY			频次
	 * @param pRE_EXE_TIME     预计执行时间
	 * @return
	 */
	@Override
	public boolean addEat(int pATIENT_ID, String dRUG, String fREQUENCY,Timestamp pRE_EXE_TIME) {
		Eat domain = new Eat();
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
	 * 通过口服药物ID 将状态标记为已执行,并记录当前系统时间为执行时间
	 * 
	 * @param id 口服药物ID
	 * @return
	 */
	@Override
	public boolean setExecutedByID(int id) {
		Eat domain = dao.findByID(id);
		Timestamp dateTimeNow = DateTools.getNowDateTime();
		domain.setEXE_TIME(dateTimeNow);
		domain.setSTATE(1);// 0未执行，1已执行
		return dao.update(domain);

	}

	/**
	 * 获取所有口服药物单
	 * 
	 * @return List<Eat>
	 */
	@Override
	public List<Eat> getAll() {
		return dao.findAll();

	}

	/**
	 * 获取所有未执行的Eat单
	 * 
	 * @return List<Eat>
	 */

	@Override
	public List<Eat> getAllNotImplemented() {
		return dao.findAllByState(0);

	};

	/**
	 * 通过EatID获取一个Eat记录
	 * 
	 * @param ID
	 * @return Eat
	 */
	@Override
	public Eat getByID(int id) {

		return dao.findByID(id);

	};

	/**
	 * 通过EatID获取该病人所有的Eat记录
	 * 
	 * @param EatID
	 * @return List<Eat>
	 */
	
	@Override
	public List<Eat> getListByPatientID(int patientID) {

		return dao.findByPatientID(patientID);

	};

	/**
	 * 获取该病人所有未执行的Eat记录
	 * 
	 * @param patientID
	 * @return List<Eat>
	 */

	
	@Override
	public List<Eat> getNotImplementedByPatientID(int patientID) {

		return dao.findEatByPatientIDAndState(patientID, 0);

	};

}