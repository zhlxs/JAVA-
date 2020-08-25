package demo;

public class Client
{
	public static void main(String[] args)
	{
		ComponentOrganization university = new University("����ɽ��ѧ", "λ�ڽ���������һ����ѧ");

		ComponentOrganization college1 = new College("������ѧѧԺ", "������ѧѧԺ");
		ComponentOrganization college2 = new College("����ѧԺ", "����ѧԺ");

		ComponentOrganization department = new Department("������ѧ", "������ѧ");
		ComponentOrganization department2 = new Department("��������", "��������");

		ComponentOrganization department3 = new Department("�������", "�������");
		ComponentOrganization department4 = new Department("�������ѧ", "�������ѧ");

		college1.add(department);
		college1.add(department2);
		college2.add(department3);
		college2.add(department4);

		university.add(college1);
		university.add(college2);

		university.print();

	}
}
