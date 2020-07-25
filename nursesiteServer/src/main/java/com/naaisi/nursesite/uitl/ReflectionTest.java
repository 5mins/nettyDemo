package com.naaisi.nursesite.uitl;

import java.lang.reflect.Method;

public class ReflectionTest {
	
	

	public static void main(String[] args) throws Exception {
		
		
		
		String classname = "com.naaisi.nursesite.patient.dao.PatientDao";
		classname = classname+"Impl";
        //寻找名称的类文件，加载进内存 产生class对象
        Class cl = Class.forName(classname);

        //获取一个Person对象
        System.out.println("获取一个Person对象:");
        Object obj=cl.newInstance();
        System.out.println();
 
 
        //1.获取 公有 无参方法 public void demo2.Person.public_prin()
        //Method Person_public_prin=cl.getMethod("findAll",null);
       // System.out.println("获取执行 public void demo2.Person.public_prin() :");
        //Person_public_prin.invoke(obj,null);
 
        //System.out.println(Person_public_prin.invoke(obj,null));
        
        
//        //2.获取 公有 有参方法 public void demo2.Person.public_show(java.lang.String,int)
        Method Person_public_show=cl.getMethod("findById",long.class);
//       // System.out.println("获取执行 public void demo2.Person.public_show(java.lang.String,int) :");
//       
        System.out.println( Person_public_show.invoke(obj,2));
        
        
		 System.out.println("================获取所有的方法=================");
	        Method[] declaredMethods=cl.getDeclaredMethods();
	        for (Method declaredmethod:declaredMethods) {
	            System.out.println("所有方法:"+declaredmethod);
	        }
        

	}

}
