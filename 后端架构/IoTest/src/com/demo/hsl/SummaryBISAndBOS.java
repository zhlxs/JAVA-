package com.demo.hsl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 使用缓冲输出流和缓冲输入流实现文件的复制
 * @author prd-hushanlin
 */
public class SummaryBISAndBOS
{
	public static void main(String[] args)
	{
		/**
		 * 1.先将文件中的内容读入到缓冲输入流中 2.将输入流中的数据通过缓冲输出流写入到目标文件中 3.关闭输入流和输出流
		 */
		try
		{
			long begin = System.currentTimeMillis();
			FileInputStream fis = new FileInputStream("BISDemo.txt");
			BufferedInputStream bis = new BufferedInputStream(fis);

			FileOutputStream outputStream = new FileOutputStream("BOSDemo.txt");
			BufferedOutputStream bos = new BufferedOutputStream(outputStream);

			int size = 0;
			byte[] buffer = new byte[1024];
			while ((size = bis.read(buffer)) != -1)
			{
				bos.write(buffer, 0, size);
			}
			// 刷新此缓冲的输出流，保证数据全部都能写出
			bos.flush();
			bis.close();
			bos.close();
			long end = System.currentTimeMillis();
			System.out.println("使用缓冲输出流和缓冲输入流实现文件的复制完毕！耗时：" + (end - begin) + "毫秒");
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
