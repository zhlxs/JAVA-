package optional;

import java.util.Optional;

public class NewMan
{
	private Optional<Goddness> god = Optional.empty();

	public Optional<Goddness> getGod()
	{
		return god;
	}

	public void setGod(Optional<Goddness> god)
	{
		this.god = god;
	}

	public NewMan()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public NewMan(Optional<Goddness> god)
	{
		super();
		this.god = god;
	}

}
