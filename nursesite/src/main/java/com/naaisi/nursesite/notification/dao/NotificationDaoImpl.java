package com.naaisi.nursesite.notification.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.naaisi.nursesite.dao.BaseDao;
import com.naaisi.nursesite.docadvice.domain.DocAdvice;
import com.naaisi.nursesite.notification.domain.Notification;
import com.naaisi.nursesite.uitl.HibernateSessionFactory;

/**
 * @author lizihao
 *
 */
public class NotificationDaoImpl extends BaseDao implements NotificationDao {

	@Override
	public boolean save(Notification domain) {

		return super.save(domain);

	}

	@Override
	public boolean update(Notification domain) {
		return super.update(domain);

	}

	@Override
	public List<Notification> findAll() {
		// DocAdvice domain = new DocAdvice();
		return (List<Notification>) super.findAll(Notification.class);

	}

	// 1有效，0无效
	@Override
	public List<Notification> findAllByState(int state) {
		return (List<Notification>) super.findAllByState(Notification.class, state);

	}

	// 1有效，0无效 查找最近num条 数据。
	@Override
	public List<Notification> findLastNotificationByState(int state, int num) {
		Session session = HibernateSessionFactory.getSession();// 获得Session对象

		String hql = "from Notification where STATE=:STATE order by id desc";// asc 升序 //后10条数据 ，desc为降序
		Query<Notification> query = session.createQuery(hql, Notification.class);
		query.setParameter("STATE", state);
		query.setMaxResults(num);
		List<Notification> list = query.getResultList();
		HibernateSessionFactory.closeSession(); // 关闭Session对象
		return list;
	}

	@Override
	public Notification findByID(int id) {

		return (Notification) super.findByID(Notification.class, id);
	}

	@Override
	public List<Notification> findByType(int type) {
		Session session = HibernateSessionFactory.getSession();// 获得Session对象

		String hql = "from Notification where Type=:type";
		Query<Notification> query = session.createQuery(hql, Notification.class);

		query.setParameter("type", type);

		List<Notification> list = query.getResultList();
		HibernateSessionFactory.closeSession(); // 关闭Session对象
		return list;
	}

	@Override
	public boolean delete(Notification domain) {
		return super.delete(domain);

	}

//	public static void main(String[] arg) {
//		
////		NotificationDao dao = new NotificationDaoImpl();
////		//System.out.println(dao.findLastNotificationByState( "0",1));
////		System.out.println(dao.findByType( 0));
//
//	}

}
