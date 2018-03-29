package com.sojson.gorgeousturn.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
public class MyThread01Controller{
	/**
	 * wan.dj
	 * 20180129
	 * 学习定时器  Thread  TimerTask  每隔 2 4 2 4 2 4 2
 	 *循环执行计划任务
 	 *
 	 * 不能在非静态内部类型中声明静态
	 * 
	 * */
	private static int count  = 0;
public static void main(String[] args) throws ParseException {
	
	@SuppressWarnings("unused")
	class timesc extends TimerTask{
		
		@Override
		public void run() {
			count=(count+1)%2;
			// TODO Auto-generated method stub
			System.out.println(" 学习定时器  Thread  TimerTask  每隔 2 4 2 4 2 4 2 循环执行计划任务"+count);
			new Timer().schedule(new timesc(), 2000*(count+1));
			
		}
		
	} 
	@SuppressWarnings("deprecation")
	Date dd=new Date();
	String str = "2018-01-30 16:11:00"; 
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	Date date = sdf.parse(str);
	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    System.out.println(date);
	new Timer().schedule(new timesc(),date);
	//new Timer().schedule(new timesc(),sdf.format(dd));
	while(true) {
		System.out.println(new Date().getSeconds());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
  }
}