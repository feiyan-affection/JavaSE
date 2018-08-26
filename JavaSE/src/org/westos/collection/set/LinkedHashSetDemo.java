package org.westos.collection.set;

import java.util.LinkedHashSet;

public class LinkedHashSetDemo {

    public static void main(String[] args) {

        func1();
    }

    public static void func1(){
        // LinkedHashSet<>() 使用链表和数组实现，元素有序（插入顺序）且唯一
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        set.add(54);
        set.add(32);
        set.add(14);
        set.add(67);
        set.add(31);
        set.add(8);
        set.add(34);
        set.add(10);
        set.add(67);
        set.add(31);
        set.add(8);
        set.add(34);
        set.add(10);

        set.forEach(s-> System.out.println(s));
    }
}
