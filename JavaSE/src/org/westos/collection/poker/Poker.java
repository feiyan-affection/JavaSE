package org.westos.collection.poker;

import java.util.ArrayList;
import java.util.Collections;

public class Poker {

    // 3个玩家 和 底牌
    public static ArrayList<String> Jack = new ArrayList<>();
    public static ArrayList<String> Mary = new ArrayList<>();
    public static ArrayList<String> Blank = new ArrayList<>();
    public static ArrayList<String> Bottom = new ArrayList<>();


    /**
     * 生成一副牌并洗牌，ArrayList实现
     */
    public static ArrayList<String> createPoker(){

        ArrayList<String> pokerList = new ArrayList<>();
        String[] colors = {"♥", "♠", "♣", "♦"};
        String[] nums = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String color : colors) {
            for (String num : nums) {
                pokerList.add(color.concat(num));
            }
        }

        //手动添加大小王
        pokerList.add("☀");
        pokerList.add("🌙");
        //洗牌
        Collections.shuffle(pokerList);
        Collections.shuffle(pokerList);
        Collections.shuffle(pokerList);

        return pokerList;
    }

    /**
     * 三人斗地主，发牌开始，留3张底牌
     */
    public void display(ArrayList<String> poker){
        for (int i = 0; i < poker.size(); i++) {
            if(i >= poker.size() - 3){
                Bottom.add(poker.get(i));
            }else if(i % 3 == 0){
                Jack.add(poker.get(i));
            }else if(i % 3 == 1){
                Mary.add(poker.get(i));
            }else{
                Blank.add(poker.get(i));
            }
        }
    }


    public void peekPoker(String name, ArrayList<String> poker){
        System.out.println(name + " :");
        for (String s : poker) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

}
