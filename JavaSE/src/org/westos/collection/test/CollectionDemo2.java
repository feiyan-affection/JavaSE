package org.westos.collection.test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Collection�ĸ߼�����:
 * 		boolean addAll(Collection c):���һ�������е�Ԫ��
 * 		removeAll(Collection c):�Ƴ�һ�������е�Ԫ��   ˼��:�Ƴ�һ�������Ƴ������Ƴ����������Ƴ���?
 * 		boolean containsAll(Collection c):����һ�������е�Ԫ��  ˼��: ����һ�����ǰ������ǰ����������ǰ���?	
 * 		boolean retainAll(Collection c) :˼������A���϶�B����ȡ����,������Ԫ��ȥ����? 
 *					����boolean�ı�����˼��ʲô
 * @author Administrator
 *
 */
public class CollectionDemo2 {
	
	public static void main(String[] args) {
		
		//�����������϶���
		Collection c1  = new ArrayList();
		Collection c2  = new ArrayList();
		
		//�ֱ������c1,c2�����Ԫ��
		c1.add("abc1") ;
		c1.add("abc2") ;
		c1.add("abc3") ;
		c1.add("abc4") ;
		
//		c2.add("abc1") ;
//		c2.add("abc2") ;
//		c2.add("abc3") ;
		c2.add("abc4") ;
//		c2.add("abc5") ;
//		c2.add("abc6") ;
//		c2.add("abc7") ;
		
		System.out.println("c1:"+c1);
		System.out.println("c2:"+c2);
		System.out.println("-------------------------");
		//boolean addAll(Collection c):���һ�������е�����Ԫ��,��ӵ�c1��
		//System.out.println("addAll():"+c1.addAll(c2));
		
		//	removeAll(Collection c):�Ƴ�һ�������е�Ԫ��   ˼��:�Ƴ�һ�������Ƴ������Ƴ����������Ƴ���?
//		System.out.println("removeAll():"+c1.removeAll(c2));  //ɾ��һ������ɾ��!,ɾ������true
		//	boolean containsAll(Collection c):����һ�������е�Ԫ��  ˼��: ����һ�����ǰ������ǰ����������ǰ���?
			
		
//		System.out.println("containsAll():"+c1.containsAll(c2)); //�����������ǰ���
		/**
		 * A���϶�B����ȡ����,������Ԫ�ص�ȥA����������,���ص�boolean������˼A�����е�Ԫ���Ƿ����仯.���û�б仯,false
		 * ����,true
		 */
		
		
		
		//boolean retainAll(Collection c) 
		System.out.println("retainAll():"+c1.retainAll(c2));
		
		
		System.out.println("c1:"+c1);
		System.out.println("c2:"+c2);
		
		
	}
}
