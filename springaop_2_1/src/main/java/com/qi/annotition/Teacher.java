package com.qi.annotition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("myTeacher")  //这个注解代表下面的这个类就是一个bean,后面起的名字就相当于该类的id
@Scope //也可以指定该类是单例还是多例。默认是单例
public class Teacher {

    @Value("张三丰")
    private String name;

    @Autowired  //相当于之前在xml中使用 ref + 全路径
    private Student student;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void show(){
        System.out.println(this.getName());
        System.out.println(student.getName());
    }
}