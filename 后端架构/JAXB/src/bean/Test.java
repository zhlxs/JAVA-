package bean;

import java.util.Date;

import util.JaxbUtil;

public class Test
{
	public static void main(String[] args)
	{
		Book book = new Book();
		book.setId(1);
		book.setAuthor("James");
		book.setCalendar(new Date());
		book.setPrice(1.5f);
		String xml = JaxbUtil.convertToXml(book);
		System.out.print(xml);
		System.out.println("----------------------------");
		String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" + "<book id=\"100\">" + "  <author>James</author>" + "  <calendar>2013-03-29T09:25:56.004+08:00</calendar>" + " <price_1>23.45</price_1>" + "</book>";
		Book book1 = JaxbUtil.convertToJavaBean(str, Book.class);
		System.out.println(book1);
	}
}
