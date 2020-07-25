package com.naaisi.nursesite.docadvice.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.naaisi.nursesite.dao.BaseDao;
import com.naaisi.nursesite.docadvice.domain.DocAdvice;
import com.naaisi.nursesite.eat.domain.Eat;
import com.naaisi.nursesite.injection.domain.Injection;
import com.naaisi.nursesite.uitl.HibernateSessionFactory;

public class DocAdviceDaoImpl extends BaseDao implements DocAdviceDao {

	@Override
	public boolean save(DocAdvice domain) {

		return super.save(domain);

	}

	@Override
	public boolean update(DocAdvice domain) {
		return super.update(domain);

	}

	@Override
	public List<DocAdvice> findAll() {
		// DocAdvice domain = new DocAdvice();
		return (List<DocAdvice>) super.findAll(DocAdvice.class);

	}

	@Override
	public List<DocAdvice> findAllByState(int state) {
		return (List<DocAdvice>) super.findAllByState(DocAdvice.class, state);

	}

	@Override
	public DocAdvice findByID(int id) {

		return (DocAdvice) super.findByID(DocAdvice.class, id);
	}

	@Override
	public List<DocAdvice> findByPatientID(int patientID) {
		Session session = HibernateSessionFactory.getSession();// 获得Session对象

		String hql = "from DocAdvice where PATIENT_ID=:patientID";
		Query<DocAdvice> query = session.createQuery(hql, DocAdvice.class);
		// Query query = session.createQuery("from Patient where patient_name = ?");
		// query.setString(0, patient_name);
		query.setParameter("patientID", patientID);
		// List list = query.list(); //查询结果保存到list中

		List<DocAdvice> list = query.getResultList();
		HibernateSessionFactory.closeSession(); // 关闭Session对象
		return list;
	}

	@Override
	public List<DocAdvice> findDocAdviceByPatientIDAndState(int patientID, int state) {
		Session session = HibernateSessionFactory.getSession();// 获得Session对象

		String hql = "from DocAdvice where PATIENT_ID=:patientID and STATE=:STATE";
		Query<DocAdvice> query = session.createQuery(hql, DocAdvice.class);
		query.setParameter("patientID", patientID);
		query.setParameter("STATE", state);
		// List list = query.list(); //查询结果保存到list中

		List<DocAdvice> list = query.getResultList();
		HibernateSessionFactory.closeSession(); // 关闭Session对象
		return list;
	}

	@Override
	public List<DocAdvice> findByNurseID(int nurseID) {
		Session session = HibernateSessionFactory.getSession();// 获得Session对象

		String hql = "from DocAdvice where EXECUTOU=:nurseID";
		Query<DocAdvice> query = session.createQuery(hql, DocAdvice.class);
		// Query query = session.createQuery("from Patient where patient_name = ?");
		// query.setString(0, patient_name);
		query.setParameter("nurseID", nurseID);
		// List list = query.list(); //查询结果保存到list中

		List<DocAdvice> list = query.getResultList();
		HibernateSessionFactory.closeSession(); // 关闭Session对象
		return list;
	}

	@Override
	public List<DocAdvice> findAdvoiceByNurseIDAndState(int nurseID, int state) {
		Session session = HibernateSessionFactory.getSession();// 获得Session对象
		String hql = "from DocAdvice where EXECUTOU=:nurseID and STATE=:STATE";
		Query<DocAdvice> query = session.createQuery(hql, DocAdvice.class);
		query.setParameter("nurseID", nurseID);
		query.setParameter("STATE", state);
		List<DocAdvice> list = query.getResultList();
		HibernateSessionFactory.closeSession(); // 关闭Session对象
		return list;
	}

	@Override
	public boolean delete(DocAdvice domain) {
		return super.delete(domain);

	}

	public static void main(String[] arg) {
		DocAdviceDao dao = new DocAdviceDaoImpl();

		// DocAdvice docAdvice = new DocAdvice();

//    	
		 DocAdvice docAdvice1 = dao.findByID(3);
		// List<DocAdvice> docAdvice1 = dao.findNewAdvoiceByNurseID("2");

		// System.out.println(docAdvice1);
//		docAdvice1.setSTATE("0");
//		dao.update(docAdvice1);
//		// System.out.println(patientdao.delByPatientId("3"));
//		 patientdao.delByPatient(patient1);

//		List<Patient> lpa = patientdao.findAll();
		System.out.println(docAdvice1);

		// System.out.println(patientdao.findById(2));
		// System.out.println(patientdao.findByPatientName("XIOAMING"));

	}

}
