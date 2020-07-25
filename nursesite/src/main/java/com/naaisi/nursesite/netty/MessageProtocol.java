package com.naaisi.nursesite.netty;


//协议包
/**
 * @author lizihao
 *
 */
public class MessageProtocol {
	
	
	public MessageProtocol(int type,String content_str){
		this.type=type;
		this.content_str=content_str;
	
	}
	public MessageProtocol(String content_str){
		this.type=1;
		this.content_str=content_str;
	
	}
	public MessageProtocol( ){

	
	}
	private int signs;//标识
	private int type;//消息类型 ，默认为1 json ，2管理端推送消息，0 普通字符串
//    private int content_len; //长度
//    private byte[] content;//josn
	
    private String content_str;//不用byte[],改成string，上层将byte[]转成string,并计算长度
    
	public int getSigns() {
		return signs;
	}
	public void setSigns(int signs) {
		this.signs = signs;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
//	public int getContent_len() {
//		return content_len;
//	}
//	public void setContent_len(int content_len) {
//		this.content_len = content_len;
//	}
//	public byte[] getContent() {
//		return content;
//	}
//	public void setContent(byte[] content) {
//		this.content = content;
//	}
	public String getContentStr() {
		return content_str;
	}
	public void setContentStr(String content_str) {
		this.content_str = content_str;
	}


}
