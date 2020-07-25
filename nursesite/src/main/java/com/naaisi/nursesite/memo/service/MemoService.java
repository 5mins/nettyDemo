package com.naaisi.nursesite.memo.service;

import java.sql.Timestamp;
import java.util.List;

import com.naaisi.nursesite.memo.domain.Memo;

public interface MemoService {

	/**添加备忘记录  权限管理未完成,默认添加到07用户的备忘
	 * @param tITLE  标题
	 * @param cONTENT 内容
	 * @param cREATED_TIME 创建时间 (时间戳)
	 * @return
	 */
	boolean addMemo(String tITLE, String cONTENT, Timestamp cREATED_TIME);
	
	/**添加备忘记录  权限管理未完成,默认添加到07用户的备忘 （带错误返回码）
	 * @param tITLE  标题
	 * @param cONTENT 内容
	 * @param cREATED_TIME 创建时间 (时间戳)
	 * @return 正常返回MemoID，失败返回-1
	 */
	int addMemo1(String tITLE, String cONTENT, Timestamp cREATED_TIME);

	/**
	 * // 将备忘状态修改为已完成。1已完成，0未完成
	 * 
	 * @param MemoID
	 * @return
	 */
	boolean setMemoToFinish(int MemoID);

	/**
	 * // 将备忘状态修改为未完成。1已完成，0未完成
	 * 
	 * @param MemoID
	 * @return
	 */
	boolean setMemoToUnFinish(int MemoID);

	/**
	 * 获取用户所有备忘记录，权限管理未完成,默认返回07用户的备忘
	 * 
	 * @param nurseID
	 * @return List<Memo>
	 */
	List<Memo> getMemoList();
	
	/**
	 *  通过memoID修改备忘。
	 * 
	 * @param memoID
	 * @param tITLE 标题
	 * @param cONTENT 内容
	 * @return
	 */
	boolean updateMemoByID(int MemoID,String tITLE,String cONTENT);
	
	/**
	 *  通过memoID修改备忘。
	 * 
	 * @param memoID
	 * @param cONTENT 内容
	 * @return
	 */
	boolean updateMemoByID(int MemoID,String cONTENT);
	
	/**
	 *  通过memoID删除备忘。
	 * 
	 * @param memoID
	 * @param cONTENT 内容
	 * @return
	 */
	boolean deleteMemoByID(int MemoID);

	

}