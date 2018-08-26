package org.westos.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        //List接口：
        // ArrayList：底层数据结构是数组，查询快，增删慢，线程不安全，效率高 可以存储重复元素

        // int indexOf (Object o)返回此列表中指定元素的第一个出现的索引，或 - 如果此列表不包含元素，或 - 1。
        // void sort (Comparator < ? super E > c)分类列表使用提供的 Comparator比较元素。
        //  List<E> subList ( int fromIndex, int toIndex)返回一个视图之间的指定 fromIndex，包容，和 toIndex这份名单的部分，独家。
        // Object[] toArray () 返回一个数组，包含在这个列表中的所有元素在适当的顺序（从第一个到最后一个元素）。
        //alt+enter 万能提示键
        //ctrl+alt+L 排版代码
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(10);
        list.add(30);
        list.add(10);
        list.add(20);
        list.add(50);
        list.add(40);
        int i = list.indexOf(10);//查找该元素第一次在集合中出现的索引
        System.out.println(i);
        //排序集合中的元素
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {

                return -(a - b);
            }
        });


        System.out.println(list);

        //截取集合中的元素
        //  List<Integer> integers = list.subList(0, 4);//含头不含尾
        //  System.out.println(integers);

        Object[] obj = list.toArray();//把一个集合转成数组
        obj[0] = 500;
        System.out.println(obj[0]);

        int[] arrs = {10, 20, 30};
        List<int[]> ints = Arrays.asList(arrs);//把数组转成集合
        System.out.println(ints);

        //通过asList方法转换过来的集合，此集合不能再添加或者删除元素
        List<Integer> integers = Arrays.asList(10, 60, 80, 90, 100);
        System.out.println(integers);
       //integers.add(100);
       //integers.remove(0);

        for (int j=0;j<integers.size();j++){

            System.out.println(integers.get(j));
        }

    }
}
