package com.example.shoppingappnew;

public class Model {
    String name;
    String category;
    String price;
    String description;

    public Model(String name, String category, String price, String description) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
    }

    public Model() {
    }

    @Override
    public String toString() {
        return "Model{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Model(String name, String category, String price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
