package vn.edu.devpro.order;

import java.io.Serializable;

public class Item implements Serializable {
    String Name;
    Double price;

    public Item() {
    }

    public Item(String name, Double price) {
        Name = name;
        this.price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
