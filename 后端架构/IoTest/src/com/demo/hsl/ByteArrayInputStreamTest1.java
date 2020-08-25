package com.demo.hsl;

import java.io.ByteArrayInputStream;

public class ByteArrayInputStreamTest1
{
	private static final int LEN = 5;
	// ��ӦӢ����ĸ��abcddefghijklmnopqrsttuvwxyz��
	private static final byte[] ArrayLetters = { 0x61, 0x62, 0x63, 0x64, 0x65, 0x66, 0x67, 0x68, 0x69, 0x6A, 0x6B, 0x6C, 0x6D, 0x6E, 0x6F, 0x70, 0x71, 0x72, 0x73, 0x74, 0x75, 0x76, 0x77, 0x78, 0x79, 0x7A };

	public static void main(String[] args)
	{
		testByteArrayInputStream();
	}

	private static void testByteArrayInputStream()
	{
		// ����ByteArrayInputStream�ֽ�����������ArrayLetters����
		ByteArrayInputStream bais = new ByteArrayInputStream(ArrayLetters);
		// ���ֽ����ж�ȡ5���ֽ�
		for (int i = 0; i < LEN; i++)
		{
			// ���ܼ�����ȡ��һ���ֽڣ����ȡ��һ���ֽ�
			if (bais.available() > 0)
			{
				int temp = bais.read();
				System.out.printf("%d : 0x%s\n", i, Integer.toHexString(temp));
			}
		}

		// �������ֽ�������֧�ֱ�ǹ��ܣ���ֱ���˳�
		if (!bais.markSupported())
		{
			System.out.println("make not supported!");
			return;
		}
		// ��ǡ��ֽ�������һ������ȡ��λ�á�����--��ǡ�0x66������Ϊ��Ϊǰ���Ѿ���ȡ��5���ֽڣ�������һ������ȡ��λ���ǵ�6���ֽڡ�
		// (01), ByteArrayInputStream���mark(0)�����еġ�����0����û��ʵ������ġ�
		// (02), mark()��reset()�����׵ģ�reset()�Ὣ���ֽ�������һ������ȡ��λ�á�����Ϊ��mark()���������λ�á�
		bais.mark(0);

		// ����5���ֽڡ�����5���ֽں��ֽ�������һ������ȡ��ֵӦ���ǡ�0x6B����
		bais.skip(5);

		// ���ֽ����ж�ȡ5�����ݡ�����ȡ��0x6B, 0x6C, 0x6D, 0x6E, 0x6F��
		byte[] buf = new byte[LEN];
		bais.read(buf, 0, LEN);
		// ��bufת��ΪString�ַ�������0x6B, 0x6C, 0x6D, 0x6E, 0x6F����Ӧ�ַ��ǡ�klmno��
		String str1 = new String(buf);
		System.out.printf("str1=%s\n", str1);

		// ���á��ֽ����������������ֽ�������һ������ȡ��λ�á����õ���mark()����ǵ�λ�á�����0x66��
		bais.reset();
		// �ӡ����ú���ֽ������ж�ȡ5���ֽڵ�buf�С�����ȡ��0x66, 0x67, 0x68, 0x69, 0x6A��
		bais.read(buf, 0, LEN);
		// ��bufת��ΪString�ַ�������0x66, 0x67, 0x68, 0x69, 0x6A����Ӧ�ַ��ǡ�fghij��
		String str2 = new String(buf);
		System.out.printf("str2=%s\n", str2);
	}
}
