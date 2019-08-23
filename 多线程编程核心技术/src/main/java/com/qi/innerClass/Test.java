package com.qi.innerClass;

//普通内部类
class Outter{

    private String name;
    private String password;

    class Inner{
        private String address;
        private String sex;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public void printOutterMsg(){
            System.out.println(name+" "+password);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

//普通内部类的实例化
//Outter.Inner inner = new Outter().new Inner()
public class Test {
    public static void main(String[] args) {
        Outter outter = new Outter();
        outter.setName("Alice");
        outter.setPassword("123");
        System.out.println(outter.getName()+" "+outter.getPassword());

        //初始化内部类
        Outter.Inner inner =outter.new Inner();
        inner.setAddress("火星");
        inner.setSex("男");
        System.out.println(inner.getAddress()+" "+inner.getSex());
    }
}
