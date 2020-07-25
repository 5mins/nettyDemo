package com.naaisi.nursesite.appservicesApi;

import java.sql.Timestamp;
import java.util.List;

import com.naaisi.nursesite.memo.domain.Memo;
import com.naaisi.nursesite.memo.service.MemoService;
import com.naaisi.nursesite.memo.service.MemoServiceImpl;
import com.naaisi.nursesite.uitl.DateTools;

/**
 * @author lizihao
 *
 */
public class SMemo implements IMemo {

	private MemoService service;

	public SMemo() {

		MemoService service = new MemoServiceImpl();
		this.service = service;
	}

	@Override
	public boolean addMemo(String tITLE, String cONTENT, String cREATED_TIME) {
		Timestamp timestamp = DateTools.string2Time(cREATED_TIME);
		// Timestamp timestamp = new java.sql.Timestamp(Long.parseLong(cREATED_TIME));
		return service.addMemo(tITLE, cONTENT, timestamp);
	}
	
	@Override
	public String addMemo1(String tITLE, String cONTENT, String cREATED_TIME) {
		Timestamp timestamp = DateTools.string2Time(cREATED_TIME);
		// Timestamp timestamp = new java.sql.Timestamp(Long.parseLong(cREATED_TIME));
		return service.addMemo1(tITLE, cONTENT, timestamp)+"";
	}

	@Override
	public boolean setMemoToFinish(String MemoID) {
		return service.setMemoToFinish(Integer.parseInt(MemoID));
	}

	@Override
	public boolean setMemoToUnFinish(String MemoID) {
		return service.setMemoToUnFinish(Integer.parseInt(MemoID));
	}

	@Override
	public List<Memo> getMemoList() {

		return service.getMemoList();
	}

	@Override
	public boolean updateMemoByID(String MemoID, String cONTENT) {

		return service.updateMemoByID(Integer.parseInt(MemoID), cONTENT);
	}

	@Override
	public boolean deleteMemoByID(String MemoID) {

		return service.deleteMemoByID(Integer.parseInt(MemoID));
	}

	@Override
	public boolean updateMemoByID(String MemoID, String tITLE, String cONTENT) {
		return service.updateMemoByID(Integer.parseInt(MemoID), tITLE,cONTENT);
	}



}
