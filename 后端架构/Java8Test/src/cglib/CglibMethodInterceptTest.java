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
//	private String name = "����";
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
//		// ����һ��Enhancer����
//		Enhancer enhancer = new Enhancer();
//		// ���ñ��������
//		enhancer.setSuperclass(Student.class);
//		Callback interceptor = new MethodInterceptor()
//		{
//			@Override
//			public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable
//			{
//				// TODO Auto-generated method stub
//				System.err.println("ԭ������:" + method.getName());
//				System.err.println("ԭ������������Ϊ " + method.getDeclaringClass());
//				System.err.println("���� " + (String) proxy.invokeSuper(object, args));
//				System.err.println("�ҵ��ý�����");
//				return null;
//			}
//		};
//		enhancer.setCallback(interceptor);
//		Student stu = (Student) enhancer.create();
//		stu.getStudentName();
//	}
//}
