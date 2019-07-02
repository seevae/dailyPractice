package io.github.seevae;/*
    name zhang;
    */

//对象序列化示范

import java.io.*;

class People implements Serializable {
    private String name;
    private int age;

    public People() {
        this.name = "Alice";
        this.age = 22;
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

}

public class SerializationTest {

    public static void main(String[] args){
        People people = new People();
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        //对象序列化过程
        //使用一个输出流构造一个对象流对象
        //使用对象流来把一个对象序列化
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("perple.out");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(people);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //对象反序列化过程
        //使用一个输入流构造一个对象流对象
        //使用对象流把一个对象反序列化
        People people1;
        try {
            FileInputStream fileInputStream = new FileInputStream("perple.out");
            objectInputStream = new ObjectInputStream(fileInputStream);
            people1 = (People) objectInputStream.readObject();
            System.out.println(people1.getAge());
            System.out.println(people1.getName());
            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
