package org.westos.collection.poker;

import java.util.ArrayList;
import java.util.List;

public class PokerTest {
    public static void main(String[] args) {

        //实现斗地主的发牌，洗牌，看牌，
        //思路：
        // 1.生成一副牌，放在集合（牌盒）
        //2.洗牌
        //3.三个人斗地主，留三张底牌 发牌
        //4.看牌 ，看谁拿了一副好牌

        /*Poker poker = new Poker();
        ArrayList<String> pokerBox = poker.createPoker();
        poker.display(pokerBox);
        poker.peekPoker("Blank", Poker.Blank);
        poker.peekPoker("Mary", Poker.Mary);
        poker.peekPoker("Jack", Poker.Jack);
        poker.peekPoker("Bottom", Poker.Bottom);*/


        PokerImprove pokerImprove = new PokerImprove();
        List<Integer> index = PokerImprove.createPoker();
        pokerImprove.display(index);
        pokerImprove.peekPkker("Jack", PokerImprove.Jack, PokerImprove.hashMap);
        pokerImprove.peekPkker("Mary", PokerImprove.Mary, PokerImprove.hashMap);
        pokerImprove.peekPkker("Blank", PokerImprove.Blank, PokerImprove.hashMap);
        pokerImprove.peekPkker("Bottom", PokerImprove.Bottom, PokerImprove.hashMap);

    }
}
