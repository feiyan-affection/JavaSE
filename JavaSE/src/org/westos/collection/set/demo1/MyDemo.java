package org.westos.collection.set.demo1;

import java.util.TreeSet;

public class MyDemo {
    public static void main(String[] args) {
        //Set 接口
        //HashSet:底层数据结构是哈希表，元素无序，且唯一 线程不安全，效率高，可以存储null元素
        //HashSet保证元素的唯一性，是靠元素重写hahsCode()和equals()方法来保证的 如果元素不重写，则无法保证元素唯一
        //LinkedHashSet 底层数据结构是链表和哈希表，链表保证元素有序，哈希表保证元素唯一，线程不安全效率高
        //TreeSet：底层数据结构是二叉树，元素唯一且可以对元素进行排序。
        //TreeSet 根据所使用的构造方法的不同，会分为自然排序（空参构造）和比较器排序（有参构造）
        //自然排序：元素必须实现Compareble接口并且重写compareTO()方法 ，元素排序就是根据compareTO()方法
        //的返回值的正负来决定排列顺序，返回0 元素不往里面存
        //主要排序条件是根据姓名的长度来排列
        Student s1 = new Student("刘亦菲", 30);
        Student s2 = new Student("尼古拉斯赵四", 30);
        Student s3 = new Student("杰森斯坦斯达", 30);
        Student s4 = new Student("马特呆萌", 37);
        Student s5 = new Student("贝加尔朵", 37);
        Student s6 = new Student("汤姆克鲁斯", 35);
        Student s7 = new Student("汤姆汉克斯", 30);
        Student s8 = new Student("马特呆萌", 37);
        Student s9 = new Student("马特呆萌", 37);
        //采用自然排序，根据姓名长度来排
        TreeSet<Student> students = new TreeSet<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);
        students.add(s7);
        students.add(s8);
        students.add(s9);
        //遍历
        for (Student stu:students) {
            System.out.println(stu.getName()+"==="+stu.getAge());
        }


    }
}
