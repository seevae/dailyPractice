package com.qi;/*
    name zhang;
    */

import com.qi.bz.UserGroom;
import com.qi.mapper.Mapper;
import com.qi.mybatisTools.MybatisTools;
import com.qi.po.User;
import com.qi.po.UserExtend;
import org.apache.ibatis.session.SqlSession;
import org.omg.PortableServer.LIFESPAN_POLICY_ID;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) throws Exception {
        String config = "sqlMapConfig.xml";
        SqlSession sqlSession = MybatisTools.getSession(config);
        Mapper mapper = sqlSession.getMapper(Mapper.class);
//        System.out.println("请键盘输入要模糊查询的内容");
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.next();
//        //在传递值的时候拼接sql
//        List<User> list =  mapper.findlikeUser("%"+s+"%");
//        System.out.println(list.size());


////        插入数据
//        User user = new User();
//        user.setUsername("火车侠");
//        user.setSex(2);
//        user.setAddress("铁道");
//        mapper.add(user);
//        sqlSession.commit();
//        User list = mapper.queryUserById(16);
//        System.out.println(list);

//         List<Map<String,String>> list  =  mapper.getList();
//         System.out.println(list);

//        UserExtend userExtend = new UserExtend();
//        userExtend.setSex(1);
//        userExtend.setUsername("张");
//        UserGroom userGroom = new UserGroom(userExtend);
//        List<UserExtend> userExtend1 =  mapper.queryByMoreCon(userGroom);
//        System.out.println(userExtend1);

//        int count = mapper.queryNumber(userGroom);
//        System.out.println(count);

//        //测试传入list
//        List<Integer> integers = new ArrayList<Integer>();
//        integers.add(1);
//        integers.add(26);
//        integers.add(42);
//        UserExtend userExtend1 = new UserExtend();
//        UserGroom userGroom1 = new UserGroom(userExtend1);
//        userGroom1.setIdList(integers);
//        List<User> userExtends = mapper.queryByMoreId(userGroom1);
//        System.out.println(userExtends);
//        sqlSession.close();

//        //测试传入数组
//        Integer[] array = new Integer[]{1,26,42};
//        UserExtend userExtend1 = new UserExtend();
//        UserGroom userGroom1 = new UserGroom(userExtend1);
//        userGroom1.setArray(array);
//        List<User> userExtends = mapper.queryByMoreId2(userGroom1);
//        System.out.println(userExtends);
//        sqlSession.close();

//        测试传入map
        List<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(16);
        list.add(22);

        String name = "小明";
        HashMap map = new HashMap();
        map.put("list",list);
        map.put("name",name);
        List<User> list1 = mapper.queryByMap(map);
        System.out.println(list1);
        
    }
}
