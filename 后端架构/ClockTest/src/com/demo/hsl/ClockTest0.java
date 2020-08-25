package com.demo.hsl;

import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ClockTest0
{
	public static void main(String[] args) throws InterruptedException
	{
		Clock clock = Clock.systemUTC();
//		System.out.println(clock);
//		System.out.println(clock.getZone());
//		System.out.println(clock.hashCode());
		// 获得一个原始钟表，以格林威治标准时间为准
		Clock c = Clock.systemDefaultZone();
		System.out.println(c);
		// 获得一个嘀嗒间隔5秒的tickClock钟表
		Clock c1 = Clock.tick(c, Duration.ofSeconds(5));
		System.out.println(c1);

		for (int i = 0; i < 5; i++)
		{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			TimeUnit.MILLISECONDS.sleep(1000);// 每隔1秒取样一次
			System.out.println("---");
			System.out.println(c.instant());// 原始钟表打印时间戳
			System.out.println(c1.instant() + " tick钟表");// tickClock钟表打印时间戳
			System.out.println(format.format(c.instant().toEpochMilli()));
		}
	}
}
