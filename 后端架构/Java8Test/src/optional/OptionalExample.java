package optional;

import java.util.Optional;

/**
 * 避免空指针异常神器
 * @author prd-hushanlin
 */
public class OptionalExample
{
	public void test1()
	{
//		Optional<User> op = Optional.of(new User());
		Optional<User> op = Optional.of(null);// 空指针异常
		User user = op.get();
		System.out.println(user.getName());
	}

	public void test2()
	{
		Optional<User> op = Optional.empty();// 构建空的对象
		System.out.println(op.get());// 空指针
	}

	public void test3()
	{
		Optional<User> op = Optional.ofNullable(new User());
		// Optional<User> op = Optional.ofNullable(null);//空指针
		if (op.isPresent())
		{
			System.out.println(op.get());
		}
		// User user = op.orElse(new User());
		// System.out.println(user);
		User user = op.orElseGet(() -> new User());
		System.out.println(user);
	}

	public void test4()
	{
		Optional<User> op = Optional.ofNullable(new User(1, "hsl"));
		// Optional<String> str = op.map((e) -> e.getName());
		// System.out.println(str.get());
		Optional<String> s = op.flatMap((e) -> Optional.of(e.getName()));
		System.out.println(s.get());
	}

	public void test5()
	{
		Man man = new Man();
		String name = getGodnessName(man);// 会出现空指针
		System.out.println(name);
	}

	public void test6()
	{
//		Optional<NewMan> op = Optional.ofNullable(null);
		Optional<Goddness> gn = Optional.ofNullable(new Goddness("波多老师"));
		Optional<NewMan> op = Optional.ofNullable(new NewMan(gn));
		String godnessName = getNameJava8(op);
		System.out.println(godnessName);
	}

	public String getGodnessName(Man m)
	{
		if (m != null)
		{
			Goddness gn = m.getGn();
			if (null != gn)
			{
				return gn.getName();
			}
		}
		return "苍老师";
	}

	public String getNameJava8(Optional<NewMan> man)
	{
		return man.orElse(new NewMan()).getGod().orElse(new Goddness("苍老师")).getName();
	}
}
