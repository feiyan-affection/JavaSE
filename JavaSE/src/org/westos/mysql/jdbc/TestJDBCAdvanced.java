package org.westos.mysql.jdbc;

import org.westos.mysql.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestJDBCAdvanced {


    public static void main(String[] args) {
        List<Student> list = queryAll("select * from student where sid<?", rs -> {
            Student s = new Student();
            s.setSid(rs.getInt("sid"));
            s.setSname(rs.getString("sname"));
            s.setBirthday(rs.getDate("birthday"));
            s.setSex(rs.getString("sex"));
            return s;
        },1005);
        for (Student student : list) {
            System.out.println(student);
        }

    }

    public void insert(Student stu){
        String sql = "insert into student(sname,birthday,sex)values(?,?,?)";
        update(sql, stu.getSname(), stu.getBirthday(), stu.getSex());
    }

    public void update(Student stu){
        String sql = "update student set sname=?, birthday=?, sex=? where sid=?";
        update(sql, stu.getSname(), stu.getBirthday(), stu.getSex(), stu.getSid());
    }

    public void delete(int sid) {
        String sql = "delete from student where sid=?";
        update(sql, sid);
    }

    // 写一个通用的增删改方法  "insert into student(sname,birthday,sex)values(?,?,?)";
    //                      "update student set sname=?, birthday=?, sex=? where sid=?";
    //                      "delete from student where sid=?";
    //                             new Object[]{"aaa",new Date(), "男"}
    //                             new Object[]{1001}
    public static void update(String sql, Object... args){ // 其中 Object... 等价于 Object[]
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = JDBCUtils.getConnection();
            System.out.println(sql);
            stmt = conn.prepareStatement(sql);
            // 用 set方法给sql语句中的？占位符赋值
            int idx = 1;
            // 遍历所有的 ? 值
            for (Object arg : args) {
                if(arg instanceof Date) {
                    Date date = (Date) arg;
                    java.sql.Date sdate = new java.sql.Date(date.getTime());
                    stmt.setObject(idx, sdate);
                } else {
                    stmt.setObject(idx, arg);
                }
                idx ++;
            }
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JDBCUtils.close(stmt, conn);
        }
    }

    // 通用的查询方法
    // sql = "select * from student where sid = ?";
    /* RowMapper mapper = new RowMapper(){
              Object map(ResultSet rs) throws SQLException {
                   Student s = new Student();
                   s.setSid(rs.getInt("sid"));
                   s.setSname(rs.getString("sname"));
                   s.setBirthday(rs.getDate("birthday"));
                   s.setSex(rs.getString("sex"));
                   return s;
              }
       }

       RowMapper mapper = (rs) -> {
           Student s = new Student();
           s.setSid(rs.getInt("sid"));
           s.setSname(rs.getString("sname"));
           s.setBirthday(rs.getDate("birthday"));
           s.setSex(rs.getString("sex"));
           return s;
       }
     */

    public static <T> List<T> queryAll(String sql, RowMapper mapper, Object... args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.prepareStatement(sql);
            // 用 set方法给sql语句中的？占位符赋值
            int idx = 1;
            // 遍历所有的 ? 值
            for (Object arg : args) {
                if(arg instanceof Date) {
                    Date date = (Date) arg;
                    java.sql.Date sdate = new java.sql.Date(date.getTime());
                    stmt.setObject(idx, sdate);
                } else {
                    stmt.setObject(idx, arg);
                }
                idx ++;
            }
            rs = stmt.executeQuery();
            List<T> list = new ArrayList<>();
            while(rs.next()) {
                Object o = mapper.map(rs);
                list.add((T)o);
            }
            return list;
        } catch(Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(rs, stmt, conn);
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

    public static void meta() {
        //  得到结果集的元数据

        // 能得到查询的结果的有哪些列，每一列是什么数据类型

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.prepareStatement("select deptno id, dname, loc from dept");
            rs = stmt.executeQuery();
            // 获得了元数据
            ResultSetMetaData metaData = rs.getMetaData();
            System.out.println("有多少列:" +metaData.getColumnCount());
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                // 有别名时，以别名为准，没有时，才找列名
                System.out.println(metaData.getColumnName(i));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, stmt, conn);
        }
    }
}
