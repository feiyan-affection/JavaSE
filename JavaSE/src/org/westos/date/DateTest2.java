package org.westos.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * ����¼�����ĳ���������,��һ����������������ж�������?
 * 
 * ����:
 * 	1)��������¼�����,¼��һ���ַ���:������������
 * 	2)ʹ��SimpleDateFormat������ǰ�ַ�����ʽ,����һ��ģʽ
 * 	3)����ͨ��getTime() :��Date--->long :�������µ�ʱ�����ֵ
 * 	4)����ͨ��Syetem��ȡ��ǰϵͳʱ���ʱ�����ֵ
 * 	5)4)-3) long ������
 * @author Administrator
 *
 */
public class DateTest2 {
	
	public static void main(String[] args) throws ParseException {
		//��������¼�����
		Scanner scanner = new Scanner(System.in) ;
		
		//��������
		System.out.println("�����������ĳ���������:");
		String line = scanner.nextLine() ;
		
		//����SimpleDateFormat����
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd") ; 
		//����
		Date date = simpleDateFormat.parse(line) ;
		
		//ͨ��date��ȡ�������������ڵ�ʱ��ĺ���ֵ
		long myTime = date.getTime() ;
		
		//��ȡ��ǰϵͳʱ�����ֵ
		long nowTime = System.currentTimeMillis() ;
		
		long time = nowTime- myTime ;
		//������
		long day = time/1000/60/60/24 ;
		System.out.println("���Ѿ��������ʱ��"+day+"����");
	}
	
}
