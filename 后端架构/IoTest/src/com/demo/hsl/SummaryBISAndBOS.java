package com.demo.hsl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * ʹ�û���������ͻ���������ʵ���ļ��ĸ���
 * @author prd-hushanlin
 */
public class SummaryBISAndBOS
{
	public static void main(String[] args)
	{
		/**
		 * 1.�Ƚ��ļ��е����ݶ��뵽������������ 2.���������е�����ͨ�����������д�뵽Ŀ���ļ��� 3.�ر��������������
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
			// ˢ�´˻�������������֤����ȫ������д��
			bos.flush();
			bis.close();
			bos.close();
			long end = System.currentTimeMillis();
			System.out.println("ʹ�û���������ͻ���������ʵ���ļ��ĸ�����ϣ���ʱ��" + (end - begin) + "����");
		}
		catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
