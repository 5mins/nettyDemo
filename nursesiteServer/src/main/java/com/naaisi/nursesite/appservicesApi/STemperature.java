package com.naaisi.nursesite.appservicesApi;

import java.util.List;

import com.naaisi.nursesite.temperature.domain.Temperature;
import com.naaisi.nursesite.temperature.service.TemperatureService;
import com.naaisi.nursesite.temperature.service.TemperatureServiceImpl;

/**
 * @author lizihao
 *
 */
public class STemperature implements ITemperature {

	private TemperatureService service;

	public STemperature() {

		TemperatureService service = new TemperatureServiceImpl();
		this.service = service;
	}

	@Override
	public boolean setTemperatureInvalid(String id) {

		return service.setTemperatureInvalid(Integer.parseInt(id));
	}

	@Override
	public boolean setTemperatureValid(String id) {
		return service.setTemperatureValid(Integer.parseInt(id));
	}

	@Override
	public List<Temperature> getTemperatureList(String patientId) {

		return service.getTemperatureList(Integer.parseInt(patientId));
	}

	@Override
	public List<Temperature> getLast15Temperature(String patientId) {

		return service.getLast15Temperature(Integer.parseInt(patientId));
	}

	@Override
	public boolean addTemperature(String tEMPERATURE, String pATIENT_ID) {
		return service.addTemperature(Double.valueOf(tEMPERATURE.toString()), Integer.parseInt(pATIENT_ID),7);//默认由07创建
	}

	@Override
	public boolean updateTemperature(String tEMPERATURE, String tEMPERATURE_ID) {
		
		return service.updateTemperature(Double.valueOf(tEMPERATURE.toString()), Integer.parseInt(tEMPERATURE_ID));
	}

	@Override
	public String addTemperature1(String tEMPERATURE, String pATIENT_ID) {
		
		return service.addTemperature1(Double.valueOf(tEMPERATURE.toString()), Integer.parseInt(pATIENT_ID),7)+"";//默认由07创建
	}

	@Override
	public boolean deleteTemperature(String tEMPERATURE_ID) {
		
		return service.deleteTemperature(Integer.parseInt(tEMPERATURE_ID));
	}

	@Override
	public boolean deleteAllTemperatureByPatientID(String pATIENT_ID) {
		
		return service.deleteAllTemperatureByPatientID(Integer.parseInt(pATIENT_ID));
	}

}
