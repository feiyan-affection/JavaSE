package org.westos.collection.test.demo2;


import java.util.TreeSet;

public class TreeSetDemo2 {
    public static void main(String[] args) {
        //比较器排序
        MyCompareTor myCompareTor = new MyCompareTor();

        Student s1 = new Student("刘亦菲", 30);
        Student s2 = new Student("尼古拉斯赵四", 30);
        Student s3 = new Student("杰森斯坦斯达", 30);
        Student s4 = new Student("马特呆萌", 37);
        Student s5 = new Student("贝加尔朵", 37);
        Student s6 = new Student("汤姆克鲁斯", 35);
        Student s7 = new Student("汤姆汉克斯", 30);
        Student s8 = new Student("马特呆萌", 37);
        Student s9 = new Student("马特呆萌", 37);
        TreeSet<Student> students = new TreeSet<>(myCompareTor);
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);
        students.add(s7);
        students.add(s8);
        students.add(s9);
        for(Student student:students){

            System.out.println(student.getName()+"====="+student.getAge());






        }
    }
}
