package com.naaisi.nursesite.notification.dao;

import java.util.List;

import com.naaisi.nursesite.notification.domain.Notification;

public interface NotificationDao {

	boolean save(Notification domain);

	boolean update(Notification domain);

	List<Notification> findAll();

	//1有效，2无效
	List<Notification> findAllByState(int state);

	//1有效，2无效  查找最近num条 数据。
	List<Notification> findLastNotificationByState(int state, int num);

	Notification findByID(int id);

	List<Notification> findByType(int type);

	//boolean deleteByID(int id);
	

	boolean delete(Notification domain);

}