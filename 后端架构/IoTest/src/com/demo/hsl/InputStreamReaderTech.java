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
		 * û�л�������ֻ��ʹ��read����
		 */
		// ���Ƕ�ȡ�ֽ���
		InputStream in = new FileInputStream("demo.txt");
		// ���ֽ������ַ�����ת����Ҫ���ô��ֽڵ��ַ�����Чת����
		// ������ǰ�ӵײ�����ȡ������ֽ�.
		InputStreamReader isr = new InputStreamReader(in);
		char[] cha = new char[1024];
		int len = isr.read(cha);
		System.out.println(new String(cha, 0, len));
		isr.close();
	}

	public static void transReadBuff() throws Exception
	{
		/**
		 * ʹ�û����� ����ʹ�û���������� read() �� readLine()������
		 */
		InputStream in = new FileInputStream("demo.txt");
		// ���ֽ������ַ�����ת����
		InputStreamReader isr = new InputStreamReader(in);// ��ȡ
		// �����ַ���������
		BufferedReader bufr = new BufferedReader(isr);// ����
		String line;
		while ((line = bufr.readLine()) != null)
		{
			System.out.println(line);
		}
		isr.close();
	}
	/**
	 * InputStreamReader ���ֽ���ת��Ϊ�ַ��������ֽ���ͨ���ַ����������������ָ���ַ������룬
	 * �ý�����̽�ʹ��ƽ̨Ĭ�ϵ��ַ����룬�磺GBK��
	 * @author prd-hushanlin
	 */
}
