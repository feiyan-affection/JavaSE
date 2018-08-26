package org.westos.iostream;

import java.io.*;
import java.util.Date;

public class Teacher2 implements Serializable{

    private int id;
    private String name;
    private Date birthday;

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Teacher2 clone() {
        try {
            // 序列化
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(bos);
            os.writeObject(this); // 写入当前对象
            byte[] bytes = bos.toByteArray(); // 字节结果

            // 反序列化
            ObjectInputStream is = new ObjectInputStream(new ByteArrayInputStream(bytes));
            Teacher2 t = (Teacher2)is.readObject();
            return t;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Teacher2 t = new Teacher2();
        t.setId(1);
        t.setName("满老师");
        t.setBirthday(new Date());

        Teacher2 t2 = t.clone();

        System.out.println(t == t2);
        System.out.println(t.getBirthday() == t2.getBirthday());
    }
}
