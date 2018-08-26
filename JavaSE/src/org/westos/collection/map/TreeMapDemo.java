package org.westos.collection.map;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {

    public static void main(String[] args) {
        //func1();

        //func2();

        //fun3();

        func4();
    }
    
    public static void func1(){
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "Jack");
        treeMap.put(8, "Mary");
        treeMap.put(6, "Lucy");
        treeMap.put(1, "Bob");
        treeMap.put(5, "Tony");
        treeMap.put(7, "John");
        treeMap.put(23, "Clerk");
        treeMap.put(11, "Black");

        Set<Integer> keySet = treeMap.keySet();
        for (Integer key : keySet) {
            System.out.println(key + "---->" + treeMap.get(key));
        }

        Set<Map.Entry<Integer, String>> entries = treeMap.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }


    public static void func2(){
        TreeMap<String, Student> treeMap = new TreeMap<>();
        treeMap.put("s01", new Student("Jack", 18));
        treeMap.put("s02", new Student("Mary", 20));
        treeMap.put("s03", new Student("Lucy", 19));
        treeMap.put("s04", new Student("Black", 22));
        treeMap.put("s05", new Student("Bob", 24));
        treeMap.put("s06", new Student("John", 21));
        treeMap.put("s07", new Student("Clerk", 20));

        Set<Map.Entry<String, Student>> entries = treeMap.entrySet();
        for (Map.Entry<String, Student> entry : entries) {
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }


    public static void fun3(){
        TreeMap<Student, String> treeMap = new TreeMap<>();
        treeMap.put(new Student("Jack", 18), "s01");
        treeMap.put(new Student("Mary", 20), "s02");
        treeMap.put(new Student("Lucy", 43), "s03");
        treeMap.put(new Student("Black", 23), "s04");
        treeMap.put(new Student("Bob", 54), "s05");
        treeMap.put(new Student("John", 12), "s06");
        treeMap.put(new Student("Clerk", 20), "s07");

        Set<Map.Entry<Student, String>> entries = treeMap.entrySet();
        for (Map.Entry<Student, String> entry : entries) {
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }

    public static void func4(){
        TreeMap<Student, String> treeMap = new TreeMap<>(new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {

                int ret = o1.getName().length() - o2.getName().length();
                ret = ret == 0 ? o1.getName().compareTo(o2.getName()) : ret;
                ret = ret == 0 ? o1.getAge() - o2.getAge() : ret;

                return ret;
            }
        });

        treeMap.put(new Student("Jack", 18), "s01");
        treeMap.put(new Student("Mary", 20), "s02");
        treeMap.put(new Student("Lucy", 43), "s03");
        treeMap.put(new Student("Black", 23), "s04");
        treeMap.put(new Student("Bob", 54), "s05");
        treeMap.put(new Student("John", 12), "s06");
        treeMap.put(new Student("Clerk", 20), "s07");

        Set<Map.Entry<Student, String>> entries = treeMap.entrySet();
        for (Map.Entry<Student, String> entry : entries) {
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }
}
