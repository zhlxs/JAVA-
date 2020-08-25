package demo;

public class Client
{
	public static void main(String[] args)
	{
		ComponentOrganization university = new University("井冈山大学", "位于江西吉安的一所大学");

		ComponentOrganization college1 = new College("生命科学学院", "生命科学学院");
		ComponentOrganization college2 = new College("教育学院", "教育学院");

		ComponentOrganization department = new Department("环境科学", "环境科学");
		ComponentOrganization department2 = new Department("环境工程", "环境工程");

		ComponentOrganization department3 = new Department("软件工程", "软件工程");
		ComponentOrganization department4 = new Department("计算机科学", "计算机科学");

		college1.add(department);
		college1.add(department2);
		college2.add(department3);
		college2.add(department4);

		university.add(college1);
		university.add(college2);

		university.print();

	}
}
