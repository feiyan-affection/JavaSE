package org.westos.exception;

/**
 * 测试finally
 */
public class Exception8 {

    public static void main(String[] args) {
        try {
            System.out.println("正常处理");
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println(" Finally...");
        }
    }
}
