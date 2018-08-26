package org.westos.collection.test.demo3;

import java.util.Random;
import java.util.TreeSet;

public class MyTest {
    public static void main(String[] args) {

        func1();
        //func2();
    }

    public static void func1(){
        //案例演示
        //需求：编写一个程序，获取10个1至20的随机数，要求随机数不能重复。
        //1.生成随机数，用Random
        //2.去重，Set集合可以去重
        Random random = new Random();

        //创建一个集合
        TreeSet<Integer> integers = new TreeSet<>();
        while (integers.size() < 10) {
            int num = random.nextInt(101);
            integers.add(num);
        }

        System.out.println(integers);
    }

    public static void func2(){
        TreeSet<Student> ts = new TreeSet<Student>();
        ts.add(new Student("zhangsan", 19));
        ts.add(new Student("zhangsan", 19));
        ts.add(new Student("lisi", 20));
        ts.add(new Student("wangwu", 22));
        for (Student s : ts) {
            s.show();
        }

    }
}
