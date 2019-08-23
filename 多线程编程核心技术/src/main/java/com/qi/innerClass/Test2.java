package com.qi.innerClass;


//静态内部类
class Out{
    private String name;
    private String id;
    private static String password = "111";

    public String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Out.password = password;
    }

    static class In{
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

        public void getOutMsg(){
            System.out.println(password);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

//静态内部类的创建: Out.In in = new Out.In()
public class Test2 {

    public static void main(String[] args) {
        Out out = new Out();
        out.setId("88");
        out.setName("大舅哥");
        Out.In in = new Out.In();
        in.getOutMsg();
    }
}
