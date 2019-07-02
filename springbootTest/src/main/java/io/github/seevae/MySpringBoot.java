package io.github.seevae;/*
    name zhang;
    */


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


//构建一个控制器
@Controller  //相当于配置了控制器,映射器,处理器,视图解析器 ..
@Configuration //相当于web项目中springContext配置文件
@SpringBootApplication(exclude = RedisAutoConfiguration.class) //相当于同时配置了@Configuration @EnableAutoConfiguration @ComponentScan
public class MySpringBoot {

    @RequestMapping(value = "/hello")
    @ResponseBody //可以将响应内容写入response的body中
    public String sayHello(){
        return "hello haha";
    }

    //编写一个主函数构建Spring容器
    public static void main(String[] args) {
        SpringApplication.run(MySpringBoot.class,args);
    }
}
