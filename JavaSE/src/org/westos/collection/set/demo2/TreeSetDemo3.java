package org.westos.collection.set.demo2;


import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo3 {
    public static void main(String[] args) {
        //通过匿名内部类来传一个比较器
        Student s1 = new Student("刘亦菲", 30);
        Student s2 = new Student("尼古拉斯赵四", 30);
        Student s3 = new Student("杰森斯坦斯达", 36);
        Student s4 = new Student("马特呆萌", 36);
        Student s5 = new Student("贝加尔朵", 37);
        Student s6 = new Student("汤姆克鲁斯", 35);
        Student s7 = new Student("汤姆汉克斯", 30);
        Student s8 = new Student("马特呆萌", 32);
        Student s9 = new Student("马特呆萌", 33);
        TreeSet<Student> students = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int r = s1.getAge() - s2.getAge();
                int r2 = r == 0 ? s1.getName().compareTo(s2.getName()) : r;

                return -r2;
            }
        });

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);
        students.add(s7);
        students.add(s8);
        students.add(s9);
        for (Student student : students) {

            System.out.println(student.getName() + "=====" + student.getAge());

        }
        System.out.println("------------------------------");
        Integer[] arr=new Integer[]{3, 5, 9, 9, 2};
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {

                return -(a-b);
            }
        });

        System.out.println(Arrays.toString(arr));


    }
}
