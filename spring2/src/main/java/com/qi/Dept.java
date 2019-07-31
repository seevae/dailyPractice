package com.qi;/*
    name zhang;
    */

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

//部门类
public class Dept {

    private String deptname;
    private String address;

    //代表一个部门里面有哪些用户
    private String[] empname;

    private List<User> userList;
    private Set<User> userSet;

    //<>代表泛型
    private Map<String,User> userMap;

    private Properties properties;

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String[] getEmpname() {
        return empname;
    }

    public void setEmpname(String[] empname) {
        this.empname = empname;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
