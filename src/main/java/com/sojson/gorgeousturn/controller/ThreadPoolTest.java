package com.sojson.gorgeousturn.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * java5 已经提供了线程池的
 * 
 * 
 * */
public class ThreadPoolTest {

	public static void main(String[] args) {
		// 创建线程池
		//ExecutorService threadPool=Executors.newFixedThreadPool(3);//创建固定的线程池
		//ExecutorService threadPool=Executors.newCachedThreadPool();//创建动态的线程池
		ExecutorService threadPool=Executors.newSingleThreadExecutor();//只有一个线程
		for (int i = 1; i <= 10; i++) {
			final int task=i;
			threadPool.execute(new Runnable() {

				@Override
				public void run() {
					for (int j = 1; j <= 10; j++) {
						try {
							Thread.sleep(20);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + " is looping of " + j +" for task of " + task);
					}
				}
			});

		}
		System.out.println("all of 10 hava commited!");
		/*threadPool.shutdown();//
		threadPool.shutdownNow();//
		
*/	
		//定时器  schedule 固定时间   scheduleAtFixedRate  固定频率  
		Executors.newScheduledThreadPool(3).schedule(new Runnable() {
			
			@Override
			public void run() {
             System.out.println("bombing~~~");				
			}
		}, 10,TimeUnit.SECONDS);
	}
}
