package com.naaisi.nursesite.memo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.naaisi.nursesite.dao.BaseDao;
import com.naaisi.nursesite.docadvice.domain.DocAdvice;
import com.naaisi.nursesite.memo.domain.Memo;
import com.naaisi.nursesite.uitl.HibernateSessionFactory;

/**
 * @author lizihao
 *
 */
public class MemoDaoImpl extends BaseDao implements MemoDao {

	@Override
	public boolean save(Memo domain) {

		return super.save(domain);

	}
	
	@Override
	public int save1(Memo domain) {

		return super.save1(domain);

	}

	@Override
	public boolean update(Memo domain) {
		return super.update(domain);

	}

	@Override
	public List<Memo> findAll() {
		// DocAdvice domain = new DocAdvice();
		return (List<Memo>) super.findAll(DocAdvice.class);

	}

	@Override
	public List<Memo> findAllByNurseID(int nurseId) {

		Session session = HibernateSessionFactory.getSession();// 获得Session对象
		String hql = "from Memo where CREATED_BY=:CREATED_BY ";
		Query<Memo> query = session.createQuery(hql, Memo.class);
		query.setParameter("CREATED_BY", nurseId);
		List<Memo> list = query.getResultList();
		HibernateSessionFactory.closeSession(); // 关闭Session对象
		return list;

	}

	// 1有效，0无效 默认1
	@Override
	public List<Memo> findAllByState(int nurseId, int state) {
		Session session = HibernateSessionFactory.getSession();// 获得Session对象

		String hql = "from Memo where CREATED_BY=:CREATED_BY and STATE=:STATE";
		Query<Memo> query = session.createQuery(hql, Memo.class);
		query.setParameter("STATE", state);
		query.setParameter("CREATED_BY", nurseId);
		List<Memo> list = query.getResultList();
		HibernateSessionFactory.closeSession(); // 关闭Session对象
		return list;
	}

	// 1有效，0无效 查找最近num条 数据。

	@Override
	public List<Memo> findLastMemoByState(int nurseId, int state, int num) {
		Session session = HibernateSessionFactory.getSession();// 获得Session对象

		String hql = "from Memo where CREATED_BY=:CREATED_BY and STATE=:STATE order by id desc";// asc 升序 //后10条数据
																								// ，desc为降序
		Query<Memo> query = session.createQuery(hql, Memo.class);
		query.setParameter("STATE", state);
		query.setParameter("CREATED_BY", nurseId);
		query.setMaxResults(num);
		List<Memo> list = query.getResultList();
		HibernateSessionFactory.closeSession(); // 关闭Session对象
		return list;
	}

	@Override
	public Memo findByID(int id) {

		return (Memo) super.findByID(Memo.class, id);
	}

	@Override
	public boolean delete(Memo domain) {
		return super.delete(domain);

	}

//	public static void main(String[] arg) {
//		
//		MemoDaoImpl dao = new MemoDaoImpl();
//		System.out.println(dao.findAllByState(7,1));
////		System.out.println(dao.findAllByState(1));
//
//	}

}
