package com.naaisi.nursesite.socketrans;

import java.lang.reflect.Method;

import org.hibernate.annotations.common.util.impl.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.naaisi.nursesite.uitl.ReflectionUtils;

//处理客户端文本入口
public class BusinessHandle {
//处理请求的通用方法。
	public Object exeNormal(String msg) {
		String finallyResult = "";
		Object[] paralist = null;
		Object result = null;
		
		//json解码
		jsonCodec Codec = new jsonCodec();
		Jsonbean jBean = Codec.jsonDecode(msg);
		
		paralist = (Object[]) jBean.getRequestPara();
		String requestClassName = jBean.getRequestClassName();
		String requestClassFullName = jsonCodec.getClsssFullName(requestClassName);
		
		String requestMethodName = jBean.getRequestMethodName();
		
		ReflectionUtils refu = new ReflectionUtils();
		// 处理参数
		if (paralist != null && paralist.length >= 0) {//

			// 开始执行参数指定的类的方法

			result = refu.executeRefle(requestClassFullName, requestMethodName, paralist);
			// 执行完毕，获取整理结果

		} else if (paralist == null) {
			Object[] list = new Object[0];
			result = refu.executeRefle(requestClassFullName, requestMethodName, list);
			//

		} else {
			System.out.println("未知参数类型");

		}
		finallyResult = (String) Codec.jsonEncode(jBean.getRequestID(), requestClassName, requestMethodName, jBean.getRemark(), paralist,
				result);
		return finallyResult;

	}









	public static void main(String[] args) {

		String reqtext = "{\"remark\":\"1\",\"requestClassName\":\"Patient\",\"requestID\":\"001\",\"requestMethodName\":\"addPatient\",\"requestPara\":[\"testname\",\"0\",\"22\"]}";

		BusinessHandle msh = new BusinessHandle();

		System.out.println(msh.exeNormal(reqtext));
		System.out.println("11");
		
		
	}

}
