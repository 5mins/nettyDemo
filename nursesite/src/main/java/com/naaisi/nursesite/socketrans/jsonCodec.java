package com.naaisi.nursesite.socketrans;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.naaisi.nursesite.uitl.DateTools;

//接收消息解码用的bean
public class jsonCodec {

//////////

	// 回传结果给客户端，json编码
	public  Object jsonEncode(String requestID, String requestClassName, String requestMethodName,
			String remark, Object[] requesPara, Object result) {

		Jsonbean prb = new Jsonbean();
		prb.setRequestID(requestID);
		prb.setRequestClassName(requestClassName);
		prb.setRequestMethodName(requestMethodName);
		prb.setRemark(remark);
		prb.setRequestPara(requesPara);
		// prb.setRequesParaNum(requesParaNum);
		// Object innerResult = JSON.toJSONString(result);//result to jsonString
		prb.setResult(result);

		Object prbJson = JSON.toJSONString(prb);

		return prbJson;

	}

	// json字符串解码
	public  Jsonbean jsonDecode(String msg) {

		if (!jsonCodec.isJSONValid(msg)) {
			return null;
		}

		Jsonbean jsonbean = new Jsonbean();
		JSONObject req_bean;
		// 处理参数
		req_bean = (JSONObject) JSON.parse(msg);
		jsonbean.setRequestID((String) req_bean.get("requestID"));

		String requestClassName = (String) req_bean.get("requestClassName");
		jsonbean.setRequestClassName(requestClassName);
		String requestClassNamefull = getClsssFullName(requestClassName);//"com.naaisi.nursesite.appservicesApi.S" + requestClassName;// 自动添加类路径,后期加判断消息来源。

		String requestMethodName = (String) req_bean.get("requestMethodName");
		jsonbean.setRequestMethodName(requestMethodName);

		jsonbean.setRemark((String) req_bean.get("remark"));
		// 对参数解码，生成list
		Object jsObjpara = req_bean.get("requestPara");// 处理参数
		String requesPara = "";
		Object[] paralist = null;
		if (jsObjpara != null) {
			// requesPara = jsObjpara.toString();// 回传字符串。
			paralist = JsonParaToList(jsObjpara, requestClassNamefull, requestMethodName);

		}

		jsonbean.setRequestPara(paralist);
		return jsonbean;

	}

	// 将客户端传来的方法参数json转成对应的数组
	public  Object[] JsonParaToList(Object requestPara, String requestClassName, String requestMethodName) {

		// 判断JsonArray
		try {
			if (requestPara.getClass() == JSONArray.class) {

				JSONArray jsarr = (JSONArray) requestPara;

				// 取得传入JSONObject 的大小，再根据大小生成Objectlist
				if (!jsarr.isEmpty()) {
					int size = jsarr.size();
					// 取得对应参数的类型
					Class cl = Class.forName(requestClassName);
					Method[] methods = cl.getMethods();
					for (Method method : methods) {
						if (method.getName().equals(requestMethodName)) {
							Class<?>[] parameterTypes = method.getParameterTypes();
							// 判断传递的参数个数是否与方法参数的个数相同，可能存在重载的方法
							if (parameterTypes.length == size) {
								// boolean isSameMethod = true;
								Object[] reOBjList = new Object[size];

								for (int i = 0; i < size; i++) {
									// Class<?> class1 = parameterTypes[i];
									// System.out.println(class1);
									reOBjList[i] = parameterTypes[i].cast(jsarr.get(i));// 将参数转换成对应类型

								}

								return reOBjList;

							}

						}
					}

//					//获取对应的bean,并按顺序添加进Object[] 

					// System.out.println(reOBjList);
					return null;

				}

			} else {

				System.out.println("传入OBJECT类型未知");

			}

		} catch (Exception e) {
			System.out.println(e);

		}
		System.out.println("null");
		return null;

	}

	public final static boolean isJSONValid(String test) {
		try {
			JSONObject.parseObject(test);
		} catch (JSONException ex) {
			try {
				JSONObject.parseArray(test);
			} catch (JSONException ex1) {
				return false;
			}
		}
		return true;
	}

	// 返回完整类路径
	public static String getClsssFullName(String clsssName) {

		return "com.naaisi.nursesite.appservicesApi.S" + clsssName;// 自动添加类路径,后期加判断消息来源。

		

	}
	
	// 模拟app端json编码
	private static String appEncodeTest() {

		Jsonbean appbean = new Jsonbean();
		appbean.setRemark("1");
		appbean.setRequestClassName("IEat");
		appbean.setRequestMethodName("getByID");
		appbean.setRequestID("001");

		String[] para = new String[1];
		para[0] = "1";
//		para[1]="0";
//		para[2]="22";
		appbean.setRequestPara(para);
		String prbJson = JSON.toJSONString(appbean);

		return prbJson;

	}

//	//可以生成"查找所有"所需的json
//	private static String findAllTest() {
//
//		PubRetrunBeanNew pdb = new PubRetrunBeanNew();
//		pdb.setRequestNum("0001");
//		pdb.setRequestClassName("docAdvice");
//		pdb.setRequestMethodName("findAll");
//		pdb.setRemark("");
//		pdb.setRequesParaNum(0);//无参方法或者参数是普通字符类型的，填0
//
//
//		pdb.setRequestPara("");//这是无参方法，此处可以留空或者不填
//
//		// 生成json
//		String ParaJson = JSON.toJSONString(pdb);//调用阿里的fastjson
//		return ParaJson;
//
//	}

