package com.zzjcy.feign.mall.controller;

/**
 * @author Administrator
 * @description
 * @date 2018/5/28
 */
public class Product {
    private String itemCode;
    private String name;
    private String bandName;
    private int price;

    public Product() {
    }

    public Product(String itemCode, String name, String bandName, int price) {
        this.itemCode = itemCode;
        this.name = name;
        this.bandName = bandName;
        this.price = price;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
