package com.naaisi.nursesite.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.naaisi.nursesite.bunk.domain.Bunk;
import com.naaisi.nursesite.docadvice.domain.DocAdvice;
import com.naaisi.nursesite.doctor.domain.Doctor;
import com.naaisi.nursesite.nurse.domain.Nurse;
import com.naaisi.nursesite.uitl.HibernateSessionFactory;

/**
 * @author lizihao
 *
 */
public class BaseDao {

	public boolean save(Object domain) {

		Session session = HibernateSessionFactory.getSession();// 获得Session对象
		Transaction transaction = null;// 声明一个事务对象
		try {
			transaction = session.beginTransaction();// 开启事务
			session.save(domain);// 保存
			transaction.commit();// 提交事务
		} catch (Exception ex) {
			ex.printStackTrace();
			
			transaction.rollback();// 事务回滚
			 throw new RuntimeException(ex);
			//return false;
		}

		HibernateSessionFactory.closeSession();// 关闭Session对象
		return true;

	}
	
	public int save1(Object domain) {
		Serializable save =null;
		int saveID = -1;//-1表示失败
		Session session = HibernateSessionFactory.getSession();// 获得Session对象
		Transaction transaction = null;// 声明一个事务对象
		try {
			transaction = session.beginTransaction();// 开启事务
			 save = session.save(domain);// 保存
			transaction.commit();// 提交事务
			//System.out.println(save);
		} catch (Exception ex) {
			ex.printStackTrace();
			transaction.rollback();// 事务回滚
			return -1;
		}

		HibernateSessionFactory.closeSession();// 关闭Session对象
		saveID = Integer.parseInt(save.toString());
		return saveID;
				
	}
	
	public boolean update(Object domain) {
		Session session = HibernateSessionFactory.getSession();// 获得Session对象
		Transaction transaction = null;// 声明一个事务对象
		try {
			transaction = session.beginTransaction();// 开启事务
			session.update(domain);// 更新
			transaction.commit();// 提交事务
		} catch (Exception ex) {
			ex.printStackTrace();
			transaction.rollback();// 事务回滚
			return false;
		}
		HibernateSessionFactory.closeSession();// 关闭Session对象
		return true;
	}
	
	public boolean delete(Object domain) {
		Session session = HibernateSessionFactory.getSession();// 获得Session对象
		try {
		session.beginTransaction(); // 开启事务

		session.delete(domain); // 删除

		session.getTransaction().commit(); // 提交事务
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		HibernateSessionFactory.closeSession(); // 关闭Session对象
		return true;
		
	}
	
	
	public boolean deleteBylist(List ObjList) {
		Session session = HibernateSessionFactory.getSession();// 获得Session对象
		try {
		session.beginTransaction(); // 开启事务

        //采用hibernate映射类的方法进行删除
        for (Object obj: ObjList) {
//            Trainee t = (Trainee)session.load(Trainee.class, idList);
//            if (t != null)
                session.delete(obj);
        }

		session.getTransaction().commit(); // 提交事务
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		HibernateSessionFactory.closeSession(); // 关闭Session对象
		return true;
		
	}
	
	public Object findAll(Class domain) {
		Session session = HibernateSessionFactory.getSession();// 获得Session对象

		
		String SimpleName = domain.getSimpleName();
		//System.out.println(SimpleName);
		String hql = "from "+SimpleName;
		Query query = session.createQuery(hql);
		//query.setParameter("ObjectName", SimpleName);
		List<Object> list = query.getResultList();
		HibernateSessionFactory.closeSession();// 关闭Session对象

		return list;
	}
	
	
	public Object findByID(Class domain,int id) {

		Session session = HibernateSessionFactory.getSession();// 获得Session对象
		Object domain1 =  session.get(domain, id);
		HibernateSessionFactory.closeSession();// 关闭Session对象
		// System.out.println(patient);
		return domain1;

	}//
	
	public Object findAllByState(Class domain,int state) {
	Session session = HibernateSessionFactory.getSession();// 获得Session对象
	String SimpleName = domain.getSimpleName();
	
	String hql = "from "+SimpleName+" where STATE=:STATE";
	Query<Object> query = session.createQuery(hql, domain);
	query.setParameter("STATE", state);
	//query.setParameter("SimpleName", SimpleName);
	List<Object> list = query.getResultList();
	HibernateSessionFactory.closeSession(); // 关闭Session对象
	return list;
	
	}
	
	public List<Bunk> findLastByState(Class domain,int state,int num) {
		Session session = HibernateSessionFactory.getSession();// 获得Session对象
		String SimpleName = domain.getSimpleName();
		
		String hql = "from "+SimpleName+" where STATE=:STATE order by id desc";//asc 升序 //后10条数据 ，desc为降序
		Query<Bunk> query = session.createQuery(hql, Bunk.class);
		query.setParameter("STATE", state);
		query.setMaxResults(num);
		List<Bunk> list = query.getResultList();
		HibernateSessionFactory.closeSession(); // 关闭Session对象
		return list;
	}
	


}
