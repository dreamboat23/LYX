package testdemo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.yongx.spring5.User;

public class UserTest {

	@Test
	public void testAdd() {
		//1 加载spring配置文件
		//ApplicationContext：代表IOC容器
		//ClassPathXmlApplicationContext：当前应用的xml配置在classpath内路径下
		//创建ioc容器
		ApplicationContext context = 
				new FileSystemXmlApplicationContext("src/bean1.xml"); 

		//ApplicationContext context = 
			//	new ClassPathXmlApplicationContext("bean1.xml");

		//2 获取配置创建的对象
		//容器帮我们创建好对象了，根据xml中的id拿值
		User user = context.getBean("user", User.class);
		User user2 = context.getBean("user2", User.class);
		System.out.println("通过配置文件创建的对象1： " + user);
		System.out.println("通过配置文件创建的对象2： " + user2);
		System.out.print("通过配置文件创建的对象1调用User类的add方法： ");
		user.add();
	}
}
