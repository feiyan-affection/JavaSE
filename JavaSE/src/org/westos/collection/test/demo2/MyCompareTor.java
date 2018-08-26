package org.westos.collection.test.demo2;


import java.util.Comparator;

public class MyCompareTor implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        //根据条件来排序
        int r = s1.getName().length() - s2.getName().length();
        int r2 = r == 0 ? s1.getAge() - s2.getAge() : r;
        int r3 = r2 == 0 ? s1.getName().compareTo(s2.getName()) : r2;
        return r3;
    }
}
