package test;

public class ConcreteWebSite extends WebSite
{
	private String name;

	public ConcreteWebSite(String name)
	{
		this.name = name;
	}

	@Override
	public void use()
	{
		System.out.println("ÍøÕ¾·ÖÀà£º" + name);
	}

}
