package classadapter;

public class Phone
{
	public void charming(IVol5V iVol5V)
	{
		if (iVol5V.out5V() == 5)
		{
			System.out.println("���Գ��~");
		}
		else if (iVol5V.out5V() > 5)
		{
			System.out.println("�޷����~");
		}
	}
}
