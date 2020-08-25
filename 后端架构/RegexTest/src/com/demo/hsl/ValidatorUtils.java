package com.demo.hsl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtils
{
	public static void main(String[] args)
	{
		// ������֤
		String email = "1358311815@qq.com";
		Pattern p = Pattern.compile("^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\\.([a-zA-Z0-9_-])+)+$");
		if (null == email || !p.matcher(email).matches())
		{
			System.out.println("������֤ʧ�ܣ�");
		}
		// �ֻ�����֤
		String phonenumber = "18397860322";
		Pattern p1 = Pattern.compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0-3]|[5-9]))\\d{8})|(0\\d{2}-\\d{7,8})|(0\\d{3}-\\d{7,8})$");
		if (null == phonenumber || !p1.matcher(phonenumber).matches())
		{
			System.out.println("�ֻ�����֤��֤ʧ�ܣ�");
		}
		// ����������ʽ
		Pattern pattern = Pattern.compile("\\w+");
		pattern.pattern();// ���� \w+
		// ����ƥ��ָ�
		Pattern p2 = Pattern.compile("\\d+");
		String[] str = p2.split("�ҵ�������:456456�ҵĵ绰��:0532214�ҵ�������:aaa@aaa.com");
//		System.out.println("-----str:" + str.length);
		// ����ƥ��
//		System.out.println(Pattern.matches("\\d+", "22123"));
		Pattern p3 = Pattern.compile("\\d+");
		Matcher m = p3.matcher("22bb23");
		m.pattern();// ����p Ҳ���Ƿ��ظ�Matcher���������ĸ�Pattern����Ĵ�����
//		System.out.println("-----m" + m.pattern());
		Pattern p33 = Pattern.compile("\\d+");
		Matcher m1 = p33.matcher("aaa2223bb");
		m1.find();// ƥ��2223
		m1.start();// ����3
		m1.end();// ����7,���ص���2223���������
		m1.group();// ����2223
		m1.lookingAt(); // ƥ��2223
		Pattern p5 = Pattern.compile("([a-z]+)(\\d+)");
		Matcher m3 = p5.matcher("aaa2223bb");
		m3.find(); // ƥ��aaa2223
		m3.groupCount(); // ����2,��Ϊ��2��
		m3.start(1); // ����0 ���ص�һ��ƥ�䵽�����ַ������ַ����е�������
		m3.start(2); // ����3
		m3.end(1); // ����3 ���ص�һ��ƥ�䵽�����ַ��������һ���ַ����ַ����е�����λ��.
		m3.end(2); // ����7
		m3.group(1); // ����aaa,���ص�һ��ƥ�䵽�����ַ���
		m3.group(2); // ����2223,���صڶ���ƥ�䵽�����ַ���
	}
}
