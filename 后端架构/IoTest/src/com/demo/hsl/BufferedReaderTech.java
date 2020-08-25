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
		// System.in ��ȡ�����ϵ�����
		// InputStreamReader ���ֽ������ַ�����ת��
		InputStreamReader isr = new InputStreamReader(System.in); // ��ȡ
		// �����ַ���������
		BufferedReader br = new BufferedReader(isr); // ����
		// ��ȡһ���ı���
		String s = br.readLine(); // ����ʽ����û�����ݶ�ȡʱ����һֱ�������������Ƿ���null
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
