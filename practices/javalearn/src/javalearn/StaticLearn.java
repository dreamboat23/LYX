package javalearn;

public class StaticLearn {

	public static void main(String[] args) {
		Demo11 demo11 = new Demo11();
		demo11.eat(); //ͨ��ʵ�������ʾ�̬����
		demo11.eat2();//ͨ��ʵ��������ʵ������

		Demo11.eat(); //ͨ������ֱ�ӷ��ʾ�̬����
		System.out.println(Demo11.str1);//ͨ������ֱ�ӷ��ʾ�̬����
		System.out.println(demo11.str2);//ͨ��ʵ��������ʵ������
	}
}

class Demo11 {
	static String str1 = "��̬����";
	String str2 = "ʵ������";
	/*
	 * ��̬����*/
	public static void eat() {
		System.out.println(str1);//ͨ����̬�������ʾ�̬����
//		System.out.println(str2);
		//Cannot make a static reference to the non-static field str3
		//��̬�������ɵ��÷Ǿ�̬����
		//eat2();
		//Cannot make a static reference to the non-static method eat2() from the type Demo9
		//��̬�������ɵ��÷Ǿ�̬����
	}
	
	public void eat2() {
		eat(); //ͨ��ʵ���������ʾ�̬����
		System.out.println(str1);//ͨ��ʵ���������ʾ�̬����
		System.out.println(str2);//ͨ��ʵ����������ʵ������
	}
}

