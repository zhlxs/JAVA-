package classadapter;

public class Client
{
	public static void main(String[] args)
	{
		System.out.println("~��������~");
		Phone p = new Phone();
		p.charming(new VolAdapter());
	}
}
