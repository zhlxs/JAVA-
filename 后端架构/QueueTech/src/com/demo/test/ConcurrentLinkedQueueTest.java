package com.demo.test;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentLinkedQueueTest
{
	private static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
	private static int count = 2;
	// CountDownLatch��һ��ͬ�������࣬�����һ�����������߳���ִ�еĲ���֮ǰ��������һ�������߳�һֱ�ȴ���
	private static CountDownLatch latch = new CountDownLatch(count);

	/**
	 * ����
	 */
	public static void offer()
	{
		for (int i = 0; i < 100000; i++)
		{
			queue.offer(i);
		}
	}

	/**
	 * ����
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
//		����һ�����̵߳��̳߳ء�����̳߳�ֻ��һ���߳��ڹ�����Ҳ�����൱�ڵ��̴߳���ִ����������������Ψһ���߳���Ϊ�쳣��������ô����һ���µ��߳�������������̳߳ر�֤���������ִ��˳����������ύ˳��ִ�С�
//		2.newFixedThreadPool
//		�����̶���С���̳߳ء�ÿ���ύһ������ʹ���һ���̣߳�ֱ���̴߳ﵽ�̳߳ص�����С���̳߳صĴ�Сһ���ﵽ���ֵ�ͻᱣ�ֲ��䣬���ĳ���߳���Ϊִ���쳣����������ô�̳߳ػᲹ��һ�����̡߳�
//		3. newCachedThreadPool
//		����һ���ɻ�����̳߳ء�����̳߳صĴ�С�����˴�����������Ҫ���̣߳�
//		��ô�ͻ���ղ��ֿ��У�60�벻ִ�����񣩵��̣߳�������������ʱ�����̳߳��ֿ������ܵ�������߳����������񡣴��̳߳ز�����̳߳ش�С�����ƣ��̳߳ش�С��ȫ�����ڲ���ϵͳ������˵JVM���ܹ�����������̴߳�С��
//		4.newScheduledThreadPool
//		����һ����С���޵��̳߳ء����̳߳�֧�ֶ�ʱ�Լ�������ִ�����������
		ExecutorService service = Executors.newFixedThreadPool(4);
		ConcurrentLinkedQueueTest.offer();
		for (int i = 0; i < count; i++)
		{
			service.submit(new Poll());
		}
		latch.await();// ʹ�����߳�(main)����ֱ��latch.countDown()Ϊ��ż���ִ��
		System.out.println("cost time " + (System.currentTimeMillis() - timeStart) + "ms");
		service.shutdown();
	}
}
