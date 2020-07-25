package com.naaisi.nursesite.patient.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.naaisi.nursesite.dao.BaseDao;
import com.naaisi.nursesite.patient.domain.Patient;
import com.naaisi.nursesite.uitl.HibernateSessionFactory;

/**
 * @author lizihao
 *
 */
public class PatientDaoImpl extends BaseDao implements PatientDao {

	@Override
	public boolean save(Patient domain) {

		return super.save(domain);

	}

	@Override
	public boolean update(Patient domain) {
		return super.update(domain);

	}

	@Override
	public List<Patient> findAll() {
		// DocAdvice domain = new DocAdvice();
		return (List<Patient>) super.findAll(Patient.class);

	}

	@Override
	public Patient findByID(int id) {

		return (Patient) super.findByID(Patient.class, id);
	}

	@Override
	public List<Patient> findByName(String name) {
		Session session = HibernateSessionFactory.getSession();// 获得Session对象

		String hql = "from Patient where NAME=:name";
		Query<Patient> query = session.createQuery(hql, Patient.class);
		// Query query = session.createQuery("from Patient where patient_name = ?");
		// query.setString(0, patient_name);
		query.setParameter("name", name);
		// List list = query.list(); //查询结果保存到list中

		List<Patient> list = query.getResultList();
		HibernateSessionFactory.closeSession(); // 关闭Session对象
		return list;
	}
	
	@Override
	public List<Patient> findByNurseID(int nurseID){
		Session session = HibernateSessionFactory.getSession();// 获得Session对象

		String hql = "from Patient where NURSE=:nurseID";
		Query<Patient> query = session.createQuery(hql, Patient.class);
		query.setParameter("nurseID", nurseID);
		List<Patient> list = query.getResultList();
		HibernateSessionFactory.closeSession(); // 关闭Session对象
		return list;
		
	}

	@Override
	public boolean delete(Patient domain) {
		return super.delete(domain);

	}
//
//	public static void main(String[] arg) {
//		PatientDao patientdao = new PatientDaoImpl();
//
//    	Patient patient = new Patient();
//    	patient.setNAME("XIOAMING");
//    	patient.setSEX(0);
//    	patientdao.save(patient);
////    	
//    	//Patient patient1 = patientdao.findById("4");
////    	patient1.setSEX("1");
////    	patientdao.updatePatient(patient1);
//		// System.out.println(patientdao.delByPatientId("3"));
//		// patientdao.delByPatient(patient1);
//
//		List<Patient> lpa = patientdao.findAll();
//		System.out.println(lpa);//
//
//		// System.out.println(patientdao.findById(2));
//		// System.out.println(patientdao.findByPatientName("XIOAMING"));
//
//	}

}
