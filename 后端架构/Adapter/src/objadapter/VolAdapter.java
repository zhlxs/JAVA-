package objadapter;

public class VolAdapter implements IVol5V
{

	private Vol220V vol220;

	// 构造器关联，聚合的方式
	public VolAdapter(Vol220V vol220)
	{
		this.vol220 = vol220;
	}

	@Override
	public int out5V()
	{
		int dstV = 0;
		if (null != vol220)
		{
			int src = vol220.out220V();
			dstV = src / 44;
		}
		return dstV;
	}

}
