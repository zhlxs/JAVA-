package com.demo.hsl;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DurationTest0
{
	public static void main(String[] args)
	{
		// 获取一个 Duration表示两个时间对象之间的持续时间。
		Duration duration = Duration.between(LocalTime.NOON, LocalTime.MIN);
		System.out.println(duration.get(ChronoUnit.SECONDS));
		Duration absDuration = duration.abs();
		System.out.println(absDuration.get(ChronoUnit.SECONDS));
		/**
		 * 知识扩展
		 */
		System.out.println("----------------------");
		LocalDate start = LocalDate.of(2020, 2, 1);
		LocalDate end = LocalDate.of(2020, 4, 1);

		Period period = Period.between(start, end);
		System.out.println(period.getYears());
	}
}
