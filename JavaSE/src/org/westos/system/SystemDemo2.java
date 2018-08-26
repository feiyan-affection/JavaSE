package org.westos.system;

import java.util.Arrays;

/**
 * public static void arraycopy(Object src, int srcPos,
                             Object dest,
                             int destPos,
                             int length)
               ��ָ��Դ�����е�ĳ��λ�ÿ�ʼ����,����Ŀ�������е�ĳ��λ��,ָ������
 * @author Administrator
 *
 */
public class SystemDemo2 {

	public static void main(String[] args) {
		
		//������������,�ֱ�̬��ʼ��
		int[] arr1 = {11,22,33,44,55} ;
		int[] arr2 = {6,7,8,9,10} ;
		
		//����
		System.arraycopy(arr1, 1, arr2, 2, 2);
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		
	}
}
