package org.westos.collection.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * ����:��5��ѧ������,5��ѧ�����Լ�����Ϣ,ʹ�õ������ı�����ʽʵ��!
 * @author Administrator
 *
 */
public class CollectionTset3 {

	public static void main(String[] args) {
		
		//1)�������϶���
		Collection collection = new ArrayList() ;
		
		//2)����ѧ������
		Student student1 = new Student("����", 29) ;
		Student student2 = new Student("����", 29) ;
		Student student3 = new Student("�����P", 38) ;
		Student student4 = new Student("������", 40) ;
		
		//3)���
		collection.add(student1);
		collection.add(student2);
		collection.add(student3);
		collection.add(student4);
		
		//4)��ȡ������
		Iterator it = collection.iterator() ;
		//5)����
		while(it.hasNext()) {
			//ת��
			Student student = (Student)it.next() ;
			System.out.println(student.getName()+"---"+student.getAge());
		}
	}
}
