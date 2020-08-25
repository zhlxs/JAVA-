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
		// ���һ��ԭʼ�ӱ��Ը������α�׼ʱ��Ϊ׼
		Clock c = Clock.systemDefaultZone();
		System.out.println(c);
		// ���һ����઼��5���tickClock�ӱ�
		Clock c1 = Clock.tick(c, Duration.ofSeconds(5));
		System.out.println(c1);

		for (int i = 0; i < 5; i++)
		{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			TimeUnit.MILLISECONDS.sleep(1000);// ÿ��1��ȡ��һ��
			System.out.println("---");
			System.out.println(c.instant());// ԭʼ�ӱ��ӡʱ���
			System.out.println(c1.instant() + " tick�ӱ�");// tickClock�ӱ��ӡʱ���
			System.out.println(format.format(c.instant().toEpochMilli()));
		}
	}
}
