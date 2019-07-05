package io.github.seevae.map;/*
    name zhang;
    */


import java.util.*;

class People{
    private Integer id;
    private String name;

    public People(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        People people = (People)obj;
        if(people.id.equals(this.id)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

public class Test2 {

    public static void main(String[] args) {
        Map<People,String> map = new HashMap<People, String>();
        People people1 = new People(1,"张三");
        People people2 = new People(1,"张三");
        map.put(people1,"北京");
        map.put(people2,"上海");
        Set<Map.Entry<People,String>> set = map.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println("key= "+entry.getKey()+" - "+"value= "+entry.getValue());
        }
    }
}
