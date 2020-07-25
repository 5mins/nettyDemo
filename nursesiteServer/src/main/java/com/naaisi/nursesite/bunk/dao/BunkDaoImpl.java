package com.naaisi.nursesite.bunk.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.naaisi.nursesite.bunk.domain.Bunk;
import com.naaisi.nursesite.dao.BaseDao;
import com.naaisi.nursesite.docadvice.domain.DocAdvice;
import com.naaisi.nursesite.uitl.HibernateSessionFactory;

public class BunkDaoImpl extends BaseDao implements BunkDao {

	@Override
	public boolean save(Bunk domain) {

		return super.save(domain);

	}

	@Override
	public boolean update(Bunk domain) {
		return super.update(domain);

	}

	@Override
	public List<Bunk> findAll() {
		// DocAdvice domain = new DocAdvice();
		return (List<Bunk>) super.findAll(Bunk.class);

	}

	// 1有效，0无效

	@Override
	public List<Bunk> findAllByState(int state) {
		return (List<Bunk>) super.findAllByState(Bunk.class, state);

	}

	// 1已使用，0未使用 查找最近num条 数据。

	@Override
	public List<Bunk> findLastBunkByState(int state, int num) {
		return (List<Bunk>) super.findLastByState(Bunk.class, state, num);

	}

	@Override
	public Bunk findByID(int id) {

		return (Bunk) super.findByID(Bunk.class, id);
	}

	@Override
	public List<Bunk> findByPatientID(int pATIENT_ID) {

		Session session = HibernateSessionFactory.getSession();// 获得Session对象

		String hql = "from Bunk where PATIENT_ID=:pATIENT_ID";
		Query<Bunk> query = session.createQuery(hql, Bunk.class);
		query.setParameter("pATIENT_ID", pATIENT_ID);

		List<Bunk> list = query.getResultList();
		HibernateSessionFactory.closeSession(); // 关闭Session对象
		return list;

	}

	@Override
	public boolean delete(Bunk domain) {
		return super.delete(domain);

	}

	public static void main(String[] arg) {

		BunkDao dao = new BunkDaoImpl();
		// System.out.println(dao.findLastNotificationByState( "0",1));
		System.out.println(dao.findAllByState(1));

	}

}
