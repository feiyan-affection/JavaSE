package org.westos.collection.test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Ϊʲôѧϰ����?
 * 		���ϵ�����:
 * 				Ŀǰ��ѧϰ��������һ�������������,����������Զ����������ͨ������(����,��Ϊ..)���ֵ�,�����������в���,
 * ���һ�Ҫ��Զ��������в���,(ʹ���������͵ı���):Ŀǰѧϰ��������:1)����  2)StringBuffer 
 * 		1)����:���ȹ̶�,�������㳤�ȱ仯��Ҫ��
 * 		2)StringBuffer:�ַ���������,���ڴ���ʼ�շ��ص���String����,Ҳ����һЩ����
 * Java�ṩһ������:����		
 * 			
 * 			������:
 * 					���Ϻ����������?
 * 					1)���ȵ�����
 * 						���鳤���ǹ̶���.			int[] arr  = new int[3]/int[] arr = {11,22,33...} ;
 * 						���ϳ����ǿɱ��!
 * 					2)�洢�������͵�����
 * 						����ȿ��Դ洢������������,Ҳ���Դ洢������������
 * 						����ֻ�ܴ洢������������
 * 					3)�洢Ԫ�ص�����
 * 						����洢ͬһ�����͵�Ԫ��       ����: ˮ���е�ˮ
 * 						���Ͽ��Դ洢������͵�Ԫ��
 
 * 						Collection<Integer> (���ͺ��潲) :��������˷���,���൱�����鶨��������
 * 
 * Collection ��νṹ �еĸ��ӿڡ�Collection ��ʾһ�������Щ����Ҳ��Ϊ collection ��Ԫ�ء�
 * 			һЩ collection �������ظ���Ԫ�أ�����һЩ������һЩ collection ������ģ�����һЩ��������ġ�
 * 			JDK ���ṩ�˽ӿڵ��κ�ֱ�� ʵ�֣����ṩ��������ӽӿڣ��� Set �� List��ʵ�֡�
 *��ӹ���:
 *		boolean add(Object e):��ӵ���Ԫ��
 *		boolean addAll(Collection c):���һ�������е�Ԫ��
 *ɾ������:r
 *		void clear()
 *		remove(Object o)
 *		removeAll(Collection c):�Ƴ�һ�������е�Ԫ��   ˼��:�Ƴ�һ�������Ƴ������Ƴ����������Ƴ���?
 *�жϹ���:
 *		boolean contains(Object o):һ���������Ƿ����ָ����Ԫ��
 *		boolean containsAll(Collection c):����һ�������е�Ԫ��  ˼��: ����һ�����ǰ������ǰ����������ǰ���?
 *		boolean isEmpty():�жϼ����Ƿ�Ϊ��. ��,����true
 *
 * ��ȡ����:
 * 			int size()  :��ȡԪ�����ķ���
 * 			Iterator iterator():������  (�������ϵ����й���)
 *ת������:
 *			Object[] toArray() :������ת��������
 *
 *����
 *	boolean retainAll(Collection c) :˼������A���϶�B����ȡ����,������Ԫ��ȥ����? 
 *					����boolean�ı�����˼��ʲô
 * 
 * @author Administrator
 *
 */
public class CollectionDemo {
	
	public static void main(String[] args) {
		
		//����all�Ĺ�������Collection��������:
		//�������϶���
//		Collection c = new Collection() ;   ����ʵ������
		Collection c = new ArrayList() ; //����List�ӿڵ���ʵ������ʵ����
		System.out.println(c);//[]   ����û��Ԫ��:[]   �ڲ�����д��Object��toString����
		
//		boolean add(Object e):��ӵ���Ԫ��
//		System.out.println(c.add("hello"));
		/**
		 * ArrayList��add������Դ��
		 *   public boolean add(E e) {
			        ensureCapacityInternal(size + 1);  // Increments modCount!!
			        elementData[size++] = e;
        			return true;  //ֻҪ���Ԫ��,�ͷ���true
    }
		 */
		c.add("hello") ;
		c.add(100);
		c.add("world") ;
		c.add("java") ;
		System.out.println(c);
		//void clear();
//		c.clear(); 
		//remove(Object o)
		System.out.println(c.remove("java"));
		System.out.println(c);
		
		
		//boolean contains(Object o):һ���������Ƿ����ָ����Ԫ��
		System.out.println(c.contains("android")) ;
		
		//boolean isEmpty():�жϼ����Ƿ�Ϊ��. ��,����true
		System.out.println(c.isEmpty());
		System.out.println(c.size());
	}
}
