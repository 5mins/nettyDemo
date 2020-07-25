package com.naaisi.nursesite.appservicesApi;

import java.util.List;

import com.naaisi.nursesite.nurse.domain.Nurse;

/**
 * @author lizihao
 *
 */
public interface INurse {
	/**
	 * 获取所有护士
	 * 
	 * @return List<Nurse>
	 */
	List<Nurse> getAll();

	/**
	 * 获取一个护士
	 * 
	 * @param nurse_id
	 * @return Nurse
	 */
	Nurse getById(String nurse_id);

	/**
	 * 通过姓名获取护士列表
	 * 
	 * @param name
	 * @return List<Nurse>
	 */

	List<Nurse> getByName(String name);
	
	/**
	 * 更新一个护士的密码by id
	 * 
	 * @param nurse_id
	 * @return 
	 */
	boolean updateNursePassWord(String nurse_id,String password);
	
	/**
	 * 添加一个护士 
	 * 
	 * @param ...
	 * @return nurseID 返回值为-1表示添加失败  -2 -3 -4分别表示nAME、nAME、pASSWORD中有空字符
	 */
	String addNurse(String nAME, String sEX, String dEPARTMENT, String eMAIIL, String pASSWORD);
	
	/**
	 * 判断一个护士的密码是否正确。
	 * @param accountType 1表示账户是ID，2表示邮箱
	 * @param account
	 * @param password
	 * @return
	 */
	boolean isNursePassWordCorrect(String accountType, String account, String password);
	
	/**
	 * 通过email获取一个护士
	 * 
	 * @param email
	 * @return Nurse
	 */
	Nurse getByEmail(String email);
}
