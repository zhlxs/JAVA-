package com.demo.hsl;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamReaderTech
{
	public void initalizeResource()
	{
		try
		{
			FileInputStream fis = new FileInputStream("demo.txt");
			BufferedInputStream bis = new BufferedInputStream(fis);
			BufferedReader bufferedReader;
			String read;
			bufferedReader = new BufferedReader(new InputStreamReader(bis));
			while ((read = bufferedReader.readLine()) != null)
			{
				System.out.println(read);
			}
			fis.close();
			bis.close();
			bufferedReader.close();
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void transReadNoBuff() throws IOException
	{
		/**
		 * 没有缓冲区，只能使用read方法
		 */
		// 这是读取字节流
		InputStream in = new FileInputStream("demo.txt");
		// 将字节流向字符流的转换。要启用从字节到字符的有效转换，
		// 可以提前从底层流读取更多的字节.
		InputStreamReader isr = new InputStreamReader(in);
		char[] cha = new char[1024];
		int len = isr.read(cha);
		System.out.println(new String(cha, 0, len));
		isr.close();
	}

	public static void transReadBuff() throws Exception
	{
		/**
		 * 使用缓冲区 可以使用缓冲区对象的 read() 和 readLine()方法。
		 */
		InputStream in = new FileInputStream("demo.txt");
		// 将字节流向字符流的转换。
		InputStreamReader isr = new InputStreamReader(in);// 读取
		// 创建字符流缓冲区
		BufferedReader bufr = new BufferedReader(isr);// 缓冲
		String line;
		while ((line = bufr.readLine()) != null)
		{
			System.out.println(line);
		}
		isr.close();
	}
	/**
	 * InputStreamReader 将字节流转换为字符流。是字节流通向字符流的桥梁。如果不指定字符集编码，
	 * 该解码过程将使用平台默认的字符编码，如：GBK。
	 * @author prd-hushanlin
	 */
}
