package com.naaisi.nursesite.password.service;

import com.naaisi.nursesite.password.dao.PassWordDao;
import com.naaisi.nursesite.password.dao.PassWordDaoImpl;
import com.naaisi.nursesite.password.domain.PassWord;

/**
 * @author lizihao
 *
 */
public class PassWordServiceImpl implements PassWrodService {

	private PassWordDao dao;

	public PassWordServiceImpl() {
		super();
		PassWordDao dao = new PassWordDaoImpl();
		this.dao = dao;
	}

	@Override
	public void setPassWordDao(PassWordDao dao) {
		this.dao = dao;
	}

	/**
	 * 获取一个护士的密码
	 * 
	 * @param nurse_id
	 * @return PassWord
	 */

	@Override
	public PassWord getByNurseID(int nurse_id) {
		return dao.findByNurseID(nurse_id);
	}

	/**
	 * 更新一个护士的密码by id
	 * 
	 * @param nurse_id
	 * @return
	 * @return
	 */

	@Override
	public boolean updatePassWord(int nurse_id, String password) {

		PassWord findByNurseID = dao.findByNurseID(nurse_id);
		findByNurseID.setPASSWORD(password);
		return dao.update(findByNurseID);

	}

	/**
	 * 添加一个护士的密码 by nurse
	 * 
	 * @param nurse
	 * @return
	 */

	@Override
	public boolean addPassWord(int nurseID, String passWord) {
		PassWord domain = new PassWord();
		domain.setNURSE_ID(nurseID);
		domain.setPASSWORD(passWord);
		return dao.save(domain);
	}

}