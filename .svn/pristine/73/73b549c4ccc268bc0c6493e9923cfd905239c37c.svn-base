package com.sojson.gorgeousturn.controller;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock   比 synchronized 更加面向对象
 * 多个读锁不互斥  读锁与写锁互斥 写锁与写锁互斥 z
 * 
 * 若是读写分离  要用读写锁 不能用lock 否则都锁上了
 * 要用readwriteLocak rwl= new ReentrantReadWritelock
 * 
 * */
public class TraditionalThreadLockTest {

	public static void main(String[] args) {
		new TraditionalThreadLockTest().init();
		
	}
	
	public void init() {

		Outputer  outputer =new  Outputer();
	    new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					outputer.output("wandianjie");
				}
				
			}
		}).start();
	    
	    
       new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					outputer.output("yangqianru");
				}
				
			}
		}).start();

	
	}
	
	static class Outputer{
		Lock lock =new ReentrantLock();
		
		String XXX="";
		public void output(String name){
			int len = name.length();
			//synchronized (XXX)//锁 一定要同一个 对象   outputer（）.output("yangqianru");  这就是两个对象
			
			lock.lock();
			try {
				for(int i=0;i<len;i++) {
					  System.out.print(name.charAt(i));	
					}
					System.out.println();
			} finally {
				lock.unlock();
			}
				
		}
		
		public synchronized void output2(String name){// synchronized 在一段代码中只能用一次  要不会出现死锁的问题
			int len = name.length();
			//synchronized (XXX)//锁 一定要同一个 对象   outputer（）.output("yangqianru");  这就是两个对象
			
			{//互斥
				for(int i=0;i<len;i++) {
					  System.out.print(name.charAt(i));	
					}
					System.out.println();
			}
		}
		
		
		public static synchronized void output3(String name){// 静态变量的锁解析的是自解码  想要 output  和 output3 互斥 就要  output  synchronized (Outputer。class ) 调用同一个对象 
			int len = name.length();
			//synchronized (XXX)//锁 一定要同一个 对象   outputer（）.output("yangqianru");  这就是两个对象
			
			{//互斥
				for(int i=0;i<len;i++) {
					  System.out.print(name.charAt(i));	
					}
					System.out.println();
			}
		}
	}

}
