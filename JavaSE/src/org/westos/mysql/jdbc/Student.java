package org.westos.mysql.jdbc;

import java.util.Date;

/**
 * *************************************
 * Copyright (c) 2018 feiyan.com
 * All rights reserved.
 * *************************************
 * *************************************
 *
 * @Author: think
 * @Project: JavaSE
 * @Date: Created in 2018/8/22 16:36
 * @Since: JDK 1.8
 * @Version: 1.0
 * @Modified By:
 * @Description：
 */
public class Student {
    private int sid; // 学生编号
    private String sname; // 学生姓名
    private Date birthday; // 生日
    private String sex; // 性别

    public Student() {
    }

    public Student(String sname, Date birthday, String sex) {
        this.sname = sname;
        this.birthday = birthday;
        this.sex = sex;
    }

    public Student(int sid, String sname, Date birthday, String sex) {
        this.sid = sid;
        this.sname = sname;
        this.birthday = birthday;
        this.sex = sex;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                '}';
    }
}
