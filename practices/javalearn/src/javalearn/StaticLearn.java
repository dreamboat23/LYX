package javalearn;

public class StaticLearn {

	public static void main(String[] args) {
		Demo11 demo11 = new Demo11();
		demo11.eat(); //通过实例来访问静态方法
		demo11.eat2();//通过实例来访问实例方法

		Demo11.eat(); //通过类名直接访问静态方法
		System.out.println(Demo11.str1);//通过类名直接访问静态变量
		System.out.println(demo11.str2);//通过实例来访问实例变量
	}
}

class Demo11 {
	static String str1 = "静态变量";
	String str2 = "实例变量";
	/*
	 * 静态方法*/
	public static void eat() {
		System.out.println(str1);//通过静态方法访问静态变量
//		System.out.println(str2);
		//Cannot make a static reference to the non-static field str3
		//静态方法不可调用非静态变量
		//eat2();
		//Cannot make a static reference to the non-static method eat2() from the type Demo9
		//静态方法不可调用非静态方法
	}
	
	public void eat2() {
		eat(); //通过实例方法访问静态方法
		System.out.println(str1);//通过实例方法访问静态变量
		System.out.println(str2);//通过实例方法访问实例变量
	}
}

