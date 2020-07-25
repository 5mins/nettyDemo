package com.naaisi.nursesite.nurse.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.naaisi.nursesite.dao.BaseDao;
import com.naaisi.nursesite.docadvice.domain.DocAdvice;
import com.naaisi.nursesite.nurse.domain.Nurse;
import com.naaisi.nursesite.uitl.HibernateSessionFactory;

/**
 * @author lizihao
 *
 */
public class NurseDaoImpl extends BaseDao implements NurseDao {

	@Override
	public String save(Nurse domain) {
//		Serializable save =null;
//		
//		Session session = HibernateSessionFactory.getSession();// 获得Session对象
//		Transaction transaction = null;// 声明一个事务对象
//		try {
//			transaction = session.beginTransaction();// 开启事务
//			save = session.save(domain);// 保存
//			transaction.commit();// 提交事务
//			System.out.println(save);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			transaction.rollback();// 事务回滚
//			return "";
//		}
//
//		HibernateSessionFactory.closeSession();// 关闭Session对象
//		return save.toString();
		
		return (super.save1(domain))+"";

	}

	@Override
	public boolean update(Nurse domain) {
		return super.update(domain);

	}

	@Override
	public List<Nurse> findAll() {
		// DocAdvice domain = new DocAdvice();
		return (List<Nurse>) super.findAll(Nurse.class);

	}

	@Override
	public Nurse findByID(int id) {

		return (Nurse) super.findByID(Nurse.class, id);
	}

	@Override
	public List<Nurse> findByName(String name) {
		Session session = HibernateSessionFactory.getSession();// 获得Session对象

		String hql = "from Nurse where NAME=:name";
		Query<Nurse> query = session.createQuery(hql, Nurse.class);
		// Query query = session.createQuery("from Patient where patient_name = ?");
		// query.setString(0, patient_name);
		query.setParameter("name", name);
		// List list = query.list(); //查询结果保存到list中

		List<Nurse> list = query.getResultList();
		HibernateSessionFactory.closeSession(); // 关闭Session对象
		return list;
	}
	
	@Override
	public Nurse findByEmail(String email) {
		Session session = HibernateSessionFactory.getSession();// 获得Session对象
		Nurse nurse = null;
		String hql = "from Nurse where EMAIIL=:EMAIIL";
		Query<Nurse> query = session.createQuery(hql, Nurse.class);
		query.setParameter("EMAIIL", email);
		List<Nurse> list = query.getResultList();
		if(list!=null) {
			nurse = list.get(0);
		}
		
		HibernateSessionFactory.closeSession(); // 关闭Session对象
		return nurse;
	}

	@Override
	public boolean delete(Nurse domain) {
		return super.delete(domain);

	}
//
	public static void main(String[] arg) {
		NurseDaoImpl impl = new NurseDaoImpl();
		Nurse domain = new Nurse();
		//domain.setNAME("lilili");
		impl.save(domain);

	}

}
