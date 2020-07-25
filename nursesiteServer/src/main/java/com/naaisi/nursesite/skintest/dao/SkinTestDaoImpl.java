package com.naaisi.nursesite.skintest.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.naaisi.nursesite.dao.BaseDao;
import com.naaisi.nursesite.docadvice.domain.DocAdvice;
import com.naaisi.nursesite.skintest.domain.SkinTest;
import com.naaisi.nursesite.uitl.HibernateSessionFactory;

/**
 * @author lizihao
 *
 */
public class SkinTestDaoImpl extends BaseDao implements SkinTestDao {

	@Override
	public boolean save(SkinTest domain) {

		return super.save(domain);

	}

	@Override
	public boolean update(SkinTest domain) {
		return super.update(domain);

	}

	@Override
	public List<SkinTest> findAll() {
		// DocAdvice domain = new DocAdvice();
		return (List<SkinTest>) super.findAll(SkinTest.class);

	}

	@Override
	public List<SkinTest> findAllByState(int state) {
		return (List<SkinTest>) super.findAllByState(SkinTest.class, state);

	}

	@Override
	public SkinTest findByID(int id) {

		return (SkinTest) super.findByID(SkinTest.class, id);
	}

	@Override
	public List<SkinTest> findByPatientID(int patientID) {
		Session session = HibernateSessionFactory.getSession();// 获得Session对象

		String hql = "from SkinTest where PATIENT_ID=:patientID";
		Query<SkinTest> query = session.createQuery(hql, SkinTest.class);
		query.setParameter("patientID", patientID);
		List<SkinTest> list = query.getResultList();
		HibernateSessionFactory.closeSession(); // 关闭Session对象
		return list;
	}

	@Override
	public List<SkinTest> findSkinTestByPatientIDAndState(int patientID, int state) {
		Session session = HibernateSessionFactory.getSession();// 获得Session对象

		String hql = "from SkinTest where PATIENT_ID=:patientID and STATE=:STATE";
		Query<SkinTest> query = session.createQuery(hql, SkinTest.class);
		query.setParameter("patientID", patientID);
		query.setParameter("STATE", state);
		// List list = query.list(); //查询结果保存到list中

		List<SkinTest> list = query.getResultList();
		HibernateSessionFactory.closeSession(); // 关闭Session对象
		return list;
	}

	@Override
	public boolean delete(SkinTest domain) {
		return super.delete(domain);

	}

//	public static void main(String[] arg) {
//
//
//	}

}
