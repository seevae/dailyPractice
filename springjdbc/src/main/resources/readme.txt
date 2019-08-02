使用Spring JDBC的基本步骤(数据库连接池选择c3p0)
1. 写c3p0的连接配置信息 c3p0.properties
        其中四条信息
            jdbc.driver
            jdbc.url
            jdbc.username
            jdbc.password

2. 在applicationContext.xml中将c3p0.properties注册到Spring中
        <bean id="config" class="org.springframework.beans.factory.config.PreferencesPlaceholderConfigurer">
                <property name="location">
                    <value>c3p0.properties</value>
                </property>
        </bean>

3. 配置数据源
        <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
                <property name="driverClass">
                    <value>${jdbc.driverClassName}</value>
                </property>

                <property name="jdbcUrl">
                    <value>${jdbc.url}</value>
                </property>

                <property name="user">
                    <value>${jdbc.username}</value>
                </property>

                <property name="password">
                    <value>${jdbc.password}</value>
                </property>
        </bean>

    至此,关于数据库连接池的东西就都配置好了

4. 配置jdbcTemplate(这是Spring对jdbc进行封装后的一个工具,相当于jdbcUntil,注册了之后可以直接调用里面的方法,便于开发)
             <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
                     <property name="dataSource" ref="dataSource"></property>
             </bean>

开始编程,目标: 向man表中添加一条数据  :

5. dao层逻辑的编写
            1. 首先完成dao层 .需要注意的是dao层是直接操纵数据库的. 所以在dao层中要引入jdbcTemplate(工具类)
            2. 写一个add方法 ,完成具体的插入工作
            代码:
                     public class DaoImpl implements Dao {

                         private JdbcTemplate jdbcTemplate; //这个使用的是Spring提供的JDBC模块

                         public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
                             this.jdbcTemplate = jdbcTemplate;
                         }

                         public void add() throws Exception {
                             String sql = "insert into man(username,money) values (?,?)";
                             int row = jdbcTemplate.update(sql,"大纲村山",1234);
                             System.out.println("有"+row+"条数据插入");
                          }
                     }

6.编写service层
        1. service层是调用dao层的,所以需要把dao关联到service层
                public class ServiceImp implements Service{

                    private DaoImpl daoImp;

                    public void setDaoImp(DaoImpl daoImp) {
                        this.daoImp = daoImp;
                    }

                    //service调用dao层
                    public void serAdd() throws Exception {
                        daoImp.add();
                    }
                }

7. 将dao层和service层都交给spring管理
        注意: 这两个类中都包含了其他的类,要注意注册时候的依赖关系

            <bean id="dao" class="com.qi.dao.DaoImpl">
                <property name="jdbcTemplate" ref="jdbcTemplate"/>
            </bean>

            <bean id="service" class="com.qi.service.ServiceImp">
                <property name="daoImp" ref="dao"/>
            </bean>

8. 测试
        直接使用Service层中的方法,调用dao,最终操作数据库

        public class Test {
            public static void main(String[] args) throws Exception {
                ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
                Service service = (Service) applicationContext.getBean("service");
                service.serAdd();
            }
        }