	// 可以生成"注册一个病人"所需的json
//	private static String creatAPatienTest() {
//
//		PubResultDecodeBean pdb = new PubResultDecodeBean();
//		pdb.setRequestNum("0001");
//		pdb.setRequestClassName("com.naaisi.nursesite.patient.service.PatientServiceImpl");//类路径
//		pdb.setRequestMethodName("register");//方法名
//		pdb.setRemark("");
//		pdb.setRequesParaType("2");
//		// 特殊参数
//		PubResultParaBean parabean = new PubResultParaBean();
//		// 添加一个病人
//		Patient patient = new Patient();
//		patient.setPatient_name("testPara");
//		patient.setSex("男");
//
//		parabean.setParaClassName("com.naaisi.nursesite.patient.domain.Patient");//参数所属的类路径
//		parabean.setParaOrder("1");//表示第一个参数
//		parabean.setParaObject(patient);
//		// 生成参数数组列表
//		PubResultParaBean[] pubResultParaBean = new PubResultParaBean[1];
//		pubResultParaBean[0] = parabean;
//
//		pdb.setRequestPara(pubResultParaBean);
//
//		// 生成json
//		String ParaJson = JSON.toJSONString(pdb);//调用阿里的fastjson
//		return ParaJson;
//
//	}
	// 可以生成修改一个病人"所需的json
//	private static String modifyAPatienTest() {
//
//		PubResultDecodeBean pdb = new PubResultDecodeBean();
//		pdb.setRequestNum("0002");
//		pdb.setRequestClassName("com.naaisi.nursesite.patient.service.PatientServiceImpl");
//		pdb.setRequestMethodName("modifyPatient");
//		pdb.setRemark("");
//		pdb.setRequesParaType("2");//因为需要传入一个病人bean,所以是特殊参数，这里改成2
//		// 特殊参数
//		PubResultParaBean parabean1 = new PubResultParaBean();
//		// 修改一个病人
//		Patient patient = new Patient();
//		patient.setPatient_name("testPara");
//		patient.setSex("0");
//		patient.setPatient_id("41");
//
//		parabean1.setParaClassName("com.naaisi.nursesite.patient.domain.Patient");
//		parabean1.setParaOrder("1");
//		parabean1.setParaObject(patient);
//		// 生成参数数组列表
//		PubResultParaBean[] pubResultParaBean = new PubResultParaBean[1];
//		pubResultParaBean[0] = parabean1;
//		pdb.setRequestPara(pubResultParaBean);
//
//		// 生成json
//		String ParaJson = JSON.toJSONString(pdb);//调用阿里的fastjson
//		return ParaJson;
//
//	}
	// update"所需的json
//	private static String updatadviceTest() throws ParseException {
//
//		PubResultDecodeBeanNew pdb = new PubResultDecodeBeanNew();
//		pdb.setRequestNum("0002");
//		pdb.setRequestClassName("docAdvice");
//		pdb.setRequestMethodName("save");
//		pdb.setRemark("");
//		pdb.setRequesParaType("2");//因为需要传入一个病人bean,所以是特殊参数，这里改成2
//		// 特殊参数
//		PubResultParaBean parabean1 = new PubResultParaBean();
//		// 修改一个病人
//		DocAdvice updatedomain = new DocAdvice();
//		updatedomain.setADVICE("别喝水");
//		//updatedomain.setID("1");
//		updatedomain.setPATIENT_ID("3");
//		String sToTimestamp = "2020-4-18 14:21:12.123";// 用于转换成java.sql.Timestamp的字符串
//		Timestamp date2 = DateTools.string2Time(sToTimestamp);
//		updatedomain.setPRE_EXE_TIME(date2);
//		
//		parabean1.setParaClassName("docAdvice");
//		parabean1.setParaOrder("1");
//		parabean1.setParaObject(updatedomain);
//		// 生成参数数组列表
//		PubResultParaBean[] pubResultParaBean = new PubResultParaBean[1];
//		pubResultParaBean[0] = parabean1;
//		pdb.setRequestPara(pubResultParaBean);
//
//		// 生成json
//		String ParaJson = JSON.toJSONString(pdb);//调用阿里的fastjson
//		return ParaJson;
//
//	}

	/////////////

	public static void main(String[] args) throws Exception {

		System.out.println(appEncodeTest());

		// TODO Auto-generated method stub

	}

}
