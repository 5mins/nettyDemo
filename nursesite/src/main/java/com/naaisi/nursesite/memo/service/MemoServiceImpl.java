package com.naaisi.nursesite.memo.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.naaisi.nursesite.memo.dao.MemoDao;
import com.naaisi.nursesite.memo.dao.MemoDaoImpl;
import com.naaisi.nursesite.memo.domain.Memo;
import com.naaisi.nursesite.temperature.domain.Temperature;



/**
 * @author lizihao
 *
 */

public class MemoServiceImpl implements MemoService {

	private MemoDao dao;

	public MemoServiceImpl() {
		super();
		MemoDao dao = new MemoDaoImpl();
		this.dao = dao;
	}

	
	

	
	/**添加备忘记录  权限管理未完成,默认添加到07用户的备忘
	 * @param tITLE  标题
	 * @param cONTENT 内容
	 * @return
	 */
	@Override
	public boolean addMemo(String tITLE,String cONTENT,Timestamp cREATED_TIME) {
		Memo domain = new Memo();
		domain.setTITLE(tITLE);
		domain.setCONTENT(cONTENT);
		domain.setCREATED_BY(7);//预留，等权限管理模块完善在做这个。
//		Date date = new Date();
//		Timestamp timenow = new Timestamp(date.getTime());
		domain.setCREATED_TIME(cREATED_TIME);//看客户端支不支持设定时间
		return dao.save(domain);
		
	}
	
	/**
	 * // 将备忘状态修改为已完成。1已完成，0未完成
	 * 
	 * @param domain
	 * @return
	 */
	@Override
	public boolean setMemoToFinish(int MemoID) {
		
		Memo domain = dao.findByID(MemoID);
		domain.setSTATE(1);
		return dao.update(domain);
		
	}
	
	/**
	 * // 将备忘状态修改为未完成。1已完成，0未完成
	 * 
	 * @param domain
	 * @return
	 */
	@Override
	public boolean setMemoToUnFinish(int MemoID) {
		
		Memo domain = dao.findByID(MemoID);
		domain.setSTATE(0);
		return dao.update(domain);
		
	}


	
	/**
	 * 获取用户所有备忘记录，权限管理未完成,默认返回07用户的备忘
	 * 
	 * @param nurseID
	 * @return List<Memo>
	 */
	@Override
	public List<Memo> getMemoList() {

		return dao.findAllByNurseID(7);//debug

	};




	@Override
	public boolean updateMemoByID(int MemoID, String cONTENT) {
		Memo domain = dao.findByID(MemoID);
		if (domain != null) {
			domain.setCONTENT(cONTENT);
		} else {
			return false;

		}

		return dao.update(domain);
	}





	@Override
	public boolean deleteMemoByID(int MemoID) {
		Memo domain = dao.findByID(MemoID);
		if (domain != null) {
			return dao.delete(domain);
		} else {
			return false;
		}

		
	}





	@Override
	public boolean updateMemoByID(int MemoID, String tITLE, String cONTENT) {
		Memo domain = dao.findByID(MemoID);
		if (domain != null) {
			domain.setTITLE(tITLE);
			domain.setCONTENT(cONTENT);
		} else {
			return false;

		}

		return dao.update(domain);
	}





	@Override
	public int addMemo1(String tITLE, String cONTENT, Timestamp cREATED_TIME) {
		Memo domain = new Memo();
		domain.setTITLE(tITLE);
		domain.setCONTENT(cONTENT);
		domain.setCREATED_BY(7);//预留，等权限管理模块完善在做这个。
//		Date date = new Date();
//		Timestamp timenow = new Timestamp(date.getTime());
		domain.setCREATED_TIME(cREATED_TIME);//看客户端支不支持设定时间
		return dao.save1(domain);
	}

}