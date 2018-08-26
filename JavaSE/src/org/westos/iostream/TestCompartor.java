package org.westos.iostream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestCompartor {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");
        list.add("zhaoliu");

        /*Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });*/
        Collections.sort(list, (o1, o2) -> o2.compareTo(o1) );

        /*
        如果{}内只有一条语句时,可以省略 return 以及{} 包括; 号
        (String o1, String o2) -> { return o2.compareTo(o1); }
        ( o1,  o2) ->  o2.compareTo(o1)
         */

        System.out.println(list);
    }
}
