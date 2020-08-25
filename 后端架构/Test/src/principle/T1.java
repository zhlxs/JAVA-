package principle;

public class T1
{
	public static void main(String[] args)
	{
		test();
	}

	public static int test()
	{
		try
		{
			return 1;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("ÎÒÄÜÖ´ĞĞÂğ~");
		}
		return 0;
	}

	private static <T extends Comparable<T>> int binarySearch(T[] x, int low, int high, T key)
	{
		if (low <= high)
		{
			int mid = low + ((high - low) >> 1);
			if (key.compareTo(x[mid]) == 0)
			{
				return mid;
			}
			else if (key.compareTo(x[mid]) < 0)
			{
				return binarySearch(x, low, mid - 1, key);
			}
			else
			{
				return binarySearch(x, mid + 1, high, key);
			}
		}
		return -1;
	}

}
