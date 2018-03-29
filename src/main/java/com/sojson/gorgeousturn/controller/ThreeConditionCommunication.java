package com.sojson.gorgeousturn.controller;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程面试题
 * 
 * 
 *condition  是继lock上的    
 *
 * 子线程循环10次 接着主线程在执行100次  接着在子线程在执行10次 主线程在执行100 如此执行50次
 * 
 * m
 * 
 * 
 * 
 * */
public class ThreeConditionCommunication {

	public static void main(String[] args) {
   final Business business = new Business();
		new Thread(new Runnable() {
			@Override
			public void run() {
			 for(int i =1 ; i< 50 ;i++) {
              business.sub2(i);    
			  
			 }
			}
		}).start();
      
		
		/*for(int i =1 ; i< 50 ;i++) { 
			business.main(i);
		}
		*/
		
		new Thread(new Runnable() {
			@Override
			public void run() {
			 for(int i =1 ; i< 50 ;i++) {
              business.main(i);    
			  
			 }
			}
		}).start();
		new Thread(new Runnable() {
			@Override
			public void run() {
			 for(int i =1 ; i< 50 ;i++) {
              business.sub3(i);    
			  
			 }
			}
		}).start();
		
	}



	static  class Business{//相同业务代码放在一起 要形成这种变成规范
		private int shouldSub = 1;
		Lock lock =new ReentrantLock();
		Condition condition1 =lock.newCondition();
		Condition condition2 =lock.newCondition();
		Condition condition3 =lock.newCondition();
		public  void sub2(int i) {
			lock.lock();
			try {
			while(shouldSub != 2) {//注意 要用 weile 用if 可能是伪唤醒
				try {
					condition2.await();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for(int j = 1 ; j < 10;j++){
		    	   System.out.println("sub2 thread sequece of " + j + " loop of " +  i );
		       }
			shouldSub= 3;
			condition3.signal();
			} finally {
				lock.unlock();
			}
		}
		
		public  void sub3(int i) {
			lock.lock();
			try {
			while(shouldSub!=3) {//注意 要用 weile 用if 可能是伪唤醒
				try {
					condition3.await();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for(int j = 1 ; j < 20;j++){
		    	   System.out.println("sub3 thread sequece of " + j + " loop of " +  i );
		       }
			shouldSub= 1;
			condition1.signal();
			} finally {
				lock.unlock();
			}
		}
		public  void main(int i) {
			lock.lock();
			try {
				while(shouldSub!=1) {
					try {
						condition1.await();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        	}
				 for(int j = 1 ; j < 100;j++){
			    	   System.out.println("main thread sequece of " + j + " loop of " +  i);
			       }	
				 shouldSub = 2;
				condition2.signal();
			} finally {
				lock.unlock();
			}
			
		}
		
	}
}
