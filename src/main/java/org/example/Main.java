package org.example;

import org.example.Shop.Product;
import org.example.Shop.Shop;
import org.example.coverage.SomeService;
import org.example.fourth.book.Book;
import org.example.fourth.book.BookRepository;
import org.example.fourth.book.BookService;
import org.example.fourth.book.InMemoryBookRepository;
import org.example.fourth.database.DataProcessor;
import org.example.fourth.database.Database;
import org.example.fourth.hotel.BookingService;
import org.example.fourth.hotel.HotelService;
import org.example.fourth.message.MessageService;
import org.example.fourth.message.NotificationService;
import org.example.fourth.weather.WeatherReporter;
import org.example.fourth.weather.WeatherService;
import org.example.tdd.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;


import static org.assertj.core.api.Assertions.*; // Импортируем классы библиотеки assertJ
import static org.example.Shop.Shop.getMostExpensiveProduct;
import static org.example.calculator.Calculator.calculatingDiscount;


public class Main {
    public static void main(String[] args) {

        /**
         * У вас есть класс BookService, который использует интерфейс BookRepository для получения информации о книгах из базы данных.
         * Ваша задача написать unit-тесты для BookService, используя Mockito для создания мок-объекта BookRepository.
         */
        // Создаем экземпляр репозитория и сервиса
        BookRepository bookRepository = new InMemoryBookRepository();
        BookService bookService = new BookService(bookRepository);

        // Проверка работы findByTitle
        Book Foundbook = bookService.findByTitle("Book2");
        System.out.println("Found Book: " + Foundbook.getTitle() + " by " + Foundbook.getAuthor());


        bookService.addBook(new Book("6", "Book6", "Author6"));
        bookService.addBook(new Book("7", "Book7", "Author7"));
        // удаление книги
//        bookService.deleteBook("5");


        System.out.println("All Books:");
        for (Book b : bookService.findAllBooks()) {
            System.out.println(b.getTitle() + " by " + b.getAuthor());
        }

        // Создаем новую книгу с обновленными данными
        Book updatedBook = new Book("1", "Updated Book1", "Updated Author1");

        // Обновляем книгу
        bookRepository.update(updatedBook);

        System.out.println("Все книги после обновления:");
        for (Book b : bookService.findAllBooks()) {
            System.out.println(b.getTitle() + " by " + b.getAuthor());
        }







        /**
         * Вам требуется протестировать класс, который обрабатывает запросы к базе данных.
         * Условие: У вас есть класс Database с методом public List<String> query(String sql), который выполняет SQLзапрос и возвращает результат.
         * Вам необходимо проверить правильность работы класса DataProcessor, который использует Database для
         * выполнения запроса и обработки результатов.
         */

        // Создаём экземпляр класса  Database
        Database database = new Database();

        // Создаём экземпляр класса DataProcessor, передавая в конструктор database
        DataProcessor dataProcessor = new DataProcessor(database);

        // Вызываем метод processData и выводим результаты
        List<String> data = dataProcessor.processData("SELECT * FROM table");
        for (String datum : data) {
            System.out.println(datum);
        }

        /**
         * Вам нужно написать тест с использованием моков для сервиса отправки сообщений.
         * Условие: У вас есть класс MessageService с методом public void sendMessage(String message, String
         * recipient), который отправляет сообщение получателю.
         * Вам необходимо проверить правильность работы класса NotificationService, который использует
         * MessageService для отправки уведомлений.
         */
        MessageService messageService = new MessageService();
        NotificationService notificationService = new NotificationService(messageService);
        notificationService.sendNotification("Привет!", "Анна");

        // Создание реального экземпляра HotelService
        HotelService realHotelService = new HotelService();

        // Создание экземпляра BookingService с реальным HotelService
        BookingService bookingService = new BookingService(realHotelService);

        // Пытаемся забронировать доступный номер (например, номер 2)
        if (bookingService.bookRoom(2)) {
            System.out.println("Успешно забронирован номер 2!");
        } else {
            System.out.println("Не удалось забронировать номер 2.");
        }

        // Пытаемся забронировать недоступный номер (например, номер 3)
        if (bookingService.bookRoom(3)) {
            System.out.println("Успешно забронирован номер 3!");
        } else {
            System.out.println("Не удалось забронировать номер 3.");
        }

        WeatherService weatherService = new WeatherService();
        WeatherReporter weatherReporter = new WeatherReporter(weatherService);
        String report = weatherReporter.generateReport();
        System.out.println("Погода: " + report);

         User user = new User("name1", "password", false);
         System.out.println("User: " + user);
        SomeService someService = new SomeService();
        System.out.println("Число чётное :" + someService.evenOddNumber(-1));
        System.out.println("Число попадает в интервал от 25 до 100: " + someService.numberInInterval(3));
        String fizzbuzz = someService.fizzBuzz(3);
        System.out.println("metod FizzBuzz: " + fizzbuzz);

        System.out.println(someService.firstLast6(new int[]{6, 3, 5, 3}));
        System.out.println("Сумма покупки со скидкой: " + someService.calculatingDiscount(200, 10));
        System.out.println();
        System.out.println("Метод someService: " + someService.luckySum(13, 10, 13));

        Shop shop = new Shop();
        List<Product> productList = new ArrayList<>();

        productList.add(new Product("Product A", 15.99));
        productList.add(new Product("Product B", 5.49));
        productList.add(new Product("Product C", 10.00));

        shop.setProducts(productList);

        List<Product> sortedProducts = shop.sortProductsByPrice();
        sortedProducts.forEach(System.out::println);
        System.out.println("Самый дорогой продукт:");
        System.out.println(getMostExpensiveProduct(productList));


//   System.out.println(calculatingDiscount(200, -1));
        // Проверьте, как работают методы:

//        assertConditionA();
//
//       assertConditionB();

  //      System.out.println(sum(2_147_483_647, 1));

  //      happyNY();

  //       expectedValue();

      //  checkingShoppingCart();

        /*
                assertThat(colors)
                        .isNotEmpty()             // Массив не должен быть пустым
                        .hasSize(7)               // Размер массива должен быть равен 7
                        .doesNotHaveDuplicates()  // Массив не должен содержать повторяющихся элементов
                        .contains("orange", "green", "violet") // Массив должен содержать цвета: "orange", "green", "violet"
                        .endsWith("gold")        //  Последним цветом в массиве должен быть "gold"
                        .startsWith("aqua")     // Первым цветом в массиве должен быть "aqua"
                        .containsSequence("yellow", "blue") // В массиве должна быть последовательность цветов "yellow", "blue"
                        .doesNotContain("red", "black");    //Массив не должен содержать цвета: "red", "black"
        */

         String[] colors = {"aqua", "orange","yellow", "blue", "green", "violet", "gold"};

   //       testingJavaCollectionsAssertJ(colors);

    //      checkingHero();
    }

