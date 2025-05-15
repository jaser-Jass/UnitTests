package org.example.five;

import org.example.five.number.MaxNumberModule;
import org.example.five.number.RandomNumberModule;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTest {
    // 5.1.
    // RandomNumberGenerator
    @Test
    public void testGenerateRandomNumbers() {
        RandomNumberModule generator = new RandomNumberModule();
        int[] numbers = generator.generateRandomNumbers(10);
        // Проверяем, что размер массива, возвращаемого функцией, равен ожидаемому
        assertEquals(10, numbers.length);
    }

    // MaxNumberModule
    @Test
    public void testFindMaxNumber() {
        MaxNumberModule finder = new MaxNumberModule();

        // Создаём тестовый массив
        int[] numbers = {1, 2, 3, 4, 5};

        // Проверяем, что функция находит ожидаемое максимальное число в массиве
        assertEquals(5, finder.findMaxNumber(numbers));
    }

    @Test
    public void testFindMaxInGeneratedNumbers() {
        RandomNumberModule generator = new RandomNumberModule();
        MaxNumberModule finder = new MaxNumberModule();

        // Генерируем массив случайных чисел
        int[] numbers = generator.generateRandomNumbers(10);

        // Находим максимальное число в массиве
        int maxNumber = finder.findMaxNumber(numbers);

        // Сортируем массив, чтобы легко определить максимальное число
        Arrays.sort(numbers);

        // Проверяем, что найденное число равно максимальному числу в отсортированном массиве
        assertEquals(numbers[numbers.length - 1], maxNumber);
    }
    @Test
    public void testGoogleSearch() throws InterruptedException {



        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-agent=User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/99.0.4844.51 Safari/537.36");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com");


        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();

        Thread.sleep(300);
        List<WebElement> searchResults = driver.findElements(By.cssSelector("div"));

        boolean isFound = false;
        for (WebElement webElement : searchResults) {
            System.out.println(webElement.getText());
            if (webElement.getText().contains("https://www.selenium.dev")) {
                isFound = true;
                break;
            }
        }
        assertTrue(isFound);
        driver.quit();
    }
    @Test
    public void testLogin() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        Thread.sleep(300);

        loginButton.click();

        Thread.sleep(3000);

        WebElement productsLabel = driver.findElement(By.className("title"));
        assertEquals("Products", productsLabel.getText());

        driver.quit();
    }
}
