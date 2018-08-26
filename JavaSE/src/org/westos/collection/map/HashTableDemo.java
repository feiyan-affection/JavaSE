package org.westos.collection.map;

import java.util.Hashtable;

public class HashTableDemo {

    public static void main(String[] args) {
        func1();
    }

    public static void func1(){
//        A:面试题
//        HashMap和Hashtable的区别:	查看API可以知道
//        HashMap: 线程不安全,效率高.允许null值和null键
//        Hashtable: 线程安全 , 效率低.不允许null值和null键
//        B:案例演示
//                HashMap和Hashtable的区别

        // Hashtable 不允许存储null值 和 null 键
        Hashtable<String, String> hashtable = new Hashtable<>();
        //hashtable.put(null, null);
        //hashtable.put("abc", null);
        //hashtable.put(null, "sbc");
    }
}
