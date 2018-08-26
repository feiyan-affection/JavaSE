package org.westos.collection.set;

import org.westos.collection.test.Student;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo {

    public static void main(String[] args) {
        //func1();

        //func2();

        //func3();

        //func4();

        func5();
    }

    public static void func1() {
        // 底层是二叉树,元素默认从大到小排好序且唯一
        TreeSet<Integer> set = new TreeSet<>();
        set.add(35);
        set.add(25);
        set.add(686);
        set.add(64);
        set.add(45);
        set.add(12);
        set.add(23);
        set.add(65);
        set.add(11);
        set.add(7);

        set.forEach(s -> System.out.println(s));
    }

    public static void func2() {
        TreeSet<Student> students = new TreeSet<>();
        students.add(new Student("Jack", 65));
        students.add(new Student("Mary", 22));
        students.add(new Student("Lucy", 23));
        students.add(new Student("Bob", 19));
        students.add(new Student("Clerk", 19));
        students.add(new Student("John", 23));
        students.add(new Student("Kai", 65));
        students.add(new Student("Lei", 12));
        students.add(new Student("Dao", 37));

        students.forEach(s -> System.out.println(s));
    }

    public static void func3() {
        TreeSet<Student> students = new TreeSet<>();
        students.add(new Student("Jack", 65));
        students.add(new Student("Maryll", 22));
        students.add(new Student("Huwangwang", 23));
        students.add(new Student("huawayi", 19));
        students.add(new Student("feiyan", 19));
        students.add(new Student("Paradise", 23));
        students.add(new Student("hud", 65));
        students.add(new Student("Ledqwdi", 12));
        students.add(new Student("google", 37));

        students.forEach(s -> System.out.println(s));
    }


    public static void func4() {
        TreeSet<Student> students = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                int r = s1.getName().length() - s2.getName().length();
                r = r == 0 ? s1.getName().compareTo(s2.getName()) : r;
                r = r == 0 ? s1.getAge() - s2.getAge() : r;
                return r;
            }
        });
        students.add(new Student("Jack", 65));
        students.add(new Student("Maryll", 22));
        students.add(new Student("Huwangwang", 23));
        students.add(new Student("huawayi", 19));
        students.add(new Student("feiyan", 19));
        students.add(new Student("Paradise", 23));
        students.add(new Student("hud", 65));
        students.add(new Student("Ledqwdi", 12));
        students.add(new Student("google", 37));

        students.forEach(s -> System.out.println(s));
    }

    public static void func5(){
        TreeSet<Student> students = new TreeSet<>();
        students.add(new Student("Jack", 65));
        students.add(new Student("Maryll", 22));
        students.add(new Student("Huwangwang", 23));
        students.add(new Student("huawayi", 19));
        students.add(new Student("feiyan", 19));
        students.add(new Student("Paradise", 23));
        students.add(new Student("hud", 65));
        students.add(new Student("Ledqwdi", 12));
        students.add(new Student("google", 37));


    }
}
