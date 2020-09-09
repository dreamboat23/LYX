package javalearn.gouzaoqi;

public class Main {

	public static void main(String[] args) {
//		Father father = new Father();//实例化类的时候，默认执行对应的构造函数
		Kid kid = new Kid();
//		Kid kid1 = new Kid("b");
	}
}
	class Father {

		public Father() {
			System.out.println("Father的无参构造方法");
		}
		/*构造器的重载*/
		public Father(String str) {
			System.out.println("Father的有参构造方法    参数为：    ".concat(str));
		}

	}

	class Kid extends Father {

		/*
		 * Constructor call must be the first statement in a constructor
		 * 上面的意思是
		 *   在子类的构造方法的第一行，必须是第一行调用super()，这样就调用了父类的构造方法，
		 *   如果父类有多个不同的构造方法，则根据调用super()时传入的参数调用相应的父类构造方法*/
		public Kid() {
//			super();//调用父类的无参构造方法
			super("a");//调用父类的有参构造方法
			System.out.println("Kid的无参构造方法");
		}

		/*
		 * 在调用子类构造方法时，不管调用的是有参还是无参，
		 * 如果没有在第一行调用super(var xx)，都会默认先调用父类的无参构造方法。
		如果父类中没有无参构造方法，子类中的构造方法则必须调用super(var xx)，否则会报错*/
		public Kid(String str) {
//			super();//调用父类的无参构造方法
			super("a");//调用父类的有参构造方法
			System.out.println("Kid的有参构造方法    参数为：    ".concat(str));
		}
	}

