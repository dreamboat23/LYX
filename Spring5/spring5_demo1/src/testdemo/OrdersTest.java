package testdemo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.Order;

import com.yongx.spring5.Orders;

public class OrdersTest {

	@Test
	public void test() {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("bean1.xml");
		Orders orders = context.getBean("orders", Orders.class);
		System.out.println(orders);
	}
}
