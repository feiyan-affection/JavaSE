package org.westos.collection.test.demo4;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class MyTest4 {
    public static void main(String[] args) {
        // 需求：键盘录入3个学生信息(姓名, 语文成绩, 数学成绩, 英语成绩), 按照总分从高到低输出到控制台。
        //1.定义学生类：姓名 语文成绩，数学成绩，英语成绩
        //2.创建键盘录入对象，录入三个学生的成绩
        //3.按照总分从高到低进行排序 输出到控制台

        //创建集合
        TreeSet<Student> students = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return (int) (s1.getTotalScore() - s2.getTotalScore());
            }
        });
        //创建键盘录入对象
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 3; i++) {
            System.out.println("请输入第" + i + "个学生的姓名");
            Student student = new Student();
            String name = sc.next();
            student.setName(name);
            System.out.println("请输入第" + i + "个学生的语文成绩");
            double yw = sc.nextDouble();
            student.setChineseScore(yw);

            System.out.println("请输入第" + i + "个学生的数学成绩");
            double sx = sc.nextDouble();
            student.setMathScore(sx);

            System.out.println("请输入第" + i + "个学生的英语成绩");
            double yy = sc.nextDouble();
            student.setEnglishScore(yy);
            //将学生对象添加到集合当中去
            students.add(student);

        }
        //输出到控制台
        System.out.println("姓名"+"\t"+"语文成绩"+"\t"+"数学成绩"+"\t"+"英语成绩"+"\t"+"总分");
        for(Student stu:students){
            System.out.println(stu.getName()+"\t"+stu.getChineseScore()+"\t"+stu.getMathScore()+"\t"+stu.getEnglishScore()+"\t"+stu.getTotalScore());
        }




    }

}
