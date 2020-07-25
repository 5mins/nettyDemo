package com.naaisi.nursesite.appservicesApi;

import java.util.List;

import com.naaisi.nursesite.notification.domain.Notification;
import com.naaisi.nursesite.notification.service.NotificationService;
import com.naaisi.nursesite.notification.service.NotificationServiceImpl;

/**
 * @author lizihao
 *
 */
public class SNotification implements INotification {

	private NotificationService service;

	public SNotification() {

		NotificationService service = new NotificationServiceImpl();
		this.service = service;
	}

	@Override
	public boolean addNotification(String tITLE, String cONTENT) {

		return service.addNotification(tITLE, cONTENT);
	}

	@Override
	public boolean pushNotification() {
		return service.pushNotification();
	}

	@Override
	public List<Notification> getAll() {
		// TODO Auto-generated method stub
		return service.getAll();
	}

	@Override
	public List<Notification> getLastNotificationByState() {
		return service.getLastNotificationByState();
	}

	@Override
	public Notification getById(String id) {
		return service.getByID(Integer.parseInt(id));
	}

	@Override
	public boolean deleteById(String id) {
		return service.deleteByID(Integer.parseInt(id));
	}

}
