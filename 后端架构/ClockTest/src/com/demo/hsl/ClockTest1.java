package com.demo.hsl;

import java.time.Clock;
import java.time.ZoneId;

public class ClockTest1
{
	public static void main(String[] args) throws InterruptedException
	{
		Clock c = Clock.tickSeconds(ZoneId.of("GMT"));
		for (int i = 0; i < 10; i++)
		{
			Thread.sleep(500); // 每半秒读一次，一秒内读两次
			System.out.println(c.instant());
		}
	}
}
