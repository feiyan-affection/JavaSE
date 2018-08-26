package org.westos.collection.test;


import java.util.ArrayList;
import java.util.Collection;

/**
 * ����:��һ����,������5��ѧ��,�ֱ����Լ�����Ϣ(����,����,�Ա�...),����5��ѧ������Ϣ!(��ʹ�ü��ϸĽ�!)
 * 
 * @author Administrator
 *
 */
public class CollectionTest {
	
	public static void main(String[] args) {

		//����һ�����϶���
		Collection collection = new ArrayList() ;
		
		//����5��ѧ������
		Student student1 = new Student("����", 28) ;
		Student student2 = new Student("����", 25) ;
		Student student3 = new Student("����", 22) ;
		Student student4 = new Student("����", 29) ;
		
		collection.add(student1) ;//Object obj  = new Student("",..) ;
		collection.add(student2) ;
		collection.add(student3) ;
		collection.add(student4) ;
		
		//����:ת��������
		Object[] objs = collection.toArray() ;
		for(int x = 0 ; x < objs.length ; x ++) {
			
			//getXXx��ȡѧ����Ϣ
			Student student  = (Student) objs[x] ;
			System.out.println(student.getName()+"---"+student.getAge());
		}
		
	}
}
