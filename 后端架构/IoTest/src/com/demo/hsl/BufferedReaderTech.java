package com.demo.hsl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderTech
{
	public static void main(String[] args) throws IOException
	{
		System.out.println(getString());
	}

	private static String getString() throws IOException
	{
		// System.in 读取键盘上的数据
		// InputStreamReader 将字节流向字符流的转换
		InputStreamReader isr = new InputStreamReader(System.in); // 读取
		// 创建字符流缓冲区
		BufferedReader br = new BufferedReader(isr); // 缓冲
		// 读取一个文本行
		String s = br.readLine(); // 阻塞式，当没有数据读取时，就一直会阻塞，而不是返回null
		return s;
	}

	public void readLinesFromFile(String filename)
	{
		BufferedReader br = null;
		try
		{
			br = new BufferedReader(new FileReader(filename));
			String line = null;
			while ((line = br.readLine()) != null)
			{
				System.out.println(line);
			}
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (br != null)
				{
					br.close();
				}
			}
			catch (Exception e2)
			{
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
}
