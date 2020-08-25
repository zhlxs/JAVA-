package com.demo.hsl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestBufferedString
{
	public static void main(String[] args) throws IOException
	{
		// ָ��Ҫ��ȡ�ļ��Ļ��������ֽ���
		BufferedInputStream in = new BufferedInputStream(new FileInputStream("F:\\test.jpg"));
		File file = new File("E:\\test.jpg");
		if (file != null)
		{
			file.createNewFile();
		}
		// ָ��Ҫд���ļ��Ļ�������ֽ���
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
		byte[] bb = new byte[1024];// �����洢ÿ�ζ�ȡ�����ֽ�����
		int n;// ÿ�ζ�ȡ�����ֽ�����ĳ���
		while ((n = in.read(bb)) != -1)
		{
			out.write(bb, 0, n);// д�뵽�����
		}
		out.close();// �ر���
		in.close();
	}
}
