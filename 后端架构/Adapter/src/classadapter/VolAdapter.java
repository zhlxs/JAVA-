package classadapter;

public class VolAdapter extends Vol220V implements IVol5V
{

	@Override
	public int out5V()
	{
		int src = out220V();
		int dstV = src / 44;
		return dstV;
	}

}
