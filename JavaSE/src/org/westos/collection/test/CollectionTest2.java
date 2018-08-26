package org.westos.collection.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * ���ϵ�ר�б�����ʽ:	(������)
 * 
 * 	Iterator<E> iterator()
 * 
 * 		��Iterator����
 * 				boolean hasNext()
 * 				Obect next()���ص�������һ��Ԫ�ء� 
 * 
 * 
 * 
 * @author Administrator
 *
 */
public class CollectionTest2 {
	
	public static void main(String[] args) {
		
		//�������϶���
		Collection  collection = new ArrayList() ;
		//����������Ӽ����ַ���Ԫ��
		collection.add("hello") ;
		collection.add("java") ;
		collection.add("world") ;
		collection.add("hadoop") ;
		//ר�е����ı�����ʽ
		//��ȡ������
		Iterator iterator = collection.iterator() ; //ʵ�ַ�ʽ:�ײ���һ���ڲ���
		
		//Object next()���ص�������һ��Ԫ�ء� 
//		Object object = iterator.next() ;
//		System.out.println(object);
		
		/*System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		//Ԫ�ػ�ȡ�����,û��Ԫ����,�������������������:NoSuchElementException:û��������Ԫ���쳣!
		 
		 java.util.ArrayList$Itr
		System.out.println(iterator.next());*/
		
		
		//����ʵ��:�ڻ�ȡ��һ������(���Ա���)��Ԫ��֮ǰ,Ӧ���ṩ�жϹ���
		//�Ľ�
	/*	if(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		if(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		if(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		if(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		if(iterator.hasNext()) {
			System.out.println(iterator.next());
		}*/
		
		//ѭ���Ľ�:whileѭ��
		//jdk5�Ժ�:������:����������� ��ǿfor
		//for(String str: ���϶���/�������){}
		while(iterator.hasNext()) {
//			System.out.println(iterator.next());
			
			//������ʽֱ�������,���Ҫ��ȡ�ַ������ݵ�ͬʱ,��ȡ����
			String str = (String)iterator.next() ;
			System.out.println(str+"---"+str.length());
		}
		
		
	}
}
