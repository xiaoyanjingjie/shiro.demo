package com.sojson.gorgeousturn.controller;

/** 
 * 
 *  * 设计4个线程 其中两个每次对县城j + 1  ling外两个每次 一 1  （或者是买票系统）
 *  
 * 
 * */
public class MultiThreadShareData {

	public static void main(String[] args) {
	  final ShareData1 data1 =new ShareData1();	 //封装在同一对象（data1）中
    /*  new Thread(data1).start();
      new Thread(data1).start();*/
	   new Thread( new Runnable() {
		public void run() {
			data1.decrement();
		}
	    }).start();
	   
	   new Thread(new Runnable() {
		
		@Override
		public void run() {
			data1.increment();
		}
	}).start();
     
	}

}

 class ShareData1 implements Runnable{
	 private int count = 100;// 卖票系统  一个对象 count   我们现在写的例子是i两个对象  一次加  一次减
	 
	 int j =0;
	public synchronized void increment() {
		j++;
		System.out.println("j++:"+j);
	}
	public synchronized void decrement() {
		j--;
		System.out.println("j--:"+j);
	}
	@Override
	public void run() {
     // while(true) {
    	  count --;
    	  System.out.println(count);
      //}		
	}
 }
