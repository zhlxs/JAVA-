package com.demo.test;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentLinkedQueueTest
{
	private static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
	private static int count = 2;
	// CountDownLatch，一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
	private static CountDownLatch latch = new CountDownLatch(count);

	/**
	 * 生产
	 */
	public static void offer()
	{
		for (int i = 0; i < 100000; i++)
		{
			queue.offer(i);
		}
	}

	/**
	 * 消费
	 */
	static class Poll implements Runnable
	{
		public void run()
		{
//			while (queue.size() > 0)
//			{
			while (!queue.isEmpty())
			{
				System.out.println("----------" + queue.poll() + "----------");
			}
			latch.countDown();
		}
	}

	public static void main(String[] args) throws InterruptedException
	{
		long timeStart = System.currentTimeMillis();
//		1. newSingleThreadExecutor
//		创建一个单线程的线程池。这个线程池只有一个线程在工作，也就是相当于单线程串行执行所有任务。如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它。此线程池保证所有任务的执行顺序按照任务的提交顺序执行。
//		2.newFixedThreadPool
//		创建固定大小的线程池。每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小。线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。
//		3. newCachedThreadPool
//		创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程，
//		那么就会回收部分空闲（60秒不执行任务）的线程，当任务数增加时，此线程池又可以智能的添加新线程来处理任务。此线程池不会对线程池大小做限制，线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。
//		4.newScheduledThreadPool
//		创建一个大小无限的线程池。此线程池支持定时以及周期性执行任务的需求。
		ExecutorService service = Executors.newFixedThreadPool(4);
		ConcurrentLinkedQueueTest.offer();
		for (int i = 0; i < count; i++)
		{
			service.submit(new Poll());
		}
		latch.await();// 使得主线程(main)阻塞直到latch.countDown()为零才继续执行
		System.out.println("cost time " + (System.currentTimeMillis() - timeStart) + "ms");
		service.shutdown();
	}
}
