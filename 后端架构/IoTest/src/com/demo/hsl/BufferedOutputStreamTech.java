package com.demo.hsl;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTech
{
	public static void main(String[] args)
	{
		try
		{
			FileOutputStream foStream = new FileOutputStream("demo.txt");
			BufferedOutputStream out = new BufferedOutputStream(foStream);
			String content = "1234567890";
			// ��ָ�� byte �����д�ƫ���� off ��ʼ�� len ���ֽ�д��˻�����������
			out.write(content.getBytes(), 0, content.getBytes().length);
			out.flush();
			out.close();
			foStream.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
