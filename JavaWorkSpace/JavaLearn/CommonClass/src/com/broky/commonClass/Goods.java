package com.broky.commonClass;

/**
 * @author 13roky
 * @date 2021-05-12 22:42
 */
public class Goods {
    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" + "name='" + name + '\'' + ", price=" + price + '}';
    }
}
