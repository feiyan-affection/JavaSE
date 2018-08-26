package org.westos.collection.set.demo1;

public class Student implements Comparable<Student>{
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student s) {
        //根据姓名长度来排
        int r=this.name.length()-s.name.length();
        //姓名长度一样不能说明他是同一个对象，还得比较年龄
        int r2=r==0?this.age-s.age:r;
        //姓名长度一样，和年龄一样，并不能说明他是同一个对象，还得比较姓名的内容
        int r3=r2==0?this.name.compareTo(s.name):r2;
        return r3;
    }
}
