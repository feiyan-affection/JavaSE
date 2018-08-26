package org.westos.generic;

public class MyClass2 {

    public void show() {


    }

    //public void show(Integer i) {
    //    //    System.out.println(i);
    //    //}
    //    //
    //    //
    //    //public void show(String abc) {
    //    //    System.out.println(abc);
    //    //}
    //    //
    //    //public void show(Double v) {
    //    //    System.out.println(v);
    //    //}
    //泛型方法
    public <T> void show(T t) {
        System.out.println(t);
    }

}
