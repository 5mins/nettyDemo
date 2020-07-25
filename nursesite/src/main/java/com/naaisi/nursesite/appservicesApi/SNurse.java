package com.naaisi.nursesite.appservicesApi;

import java.util.List;

import com.naaisi.nursesite.nurse.domain.Nurse;
import com.naaisi.nursesite.nurse.service.NurseService;
import com.naaisi.nursesite.nurse.service.NurseServiceImpl;

/**
 * @author lizihao
 *
 */
public class SNurse implements INurse {

	private NurseService service;

	public SNurse() {

		NurseService service = new NurseServiceImpl();
		this.service = service;
	}

	@Override
	public List<Nurse> getAll() {

		return service.getAll();
	}

	@Override
	public Nurse getById(String nurse_id) {

		return service.getByID(Integer.parseInt(nurse_id));
	}

	@Override
	public List<Nurse> getByName(String name) {

		return service.getByName(name);
	}

	@Override
	public boolean updateNursePassWord(String nurse_id, String password) {

		return service.updateNursePassWord(Integer.parseInt(nurse_id), password);
	}

	@Override
	public String addNurse(String nAME, String sEX, String dEPARTMENT, String eMAIIL, String pASSWORD) {
		
		return service.addNurse(nAME, Integer.parseInt(sEX), dEPARTMENT, eMAIIL, pASSWORD)+"";
	}

	@Override
	public boolean isNursePassWordCorrect(String accountType, String account, String password) {
		
		return service.isNursePassWordCorrect(Integer.parseInt(accountType), account, password);
	}

	@Override
	public Nurse getByEmail(String email) {
		
		return service.getByEmail(email);
	}

}
