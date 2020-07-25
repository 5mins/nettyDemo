package com.naaisi.nursesite.nurse.service;

import java.util.List;

import com.naaisi.nursesite.nurse.dao.NurseDao;
import com.naaisi.nursesite.nurse.dao.NurseDaoImpl;
import com.naaisi.nursesite.nurse.domain.Nurse;
import com.naaisi.nursesite.password.domain.PassWord;
import com.naaisi.nursesite.password.service.PassWordServiceImpl;
import com.naaisi.nursesite.password.service.PassWrodService;

//@Service("PatientService")
/**
 * @author lizihao
 *
 */
public class NurseServiceImpl implements NurseService {

	private NurseDao dao;

	public NurseServiceImpl() {
		super();
		NurseDao dao = new NurseDaoImpl();
		this.dao = dao;
	}

	@Override
	public void setNurseDao(NurseDao dao) {
		this.dao = dao;
	}

	/**
	 * 获取所有护士
	 * 
	 * @return List<Nurse>
	 */
	@Override
	public List<Nurse> getAll() {
		return dao.findAll();

	}

	/**
	 * 获取一个护士
	 * 
	 * @param nurse_id
	 * @return Nurse
	 */
	@Override
	public Nurse getByID(int nurse_id) {
		return dao.findByID(nurse_id);
	}

	/**
	 * 通过姓名获取护士列表
	 * 
	 * @param name
	 * @return List<Nurse>
	 */

	@Override
	public List<Nurse> getByName(String name) {
		return dao.findByName(name);
	}
	
	/**
	 * 通过email获取一个护士
	 * 
	 * @param email
	 * @return Nurse
	 */
	@Override
	public Nurse getByEmail(String email) {
		return dao.findByEmail(email);
	}

	/**
	 * 更新一个护士的密码by id
	 * 
	 * @param nurse_id
	 * @return
	 */
	@Override
	public boolean updateNursePassWord(int nurse_id, String password) {
//		Nurse domain = dao.findByID(nurse_id);
//		domain.setPASSWORD(password);
		PassWrodService passService = new PassWordServiceImpl();
		return passService.updatePassWord(nurse_id, password);

	}

	/**
	 * 添加一个护士 by nurse
	 * 
	 * @param NAME 
	 * @param sEX
	 * @param dEPARTMENT
	 * @param eMAIIL
	 * @param pASSWORD
	 * @return nurseID 返回值为0表示添加失败 1 2 3分别表示nAME、nAME、pASSWORD中有空字符
	 */
	@Override
	public int addNurse(String nAME, int sEX, String dEPARTMENT, String eMAIIL, String pASSWORD) {
		int sign = 0;// 判断传入字符是否为空

		if (nAME == null || nAME.length() == 0) {
			sign = -2;
			return sign;
		}
		if (eMAIIL == null || eMAIIL.length() == 0) {
			//sign = (sign << 1) | 1;
			sign = -3;
			return sign;
		}

		if (pASSWORD == null || pASSWORD.length() == 0) {
			//sign = (sign << 2) | 1;
			sign = -4;
			return sign;
		}

//		if (sign != 0) {
//			return sign;
//		}

		int addsign = -1;// addsing=-10表示添加数据库时失败
		Nurse nurse = new Nurse();
		nurse.setNAME(nAME);
		nurse.setSEX(sEX);
		nurse.setDEPARTMENT(dEPARTMENT);
		nurse.setEMAIIL(eMAIIL);
		String save = dao.save(nurse);
		if (save != null && !save.equals("")) {
			int nurseID = Integer.parseInt(save);
			PassWrodService passService = new PassWordServiceImpl();
			boolean addPassWord = passService.addPassWord(nurseID, pASSWORD);
			if (addPassWord) {// 如果密码保存成功则返回，否则回退。
				return nurseID;

			} else {
				nurse.setID(nurseID);
				dao.delete(nurse);
				return addsign;
			}
		} else {
			return addsign;
		}

	}

	/**
	 * 判断一个护士的密码是否正确。
	 * 
	 * @param accountType 1表示账户是ID，2表示邮箱
	 * @param account
	 * @param password
	 * @return
	 */
	@Override
	public boolean isNursePassWordCorrect(int accountType, String account, String password) {
		// 如果accountType为2，先获取邮箱对应的ID
		if (accountType == 2) {
			Nurse nurse = dao.findByEmail(account);
			if (nurse != null) {
				return isNursePassWordCorrectByID(nurse.getID(), password);

			}

		} else if (accountType == 1) {
			return isNursePassWordCorrectByID(Integer.parseInt(account), password);
		}
		return false;

	}

	private boolean isNursePassWordCorrectByID(int nurseID, String password) {

		PassWrodService passService = new PassWordServiceImpl();

		String passwordbyID = passService.getByNurseID(nurseID).getPASSWORD();
		if (password != null && password.length() != 0) {
			if (passwordbyID != null && passwordbyID.length() != 0) {
				if (passwordbyID.equals(password)) {

					return true;
				} else {
					System.out.println("密码错误!");
					return false;
				}

			} else {
				System.out.println("账户密码为空，请先修改账户密码!");
				return false;
			}

		} else {
			System.out.println("传入空密码!");
			return false;
		}

	}

	public static void main(String[] args) {
		NurseServiceImpl impl = new NurseServiceImpl();

		int addNurse = impl.addNurse("CEHI", 0, "123", "123@123", "");
		//boolean nursePassWordCorrect = impl.isNursePassWordCorrect(1, "3", "345");
		//Nurse byEmail = impl.getByEmail("3@0.com");
		System.out.println(addNurse);
	}

}