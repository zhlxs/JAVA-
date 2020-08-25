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
	 * ���ļ��ж�ȡ�ı�
	 * @param filename
	 */
	public void readFromFile(String filename)
	{
		BufferedInputStream inputStream = null;
		// ����һ���ֽ�����,�൱�ڻ���
		byte[] buffer = new byte[1024];
		try
		{
			// ����BufferedInputStream����
			inputStream = new BufferedInputStream(new FileInputStream(filename));
			int bytesRead = 0;
			// ���ļ��а��ֽڶ�ȡ���ݣ����ļ�β��ʱread����������-1
			while ((bytesRead = inputStream.read(buffer)) != -1)
			{
				// ����ȡ���ֽ�תΪ�ַ�������
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
			/* ���ֽ����ж�ȡ5���ֽ� */
			byte[] tmp = new byte[5];
			in.read(tmp, 0, 5);
			System.out.println("�ֽ�����ǰ5���ֽ�Ϊ: " + new String(tmp));
			/* ��ǲ��� */
			in.mark(6);
			/* ��ȡ5���ֽ� */
			in.read(tmp, 0, 5);
			System.out.println("�ֽ����е�6��10���ֽ�Ϊ: " + new String(tmp));
			in.reset();
			System.out.printf("reset���ȡ�ĵ�һ���ֽ�Ϊ: %c", in.read());
		}
		catch (Exception e)
		{
			// ��ӡ������ջ�������
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		new BufferedInputStreamTech().readFromFile("myFile.txt");
	}
	/**
	 * BufferedInputStream�̳���FilterInputStream���ṩ�������������ܡ�
	 * �����������������ͨ�������������ǣ����ṩ��һ���������飬ÿ�ε���read������ʱ��
	 * �����ȳ��Դӻ��������ȡ���ݣ�����ȡʧ�ܣ��������޿ɶ����ݣ���
	 * ��ѡ�����������Դ��Ʃ���ļ�����ȡ�����ݣ�����᳢�Ծ����ܶ�ȡ����ֽڣ����뵽�������У�
	 * ����ٽ��������е����ݲ��ֻ�ȫ�����ظ��û�.���ڴӻ��������ȡ����Զ��ֱ�Ӵ���������Դ��Ʃ���ļ�����ȡ�ٶȿ졣
	 */
}
