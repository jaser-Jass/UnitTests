package org.example.notebook;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Меню:");
            System.out.println("1. Добавить контакт");
            System.out.println("2. Редактировать контакт");
            System.out.println("3. Удалить контакт");
            System.out.println("4. Показать все контакты");
            System.out.println("5. Выход");
            System.out.print("Введите ваш выбор: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Очистить буфер ввода

            switch (choice) {
                case 1:
                    System.out.print("Введите имя контакта: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите номер телефона: ");
                    String phoneNumber = scanner.nextLine();
                    addressBook.addContact(new Contact(name, phoneNumber));
                    break;
                case 2:
                    addressBook.listContacts();
                    System.out.print("Введите индекс контакта для редактирования: ");
                    int editIndex = scanner.nextInt();
                    scanner.nextLine(); // Очистить буфер ввода
                    System.out.print("Введите новое имя контакта: ");
                    String newName = scanner.nextLine();
                    System.out.print("Введите новый номер телефона: ");
                    String newPhoneNumber = scanner.nextLine();
                    addressBook.editContact(editIndex, newName, newPhoneNumber);
                    break;
                case 3:
                    addressBook.listContacts();
                    System.out.print("Введите индекс контакта для удаления: ");
                    int deleteIndex = scanner.nextInt();
                    addressBook.deleteContact(deleteIndex);
                    break;
                case 4:
                    addressBook.listContacts();
                    break;
                case 5:
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, попробуйте снова.");
            }
        } while (choice != 5);

        scanner.close(); // Закрыть сканер
    }
}

