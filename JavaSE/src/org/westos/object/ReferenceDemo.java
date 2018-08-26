package org.westos.object;


public class ReferenceDemo {

    public static void main(String[] args) {
        test1();

        test2();
    }


    public static void method1(String s){
        s = "jack";
        System.out.println(s);
    }
    public static void test1(){
        String str = "mary";
        method1(str);
        System.out.println(str.getClass());
    }


    public static void method2(Student stu){
        stu.setName("Sheldon");
    }
    public static void test2(){
        Student amy = new Student("Amy", 18);
        method2(amy);
        System.out.println(amy);
    }
}
