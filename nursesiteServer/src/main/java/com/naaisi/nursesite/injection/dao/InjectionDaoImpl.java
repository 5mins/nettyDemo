package com.naaisi.nursesite.injection.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.naaisi.nursesite.dao.BaseDao;
import com.naaisi.nursesite.injection.domain.Injection;
import com.naaisi.nursesite.uitl.HibernateSessionFactory;

/**
 * @author lizihao
 *
 */
public class InjectionDaoImpl extends BaseDao implements InjectionDao {

	@Override
	public boolean save(Injection domain) {

		return super.save(domain);

	}

	@Override
	public boolean update(Injection domain) {
		return super.update(domain);

	}

	@Override
	public List<Injection> findAll() {
		// DocAdvice domain = new DocAdvice();
		return (List<Injection>) super.findAll(Injection.class);

	}

//	//查找所有未执行的injection单

	@Override
	public List<Injection> findAllByState(int state) {
		return (List<Injection>) super.findAllByState(Injection.class, state);

	}

//
	@Override
	public Injection findByID(int id) {

		return (Injection) super.findByID(Injection.class, id);
	}

	@Override
	public List<Injection> findByPatientID(int patientID) {
		Session session = HibernateSessionFactory.getSession();// 获得Session对象

		String hql = "from Injection where PATIENT_ID=:patientID";
		Query<Injection> query = session.createQuery(hql, Injection.class);
		// Query query = session.createQuery("from Patient where patient_name = ?");
		// query.setString(0, patient_name);
		query.setParameter("patientID", patientID);
		// List list = query.list(); //查询结果保存到list中

		List<Injection> list = query.getResultList();
		HibernateSessionFactory.closeSession(); // 关闭Session对象
		return list;
	}

	@Override
	public List<Injection> findInjectionByPatientIDAndState(int patientID, int state) {
		Session session = HibernateSessionFactory.getSession();// 获得Session对象

		String hql = "from Injection where PATIENT_ID=:patientID and STATE=:STATE";
		Query<Injection> query = session.createQuery(hql, Injection.class);
		// Query query = session.createQuery("from Patient where patient_name = ?");
		// query.setString(0, patient_name);
		query.setParameter("patientID", patientID);
		query.setParameter("STATE", state);
		// List list = query.list(); //查询结果保存到list中

		List<Injection> list = query.getResultList();
		HibernateSessionFactory.closeSession(); // 关闭Session对象
		return list;
	}

	@Override
	public boolean delete(Injection domain) {
		return super.delete(domain);

	}

//	public static void main(String[] arg) {
////		InjectionDaoImpl dao = new InjectionDaoImpl();
////
////		Injection domain = new Injection();
////		domain.setPATIENT_ID(2);
////		domain.setDRUG("单思病");
////		
////		dao.save(domain);
//
////    	
//		//DocAdvice docAdvice1 = dao.findByAdviceID("1");
//		//List<DocAdvice> docAdvice1 = dao.findNewAdvoiceByNurseID("2");
//		
//		//System.out.println(docAdvice1);
////		docAdvice1.setSTATE("0");
////		dao.update(docAdvice1);
////		// System.out.println(patientdao.delByPatientId("3"));
////		 patientdao.delByPatient(patient1);
//
////		List<Patient> lpa = patientdao.findAll();
////		System.out.println(lpa);//
//
//		// System.out.println(patientdao.findById(2));
//		// System.out.println(patientdao.findByPatientName("XIOAMING"));
//
//	}

}
