package org.westos.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * (�ص�)
 * Date---->String֮�����ת��
 * ���ڸ�ʽ       �����ı���ʽ
 * 
 * ��������֮���ת���õ�:DateFormat�����:����һ��������,����ʵ����!����������:SimpleDateFormat
 * Date----String			��ʽ��       String format(Date date) 
 * String--Date				����           public Date parse(String source)  throws parseEception (����ʱ���쳣)
 * 
 * SimpleDateFormat�Ĺ��췽��
 * 
 * SimpleDateFormat(String pattern):
 * ������ʾ:  pattern:��ǰ����ʹ����һ��ģʽ:�����߹涨xxxx��xx�� xx��  xxʱ x��x��
 * 											 xxxx-xx-xx 
 * 
 *     	��:	y			   yyyy
 *     	�£�M               MM
 *     	��: d				dd 			yyyy-MM-dd HH:mm:ss  
 *        												
 * 
 * @author Administrator
 *
 */


public class DateDemo3 {
   
	public static void main(String[] args) throws ParseException {
		
		//Date  -- >String :��ʽ��
		//����Date���ڶ���
		Date date = new Date() ;
		//����SimpleDateFormat����
		SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("yyyy-MM-dd") ;
		//����format��ʽ������
		String dateStr = simpleDateFormat.format(date) ;
		System.out.println("dateStr:"+dateStr);
		
		
		System.out.println("------------------------------------");
		
		//String--->Date:����
		//���������ı���ʽ
		String str = "2019-10-1" ;
		
		//����SimpleDateFormat����
		/**
		 * ע��:
		 * 	����Ҫ���ı����ڸ�ʽת����Date��ʽ:�ı���ʽ�ĸ�ʽ �����SimpleDateFormatģʽһ��,
		 * 					�����޷�����!����ParseException
		 */
		SimpleDateFormat simpleDateFormat2  = new SimpleDateFormat("yyyy-MM-dd") ;
		//����
		Date date2 = simpleDateFormat2.parse(str) ;
		System.out.println("date2:"+date2);//Tue Oct 01 00:00:00 CST 2019
	}
}
