package org.westos.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.print.attribute.standard.RequestingUserName;

/**
 * ����Date���ڵĹ�����
 * 	�ṩһЩ����,���Խ�����-->�ı���ʽ
 *  �ı���ʽ--->���ڸ�ʽ
 * @author Administrator
 *
 */
public class DateUtils {
	
	/**
	 * Ϊ�˲�����紴����ǰ�����
	 */
	private DateUtils() {
	}
	
	/**
	 * ���ǽ�Date���ڸ�ʽת���������ı���ʽ�ķ���
	 * @param d ��ʾ��ǰ���ڶ���
	 * @param format ��ʾָ����һ��ģʽ
	 * @return ���ؾ��������ı���ʽ
	 */
	public static String dateToString(Date d,String format) {
		//����SimpleDateFormat����
		//�ֲ�
		/*SimpleDateFormat dateFormat = new SimpleDateFormat(format) ;
		String str = dateFormat.format(d) ;
		return str ;*/
		
		//�Ľ�
		return new SimpleDateFormat(format).format(d) ;
	}
	
	/**
	 * ���ǽ������ı���ʽת����Date���ڸ�ʽ�ķ���
	 * @param source  ����Դ,��ǰ��Ҫ��ת���������ı���ʽ
	 * @param format  ��ʾָ��һ��ģʽ
	 * @return ���صľ���Date���ڸ�ʽ
	 * @throws ParseException 
	 */
	public static Date stringToDate(String source,String format) throws ParseException {
		
		/*SimpleDateFormat dateFormat = new SimpleDateFormat(format) ;
		Date d = dateFormat.parse(source) ;
		return d;*/
		
		//�Ľ�
		return new SimpleDateFormat(format).parse(source);
	}
}
