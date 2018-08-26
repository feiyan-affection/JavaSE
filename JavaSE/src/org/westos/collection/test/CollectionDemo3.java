package org.westos.collection.test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * �������д洢�Զ���һ��String���͵�����,��String���͵����ݴӼ����б�������
 * 
 * 
 * ʹ�õ��ķ���:	
 * 		Object[] toArray() :������ת��������			:��������ԭʼ�ı������ϵķ�ʽ
 * 
 * 
 * ����:��һ����,������5��ѧ��,�ֱ����Լ�����Ϣ(����,����,�Ա�...),����5��ѧ������Ϣ!(��ʹ�ü��ϸĽ�!)
 * @author Administrator
 *
 */
public class CollectionDemo3 {

	public static void main(String[] args) {
		
		//����һ�����϶���
		Collection c = new ArrayList() ;
		
		//�����������Ԫ��
		c.add("hello") ; // add(Object obj ):Object  obj = new String("hello") ; //����ת��
		c.add("java") ;
		c.add("world");
		c.add("javaEE") ;
		
		//����: ������ת�������� Object[] toArray()
		Object[] objs  =c.toArray() ;
		for(int x = 0 ; x <objs.length ; x++) {
		   //	System.out.println(objs[x]);
			
			//����ַ�����ͬʱ,��Ҫ��ȡString�������ݳ���
			 String str = (String) objs[x] ; //����ת��
			System.out.println(str+"---"+str.length());
			
		}
	}
}
