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
			// 1.����BufferedWriter���͵Ķ�����c:/a.txt�ļ�����
			// true�������׷�ӣ�
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("a.txt", true)));
			// ��ʱ���ʽ��
			DateFormat bf = new SimpleDateFormat("yyyy-MM-dd E a HH:mm:ss");
			Date date = new Date();
			String format = bf.format(date);
			// 2.���ַ�������"last demo!"д���ļ���
			bw.write(format + ":" + name + "\r\n");
			// 3.�ر��������ͷ��йص���Դ
			bw.close();
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
