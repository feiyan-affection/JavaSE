package org.westos.collection.poker;

import java.security.Key;
import java.util.*;

public class PokerImprove {
    // 一副扑克牌
    public static HashMap<Integer, String> hashMap = new HashMap<>();

    // 3个玩家 和 底牌
    // 发牌(发的也是编号，为了保证编号是排序的，就创建TreeSet集合接收)
    public static TreeSet<Integer> Jack = new TreeSet<Integer>();
    public static TreeSet<Integer> Mary = new TreeSet<Integer>();
    public static TreeSet<Integer> Blank = new TreeSet<Integer>();
    public static TreeSet<Integer> Bottom = new TreeSet<Integer>();


    /**
     * 创建一副扑克牌
     * @return
     */
    public static List<Integer> createPoker() {
        // 存储牌的序号
        List<Integer> list = new ArrayList<>();

        // 创建花色数组和点数数组
        String[] colors = {"♥", "♠", "♣", "♦"};
        String[] nums = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        int index = 0;
        // 从0开始往HashMap里面存储编号，并存储对应的牌,同时往ArrayList里面存储编号即可。
        for (String num : nums) {
            for (String color : colors) {
                hashMap.put(index, color.concat(num));
                list.add(index);
                index++;
            }
        }

        //手动添加大小王
        hashMap.put(index, "☀");
        list.add(index);
        index++;

        hashMap.put(index, "🌙");
        list.add(index);

        // 洗牌，洗的是编号
        Collections.shuffle(list);
        Collections.shuffle(list);
        Collections.shuffle(list);

        return list;
    }

    /**
     * 三人斗地主，发牌开始，留3张底牌
     */
    public void display(List<Integer> list){
        for (int i = 0; i < list.size(); i++) {
            if(i >= list.size() - 3){
                Bottom.add(list.get(i));
            }else if(i % 3 == 0){
                Jack.add(list.get(i));
            }else if(i % 3 == 1){
                Mary.add(list.get(i));
            }else{
                Blank.add(list.get(i));
            }
        }
    }

    /**
     * 看牌
     */
    public void peekPkker(String name, TreeSet<Integer> set, HashMap<Integer, String> hashMap){
        System.out.println(name + " :");
        for (Integer key : set) {
            System.out.print(hashMap.get(key) + " ");
        }
        System.out.println();
    }

}
