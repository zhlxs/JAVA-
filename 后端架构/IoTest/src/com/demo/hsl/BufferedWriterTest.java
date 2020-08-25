package com.demo.hsl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class BufferedWriterTest
{
	private static final int len = 5;
	private static final char[] arrayLetters = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	// 创建“文件输出流”对应的BufferedWriter
	// 它对应缓冲区的大小是16，即缓冲区的数据>=16时，会自动将缓冲区的内容写入到输出流。
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
		// 等待一个输入
		String str = reader.next();
		System.out.printf("the input is : %s\n", str);
	}

	public static void main(String[] args)
	{
		testBufferedWriter();
	}
}
