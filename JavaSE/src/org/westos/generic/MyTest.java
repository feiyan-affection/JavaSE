package org.westos.generic;

import java.util.ArrayList;
import java.util.Collection;

public class MyTest {
    public static void main(String[] args) {
        //泛型机制：JDK1.5之后引入的一个新特性
        //泛型机制是一种把数据类型明确工作推迟到创建对象或调用方法时才去明确的一种机制
        //泛型的语法  <数据类型，数据类型> 数据类型只能写引用数据类型
        //泛型只在编译期间有效，在运行期就擦除了
        //泛型的好处1.把问题提前到了编译期
        //2. 避免了向下转型
        //泛型定义的位置：可以定义在接口，类，方法上面

       //Collection<Integer> integers = new ArrayList<>();
        ArrayList<String> strings = new ArrayList();

        strings.add("abc");
        strings.add("bbb");
        String s = strings.get(0);
        //向下转型
       // Integer integer= (Integer) o;







    }
}
