package org.westos.date;

import java.util.Date;

/**
 * Date:��ʾ���ڸ�ʽ,��ȷ������
 * 
 * Date() �Ƚϳ��õ�   :��ȡ��ǰ��ϵͳʱ��:��Date��ʽ�����ֵ�
 * public Date(long date)���� Date ���󲢳�ʼ���˶����Ա�ʾ�Դӱ�׼��׼ʱ�䣨��Ϊ����Ԫ��epoch����
 * 				�� 1970 �� 1 �� 1 �� 00:00:00 GMT��������ָ���������� 
 * @author Administrator
 *
 */
public class DateDemo {
	
	public static void main(String[] args) {
		  
		//����һ��Date����
		Date date = new  Date() ;
		System.out.println("date:"+date);//Tue Jul 31 09:34:35 CST 2018 Date���ڸ�ʽ
		
		//2018-7-31 :�����ı���ʽ(���ڵ��ַ�����ʽ)
		
		long time = 1000*60 * 60 ;//Сʱ
		//�вι��췽��
		Date date2 = new Date(time) ;  //������  (��������Ŀ�õ�--ͨ��Date���ͱ�֤long���͵�ʱ��)
		System.out.println("date2:"+date2);
	}
}
