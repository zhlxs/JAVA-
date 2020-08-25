package optional;

import java.util.Optional;

/**
 * �����ָ���쳣����
 * @author prd-hushanlin
 */
public class OptionalExample
{
	public void test1()
	{
//		Optional<User> op = Optional.of(new User());
		Optional<User> op = Optional.of(null);// ��ָ���쳣
		User user = op.get();
		System.out.println(user.getName());
	}

	public void test2()
	{
		Optional<User> op = Optional.empty();// �����յĶ���
		System.out.println(op.get());// ��ָ��
	}

	public void test3()
	{
		Optional<User> op = Optional.ofNullable(new User());
		// Optional<User> op = Optional.ofNullable(null);//��ָ��
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
		String name = getGodnessName(man);// ����ֿ�ָ��
		System.out.println(name);
	}

	public void test6()
	{
//		Optional<NewMan> op = Optional.ofNullable(null);
		Optional<Goddness> gn = Optional.ofNullable(new Goddness("������ʦ"));
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
		return "����ʦ";
	}

	public String getNameJava8(Optional<NewMan> man)
	{
		return man.orElse(new NewMan()).getGod().orElse(new Goddness("����ʦ")).getName();
	}
}
