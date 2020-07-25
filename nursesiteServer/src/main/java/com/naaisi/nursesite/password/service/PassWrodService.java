package com.naaisi.nursesite.password.service;

import com.naaisi.nursesite.password.dao.PassWordDao;
import com.naaisi.nursesite.password.domain.PassWord;

public interface PassWrodService {

	void setPassWordDao(PassWordDao dao);

	/**
	 * 获取一个护士的密码
	 * 
	 * @param nurse_id
	 * @return PassWord
	 */

	PassWord getByNurseID(int nurse_id);

	/**
	 * 更新一个护士的密码by id
	 * 
	 * @param nurse_id
	 * @return
	 * @return
	 */

	boolean updatePassWord(int nurse_id, String password);

	/**
	 * 添加一个护士的密码 by nurse
	 * 
	 * @param nurse
	 * @return
	 */

	boolean addPassWord(int nurseID, String passWord);

}