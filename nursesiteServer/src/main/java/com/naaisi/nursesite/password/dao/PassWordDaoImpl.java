package com.naaisi.nursesite.password.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import com.naaisi.nursesite.dao.BaseDao;
import com.naaisi.nursesite.password.domain.PassWord;
import com.naaisi.nursesite.patient.domain.Patient;
import com.naaisi.nursesite.uitl.HibernateSessionFactory;

/**
 * @author lizihao
 *
 */
public class PassWordDaoImpl extends BaseDao implements PassWordDao {

	@Override
	public boolean save(PassWord domain) {

		return super.save(domain);

	}

	@Override
	public boolean update(PassWord domain) {
		return super.update(domain);

	}

	@Override
	public List<PassWord> findAll() {
		// DocAdvice domain = new DocAdvice();
		return (List<PassWord>) super.findAll(PassWord.class);

	}

	@Override
	public PassWord findByID(int id) {

		return (PassWord) super.findByID(PassWord.class, id);
	}

	@Override
	public boolean delete(PassWord domain) {
		return super.delete(domain);

	}
	
	@Override
	public PassWord findByNurseID(int nurseID) {
		PassWord passWord = null;
		Session session = HibernateSessionFactory.getSession();// 获得Session对象
		String hql = "from PassWord where NURSE_ID=:NurseID";
		Query<PassWord> query = session.createQuery(hql, PassWord.class);
		query.setParameter("NurseID", nurseID);
		List<PassWord> list = query.getResultList();
		if (list != null) {
			passWord = list.get(0);
		}

		HibernateSessionFactory.closeSession(); // 关闭Session对象
		return passWord;
	}

//
//	public static void main(String[] arg) {
//		PassWordDaoImpl impl = new PassWordDaoImpl();
//
//		//List<PassWord> findAll = impl.findAll();
//		PassWord findByNurseID = impl.findByNurseID(1);
//		System.out.println(findByNurseID);
//	}



}
