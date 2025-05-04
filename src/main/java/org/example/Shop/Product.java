package org.example.Shop;

public class Product {
    private double cost; // Стоимость продукта
    private String title; // Название


    public Product(String title, double cost) {
        this.title = title;
        this.cost = cost;
    }

    // Геттеры, сеттеры:
    public double getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Override
    public String toString() {
        return "Product{name='" + title + "', price=" + cost + '}';
    }
}
