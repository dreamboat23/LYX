package testdemo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yongx.spring5.User;

public class UserTest {

	@Test
	public void testAdd() {
		//ApplicationContext：代表IOC容器
		//ClassPathXmlApplicationContext：当前应用的xml配置在classpath内路径下
		//创建ioc容器
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("bean1.xml");

		//容器帮我们创建好对象了，根据xml中的id拿值
		User user = context.getBean("user", User.class);
		System.out.println(user);
		user.add();
	}
}
