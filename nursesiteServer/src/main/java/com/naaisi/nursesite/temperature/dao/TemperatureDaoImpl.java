package com.naaisi.nursesite.temperature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.naaisi.nursesite.dao.BaseDao;
import com.naaisi.nursesite.temperature.domain.Temperature;
import com.naaisi.nursesite.uitl.HibernateSessionFactory;

/**
 * @author lizihao
 *
 */
public class TemperatureDaoImpl extends BaseDao implements TemperatureDao {

	@Override
	public boolean save(Temperature domain) {

		return super.save(domain);

	}
	
	@Override
	public int save1(Temperature domain) {

		return super.save1(domain);

	}

	@Override
	public boolean update(Temperature domain) {
		return super.update(domain);

	}

	@Override
	public List<Temperature> findAll() {
		// DocAdvice domain = new DocAdvice();
		return (List<Temperature>) super.findAll(Temperature.class);

	}

	@Override
	public List<Temperature> findAllByPatientID(int patientId) {
		Session session = HibernateSessionFactory.getSession();// 获得Session对象

		String hql = "from Temperature where PATIENT_ID =:patientId";
		Query<Temperature> query = session.createQuery(hql, Temperature.class);
		query.setParameter("patientId", patientId);

		List<Temperature> list = query.getResultList();
		HibernateSessionFactory.closeSession(); // 关闭Session对象
		return list;
	}

	// 查找病人ID 最近num条数据
	@Override
	public List<Temperature> findLastByPatientID(int patientId, int num) {
		Session session = HibernateSessionFactory.getSession();// 获得Session对象

		String hql = "from Temperature where PATIENT_ID=:patientId order by id desc";// asc 升序 //后10条数据 ，desc为降序
		Query<Temperature> query = session.createQuery(hql, Temperature.class);
		query.setParameter("patientId", patientId);
		query.setMaxResults(num);
		List<Temperature> list = query.getResultList();
		HibernateSessionFactory.closeSession(); // 关闭Session对象
		return list;
	}

	public Temperature findByID(int id) {

		return (Temperature) super.findByID(Temperature.class, id);
	}

	@Override
	public boolean delete(Temperature domain) {
		return super.delete(domain);

	}
	
	@Override
	public boolean deleteAllTemperatureByPatientID(int pATIENT_ID) {
		
		List<Temperature> findAllByPatientID = findAllByPatientID(pATIENT_ID);
		return super.deleteBylist(findAllByPatientID);

	}
	
	

//	public static void main(String[] arg) {
//		
//		TemperatureDaoImpl dao = new TemperatureDaoImpl();
//		System.out.println(dao.findLastByPatientId(1,3));
//		//System.out.println(dao.findAllByPatientId(1));
//
//	}

}
