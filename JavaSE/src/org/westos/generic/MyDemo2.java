package org.westos.generic;

public class MyDemo2 {
    public static void main(String[] args) {
        Teacher<String> stringTeacher = new Teacher<>();
        stringTeacher.setName("abc");
        String name = stringTeacher.getName();

        Teacher<Integer> integerTeacher = new Teacher<>();
        integerTeacher.setName(100);
        integerTeacher.getName();
    }
}
