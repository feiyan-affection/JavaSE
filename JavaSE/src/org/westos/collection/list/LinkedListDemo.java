package org.westos.collection.list;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        //LinkedList 底层数据结构是链表，查询慢，增删快，线程不安全，效率高
        //B:
        //LinkedList类特有功能
        //public void addFirst (E e)及addLast(E e)
        //public E getFirst () 及getLast()
       // public E removeFirst () 及public E removeLast()
        //ctrl+alt+v 自动补全
        LinkedList<String> list= new LinkedList<>();
        list.add("abc");
        list.add("ccc");
        list.addFirst("AAA");

        System.out.println(list);
        System.out.println(list.getLast());
        System.out.println(list.removeLast());
        System.out.println(list);




    }
}
