package com.naaisi.nursesite.appservicesApi;

import java.util.List;

import com.naaisi.nursesite.memo.domain.Memo;

/**
 * @author lizihao
 *
 */
public interface IMemo {
	
	
	/**添加备忘记录  权限管理未完成,默认添加到07用户的备忘
	 * @param tITLE  标题
	 * @param cONTENT 内容
	 * @param cREATED_TIME 创建时间 (时间戳)
	 * @return
	 */
	boolean addMemo(String tITLE, String cONTENT, String cREATED_TIME);
	
	/**添加备忘记录  权限管理未完成,默认添加到07用户的备忘 （带错误返回码）
	 * @param tITLE  标题
	 * @param cONTENT 内容
	 * @param cREATED_TIME 创建时间 (时间戳)
	 * @return 正常返回MemoID，失败返回-1
	 */
	String addMemo1(String tITLE, String cONTENT, String cREATED_TIME);

	/**
	 * 将备忘状态修改为已完成。
	 * 
	 * @param domain
	 * @return
	 */
	boolean setMemoToFinish(String MemoID);

	/**
	 * 将备忘状态修改为未完成。
	 * 
	 * @param domain
	 * @return
	 */
	boolean setMemoToUnFinish(String MemoID);

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
	 * @param cONTENT 内容
	 * @return
	 */
	boolean updateMemoByID(String MemoID,String cONTENT);
	
	/**
	 *  通过memoID修改备忘。new
	 * 
	 * @param memoID
	 * @param tITLE 标题
	 * @param cONTENT 内容
	 * @return
	 */
	boolean updateMemoByID(String MemoID,String tITLE,String cONTENT);
	
	/**
	 *  通过memoID删除备忘。
	 * 
	 * @param memoID
	 * @param cONTENT 内容
	 * @return
	 */
	boolean deleteMemoByID(String MemoID);
	

}
