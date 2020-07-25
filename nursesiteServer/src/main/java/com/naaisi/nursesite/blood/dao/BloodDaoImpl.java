package com.naaisi.nursesite.blood.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.naaisi.nursesite.blood.domain.Blood;
import com.naaisi.nursesite.dao.BaseDao;
import com.naaisi.nursesite.docadvice.domain.DocAdvice;
import com.naaisi.nursesite.uitl.HibernateSessionFactory;

public class BloodDaoImpl extends BaseDao implements BloodDao {

	@Override
	public boolean save(Blood domain) {

		return super.save(domain);

	}

	@Override
	public boolean update(Blood domain) {
		return super.update(domain);

	}

	@Override
	public List<Blood> findAll() {
		return (List<Blood>) super.findAll(Blood.class);

	}

	@Override
	public List<Blood> findAllByState(int state) {
		return (List<Blood>) super.findAllByState(Blood.class, state);

	}

//
	@Override
	public Blood findByID(int id) {

		return (Blood) super.findByID(Blood.class, id);
	}

	@Override
	public List<Blood> findByPatientID(int patientID) {
		Session session = HibernateSessionFactory.getSession();// 获得Session对象

		String hql = "from Blood where PATIENT_ID=:patientID";
		Query<Blood> query = session.createQuery(hql, Blood.class);
		query.setParameter("patientID", patientID);
		List<Blood> list = query.getResultList();
		HibernateSessionFactory.closeSession(); // 关闭Session对象
		return list;
	}

	@Override
	public List<Blood> findBloodByPatientIDAndState(int patientID, int state) {
		Session session = HibernateSessionFactory.getSession();// 获得Session对象

		String hql = "from Blood where PATIENT_ID=:patientID and STATE=:STATE";
		Query<Blood> query = session.createQuery(hql, Blood.class);
		query.setParameter("patientID", patientID);
		query.setParameter("STATE", state);
		// List list = query.list(); //查询结果保存到list中

		List<Blood> list = query.getResultList();
		HibernateSessionFactory.closeSession(); // 关闭Session对象
		return list;
	}

	@Override
	public boolean delete(Blood domain) {
		return super.delete(domain);

	}

	public static void main(String[] arg) {

		BloodDaoImpl dao = new BloodDaoImpl();
		System.out.println(dao.findByPatientID(1));

	}

}
