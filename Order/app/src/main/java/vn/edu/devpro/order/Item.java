package vn.edu.devpro.order;

import java.io.Serializable;

public class Item implements Serializable {
    String Name;
    int amount;

    public Item(String name, int amount) {
        Name = name;
        this.amount = amount;
    }

    public Item() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
