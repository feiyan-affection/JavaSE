package org.westos.date;

import java.text.ParseException;
import java.util.Date;

//DateUtils�Ĳ�����
public class DateUtilDemo {

	public static void main(String[] args) throws ParseException {
		
		//Date---String
		Date date = new Date() ;
		String str1 = DateUtils.dateToString(date, "yyyy-MM-dd") ;
		System.out.println(str1);
		
		String str2 = DateUtils.dateToString(date, "yyyy��MM��dd�� HHʱmm��ss��") ;
		System.out.println(str2);
		System.out.println("-------------------------------");
		
		//String--Dat
		String s = "2012-5-12" ;
		Date date2 = DateUtils.stringToDate(s, "yyyy-MM-dd") ; //�����String���͸�ʽһ��
		System.out.println(date2);
		
	}
}
