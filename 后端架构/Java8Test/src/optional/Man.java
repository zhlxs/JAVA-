package optional;

public class Man
{
	private String name;

	private Goddness gn;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Goddness getGn()
	{
		return gn;
	}

	public void setGn(Goddness gn)
	{
		this.gn = gn;
	}

	public Man()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Man(String name, Goddness gn)
	{
		super();
		this.name = name;
		this.gn = gn;
	}

}
