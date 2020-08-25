package test;

import java.util.HashMap;

public class WebSiteFactory
{
	private HashMap<String, ConcreteWebSite> pool = new HashMap<>();

	// �����վ����
	public WebSite getWebSiteCategory(String key)
	{
		if (!pool.containsKey(key))
		{
			pool.put(key, new ConcreteWebSite(key));
		}
		return (WebSite) pool.get(key);
	}

	// �����վ��������
	public int getWebSiteCount()
	{
		return pool.size();
	}
}
