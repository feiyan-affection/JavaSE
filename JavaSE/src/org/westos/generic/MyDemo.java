package org.westos.generic;

public class MyDemo {
    public static void main(String[] args) {
        Student student = new Student();
        student.setObj("abc");
        Object obj = student.getObj();
        String s= (String) obj;
        System.out.println(s.length());
        Student student2 = new Student();
        student2.setObj(100);
        Object obj1 = student2.getObj();
        Integer num= (Integer) obj1;
        System.out.println(num+100);
    }

}
