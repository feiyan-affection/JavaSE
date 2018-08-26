package org.westos.mysql.jdbc.dao;

import org.junit.Test;
import org.westos.mysql.jdbc.Student;
import org.westos.mysql.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * *************************************
 * Copyright (c) 2018 feiyan.com
 * All rights reserved.
 * *************************************
 * *************************************
 *
 * @Author: think
 * @Project: JavaSE
 * @Date: Created in 2018/8/22 16:56
 * @Since: JDK 1.8
 * @Version: 1.0
 * @Modified By:
 * @Description：
 */
public class StudentDAO {
    // 新增方法
    @Test
    public void insert(Student stu){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into student(sname,birthday,sex)values(?,?,?)";
            stmt = conn.prepareStatement(sql);

            // 用 set方法给sql语句中的？占位符赋值
            stmt.setString(1, stu.getSname());
            Date birthday = stu.getBirthday();
            stmt.setDate(2, new java.sql.Date(birthday.getTime()));
            stmt.setString(3, stu.getSex());
            stmt.executeUpdate();

            System.out.println("Successful insert info.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JDBCUtils.close(stmt,conn);
        }
    }


    // 修改方法
    @Test
    public void update(Student stu){
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "update student set sname=?, birthday=?, sex=? where sid=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, stu.getSname());
            stmt.setDate(2, new java.sql.Date(stu.getBirthday().getTime()));
            stmt.setString(3, stu.getSex());
            stmt.setInt(4, stu.getSid());
            stmt.executeUpdate();

            System.out.println("Successful update info.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(stmt, conn);
        }
    }


    // 删除方法
    @Test
    public void delete(int sid) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "delete from student where sid=?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, sid);
            stmt.executeUpdate();

            System.out.println("Successful delete info.");
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(stmt, conn);
        }
    }

    // 按id查询
    public Student findById(int sid) { // sid 1012
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from student where sid = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, sid);
            resultSet = stmt.executeQuery();
            // 因为sid是唯一的，因此要么查到一条记录，要么没有
            if(resultSet.next()) {
                // 查到了
                // 这些数据保存起来, 将各个列的值存入学生对象的属性中
                Student s = new Student();
                s.setSid( resultSet.getInt("sid") );
                s.setSname( resultSet.getString("sname"));
                s.setBirthday(resultSet.getDate("birthday"));
                s.setSex(resultSet.getString("sex"));
                return s;
            } else { // 没查到
                return null;
            }
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(resultSet, stmt, conn);
        }
    }

    // 查询所有
    public List<Student> findAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select * from student";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            List<Student> list = new ArrayList<>();
            while(rs.next()) {
                Student s = new Student();
                s.setSid(rs.getInt("sid"));
                s.setSname(rs.getString("sname"));
                s.setBirthday(rs.getDate("birthday"));
                s.setSex(rs.getString("sex"));
                list.add(s);
            }
            return list;
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(rs, stmt, conn);
        }
    }



    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();

        // 新增
//        Student s = new Student("老三", new Date(), "男");
//        dao.insert(s);

        // 查询所有
//        List<Student> list = dao.findAll();
//        for(Student s:list) {
//            System.out.println(s);
//        }

        // 按id查询
       Student stu = dao.findById(1006);
       //System.out.println(stu);

       // 修改
       stu.setSex("女");
       dao.update(stu);

        // 删除
        // dao.delete(1008);
    }
}
