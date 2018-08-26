package org.westos.collection.utils;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class CollectionUtilsDemo {

    public static void main(String[] args) {

        //func1();

        Random random = new Random();
        for (int i = 0; i < 54; i++) {
            int anInt = random.nextInt(54);
            System.out.print(anInt + " ");
        }
    }


    public static void func1() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(65);
        list.add(12);
        list.add(50);
        list.add(45);
        list.add(32);
        list.add(73);

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        System.out.println(list);

        //二分查找
        int search = Collections.binarySearch(list, 50);
        System.out.println(search);

        //求最大值和最小值
        Integer max = Collections.max(list);
        Integer min = Collections.min(list);
        System.out.println("最大值" + max);
        System.out.println("最小值" + min);

        //元素反转
        Collections.reverse(list);
        System.out.println(list);
        //随机打乱集合中的元素
        Collections.shuffle(list);
        System.out.println(list);
    }

}
