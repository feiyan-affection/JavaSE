package org.westos.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exception2 {

    // 积极处理
    /*public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse("yyaa-08-07");
            System.out.println(date);
        } catch (ParseException e) {
            System.out.println("捕获了异常");
        }
    }*/

    // 消极处理,将异常交给方法的调用者处理
    // main 的调用者是jvm,当异常传给jvm时,程序运行就结束了
    public static void main(String[] args) {
        try {
            m1();
        } catch (ParseException e) {
            System.out.println("日期格式不对");
        }
    }

    public static void m1() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date date = sdf.parse("aaaa-08-07");
        System.out.println(date);
    }

}
