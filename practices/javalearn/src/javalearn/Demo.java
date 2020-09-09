package javalearn;

public class Demo {
	static String str1 = "hello string1";

	public static void main(String[] args) {
//		Demo7 demo7 = new Demo7();
//		System.out.println(str1);//调用静态(全局)变量
//		//System.out.println(str2);
//		Demo9.eat(); //通过类名直接调用静态方法/静态方法调用静态变量
		Demo9 demo9A = new Demo9();
//		demo9.eat2();//通过实例化对象调用非静态方法
		demo9A.eat(); //通过实例化对象调用静态方法/静态方法调用静态变量
//		System.out.println(Demo9.str2);//通过类.static变量 调用static变量
//		System.out.println(demo9.str3);//通过实例化对象调用局部变量
//		demo7.father(); //抽象类的子类访问父类方法
		Demo9 demo9B = new Demo9();
		System.out.println(demo9A.str2 = "A"); //对象A修改了一个static变量
		System.out.println(demo9B.str2); //对象B去访问,得到的是修改后的值
		System.out.println(Demo9.str2); //类去访问,得到的是修改后的值
		System.out.println(demo9A.str3 = "A"); //对象A修改了一个非static变量
		System.out.println(demo9B.str3); //对象B去访问,得到的是修改前的值
		
	}
//	public static void main() {
//		
//	} 
	//Demo.main();
	//Demo.main(args);系统调用main方法时是调用的含有对应的参数的重载main方法，
	//所以main方法定义时需要定义String[]类型的参数args
}

interface DemoInterface {
	void read();
	void write();
	static void fatehr() {
		System.out.println("接口实现的fatehr()");
	}
}

/*
 * 抽象类*/
abstract class Demo2 implements DemoInterface {
	/*抽象方法必须为public或者protected（因为如果为private，则不能被子类继承，子类便无法实现该方法），
	 * 缺省情况下默认为public。*/
	public void sleep() {
	}
}

/*
 * 父接口的实现*/
class Demo3 implements DemoInterface {
	public void read() {
		System.out.println("父接口实现的read()");
	}
	public void write() {
	}
}

/*
 * 子接口中不需再定义父接口中的方法；
 * 即extends表示子接口已继承父接口中的所有方法
 * 且子接口还可以再定义更多父接口中没有的方法，来达到扩展功能的效果*/
interface Demo4 extends DemoInterface {
	void work();
}

/*
 * 子接口的实现*/
class Demo5 implements Demo4 {

	public void read() {
		System.out.println("子接口实现的read()");
	}
	public void write() {
	}
	public void work() {
		System.out.println("子接口实现的work()");
	}
}
/*
 * 有抽象方法的类必须被定义为abstract类*/
abstract class Demo6 {
	abstract void learn();
	void father() {
		System.out.println("抽象类实现的father()");
	}
}
/*
 * 抽象类的子类*/
class Demo7 extends Demo6 {
	void jump() {
		System.out.println("抽象类的子类的jump()");
	}
	
	public void learn() {
		System.out.println("抽象类的子类的learn()");
	}
}
/*
 * 重写及重载演示*/
class Demo8 extends Demo7 {
	void jump() {
		System.out.println("父类jump()的重写");
	}
	
	void jump(int i, int j) {
		System.out.println("子类jump(int)的重载:" + (i*j));
	}
	
	void jump(String a, String b) {
		System.out.println("子类jump(String)的重载:" + (a + b));
	}
}

class Demo9 {
	//String str2 = "hello string2"; Cannot make a static reference to the non-static field str2
	static String str2 = "hello string2";
	String str3 = "hello string3";
	/*
	 * 静态方法*/
	public static void eat() {
		System.out.println("静态方法的类名调用");
		System.out.println(str2);
		//System.out.println(str3);
		//Cannot make a static reference to the non-static field str3
		/*
		 * java静态方法中不能引用非静态变量
		 * 因为我们知道静态的方法可以在没有创建实例时使用,
		 * 而申明为非静态的成员变量是一个对象属性,它只有在对象存在时引用,
		 * 因此如果在对象未创建实例时我们在静态方法中调用了非静态成员方法自然是非法的，
		 * 所以编译器会在这种时候给出错误。*/
		//eat2();
		//Cannot make a static reference to the non-static method eat2() from the type Demo9
		//静态方法不可调用非静态方法
	}
	
	public void eat2() {
		String str4 = "hello string4";
		System.out.println(str3);
		System.out.println(str4);
	}
}

class Demo10 {
	private String name;

	public String GetName(String name) {
		this.name = name;
		return this.name;
	}
}
