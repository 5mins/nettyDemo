package com.naaisi.nursesite.temperature.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.naaisi.nursesite.temperature.dao.TemperatureDao;
import com.naaisi.nursesite.temperature.dao.TemperatureDaoImpl;
import com.naaisi.nursesite.temperature.domain.Temperature;

/**
 * @author lizihao
 *
 */

public class TemperatureServiceImpl implements TemperatureService {

	private TemperatureDao dao;

	public TemperatureServiceImpl() {
		super();
		TemperatureDao dao = new TemperatureDaoImpl();
		this.dao = dao;
	}

	/**
	 * 添加一条体温记录
	 * 
	 * @param tEMPERATURE 温度记录
	 * @param pATIENT_ID  病人ID
	 * @param cREATED_BY  创建护士ID
	 * @return
	 */
	@Override
	public boolean addTemperature(double tEMPERATURE, int pATIENT_ID, int cREATED_BY) {
		Temperature domain = new Temperature();
		domain.setTEMPERATURE(tEMPERATURE);
		domain.setPATIENT_ID(pATIENT_ID);
		// domain.setCREATED_TIME(cREATED_TIME);
		domain.setCREATED_BY(cREATED_BY);
		Timestamp timenow = new Timestamp(new Date().getTime());
		domain.setCREATED_TIME(timenow);// 看客户端支不支持设定时间，现在默认是服务端添加
		return dao.save(domain);

	}
	
	/**
	 * 添加一条体温记录
	 * 
	 * @param tEMPERATURE 温度记录
	 * @param pATIENT_ID  病人ID
	 * @param cREATED_BY  创建护士ID
	 * @return TemperatureID 正常返回ID，失败返回-1
	 */
	@Override
	public int addTemperature1(double tEMPERATURE, int pATIENT_ID, int cREATED_BY) {
		Temperature domain = new Temperature();
		domain.setTEMPERATURE(tEMPERATURE);
		domain.setPATIENT_ID(pATIENT_ID);
		// domain.setCREATED_TIME(cREATED_TIME);
		domain.setCREATED_BY(cREATED_BY);
		Timestamp timenow = new Timestamp(new Date().getTime());
		domain.setCREATED_TIME(timenow);// 看客户端支不支持设定时间，现在默认是服务端添加
		return dao.save1(domain);

	}

	/**
	 * 将体温记录修改为无效。1有效，0无效
	 * 
	 * @param id Temperature id
	 * @return
	 */
	@Override
	public boolean setTemperatureInvalid(int id) {

		Temperature domain = dao.findByID(id);
		domain.setSTATE(0);
		return dao.update(domain);
	}

	/**
	 * 将体温记录修改为有效。1有效，0无效
	 * 
	 * @param id Temperature id
	 * @return
	 */
	@Override
	public boolean setTemperatureValid(int id) {

		Temperature domain = dao.findByID(id);
		domain.setSTATE(1);
		return dao.update(domain);
	}

	/**
	 * 获取病人所有体温记录
	 * 
	 * @param patient_Id
	 * @return List<Memo>
	 */
	@Override
	public List<Temperature> getTemperatureList(int patientId) {
		return dao.findAllByPatientID(patientId);
	};

	/**
	 * 获取病人最近15条体温记录
	 * 
	 * @param patient_Id
	 * @return List<Memo>
	 */
	@Override
	public List<Temperature> getLast15Temperature(int patientId) {
		return dao.findLastByPatientID(patientId, 15);
	}

	
	/**修改一条体温记录
	 * @param tEMPERATURE  温度记录
	 * @param tEMPERATURE_ID   ID
	 * @return 
	 */ 
	@Override
	public boolean updateTemperature(double tEMPERATURE, int tEMPERATURE_ID) {
		Temperature domain = dao.findByID(tEMPERATURE_ID);
		if (domain != null) {
			domain.setTEMPERATURE(tEMPERATURE);
		} else {
			return false;

		}

		return dao.update(domain);
	}

	@Override
	public boolean deleteTemperature(int tEMPERATURE_ID) {
		Temperature domain = dao.findByID(tEMPERATURE_ID);
		if (domain != null) {
			return dao.delete(domain);
		} else {
			return false;

		}
	}

	@Override
	public boolean deleteAllTemperatureByPatientID(int pATIENT_ID) {
		
		return dao.deleteAllTemperatureByPatientID(pATIENT_ID);
	}

}