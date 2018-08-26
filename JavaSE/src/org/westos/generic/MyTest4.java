package org.westos.generic;

public class MyTest4 {
    public static void main(String[] args) {
        MyClass2 myClass2 = new MyClass2();
        //泛型方法，当你在调用方法时，明确泛型的具体类型
        myClass2.show(100);
        myClass2.show("abc");
        myClass2.show(3.14);
    }
}