package com.sojson.gorgeousturn.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * callable  返回的结果用future 拿出来
 * 
 * 
 * 
 * */
public class CallablAndFuture {

	public static void main(String[] args) {
         ExecutorService threadPool = Executors.newSingleThreadExecutor();
         Future<String> future =
         threadPool.submit(new Callable<String>() {
        	 @Override
        	public String  call() throws Exception {
                 Thread.sleep(2000);
        		 return "hello";
        	}
        	 
        	 
		});
         System.out.println("Waiting-------");
         try {
			System.out.println("拿到结果："+future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * CompletionService小结

相比ExecutorService，CompletionService可以更精确和简便地完成异步任务的执行
CompletionService的一个实现是ExecutorCompletionService，它是Executor和BlockingQueue功能的融合体，Executor完成计算任务，BlockingQueue负责保存异步任务的执行结果
在执行大量相互独立和同构的任务时，可以使用CompletionService
CompletionService可以为任务的执行设置时限，主要是通过BlockingQueue的poll(long time,TimeUnit unit)为任务执行结果的取得限制时间，如果没有完成就取消任务
	 * 
	 * */
	//CompletionService<V> completionService= new ExecutorCompletionService<>(executor);

}
