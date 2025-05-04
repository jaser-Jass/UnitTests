package org.example.shop;
import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.example.Shop.Product;
import org.example.Shop.Shop;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class ShopTest {
    @Test
    public void testProductsStorage() {
        Shop shop = new Shop();
        Product product1 = new Product("Product A", 10.99);
        Product product2 = new Product("Product B", 15.49);

        shop.setProducts(Arrays.asList(product1, product2));

        // Проверка размера списка
        assertThat(shop.getProducts()).hasSize(2);

        // Проверка содержимого списка
        assertThat(shop.getProducts()).containsExactly(product1, product2);
    }

    @Test
    public void testGetMostExpensiveProduct() {
        Product product1 = new Product("Product A", 10.99);
        Product product2 = new Product("Product B", 15.49);
        Product product3 = new Product("Product C", 20.00);

        List<Product> productList = Arrays.asList(product1, product2, product3);

        // Проверяем, что самый дорогой продукт — это product3
        Product mostExpensive = Shop.getMostExpensiveProduct(productList);
        assertThat(mostExpensive).isEqualTo(product3);
    }

    @Test
    public void testGetMostExpensiveProductThrowsExceptionOnEmptyList() {
        List<Product> emptyList = Collections.emptyList();

        // Проверяем, что выбрасывается исключение, когда список пуст
        assertThatThrownBy(() -> Shop.getMostExpensiveProduct(emptyList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Список пуст");
    }

    @Test
    public void testSortProductsByPrice() {
        Shop shop = new Shop();
        Product product1 = new Product("Product B", 15.49);
        Product product2 = new Product("Product A", 10.99);
        Product product3 = new Product("Product C", 20.00);

        shop.setProducts(Arrays.asList(product1, product2, product3));

        List<Product> sortedProducts = shop.sortProductsByPrice();

        // Проверка, что список продуктов отсортирован по цене
        assertThat(sortedProducts)
                .containsExactly(product2, product1, product3);  // Ожидаем, что product2 будет первым, затем product1 и product3
    }

    @Test
    public void testSortProductsByPriceReturnsEmptyListWhenNoProducts() {
        Shop shop = new Shop();
        shop.setProducts(Collections.emptyList());

        // Проверяем, что возвращается пустой список при отсутствии продуктов
        List<Product> sortedProducts = shop.sortProductsByPrice();
        assertThat(sortedProducts).isEmpty();
    }
}




//    public static void main(String[] args) {
//        Shop shop = new Shop();
//        Product product1 = new Product("Product A", 10.99);
//        Product product2 = new Product("Product B", 15.49);
//        Product product3 = new Product("Product C", 9.99);
//        Product product4 = new Product("Product D", 16.49);
//        Product product5 = new Product("Product I", 20.00);
//
//        shop.setProducts(Arrays.asList(product1, product2, product3, product4, product5));
//
//        // Проверка размера списка
//        assertThat(shop.getProducts()).hasSize(5);
//
//        // Проверка содержимого списка
//        assertThat(shop.getProducts()).containsExactly(product1, product2, product3, product4, product5);
//
//
//
//        List<Product> productList = Arrays.asList(product1, product2, product3, product4, product5);
//
//        // Проверяем, что самый дорогой продукт — это product3
//        Product mostExpensive = Shop.getMostExpensiveProduct(productList);
//        assertThat(mostExpensive).isEqualTo(product5);
//
//
//        List<Product> emptyList = Collections.emptyList();
//
//        // Проверяем, что выбрасывается исключение, когда список пуст
//        Assertions.assertThatThrownBy(() -> Shop.getMostExpensiveProduct(emptyList))
//                .isInstanceOf(IllegalArgumentException.class)
//                .hasMessage("Список пуст");
//
//        List<Product> sortedProducts = shop.sortProductsByPrice();
//        // System.out.println(sortedProducts);
//
//        // Проверка, что список продуктов отсортирован по цене
//        assertThat(sortedProducts)
//                .containsExactly(product3, product1, product2, product4, product5);  // Ожидаем, что product3 будет первым, затем product1, product2, product4, product5
//
//
//        Shop shop1 = new Shop();
//        shop1.setProducts(Collections.emptyList());
//
//        // Проверяем, что возвращается пустой список при отсутствии продуктов
//        List<Product> sortedProducts1 = shop1.sortProductsByPrice();
//        assertThat(sortedProducts1).isEmpty();
//    }
//