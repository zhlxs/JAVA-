package com.demo.test;

public class TestThread extends Thread
{
	private int i = 5;

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		m();
	}

	public void m()
	{
		synchronized (this)
		{
			System.out.println("i=" + (i--) + "-----------------" + Thread.currentThread().getName());
		}
	}

	public static void main(String[] args)
	{
		TestThread t = new TestThread();
		Thread t1 = new Thread(t);
		Thread t2 = new Thread(t);
		Thread t3 = new Thread(t);
		Thread t4 = new Thread(t);
		Thread t5 = new Thread(t);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}
}
