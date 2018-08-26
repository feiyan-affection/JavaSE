package org.westos.date;

import java.util.Date;

/**
 * Date---->long
 * 		public long getTime() 
 * 
 * public void setTime(long time)  :������
 * @author Administrator
 *
 */
public class DateDemo2 {
	
	public static void main(String[] args) {
		
		//����Date���ڶ���
		Date d = new Date() ;
		
		long time = d.getTime() ;
		System.out.println(time);//1533001499169 ms
		
		System.out.println(System.currentTimeMillis()); //1533001499169
		
	//System.currentTimeMillis() :System���еķ���,����ʹ��û����,һ�����:ֱ�Ӳ��� �����ִ������
		long start = System.currentTimeMillis() ;
		for(int x = 0 ; x < 10000;x ++) {
			System.out.println("hello"+x);
		}
		
		long end = System.currentTimeMillis() ;
		System.out.println("����ʱ"+(end-start)+"����");
	}
}
