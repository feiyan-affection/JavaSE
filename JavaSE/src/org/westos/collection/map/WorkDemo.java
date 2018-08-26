package org.westos.collection.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WorkDemo {

    public static void main(String[] args) {

        func1();

        //func2();

        //func3();

        //func4();
    }

    public static void func5(){
        // 统计字符串中每个字符出现的次数
        // "aababcabcdabcde"
        // 用map集合实现
        HashMap<Character, Integer> hashMap = new HashMap<>();
        Set<Map.Entry<Character, Integer>> entries = hashMap.entrySet();


    }

    public static void func1(){
        // 统计字符串中每个字符出现的次数
        // "aababcabcdabcde"
        // 用map集合实现
        HashMap<Character, Integer> hashMap = new HashMap<>();
        String str = "aababcabcdabcde";
        for (int i = 0; i < str.length(); i++) {
            char key = str.charAt(i);
            if(hashMap.get(key) == null){
                hashMap.put(key, 1);
            }else{
                /*Integer value = hashMap.get(key);
                value++;
                hashMap.put(key, value);*/
                hashMap.put(key, hashMap.get(key) + 1);
            }

        }

        //遍历集合拼接串
        StringBuilder stringBuilder = new StringBuilder();
        Set<Character> characters = hashMap.keySet();
        for (Character character : characters) {
            stringBuilder.append(character).append("(").append(hashMap.get(character)).append(") ");
        }
        System.out.println(stringBuilder);

//        Set<Map.Entry<Character, Integer>> entries = hashMap.entrySet();
//        for (Map.Entry<Character, Integer> entry : entries) {
//            System.out.println(entry.getKey() + "-->" + entry.getValue());
//        }

    }

    public static void func2(){
//        集合嵌套之HashMap嵌套HashMap
//
//        jc	基础班
//        张三		20
//        李四		22
//        jy	就业班
//        王五		21
//        赵六		23

        HashMap<String, Integer> jc = new HashMap<>();
        jc.put("张三", 20);
        jc.put("李四", 22);
        HashMap<String, Integer> jy = new HashMap<>();
        jy.put("王五", 21);
        jy.put("赵六", 23);

        HashMap<String, HashMap<String, Integer>> bigMap = new HashMap<>();
        bigMap.put("基础班", jc);
        bigMap.put("就业班", jy);

        // 遍历
        Set<String> keys = bigMap.keySet();
        for (String key : keys ) {
            System.out.println(key + "##");
            HashMap<String, Integer> map = bigMap.get(key);
            Set<Map.Entry<String, Integer>> entries = map.entrySet();
            for (Map.Entry<String, Integer> entry : entries) {
                System.out.println("\t" + entry.getKey() + " : " + entry.getValue());
            }
        }
    }

    public static void func3(){
//        集合嵌套之HashMap嵌套ArrayList
//
//        假设HashMap集合的元素是ArrayList。有3个。
//        每一个ArrayList集合的值是字符串。
//
//        三国演义
//                  吕布
//                  周瑜
//        笑傲江湖
//                  令狐冲
//                  林平之
//        神雕侠侣
//                  郭靖
//                  杨过

        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("吕布");
        arrayList1.add("周瑜");

        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add("令狐冲");
        arrayList2.add("林平之");

        ArrayList<String> arrayList3 = new ArrayList<>();
        arrayList3.add("郭靖");
        arrayList3.add("杨过");

        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
        hashMap.put("三国演义", arrayList1);
        hashMap.put("笑傲江湖", arrayList2);
        hashMap.put("神雕侠侣", arrayList3);

        //遍历
        Set<String> keys = hashMap.keySet();
        for (String key : keys) {
            System.out.println(key + " : ");
            ArrayList<String> strings = hashMap.get(key);
            for (String string : strings) {
                System.out.println("\t" + string);
            }
        }
    }

    public static void func4(){
//        集合嵌套之ArrayList嵌套HashMap
//
//        假设ArrayList集合的元素是HashMap。有3个。
//        每一个HashMap集合的键和值都是字符串。
//
//        周瑜---小乔
//        吕布---貂蝉
//
//        郭靖---黄蓉
//        杨过---小龙女
//
//        令狐冲---任盈盈
//        林平之---岳灵珊

        HashMap<String, String> map1 = new HashMap<>();
        map1.put("周瑜", "小乔");
        map1.put("吕布", "貂蝉");

        HashMap<String, String> map2 = new HashMap<>();
        map1.put("郭靖", "黄蓉");
        map1.put("杨过", "小龙女");

        HashMap<String, String> map3 = new HashMap<>();
        map1.put("令狐冲", "任盈盈");
        map1.put("林平之", "岳灵珊");

        ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
        arrayList.add(map1);
        arrayList.add(map2);
        arrayList.add(map3);

        // 遍历
        for (HashMap<String, String> map : arrayList) {
            Set<Map.Entry<String, String>> entries = map.entrySet();
            for (Map.Entry<String, String> entry : entries) {
                System.out.println(entry.getKey() + "-->" + entry.getValue());
            }
        }

        for (HashMap<String, String> map : arrayList) {
            Set<String> keys = map.keySet();
            for (String key : map.keySet()) {
                System.out.println(key + "-->" + map.get(key));
            }

        }
    }
}