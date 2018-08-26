package org.westos.collection.map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapDemo {

    public static void main(String[] args) {

        func1();
    }

    public static void func1(){
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "Jack");
        linkedHashMap.put(2, "Mary");
        linkedHashMap.put(3, "Lucy");
        linkedHashMap.put(4, "Bob");
        linkedHashMap.put(5, "Tony");
        linkedHashMap.put(6, "John");
        linkedHashMap.put(7, "Clerk");
        linkedHashMap.put(8, "Blink");

        Set<Map.Entry<Integer, String>> entries = linkedHashMap.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry.getKey() + "----->" + entry.getValue());
        }

        Set<Integer> keySet = linkedHashMap.keySet();
        for (Integer key : keySet) {
            System.out.println(key + "---->" + linkedHashMap.get(key));
        }
    }
}
