package com.naaisi.nursesite.bunk.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.naaisi.nursesite.bunk.dao.BunkDao;
import com.naaisi.nursesite.bunk.dao.BunkDaoImpl;
import com.naaisi.nursesite.bunk.domain.Bunk;

/**
 * @author lizihao
 *
 */

public class BunkServiceImpl implements BunkService {

	private BunkDao dao;

	public BunkServiceImpl() {
		super();
		BunkDao dao = new BunkDaoImpl();
		this.dao = dao;
	}

	
	
	/**
	 * // 新增一张床位
	 * 
	 * @param ward 所属病区
	 * @return
	 */
	@Override
	public boolean addBunk(String ward) {
		Bunk domain = new Bunk();
		domain.setWARD(ward);
		return dao.save(domain);
		
	}
	
	/**
	 * // 绑定床位给病人。
	 * 
	 * @param domain
	 * @return
	 */

	@Override
	public boolean bindBunkToPatient(int patientID,int bunkID) {
		
		Bunk bunk = dao.findByID(bunkID);
		bunk.setPATIENT_ID(patientID);
		bunk.setSTATE(1);
		return dao.update(bunk);
		
	}

	/**
	 * // 查找所有床位
	 * 
	 * @return
	 */

	@Override
	public List<Bunk> getAll() {
		return dao.findAll();

	}

	
	
	/**
	 * // 查找所有空闲的床位
	 * 
	 * @return
	 */

	@Override
	public List<Bunk> getAllNotImplemented() {
		return dao.findAllByState(0);

	};

	/**
	 * //通过ID获取一个床位记录
	 * 
	 * @param ID
	 * @return
	 */
	@Override
	public Bunk getByID(int id) {

		return dao.findByID(id);

	};

	
	
	/**
	 * //获取一张空闲的床位记录
	 * 
	 * @param
	 * @return
	 */
	@Override
	public Bunk getNotUseBunk() {

		List<Bunk> findLastBunkByState = dao.findLastBunkByState(0, 1);
		if (findLastBunkByState != null) {// ???
			return findLastBunkByState.get(0);

		} else {

			return null;
		}

	};

	
	
	/**
	 * //通过该病人所有的床位记录
	 * 
	 * @param patientID
	 * @return List<Bunk>
	 */
	
	@Override
	public List<Bunk> getListByPatientID(int patientID) {

		return dao.findByPatientID(patientID);

	};

	/**
	 * //将床位设定为已使用
	 * 
	 * @param ID
	 * 
	 * @return
	 */
	
	@Override
	public boolean setBunkUsed(int id) {
		
		Bunk bunk = dao.findByID(id);
		bunk.setSTATE(1);
		return dao.update(bunk);

	};
	
	/**
	 * //将床位设定为未使用
	 * 
	 * @param ID
	 * 
	 * @return
	 */
	@Override
	public boolean setBunkNotUsed(int id) {
		
		Bunk bunk = dao.findByID(id);
		bunk.setSTATE(0);
		return dao.update(bunk);

	};

	public static void main(String[] args) {

	}

}