package com.naaisi.nursesite.doctor.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.naaisi.nursesite.dao.BaseDao;
import com.naaisi.nursesite.docadvice.domain.DocAdvice;
import com.naaisi.nursesite.doctor.domain.Doctor;
import com.naaisi.nursesite.uitl.HibernateSessionFactory;

/**
 * @author lizihao
 *
 */
public class DoctorDaoImpl extends BaseDao implements DoctorDao {

	@Override
	public boolean save(Doctor domain) {

		return super.save(domain);

	}

	@Override
	public boolean update(Doctor domain) {
		return super.update(domain);

	}

	@Override
	public List<Doctor> findAll() {
		// DocAdvice domain = new DocAdvice();
		return (List<Doctor>) super.findAll(Doctor.class);

	}

	@Override
	public Doctor findByID(int id) {

		return (Doctor) super.findByID(Doctor.class, id);
	}

	@Override
	public List<Doctor> findByName(String name) {
		Session session = HibernateSessionFactory.getSession();// 获得Session对象

		String hql = "from Doctor where NAME=:name";
		Query<Doctor> query = session.createQuery(hql, Doctor.class);
		query.setParameter("name", name);
		List<Doctor> list = query.getResultList();
		HibernateSessionFactory.closeSession(); // 关闭Session对象
		return list;
	}

	@Override
	public boolean delete(Doctor domain) {
		return super.delete(domain);

	}

//	public static void main(String[] arg) {
//		DoctorDaoImpl dao = new DoctorDaoImpl();
//		System.out.println(dao.findByID(1));
//		
//	}

}
