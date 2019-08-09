package com.qi;/*
    name zhang;
    */

public class Items {

    private Integer id;
    private String name;
    private Double price;
    private String itemsdetail;

    public Items(Integer id, String name, Double price, String itemsdetail) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.itemsdetail = itemsdetail;
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
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public String getItemsdetail() {
        return itemsdetail;
    }
    public void setItemsdetail(String itemsdetail) {
        this.itemsdetail = itemsdetail;
    }



}