package io.github.seevae.mapper;/*
    name zhang;
    */

import io.github.seevae.po.User;

import java.util.List;

/**
 * 定义接口要按照一定规范,只有按照规范定义了接口,Mybatis才能够帮助我们动态的创建这个接口的代理对象
 * 我们才能够使用该对象调用对象方法
 * 也就是说我们不需要自己再去定义类实现接口了,这些活都由mybatis帮助我们去完成
 *
 * 接口的规范:
 * 1. mapper.xml(UserManager.xml)文件中的命名空间(namespace)必须是接口的全限定名
 * 2. mapper.xml中的statementID必须是接口中对象方法的方法名
 * 3. mapper.xml中的输入映射parameterType类型必须是接口方法的参数类型
 * 4. mapper.xml中的输出映射resultType是接口的方法的返回值
 *
 */


public interface UserManager {

    public User queryUserById(int id) throws Exception;

    public List<User> queryUserByName(String name) throws Exception;
}
