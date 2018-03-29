package com.sojson.gorgeousturn.controller;
/**
 * 线程面试题
 * 
 * 
 *TraditionalThreadSynchronized。class /同一个监视器      只有在同一个组才能使用 多个不能使用 否则要用面向对象的思想 
 * 
 * 
 * 
 * */
public class TraditonnalThreadCommunication {

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

}

class Business{//相同业务代码放在一起 要形成这种变成规范
	private boolean bShouldSub = true;
	public synchronized void sub(int i) {
		while(!bShouldSub) {//注意 要用 weile 用if 可能是伪唤醒
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int j = 1 ; j < 10;j++){
	    	   System.out.println("sub thread sequece of " + j + " loop of " +  i );
	       }
		bShouldSub= false;
		this.notify();
	}
	public synchronized void main(int i) {
		while(bShouldSub) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        	}
		 for(int j = 1 ; j < 100;j++){
	    	   System.out.println("main thread sequece of " + j + " loop of " +  i);
	       }	
		 bShouldSub = true;
		 this.notify();
	}
	
}
