package demo;

/**
 * ���ģʽ
 * @author prd-hushanlin
 */
public abstract class ComponentOrganization
{
	private String name;
	private String desc;

	protected void add(ComponentOrganization componentOrganization)
	{
		throw new UnsupportedOperationException();
	}

	protected void remove(ComponentOrganization componentOrganization)
	{
		throw new UnsupportedOperationException();
	}

	public ComponentOrganization(String name, String desc)
	{
		super();
		this.name = name;
		this.desc = desc;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}

	// ��ӡ����
	public abstract void print();
}
