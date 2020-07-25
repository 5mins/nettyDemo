package com.naaisi.nursesite.uitl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class ReflectionUtils {

	/**
	 * 根据方法名调用指定对象的方法
	 * 
	 * @param object 要调用方法的对象
	 * @param method 要调用的方法名
	 * @param args   参数对象数组
	 * @return
	 */
	public Object invoke(Object object, String method, Object... args) {
		Object result = null;
		Class<? extends Object> clazz = object.getClass();
		Method queryMethod = getMethod(clazz, method, args);
		if (queryMethod != null) {
			try {
				result = queryMethod.invoke(object, args);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		} else {
			try {
				throw new NoSuchMethodException(clazz.getName() + " 类中没有找到 " + method + " 方法。");
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 根据方法名和参数对象查找方法
	 * 
	 * @param clazz
	 * @param name
	 * @param args  参数实例数据
	 * @return
	 */
	public Method getMethod(Class<? extends Object> clazz, String name, Object[] args) {
		Method queryMethod = null;
		Method[] methods = clazz.getMethods();
		for (Method method : methods) {
			if (method.getName().equals(name)) {
				Class<?>[] parameterTypes = method.getParameterTypes();
				// 判断传递的参数个数是否与方法参数的个数相同，可能存在重载的方法
				if (parameterTypes.length == args.length) {
					boolean isSameMethod = true;
					// 判断传递的参数类型是否与方法参数类型相同
					for (int i = 0; i < parameterTypes.length; i++) {
						Object arg = args[i];
						if (arg == null) {
							arg = "";
						}
						if (!parameterTypes[i].equals(args[i].getClass())) {
							isSameMethod = false;
						}
					}
					if (isSameMethod) {
						queryMethod = method;
						break;
					}
				}
			}
		}
		return queryMethod;
	}

	/**
	 * 用反射执行指定的类中的方法。
	 * 
	 * 
	 **/
	public Object executeRefle(String classname, String MethodName, Object[] args) {
		Object result = null;

		try {
			Class cl = Class.forName(classname);

			Object obj = cl.newInstance();
			if ((args == null) || (args.length == 0)) {// 判断是否有参数传入
				result = invoke(obj, MethodName);

			} else if ((args.length==1)&&("".equals(args[0]))) {

				result = invoke(obj, MethodName);
			}

			else {
				// 执行带参数方法，增加判断

				result = invoke(obj, MethodName, args);

			}

			return result;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	public static void main(String[] args) throws Exception {

		ReflectionUtils refu = new ReflectionUtils();

		String classname = "com.naaisi.nursesite.patient.dao.PatientDao";
		classname = classname + "Impl";

		// 寻找名称的类文件，加载进内存 产生class对象
		Class cl = Class.forName(classname);
		Object obj = cl.newInstance();

//		 System.out.println("================获取所有的方法=================");
//	        Method[] declaredMethods=cl.getDeclaredMethods();
//	        for (Method declaredmethod:declaredMethods) {
//	            System.out.println("所有方法:"+declaredmethod);
//	        }
//        

		// Object result = invoke(obj, "findAll");
		// Object result = invoke(obj, "findByPatientName","柴进");
		// Object result = invoke(obj, "delByPatientId","33");
		// Object result = invoke(obj, "findById","3");
//		Object result = refu.invoke(obj, "updatePatient", "33");
//
//		System.out.println(result);
//		// Method Person_public_prin = getMethod(cl, "findAll",null);

	}
}