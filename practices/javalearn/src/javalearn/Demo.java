package javalearn;

public class Demo {
	static String str1 = "hello string1";

	public static void main(String[] args) {
//		Demo7 demo7 = new Demo7();
//		System.out.println(str1);//���þ�̬(ȫ��)����
//		//System.out.println(str2);
//		Demo9.eat(); //ͨ������ֱ�ӵ��þ�̬����/��̬�������þ�̬����
		Demo9 demo9A = new Demo9();
//		demo9.eat2();//ͨ��ʵ����������÷Ǿ�̬����
		demo9A.eat(); //ͨ��ʵ����������þ�̬����/��̬�������þ�̬����
//		System.out.println(Demo9.str2);//ͨ����.static���� ����static����
//		System.out.println(demo9.str3);//ͨ��ʵ����������þֲ�����
//		demo7.father(); //�������������ʸ��෽��
		Demo9 demo9B = new Demo9();
		System.out.println(demo9A.str2 = "A"); //����A�޸���һ��static����
		System.out.println(demo9B.str2); //����Bȥ����,�õ������޸ĺ��ֵ
		System.out.println(Demo9.str2); //��ȥ����,�õ������޸ĺ��ֵ
		System.out.println(demo9A.str3 = "A"); //����A�޸���һ����static����
		System.out.println(demo9B.str3); //����Bȥ����,�õ������޸�ǰ��ֵ
		
	}
//	public static void main() {
//		
//	} 
	//Demo.main();
	//Demo.main(args);ϵͳ����main����ʱ�ǵ��õĺ��ж�Ӧ�Ĳ���������main������
	//����main��������ʱ��Ҫ����String[]���͵Ĳ���args
}

interface DemoInterface {
	void read();
	void write();
	static void fatehr() {
		System.out.println("�ӿ�ʵ�ֵ�fatehr()");
	}
}

/*
 * ������*/
abstract class Demo2 implements DemoInterface {
	/*���󷽷�����Ϊpublic����protected����Ϊ���Ϊprivate�����ܱ�����̳У�������޷�ʵ�ָ÷�������
	 * ȱʡ�����Ĭ��Ϊpublic��*/
	public void sleep() {
	}
}

/*
 * ���ӿڵ�ʵ��*/
class Demo3 implements DemoInterface {
	public void read() {
		System.out.println("���ӿ�ʵ�ֵ�read()");
	}
	public void write() {
	}
}

/*
 * �ӽӿ��в����ٶ��常�ӿ��еķ�����
 * ��extends��ʾ�ӽӿ��Ѽ̳и��ӿ��е����з���
 * ���ӽӿڻ������ٶ�����ุ�ӿ���û�еķ��������ﵽ��չ���ܵ�Ч��*/
interface Demo4 extends DemoInterface {
	void work();
}

/*
 * �ӽӿڵ�ʵ��*/
class Demo5 implements Demo4 {

	public void read() {
		System.out.println("�ӽӿ�ʵ�ֵ�read()");
	}
	public void write() {
	}
	public void work() {
		System.out.println("�ӽӿ�ʵ�ֵ�work()");
	}
}
/*
 * �г��󷽷�������뱻����Ϊabstract��*/
abstract class Demo6 {
	abstract void learn();
	void father() {
		System.out.println("������ʵ�ֵ�father()");
	}
}
/*
 * �����������*/
class Demo7 extends Demo6 {
	void jump() {
		System.out.println("������������jump()");
	}
	
	public void learn() {
		System.out.println("������������learn()");
	}
}
/*
 * ��д��������ʾ*/
class Demo8 extends Demo7 {
	void jump() {
		System.out.println("����jump()����д");
	}
	
	void jump(int i, int j) {
		System.out.println("����jump(int)������:" + (i*j));
	}
	
	void jump(String a, String b) {
		System.out.println("����jump(String)������:" + (a + b));
	}
}

class Demo9 {
	//String str2 = "hello string2"; Cannot make a static reference to the non-static field str2
	static String str2 = "hello string2";
	String str3 = "hello string3";
	/*
	 * ��̬����*/
	public static void eat() {
		System.out.println("��̬��������������");
		System.out.println(str2);
		//System.out.println(str3);
		//Cannot make a static reference to the non-static field str3
		/*
		 * java��̬�����в������÷Ǿ�̬����
		 * ��Ϊ����֪����̬�ķ���������û�д���ʵ��ʱʹ��,
		 * ������Ϊ�Ǿ�̬�ĳ�Ա������һ����������,��ֻ���ڶ������ʱ����,
		 * �������ڶ���δ����ʵ��ʱ�����ھ�̬�����е����˷Ǿ�̬��Ա������Ȼ�ǷǷ��ģ�
		 * ���Ա�������������ʱ���������*/
		//eat2();
		//Cannot make a static reference to the non-static method eat2() from the type Demo9
		//��̬�������ɵ��÷Ǿ�̬����
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
