package demo;

public class Department extends ComponentOrganization
{

	public Department(String name, String desc)
	{
		super(name, desc);
	}

	@Override
	public String getName()
	{
		return super.getName();
	}

	@Override
	public String getDesc()
	{
		return super.getDesc();
	}

	@Override
	public void print()
	{
		System.out.println(getName());
	}
}
