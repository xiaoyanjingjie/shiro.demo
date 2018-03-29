package com.sojson.gorgeousturn.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 
 * simaphore 实现信号灯 
 * 可以维护当前访问自身的额线程个数  并提供了同步机制  。使用Semaphore可以控制同时i访问的资源线程的个数  
 * 
 * eg:厕所五个坑 十个人来 
 * 
 * */
public class SemaphoreTest {

	public static void main(String[] args) {
       ExecutorService service  = Executors.newCachedThreadPool();
       final Semaphore sp =new Semaphore(3);
       for(int i =0 ; i <= 10 ;  i ++){
    	    Runnable runnable =new Runnable() {
				
				@Override
				public void run() {
                   try {
					sp.acquire();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
                   
                  System.out.println("线程"+Thread.currentThread().getName()+"进入 ，当前已有"+(3-sp.availablePermits()+"并发"));
                  
                  try {
					Thread.sleep((long) (Math.random()*10000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                  System.out.println("线程"+Thread.currentThread().getName()+"即将离开");
                  sp.release();
				}
			};
			service.execute(runnable);
       }
	}

}
