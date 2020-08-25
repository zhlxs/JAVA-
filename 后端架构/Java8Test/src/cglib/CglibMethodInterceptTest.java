//package cglib;
//
//import java.lang.reflect.Method;
//
//import net.sf.cglib.proxy.Callback;
//import net.sf.cglib.proxy.Enhancer;
//import net.sf.cglib.proxy.MethodInterceptor;
//import net.sf.cglib.proxy.MethodProxy;
//
///***
// * cglib
// * @author prd-hushanlin
// */
//
//class Student
//{
//	private String name = "张三";
//
//	public String getStudentName()
//	{
//		return name;
//	}
//}
//
//public class CglibMethodInterceptTest
//{
//	public static void main(String[] args)
//	{
//		// 创建一个Enhancer对象
//		Enhancer enhancer = new Enhancer();
//		// 设置被代理的类
//		enhancer.setSuperclass(Student.class);
//		Callback interceptor = new MethodInterceptor()
//		{
//			@Override
//			public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable
//			{
//				// TODO Auto-generated method stub
//				System.err.println("原方法名:" + method.getName());
//				System.err.println("原方法声明的类为 " + method.getDeclaringClass());
//				System.err.println("我是 " + (String) proxy.invokeSuper(object, args));
//				System.err.println("我调用结束了");
//				return null;
//			}
//		};
//		enhancer.setCallback(interceptor);
//		Student stu = (Student) enhancer.create();
//		stu.getStudentName();
//	}
//}
