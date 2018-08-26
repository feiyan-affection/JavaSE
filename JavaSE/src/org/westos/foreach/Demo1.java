package org.westos.foreach;

import java.util.*;


public class Demo1 {
    public static void main(String[] args) {
        // 定义大的集合
        ArrayList<ArrayList<Student>> allClassList = new  ArrayList<>() ;
        
        // 创建每一个班的集合
        ArrayList<Student> jcClassList1 = new  ArrayList<>() ;
        jcClassList1.add(new Student("Tom", 20));
        jcClassList1.add(new Student("Mary", 18));
        jcClassList1.add(new Student("John", 22));
        jcClassList1.add(new Student("Lulu", 23));
        jcClassList1.add(new Student("Jack", 24));
        jcClassList1.add(new Student("span", 27));
        //jcClassList1.forEach(s-> System.out.println(s));

        // 创建每一个班的集合
        ArrayList<Student> jcClassList2 = new  ArrayList<>() ;
        jcClassList2.add(new Student("Tom", 20));
        jcClassList2.add(new Student("Mary", 18));
        jcClassList2.add(new Student("Lulu", 23));
        jcClassList2.add(new Student("Jack", 24));
        jcClassList2.add(new Student("span", 27));
        //jcClassList2.forEach(s-> System.out.println(s));

        allClassList.add(jcClassList1);
        allClassList.add(jcClassList2);


        for (ArrayList<Student> a : allClassList) {
            for (Student s : a) {
                System.out.println(s);
            }
        }

        for (int i = 0; i < allClassList.size(); i++) {
            ArrayList<Student> students = allClassList.get(i);
            for (int j = 0; j < students.size(); j++) {
                Student student = students.get(j);
                System.out.print(student);
            }
            System.out.println();
        }

    }
}
