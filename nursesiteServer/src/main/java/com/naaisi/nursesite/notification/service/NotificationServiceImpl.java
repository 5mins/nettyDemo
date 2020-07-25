package com.naaisi.nursesite.notification.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.naaisi.nursesite.notification.dao.NotificationDao;
import com.naaisi.nursesite.notification.dao.NotificationDaoImpl;
import com.naaisi.nursesite.notification.domain.Notification;

/**
 * @author lizihao
 *
 */

public class NotificationServiceImpl implements NotificationService {

	private NotificationDao dao;

	public NotificationServiceImpl() {
		super();
		NotificationDao dao = new NotificationDaoImpl();
		this.dao = dao;
	}

	/**
	 * 添加一条公告 （管理端使用）
	 * 
	 * @param tITLE   标题
	 * @param cONTENT 内容
	 * @return
	 */
	@Override
	public boolean addNotification(String tITLE, String cONTENT) {

		Notification domain = new Notification();
		domain.setTITLE(tITLE);
		domain.setCONTENT(cONTENT);
		domain.setCREATED_BY(8);
		Date date = new Date();
		Timestamp timenow = new Timestamp(date.getTime());
		domain.setCREATED_TIME(timenow);
		return dao.save(domain);

	}

	/**
	 * 推送公告 （管理端使用）
	 * 
	 * @return
	 */
	@Override
	public boolean pushNotification() {

		return false;

	}

	/**
	 * 获取所有公告
	 * 
	 * @return
	 */
	@Override
	public List<Notification> getAll() {
		return dao.findAll();

	}

	/**
	 * 获取最新5条公告 （客户端使用）
	 * 
	 * @return
	 */
	@Override
	public List<Notification> getLastNotificationByState() {
		return dao.findLastNotificationByState(1, 5);

	}

	/**
	 * 获取一条公告 （管理端使用）
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Notification getByID(int id) {
		return dao.findByID(id);

	}

	/**
	 * 删除一条公告 （管理端使用）
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public boolean deleteByID(int id) {
		Notification domain = dao.findByID(id);
		return dao.delete(domain);

	}

}