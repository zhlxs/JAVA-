package com.demo.hsl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteArrayInputStreamTest
{
	// ByteArrayOutputStream
	// 缓冲区会自动增长，这个自动增长的过程，根据源码来看会有copyArray动作，所以整个write过程，消耗内存成倍增长
	public static byte[] convertstream(InputStream inputStream, long length) throws IOException
	{
		length = length > Integer.MAX_VALUE ? Integer.MAX_VALUE : length;
		ByteArrayOutputStream swapStream = new ByteArrayOutputStream((int) length);
		byte[] buff = new byte[10240];
		int rc = 0;
		while ((rc = inputStream.read(buff, 0, 10240)) > 0)
		{
			swapStream.write(buff, 0, rc);
		}
		byte[] buf = swapStream.toByteArray();
		swapStream.close();
		return buf;
	}
}
