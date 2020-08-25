package com.demo.hsl;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BufferedWriterTech
{
	public static void main(String[] args)
	{
		IOBufferedWriters("Hello World!");
	}

	static public void IOBufferedWriters(String name)
	{
		try
		{
			// 1.创建BufferedWriter类型的对象与c:/a.txt文件关联
			// true代表可以追加，
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("a.txt", true)));
			// 把时间格式化
			DateFormat bf = new SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss");
			Date date = new Date();
			String format = bf.format(date);
			// 2.将字符串数据"last demo!"写入文件中
			bw.write(format + ":" + name + "\r\n");
			// 3.关闭流对象并释放有关的资源
			bw.close();
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
