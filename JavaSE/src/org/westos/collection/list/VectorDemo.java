package org.westos.collection.list;

import java.util.Enumeration;
import java.util.Vector;

public class VectorDemo {

    //E elementAt(int index)
    //
    //返回指定索引处的组件。
    //
    //Enumeration<E> elements()
    //
    //返回此向量的组件的枚举。
    //
    //E firstElement()
    //
    //返回第一个组件（在指数 0项目）这个载体。
    //
    //E lastElement()
    //
    //返回向量的最后一个组件。

    //Vector:底层数据结构是数组，查询快，增删慢，线程安全，效率低。
    public static void main(String[] args) {
        Vector<Integer> integers = new Vector<>();
        integers.add(10);
        integers.add(20);
        integers.add(30);
        integers.add(40);
        integers.add(50);

        Integer integer = integers.elementAt(integers.size() - 1);
        System.out.println(integer);
        //Vector 集合特有的遍历方式
        Enumeration<Integer> elements = integers.elements();
        while (elements.hasMoreElements()) {

            System.out.println(elements.nextElement());
        }
        Integer integer1 = integers.firstElement();
        Integer integer2 = integers.lastElement();
        System.out.println(integer1);
        System.out.println(integer2);
    }


}
