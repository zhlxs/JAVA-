package principle;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest
{
	// newFixedThreadPool鐨勯樆濉為槦鍒楀ぇ灏忔槸娌℃湁澶у皬闄愬埗鐨勶紝濡傛灉闃熷垪鍫嗙Н鏁版嵁澶浼氶�犳垚璧勬簮娑堣�椼��
	// newCachedThreadPool鏄嚎绋嬫暟閲忔槸娌℃湁澶у皬闄愬埗鐨勶紝褰撴柊鐨勭嚎绋嬫潵浜嗙洿鎺ュ垱寤猴紝鍚屾牱浼氶�犳垚璧勬簮娑堣�楁畣灏姐��
	private ExecutorService executorService;

	/**
	 * 鑷畾涔夌嚎绋嬫睜
	 */
	public void customThreadPool()
	{
		int corePoolSize = 2;
		int maximumPoolSize = 4;
		long keepAliveTime = 10;
		TimeUnit unit = TimeUnit.SECONDS;
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
		// ThreadFactory threadFactory = new NameTreadFactory();
		// RejectedExecutionHandler handler = new MyIgnorePolicy();
		RejectedExecutionHandler defaultHandler = new AbortPolicy(); // 浣跨敤榛樿鐨勬嫆缁濈瓥鐣�
		executorService = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, Executors.defaultThreadFactory(), defaultHandler);
	}

	/**
	 * 骞村害闇�姹備换鍔″彴涓嬭揪浠诲姟鏃跺悓姝ョ鍚堣鍒掔殑骞村害闇�姹傝鍒�(鐗╄祫+鏈嶅姟)
	 * @param fdYear
	 */
	public void syncAnnualPlans(String fdYear)
	{
		try
		{
			executorService.submit(new SyncFwPlans(fdYear));
			executorService.submit(new SyncWzPlans(fdYear));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			executorService.shutdown();
		}
	}

	/**
	 * 鍚屾鏈嶅姟璁″垝
	 * @author prd-hushanlin
	 */
	class SyncFwPlans implements Runnable
	{
		String year;

		public SyncFwPlans(String year)
		{
			super();
			this.year = year;
		}

		public String getYear()
		{
			return year;
		}

		@Override
		public void run()
		{
			// 鍚屾閫昏緫浠ｇ爜
//			MtPlanProjectService query = new MtPlanProjectService();
//			query.setYear(getYear());
//			List<MtPlanDemandSyncRelation> syncList = mtPlanProjectServiceService.selectAnnualPlansByExample(query);
//			BuildAnnualRelation buildAnnualRelation = new BuildAnnualRelationUtil(syncList);
//			buildAnnualRelation.buildResult();
		}
	}

	/**
	 * 鍚屾鐗╄祫璁″垝
	 * @author prd-hushanlin
	 */
	class SyncWzPlans implements Runnable
	{
		String year;

		public SyncWzPlans(String year)
		{
			super();
			this.year = year;
		}

		public String getYear()
		{
			return year;
		}

		@Override
		public void run()
		{
			// 鍚屾閫昏緫浠ｇ爜
//			MtPlanMain query = new MtPlanMain();
//			query.setYear(getYear());
//			List<MtPlanDemandSyncRelation> syncList = mtPlanMainService.selectAnnualPlansByExample(query);
//			BuildAnnualRelation buildAnnualRelation = new BuildAnnualRelationUtil(syncList);
//			buildAnnualRelation.buildResult();
		}
	}

	/**
	 * 鑷畾涔夌嚎绋嬫睜
	 * @param args
	 * @throws InterruptedException
	 * @throws IOException
	 */
	public static void main(String[] args) throws InterruptedException, IOException
	{
		int corePoolSize = 2;
		int maximumPoolSize = 4;
		long keepAliveTime = 10;
		TimeUnit unit = TimeUnit.SECONDS;
		BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
		ThreadFactory threadFactory = new NameTreadFactory();
		RejectedExecutionHandler handler = new MyIgnorePolicy();
		ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
		executor.prestartAllCoreThreads(); // 棰勫惎鍔ㄦ墍鏈夋牳蹇冪嚎绋�
		for (int i = 1; i <= 10; i++)
		{
			MyTask task = new MyTask(String.valueOf(i));
			executor.execute(task);
		}
		System.in.read(); // 闃诲涓荤嚎绋�
	}

	/**
	 * 鑷畾涔塗hreadFactory
	 * @author prd-hushanlin
	 */
	static class NameTreadFactory implements ThreadFactory
	{

		private final AtomicInteger mThreadNum = new AtomicInteger(1);

		@Override
		public Thread newThread(Runnable r)
		{
			Thread t = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
			System.out.println(t.getName() + " has been created");
			return t;
		}
	}

	/**
	 * 鎷掔粷绛栫暐
	 * @author prd-hushanlin
	 */
	public static class MyIgnorePolicy implements RejectedExecutionHandler
	{

		public void rejectedExecution(Runnable r, ThreadPoolExecutor e)
		{
			doLog(r, e);
		}

		private void doLog(Runnable r, ThreadPoolExecutor e)
		{
			// 鍙仛鏃ュ織璁板綍绛�
			System.err.println(r.toString() + " rejected");
			// System.out.println("completedTaskCount: " +
			// e.getCompletedTaskCount());
		}
	}

	static class MyTask implements Runnable
	{
		private String name;

		public MyTask(String name)
		{
			this.name = name;
		}

		@Override
		public void run()
		{
			try
			{
				System.out.println(this.toString() + " is running!");
				Thread.sleep(3000); // 璁╀换鍔℃墽琛屾參鐐�
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

		public String getName()
		{
			return name;
		}

		@Override
		public String toString()
		{
			return "MyTask [name=" + name + "]";
		}
	}
}
