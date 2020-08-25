package demo;

import java.util.ArrayList;
import java.util.List;

public class College extends ComponentOrganization
{

	List<ComponentOrganization> organizations = new ArrayList<ComponentOrganization>();

	@Override
	protected void add(ComponentOrganization componentOrganization)
	{
		organizations.add(componentOrganization);
	}

	@Override
	protected void remove(ComponentOrganization componentOrganization)
	{
		organizations.remove(componentOrganization);
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

	public College(String name, String desc)
	{
		super(name, desc);
	}

	@Override
	public void print()
	{
		System.out.println("--------------" + getName() + "---------------");
		if (!organizations.isEmpty())
		{
			for (ComponentOrganization organization : organizations)
			{
				organization.print();
			}
		}
	}

}
