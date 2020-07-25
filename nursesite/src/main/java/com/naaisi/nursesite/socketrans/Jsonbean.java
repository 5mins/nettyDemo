package com.naaisi.nursesite.socketrans;

import java.util.ArrayList;
import java.util.Arrays;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.naaisi.nursesite.uitl.ReflectionUtils;

//回传消息用的bean 模板
public class Jsonbean {

	private String requestID;// 随机数，时间戳都可以，做唯一标识符

	private String requestClassName;// 请求的类名

	private String requestMethodName;// 请求的方法名

	//private int requesParaNum;// 定义参数个数

	//private String requestPara;// 请求参数集 字符串数组
	
	private Object requestPara;// 请求参数集 字符串数组

	private String remark;// 留空，备用


	private Object result;// 请求结果集


	
	
	
	

	public String getRequestID() {
		return requestID;
	}







	public void setRequestID(String requestID) {
		this.requestID = requestID;
	}







	public String getRequestClassName() {
		return requestClassName;
	}







	public void setRequestClassName(String requestClassName) {
		this.requestClassName = requestClassName;
	}







	public String getRequestMethodName() {
		return requestMethodName;
	}







	public void setRequestMethodName(String requestMethodName) {
		this.requestMethodName = requestMethodName;
	}







	public Object getRequestPara() {
		return requestPara;
	}







	public void setRequestPara(Object requestPara) {
		this.requestPara = requestPara;
	}







	public String getRemark() {
		return remark;
	}







	public void setRemark(String remark) {
		this.remark = remark;
	}







	public Object getResult() {
		return result;
	}







	public void setResult(Object result) {
		this.result = result;
	}







	public static void main(String[] args) {

	}

}