    //                  Практические задания:
    // 1.1
    public static void assertConditionA() {
        String[] weekends = {"Суббота", "Воскресенье"};
        assert weekends.length == 2;
        System.out.println("В неделе " + weekends.length + " дня выходных");
    }

    // 1.2
    public static void assertConditionB() {
        int x = -1;
        assert x < 0;
    }

    // 1.3
    // assert boolean_выражение : сообщение_об_ошибке;
    // Ariane V - https://habr.com/ru/company/pvs-studio/blog/306748/
    // sum(2_147_483_647, 1) возвращает "-2147483648"
    public static int sum(int a, int b) {
        long result = (long) a + b;
        assert (result <= Integer.MAX_VALUE && result >= Integer.MIN_VALUE) : "Integer overflow";
        return (int) result;
    }

    // 1.4
    // 08/12/2022 06:19:41
    // windows fail - https://habr.com/ru/company/pvs-studio/blog/698404/
    public static void happyNY() {
        Calendar calendar = Calendar.getInstance();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String currentDateTime = dateFormat.format(calendar.getTime());

        assert currentDateTime.equals("01/01/2026") : "Еще 2025 год :(";
        if (currentDateTime.equals("01/01/2026")) {

        System.out.println("С новым годом!");
    }else {
            System.out.println("Еще 2025 год :(");
        }
    }

