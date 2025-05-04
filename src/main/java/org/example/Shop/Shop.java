package org.example.Shop;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        if (products == null || products.isEmpty()) {
            return new ArrayList<>();  // Возвращаем пустой список, если нет продуктов
        }

        products.sort(Comparator.comparing(Product::getCost));  // Сортируем список по цене
        return products;  // Возвращаем отсортированный список
    }

    // Метод должен вернуть самый дорогой продукт:
    public static Product getMostExpensiveProduct(List<Product> products) {
        if (products.isEmpty()) {
            throw new IllegalArgumentException("Список пуст");
        }

        Product mostExpensive = products.get(0); // Берём первый элемент как начальное значение

        for (Product product : products) {
            if (product.getCost() > mostExpensive.getCost()) {
                mostExpensive = product;
            }
        }

        return mostExpensive;
    }
}
