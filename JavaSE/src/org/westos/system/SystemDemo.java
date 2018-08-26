package org.westos.system;
/**
 * System
 * 		in:��׼������				InputStream  �ֽ�������
 * 		out:��׼�����				PrintStream  �ֽڴ�ӡ��				PrintWriter:�ַ���ӡ��
 * 
 * 	gc():public static void gc()  :Java ���������һЩŬ��������δ�ö���
 * 				��������������,��ʵ�����ǵ�������дObject�е�finalize()����
 * 
 * 			final, finalize, finally(�����쳣������ʱ��:�����쳣�ͷ���Դ)֮�������?
 * 			public static void exit(int status):�������ִ��,jvm���˳��� ,������0
 * @author Administrator
 *
 */
public class SystemDemo {
	
	public static void main(String[] args) {
		System.out.println("�Ұ���ԲԲ");
		System.exit(0); //jvm�˳���...
		System.out.println("�һ�������...");
		
		
		
		//����ѧ������
		Student student = new Student("��ԲԲ",28	) ;
		System.out.println(student);//westos.org.system.demo.Student@70dea4e
		//Student [name=��ԲԲ, age=28]
		
		
		student = null ;//student����ָ�����ڴ�
		//��������������
		System.gc(); 
	}
}
