package bean;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD) // �����ֶλ����Ե����л���FIELD��ʾJAXB���Զ���Java���е�ÿ���Ǿ�̬�ģ�static������˲̬�ģ���@XmlTransient��
@XmlRootElement // ע���ֶε�XML������ֵ����XmlAccessType.PROPERTY��XmlAccessType.NONE��
@XmlType(name = "book", propOrder = { "author", "calendar", "price", "id" })
public class Book
{
	@XmlElement(required = true)
	private String author;
	@XmlElement(name = "price_1", required = true)
	private float price;
	@XmlElement
	private Date calendar;
	@XmlAttribute
	private Integer id;

	public String getAuthor()
	{
		return author;
	}

	public void setAuthor(String author)
	{
		this.author = author;
	}

	public float getPrice()
	{
		return price;
	}

	public void setPrice(float price)
	{
		this.price = price;
	}

	public Date getCalendar()
	{
		return calendar;
	}

	public void setCalendar(Date calendar)
	{
		this.calendar = calendar;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	@Override
	public String toString()
	{
		return "Book [author=" + author + ", price=" + price + ", calendar=" + calendar + ", id=" + id + "]";
	}

}
