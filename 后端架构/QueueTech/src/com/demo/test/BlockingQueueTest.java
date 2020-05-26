package com.demo.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingQueueTest
{
	public static class Basket
	{
		BlockingQueue<String> basket = new ArrayBlockingQueue<String>(3);

		public void produce() throws InterruptedException
		{
			basket.put("apple");
		}

		public String consume() throws InterruptedException
		{
			String apple = basket.take();
			return apple;
		}

		public int getAppleNumber()
		{
			return basket.size();
		}
	}

	public static void testBasket()
	{
		final Basket basket = new Basket();
		// 生产者
		class Producer implements Runnable
		{
			@Override
			public void run()
			{
				try
				{
					while (true)
					{
						basket.produce();
						Thread.sleep(300);
					}
				}
				catch (Exception e)
				{
					// TODO: handle exception
				}
			}
		}
		// 消费者
		class Consumer implements Runnable
		{
			@Override
			public void run()
			{
				try
				{
					while (true)
					{
						basket.consume();
						Thread.sleep(1000);
					}
				}
				catch (Exception e)
				{
					// TODO: handle exception
				}
			}
		}
		ExecutorService service = Executors.newCachedThreadPool();
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		service.submit(producer);
		service.submit(consumer);
		try
		{
			Thread.sleep(10000);
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		service.shutdown();
	}

	public static void main(String[] args)
	{
		BlockingQueueTest.testBasket();
	}
}
