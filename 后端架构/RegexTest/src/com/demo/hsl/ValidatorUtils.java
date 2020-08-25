package com.demo.hsl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtils
{
	public static void main(String[] args)
	{
		// 邮箱验证
		String email = "1358311815@qq.com";
		Pattern p = Pattern.compile("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\\.([a-zA-Z0-9_-])+)+$");
		if (null == email || !p.matcher(email).matches())
		{
			System.out.println("邮箱验证失败！");
		}
		// 手机号验证
		String phonenumber = "18397860322";
		Pattern p1 = Pattern.compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0-3]|[5-9]))\\d{8})|(0\\d{2}-\\d{7,8})|(0\\d{3}-\\d{7,8})$");
		if (null == phonenumber || !p1.matcher(phonenumber).matches())
		{
			System.out.println("手机号验证验证失败！");
		}
		// 创建正则表达式
		Pattern pattern = Pattern.compile("\\w+");
		pattern.pattern();// 返回 \w+
		// 正则匹配分割
		Pattern p2 = Pattern.compile("\\d+");
		String[] str = p2.split("我的姓名是:456456我的电话是:0532214我的邮箱是:aaa@aaa.com");
//		System.out.println("-----str:" + str.length);
		// 正则匹配
//		System.out.println(Pattern.matches("\\d+", "22123"));
		Pattern p3 = Pattern.compile("\\d+");
		Matcher m = p3.matcher("22bb23");
		m.pattern();// 返回p 也就是返回该Matcher对象是由哪个Pattern对象的创建的
//		System.out.println("-----m" + m.pattern());
		Pattern p33 = Pattern.compile("\\d+");
		Matcher m1 = p33.matcher("aaa2223bb");
		m1.find();// 匹配2223
		m1.start();// 返回3
		m1.end();// 返回7,返回的是2223后的索引号
		m1.group();// 返回2223
		m1.lookingAt(); // 匹配2223
		Pattern p5 = Pattern.compile("([a-z]+)(\\d+)");
		Matcher m3 = p5.matcher("aaa2223bb");
		m3.find(); // 匹配aaa2223
		m3.groupCount(); // 返回2,因为有2组
		m3.start(1); // 返回0 返回第一组匹配到的子字符串在字符串中的索引号
		m3.start(2); // 返回3
		m3.end(1); // 返回3 返回第一组匹配到的子字符串的最后一个字符在字符串中的索引位置.
		m3.end(2); // 返回7
		m3.group(1); // 返回aaa,返回第一组匹配到的子字符串
		m3.group(2); // 返回2223,返回第二组匹配到的子字符串
	}
}
