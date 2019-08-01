注解开发就是使用注解来直接注入你的属性等等 ;
注解的本质是反射机制

用法:
1. 首先要有一个包扫描器
   <context:component-scan base-package="要扫描的包的路径"></context:component-scan>
2. 在自定义的类上加入注解 @Component 表示这个类是一个bean , 包扫描器可以进行扫描
3. 类中的属性直接使用@Value("属性值")的方式注入
4. 在一个类中注入其他的类使用注解 @Autowired






