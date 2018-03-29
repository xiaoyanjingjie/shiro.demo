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
 * 替代了  wait 和  nodify
 * 
 * 
 * 
 * */
public class ConditionCommunication {

	public static void main(String[] args) {
   final Business business = new Business();
		new Thread(new Runnable() {
			@Override
			public void run() {
			 for(int i =1 ; i< 50 ;i++) {
              business.sub(i);    
			  
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
		
	}



	static  class Business{//相同业务代码放在一起 要形成这种变成规范
		private boolean bShouldSub = true;
		Lock lock =new ReentrantLock();
		Condition condition =lock.newCondition();
		public  void sub(int i) {
			lock.lock();
			try {
			while(!bShouldSub) {//注意 要用 weile 用if 可能是伪唤醒
				try {
					condition.await();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for(int j = 1 ; j < 10;j++){
		    	   System.out.println("sub thread sequece of " + j + " loop of " +  i );
		       }
			bShouldSub= false;
			condition.signal();
			} finally {
				lock.unlock();
			}
		}
		public  void main(int i) {
			lock.lock();
			try {
				while(bShouldSub) {
					try {
						condition.await();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        	}
				 for(int j = 1 ; j < 100;j++){
			    	   System.out.println("main thread sequece of " + j + " loop of " +  i);
			       }	
				 bShouldSub = true;
				condition.signal();
			} finally {
				lock.unlock();
			}
			
		}
		
	}
}
