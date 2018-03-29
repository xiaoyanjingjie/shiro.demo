package com.sojson.gorgeousturn.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 实现读写锁的应用
 * 先进来的是先加读锁  不会影响数据 当没有数据的时候 加上写锁 解除读锁
 * 
 * */
public class CacheDemo {
    private Map<String , Object> cache =new HashMap<String,Object>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private ReadWriteLock rwl =new ReentrantReadWriteLock();
	public  Object getData(String key) {
		rwl.readLock().lock();
		Object value=null;
		try {
			 value=cache.get(key);
			if(value == null) {
				rwl.readLock().unlock();
				rwl.writeLock().lock();//当多个线程在等待着写入的 时候 第一个线程已经写好了  现在需要在加一次判断 让其他的线程不要在写入了 即可 多加了一个 if  可根据jdk文档判断
				try {
					if(value ==null) {
						value ="aaaa";	
					}
					
				} finally {
					rwl.writeLock().unlock();
				}
				rwl.readLock().lock();
			}
		} finally{
			rwl.readLock().unlock();
		}
		
		
		return value;
		
	}
	

}
