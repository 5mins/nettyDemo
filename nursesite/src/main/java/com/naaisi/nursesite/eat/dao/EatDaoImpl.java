package com.naaisi.nursesite.eat.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.naaisi.nursesite.dao.BaseDao;
import com.naaisi.nursesite.docadvice.domain.DocAdvice;
import com.naaisi.nursesite.eat.domain.Eat;
import com.naaisi.nursesite.uitl.HibernateSessionFactory;

/**
 * @author lizihao
 *
 */
public class EatDaoImpl extends BaseDao implements EatDao {

	@Override
	public boolean save(Eat domain) {

		return super.save(domain);
	}

	@Override
	public boolean update(Eat domain) {
		return super.update(domain);

	}

	@Override
	public List<Eat> findAll() {
		// DocAdvice domain = new DocAdvice();
		return (List<Eat>) super.findAll(Eat.class);

	}

	@Override
	public List<Eat> findAllByState(int state) {
		return (List<Eat>) super.findAllByState(Eat.class, state);

	}

//
	@Override
	public Eat findByID(int id) {

		return (Eat) super.findByID(Eat.class, id);
	}

	@Override
	public List<Eat> findByPatientID(int patientID) {
		Session session = HibernateSessionFactory.getSession();// 获得Session对象

		String hql = "from Eat where PATIENT_ID=:patientID";
		Query<Eat> query = session.createQuery(hql, Eat.class);
		query.setParameter("patientID", patientID);
		List<Eat> list = query.getResultList();
		HibernateSessionFactory.closeSession(); // 关闭Session对象
		return list;
	}

	@Override
	public List<Eat> findEatByPatientIDAndState(int patientID, int state) {
		Session session = HibernateSessionFactory.getSession();// 获得Session对象

		String hql = "from Eat where PATIENT_ID=:patientID and STATE=:STATE";
		Query<Eat> query = session.createQuery(hql, Eat.class);
		query.setParameter("patientID", patientID);
		query.setParameter("STATE", state);
		// List list = query.list(); //查询结果保存到list中

		List<Eat> list = query.getResultList();
		HibernateSessionFactory.closeSession(); // 关闭Session对象
		return list;
	}

	@Override
	public boolean delete(Eat domain) {
		return super.delete(domain);

	}

	public static void main(String[] arg) {

	}

}