    // 1.5
    // выражение assert верно, нужно исправить код
    // Вот наиболее распространенный вариант использования. Предположим, вы включаете значение enum:
    public static void checkingShoppingCart() {
        ArrayList<String> productCategories = new ArrayList<>();
        productCategories.add("fruits");
        productCategories.add("vegetables");
        productCategories.add("bakery");
        productCategories.add("drinks");

        ArrayList<String> products = new ArrayList<>();
        products.add("apple");
        products.add("tomato");
        products.add("bread");
        products.add("water");

        for (String product : products) {
            if (product.equals("apple")) {
                System.out.println("category: " + productCategories.get(0));
            } else if (product.equals("tomato")) {
                System.out.println("category: " + productCategories.get(1));
            } else if (product.equals("bread")) {
                System.out.println("category: " + productCategories.get(2));
            }  else if (product.equals("water")) {
                System.out.println("category: " + productCategories.get(3));
            }else {
                assert false : "Unknown category for the product " + product;
            }
        }
    }

    // 1.6
    //   AssertJ
    // ok - assertThat(actual/фактическое).isEqualTo(expected/ожидаемое);
    // not ok - assertThat(expected/ожидаемое).isEqualTo(actual/фактическое);
    public static void expectedValue() {
        assertThat(sum(2, 3)).isEqualTo(5);
    }

    // 1.7
    public static void testingJavaCollectionsAssertJ(String[] colors) {
        assertThat(colors)
                .isNotEmpty()             // Массив не должен быть пустым
                .hasSize(7)      // Размер массива должен быть равен 7
                .doesNotHaveDuplicates() // Массив не должен содержать повторяющихся элементов
                .contains("orange", "green", "violet") // Массив должен содержать цвета: "orange", "green", "violet"
                .endsWith("gold")   //  Последним цветом в массиве должен быть "gold"
                .startsWith("aqua")     // Первым цветом в массиве должен быть "aqua"
                .containsSequence("yellow", "blue")      // В массиве должна быть последовательность цветов "yellow", "blue"
                .doesNotContain("red", "black"); //Массив не должен содержать цвета: "red", "black"
    }

    // 1.8
    public static void checkingHero() {

        List<String> heroBag = Arrays.asList("Bow", "Axe", "Gold");
        Hero emmett = new Hero("Emmett", 50, "sword", heroBag, true);

        /*
        1. Проверить, что герой создался с именем Emmett
        2. Проверить, что значение прочности брони героя равно 50
        3. Проверить, что у героя оружие типа sword
        4. Проверить содержимое инвентаря героя (не пустой, размер 3, содержимое "Bow", "Axe", "Gold", порядок не важен)
        5. Проверить, что герой человек (свойство true)
        */

         assert "Emmett".equals(emmett.getName()): "Name should be Emmett";
         assert "50".equals(String.valueOf(emmett.getArmorStrength())): "значение прочности брони героя должно быть равно 50";
         assert "sword".equals(emmett.getWeapon()): "у героя оружие должно быть типа sword";
         assert emmett.isHuman : "герой должен быть человеком (свойство true)";

        assertThat(heroBag)
                .isNotEmpty()             // Массив не должен быть пустым
                .hasSize(3)      // Размер массива должен быть равен 3
                .doesNotHaveDuplicates() // Массив не должен содержать повторяющихся элементов
                .contains("Bow", "Axe", "Gold"); // Массив должен содержать "Bow", "Axe", "Gold"


    }

    // 1.8 (Черный ящик)
    static class Hero {
        private String name;
        private int armorStrength;
        private String weapon;
        private List<String> bag;
        private boolean isHuman;

        public Hero(String name, int armorStrength, String weapon, List<String> bag, boolean isHuman) {
            this.name = name;
            this.armorStrength = armorStrength;
            this.weapon = weapon;
            this.bag = bag;
            this.isHuman = isHuman;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getArmorStrength() {
            return armorStrength;
        }

        public void setArmorStrength(int armorStrength) {
            this.armorStrength = armorStrength;
        }

        public String getWeapon() {
            return weapon;
        }

        public void setWeapon(String weapon) {
            this.weapon = weapon;
        }

        public List<String> getBag() {
            return bag;
        }

        public void setBag(List<String> bag) {
            this.bag = bag;
        }

        public boolean isHuman() {
            return isHuman;
        }

        public void setHuman(boolean human) {
            isHuman = human;
        }



 }
}