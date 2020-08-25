package com.demo.hsl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * BufferedInputStream
 * @author prd-hushanlin
 */
public class BufferedInputStreamTech
{
	/**
	 * 从文件中读取文本
	 * @param filename
	 */
	public void readFromFile(String filename)
	{
		BufferedInputStream inputStream = null;
		// 定义一个字节数组,相当于缓存
		byte[] buffer = new byte[1024];
		try
		{
			// 创建BufferedInputStream对象
			inputStream = new BufferedInputStream(new FileInputStream(filename));
			int bytesRead = 0;
			// 从文件中按字节读取内容，到文件尾部时read方法将返回-1
			while ((bytesRead = inputStream.read(buffer)) != -1)
			{
				// 将读取的字节转为字符串对象
				String chunk = new String(buffer, 0, bytesRead);
				System.out.println("-----chunk:" + chunk);
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
				if (inputStream != null)
				{
					inputStream.close();
				}
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void testBufferedInput()
	{
		try
		{
			InputStream in = new BufferedInputStream(new FileInputStream(new File("buff.txt")), 8);
			/* 从字节流中读取5个字节 */
			byte[] tmp = new byte[5];
			in.read(tmp, 0, 5);
			System.out.println("字节流的前5个字节为: " + new String(tmp));
			/* 标记测试 */
			in.mark(6);
			/* 读取5个字节 */
			in.read(tmp, 0, 5);
			System.out.println("字节流中第6到10个字节为: " + new String(tmp));
			in.reset();
			System.out.printf("reset后读取的第一个字节为: %c", in.read());
		}
		catch (Exception e)
		{
			// 打印出错误栈里的内容
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		new BufferedInputStreamTech().readFromFile("myFile.txt");
	}
	/**
	 * BufferedInputStream继承于FilterInputStream，提供缓冲输入流功能。
	 * 缓冲输入流相对于普通输入流的优势是，它提供了一个缓冲数组，每次调用read方法的时候，
	 * 它首先尝试从缓冲区里读取数据，若读取失败（缓冲区无可读数据），
	 * 则选择从物理数据源（譬如文件）读取新数据（这里会尝试尽可能读取多的字节）放入到缓冲区中，
	 * 最后再将缓冲区中的内容部分或全部返回给用户.由于从缓冲区里读取数据远比直接从物理数据源（譬如文件）读取速度快。
	 */
}
