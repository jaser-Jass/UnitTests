package org.example.notebook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


// Юнит-тесты для класса AddressBook

public class AddressBookTest {
    private AddressBook addressBook;

    @BeforeEach
    public void setUp() {
        addressBook = new AddressBook();
    }

    // Тестируем метод добавления контакта в записную книжку
    @Test
    public void testAddContact() {
        // Создаем контакт
        Contact contact = new Contact("User1", "12345");

        // Добавляем созданный контакт в записную книгу
        addressBook.addContact(contact);


        // Проверяем, что размер списка контактов равен одному
        assertEquals(1, addressBook.getContacts().size());

        // Проверяем, что имя контакта соответствует ожидаемому
        assertEquals("User1", addressBook.getContacts().get(0).getName());
    }

    // Тестируем метод редактирования существующего контакта

    @Test
    public void testEditContact_ValidIndex() {
        Contact contact = new Contact("User1", "12345");
        addressBook.addContact(contact);

        addressBook.editContact(0, "User2", "67890");
        assertEquals("User2", addressBook.getContacts().get(0).getName());
        assertEquals("67890", addressBook.getContacts().get(0).getPhoneNumber());
    }

    // Тестируем метод редактирования несуществующего контакта

    @Test
    public void testEditContact_InvalidIndex() {

        // Создаём и добавляем контакты
        Contact contact1 = new Contact("User1", "12345");
        addressBook.addContact(contact1);

        Contact contact2 = new Contact("User2", "67891");
        addressBook.addContact(contact2);

        // Пробуем изменить несуществующий контакт
        addressBook.editContact(-3, "User3", "00000");

        // Проверяем, что контакты не изменились
         assertEquals("User1", contact1.getName());
         assertEquals("User2", contact2.getName());

    }
    // Проверка вывода сообщений. Метод выводит сообщение "Контакт не найден", если переданный индекс выходит за пределы диапазона
    // Что бы проверить вывод, используем класс System.setOut() для перенаправления стандартного потока вывода
    @Test
    void testEditContactOutputForInvalidIndex() {
        // Создаём и добавляем контакты
        Contact contact1 = new Contact("User1", "12345");
        addressBook.addContact(contact1);

        Contact contact2 = new Contact("User2", "67891");
        addressBook.addContact(contact2);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        try {
            System.setOut(new PrintStream(outputStream));

            // Пробуем изменить несуществующий контакт
            addressBook.editContact(-3, "User3", "00000");

            assertTrue(outputStream.toString().contains("Контакт не найден."));
        } finally {
            System.setOut(originalOut); // Возвращаем стандартный поток обратно
        }
    }
         // Тестируем метод удаления контакта с существующим id
    @Test
    public void testDeleteContact_ValidIndex() {
        // Создаём контакты
        addressBook.addContact(new Contact("User1", "12345"));
        addressBook.addContact(new Contact("User2", "67890"));

        // Вызываем метод deleteContact
        addressBook.deleteContact(0);

        // Проверяем размер массива contacts
        assertEquals(1, addressBook.getContacts().size());

        // Проверяем оставшийся после удаления контакт на соответствие имени
        assertEquals("User2", addressBook.getContacts().get(0).getName());
    }


    // Тестируем метод удаления контакта с несуществующим id
    @Test
    public void testDeleteContact_InvalidIndex() {
        // Создаём и добавляем контакты
        Contact contact1 = new Contact("User1", "12345");
        addressBook.addContact(contact1);

        Contact contact2 = new Contact("User2", "67891");
        addressBook.addContact(contact2);

        // Вызываем метод deleteContact с некорректным id
        addressBook.deleteContact(-1);

        // Проверяем, что контакты не изменились
        assertEquals("User1", contact1.getName());
        assertEquals("User2", contact2.getName());
    }


    // тестируем метод deleteContact с некорректным id на вывод соответствующего сообщения
    @Test
    void testdeleteContactOutputForInvalidIndex() {
        // Создаём и добавляем контакты
        addressBook.addContact(new Contact("User1", "12345"));
        addressBook.addContact(new Contact("User2", "67890"));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        try {
            System.setOut(new PrintStream(outputStream));

            // Пробуем удалить несуществующий контакт
         addressBook.deleteContact(3);

            assertTrue(outputStream.toString().contains("Контакт не найден."));
        } finally {
            System.setOut(originalOut); // Возвращаем стандартный поток обратно
        }
    }

    // Тестируем метод listContacts(). Если список контактов пуст, выводит соответствующее сообщение
 @Test
    void testListContactsWithEmptyBook() {


     ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
     PrintStream originalOut = System.out;

     try {
         System.setOut(new PrintStream(outputStream));


         addressBook.listContacts();

         assertTrue(outputStream.toString().contains("Записная книжка пуста."));
     } finally {
         System.setOut(originalOut); // Возвращаем стандартный поток обратно
     }
 }

 // Тестирование записной книжки с одним контактом
 @Test
 void testListContactsWithOneContact() {
     addressBook.addContact(new Contact("User1", "12345"));

     ByteArrayOutputStream outContent = new ByteArrayOutputStream();
     PrintStream originalOut = System.out; // Сохраняем оригинальный поток
     System.setOut(new PrintStream(outContent));

     try {
         addressBook.listContacts();

         // Добавляем символ новой строки в ожидаемое значение
         String expected = "0: Contact{name='User1', phoneNumber='12345'}" + System.lineSeparator();
         assertEquals(expected, outContent.toString());
     } finally {
         System.setOut(originalOut); // Восстанавливаем оригинальный поток
     }
   }

    // Тестирование записной книжки с несколькими контактами
    @Test
    void testListContactsWithMultipleContacts() {
        addressBook.addContact(new Contact("User1", "12345"));
        addressBook.addContact(new Contact("User2", "67890"));
        addressBook.addContact(new Contact("User3", "45678"));
          ByteArrayOutputStream outContent = new ByteArrayOutputStream();
          System.setOut(new PrintStream(outContent));

          addressBook.listContacts();

        String expected =
                "0: Contact{name='User1', phoneNumber='12345'}" + System.lineSeparator() +
                "1: Contact{name='User2', phoneNumber='67890'}" + System.lineSeparator() +
                        "2: Contact{name='User3', phoneNumber='45678'}" + System.lineSeparator();
        assertEquals(expected, outContent.toString());
        
    }

    // Тестируем все функции в совокупности
    @Test
    public void testFullAddressBookFunctionality() {
        addressBook.addContact(new Contact("User1", "12345"));
        addressBook.addContact(new Contact("User2", "67890"));
        addressBook.addContact(new Contact("User3", "45678"));
        assertEquals(3, addressBook.getContacts().size());

        addressBook.editContact(2, "User3Edit", "33333");
        assertEquals("User3Edit", addressBook.getContacts().get(2).getName());

       addressBook.deleteContact(1);
       assertEquals(2, addressBook.getContacts().size());
       assertEquals("User1", addressBook.getContacts().get(0).getName());

    }

}


