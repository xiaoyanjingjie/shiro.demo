package com.sojson.gorgeousturn.controller;

import java.util.Random;
/**
 * 
 * 线程变量共享 同一个线程上的数据相同
 * 用单例模式
 * 

 * 
 * 
 * */
public class TheradlocalThread {
	private static ThreadLocal<Integer> x= new ThreadLocal<Integer>();  //ThreadLocal 存放当前线程的数据
	public static void main(String[] args) {
       for(int i=0 ;i<2 ; i++) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
             int   data=new Random().nextInt();	
              System.out.println(Thread.currentThread().getName()+" has put data :"+ data);
              x.set(data);//往当前线程存放数数据
              MyThreadScopeData.getInstance().setName("name"+data);
              MyThreadScopeData.getInstance().setAge(data);
              new A().get();
              new B().get();
             // new C().get();
			}
		}).start();
       }	
		
	}
    
	static class A{
		public void get() {
		  int data=x.get();
			System.out.println(" A from "+ Thread.currentThread().getName()+" get data :"+ data);
			MyThreadScopeData myData =MyThreadScopeData.getInstance();
			System.out.println(" A from "+ Thread.currentThread().getName()+" get my data :"+ 
			myData.getAge() +" name "+ myData.getName());
			
		}
	}
	static class B{
		public void get() {
		  int data=x.get();
			System.out.println(" B from "+ Thread.currentThread().getName()+" get  data :"+ data);
			
			MyThreadScopeData myData =MyThreadScopeData.getInstance();
			System.out.println(" B from "+ Thread.currentThread().getName()+" get my data :"+ 
			myData.getAge() +" name "+ myData.getName());
		}
	}
	
}
class MyThreadScopeData{
	//创建单利模式
	private MyThreadScopeData () {};
	//private static MyThreadScopeData instance =null;
	public static /*synchronized*/ MyThreadScopeData getInstance() {
		MyThreadScopeData instance =map.get();
		if(instance ==null) {
			instance=new MyThreadScopeData();
			map.set(instance);
		}
		return instance;
	}
	private static ThreadLocal<MyThreadScopeData> map =new ThreadLocal<MyThreadScopeData>();
	
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
