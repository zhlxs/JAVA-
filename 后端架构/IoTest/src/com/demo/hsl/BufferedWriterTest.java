package com.demo.hsl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class BufferedWriterTest
{
	private static final int len = 5;
	private static final char[] arrayLetters = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	// �������ļ����������Ӧ��BufferedWriter
	// ����Ӧ�������Ĵ�С��16����������������>=16ʱ�����Զ���������������д�뵽�������
	private static void testBufferedWriter()
	{
		try
		{
			File file = new File("test.txt");
			BufferedWriter out = new BufferedWriter(new FileWriter(file));
			out.write(arrayLetters, 0, len);
			out.write('\n');
			out.flush();
			out.close();
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static void readUserInput()
	{
		System.out.println("please input a text:");
		Scanner reader = new Scanner(System.in);
		// �ȴ�һ������
		String str = reader.next();
		System.out.printf("the input is : %s\n", str);
	}

	public static void main(String[] args)
	{
		testBufferedWriter();
	}
}
