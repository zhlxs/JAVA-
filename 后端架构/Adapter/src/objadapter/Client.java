package objadapter;

public class Client
{
	public static void main(String[] args)
	{
		System.out.println("~��������~");
		Phone p = new Phone();
		p.charming(new VolAdapter(new Vol220V()));
	}
}
