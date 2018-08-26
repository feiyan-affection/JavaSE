package org.westos.collection.set;

import org.westos.collection.test.Student;

import java.util.ArrayList;
import java.util.HashSet;

public class HashSetDemo {

    public static void main(String[] args){

        func2();
    }

    public static void func1(){
        HashSet<Student> set = new HashSet<>();
        set.add(new Student("Jack", 20));
        set.add(new Student("John", 22));
        set.add(new Student("Mary", 18));
        set.add(new Student("Bob", 21));
        set.add(new Student("Lucy", 19));
        set.add(null);      //允许存储null值

        set.forEach((s)->{
            System.out.println(s);
        });
    }

    // 去掉重复值
    public static void func2(){
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(10);
        integers.add(10);
        integers.add(20);
        integers.add(30);
        integers.add(10);
        integers.add(20);
        integers.add(30);

        HashSet<Integer> set = new HashSet<>(integers);
        set.forEach(s-> System.out.println(s));
    }
}
