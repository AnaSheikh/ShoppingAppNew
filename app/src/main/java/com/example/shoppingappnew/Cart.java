package com.example.shoppingappnew;

public class Cart {

    String name;
    String category;
    String price;
    String description;
    Number amount;
    int image;




    @Override
    public String toString() {
        return "Cart{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", image=" + image +
                '}';
    }

    public Cart(String name, String category, String price, String description, int image) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public Cart(String name, String category, String price, String description, Number amount, int image) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.amount = amount;
        this.image = image;
    }

    public Number getAmount() {
        return amount;
    }

    public void setAmount(Number amount) {
        this.amount = amount;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }



    public void setCart(String a,String b, String c, String d, int e)
    {
        name= a;
        category =b;
        price =c;
        description =d;
        image= e;
    }
}
