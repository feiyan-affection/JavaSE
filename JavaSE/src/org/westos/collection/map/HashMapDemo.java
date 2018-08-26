package org.westos.collection.map;


import java.util.*;

/**
 * Map : 双列集合， 存储键值对关系，一个键只能映射一个值，键相同，值覆盖
 * HashMap： 哈希表实现，元素唯一，键唯一，允许null值和null键  线程不安全，效率高
 * LinkedHashMap：链表和哈希表实现，元素唯一且有序，线程不安全，效率高
 * TreeMap :  二叉树实现，可对键排序，不允许null键，线程不安全，效率高
 *
 */
public class HashMapDemo {

    public static void main(String[] args) {

        //func1();

        func2();

        //func3();

        //func4();
    }

    // 遍历map集合
    public static void func1(){
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Jack");
        hashMap.put(2, "Mary");
        hashMap.put(3, "Lucy");
        hashMap.put(4, "Bob");
        hashMap.put(5, "Tony");
        hashMap.put(6, "John");
        hashMap.put(7, "Clerk");
        hashMap.put(8, "Black");

        //hashMap.forEach((key, value)-> System.out.println(key + "--->" + value));
        //hashMap.forEach((key, value)-> {System.out.println(key + "--->" + value);});

        System.out.println(hashMap.containsKey(1));
        System.out.println(hashMap.containsValue("Mary"));
        System.out.println(hashMap.isEmpty());

        // 遍历map集合
        Set<Map.Entry<Integer, String>> entries = hashMap.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }

        // 获取所有的值,得到键key
        Collection<String> values = hashMap.values();
        for (String value : values) {
            String key = hashMap.get(value);
            System.out.println(key);
        }

        // 获取所有的键,得到值value
        Set<Integer> keys = hashMap.keySet();
        for (Integer key : keys) {
            String value = hashMap.get(key);
            System.out.println(value);
        }

    }

    public static void func2(){
        HashMap<String, Integer> hashMap = new HashMap<>();

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Jack");
        arrayList.add("Lucy");
        arrayList.add("Bob");
        arrayList.add("Lucy");
        arrayList.add("Clerk");
        arrayList.add("Blank");
        arrayList.add("Mary");
        arrayList.add("John");
        arrayList.add("Piny");

        for (int i = 0; i < arrayList.size(); i++) {

        }

    }

    //
    public static void func3(){
        HashMap<String, Student> hashMap = new HashMap<>();
        hashMap.put("s01", new Student("Jack", 18));
        hashMap.put("s02", new Student("Mary", 20));
        hashMap.put("s03", new Student("Lucy", 19));
        hashMap.put("s04", new Student("Black", 22));
        hashMap.put("s05", new Student("Bob", 24));
        hashMap.put("s06", new Student("John", 21));
        hashMap.put("s07", new Student("Clerk", 20));

        // 根据key遍历值value
        Set<String> keySet = hashMap.keySet();
        for (String key : keySet) {
            Student student = hashMap.get(key);
            System.out.println(student.getName() + "---->" + student.getAge());
        }

        // 根据entry对象遍历
        Set<Map.Entry<String, Student>> entries = hashMap.entrySet();
        for (Map.Entry<String, Student> entry : entries) {
            Student student = entry.getValue();
            System.out.println(student.getName() + "---->" + student.getAge());
        }
    }

    public  static void func4(){
        HashMap<Student, String> hashMap = new HashMap<>();
        hashMap.put(new Student("Jack", 18), "s01");
        hashMap.put(new Student("Mary", 20), "s02");
        hashMap.put(new Student("Lucy", 19), "s03");
        hashMap.put(new Student("Black", 22), "s04");
        hashMap.put(new Student("Bob", 24), "s05");
        hashMap.put(new Student("John", 21), "s06");
        hashMap.put(new Student("Clerk", 20), "s07");

        // 根据key遍历值value
        Set<Student> keys = hashMap.keySet();
        for (Student student : keys) {
            int age = student.getAge();
            String name = student.getName();
            System.out.println(name + "--->" + age);
        }
    }
}
