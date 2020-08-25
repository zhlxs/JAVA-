package classadapter;

public class Phone
{
	public void charming(IVol5V iVol5V)
	{
		if (iVol5V.out5V() == 5)
		{
			System.out.println("可以充电~");
		}
		else if (iVol5V.out5V() > 5)
		{
			System.out.println("无法充电~");
		}
	}
}
