package com.naaisi.nursesite.appservicesApi;

import java.util.List;

import com.naaisi.nursesite.notification.domain.Notification;

/**
 * @author lizihao
 *
 */
public interface INotification {
	/**
	 * 添加一条公告 （管理端使用）
	 * 
	 * @param tITLE   标题
	 * @param cONTENT 内容
	 * @return
	 */
	boolean addNotification(String tITLE, String cONTENT);

	/**
	 * 推送公告 （管理端使用）
	 * 
	 * @return
	 */
	boolean pushNotification();

	/**
	 * 获取所有公告
	 * 
	 * @return
	 */
	List<Notification> getAll();

	/**
	 * 获取最新5条公告 （客户端使用）
	 * 
	 * @return
	 */
	List<Notification> getLastNotificationByState();

	/**
	 * 获取一条公告 （管理端使用）
	 * 
	 * @param id
	 * @return
	 */
	Notification getById(String id);

	/**
	 * 删除一条公告 （管理端使用）
	 * 
	 * @param id
	 * @return
	 */
	boolean deleteById(String id);
}
