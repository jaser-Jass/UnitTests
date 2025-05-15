package org.example.notebook;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void editContact(int index, String newName, String newPhoneNumber) {
        if (index >= 0 && index < contacts.size()) {
            contacts.get(index).setName(newName);
            contacts.get(index).setPhoneNumber(newPhoneNumber);
        } else {
            System.out.println("Контакт не найден.");
        }
    }

    public void deleteContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
        } else {
            System.out.println("Контакт не найден.");
        }
    }

    public void listContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Записная книжка пуста.");
            return;
        }
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println(i + ": " + contacts.get(i));
        }
    }

    public List<Contact> getContacts() {
        return contacts;
    }
}
