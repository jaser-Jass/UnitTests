package org.example.fourth.book;

import java.util.*;

public class InMemoryBookRepository implements BookRepository  {
    private final Map<String, Book> books;

    public InMemoryBookRepository() {
        this.books = new HashMap<>();
        books.put("1", new Book("1", "Book1", "Author1"));
        books.put("2", new Book("2", "Book2", "Author2"));
    }

    @Override
    public Book findById(String id) {
        Book findBook = books.get(id);
        if (findBook == null) {
            throw new NoSuchElementException("Книга с ID " + id + " не найдена.");
        }

        return findBook;
    }

    @Override
    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }
    @Override
    public void add(Book book) {
        books.put(book.getId(), book);
    }

    @Override
    public void delete(String id) {
        Book removedBook = books.remove(id);

        if (removedBook == null) {
            throw new NoSuchElementException("Книга с ID " + id + " не найдена.");
        }
        System.out.println("Удалена книга: " + removedBook.getTitle() + " Автор: " + removedBook.getAuthor());
    }
    @Override
    public void update(Book book) {
        // Логика обновления книги
        if (books.containsKey(book.getId())) {
            books.put(book.getId(), book); // Обновляем или добавляем книгу по ID
        } else {
            throw new NoSuchElementException("Книга с ID " + book.getId() + " не найдена для обновления.");
        }
    }
     // Метод для поиска книг по заголовку, возможно, возвращающий список книг.

    public Book findByTitle(String title) {
        for (Book book : books.values()) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
 throw new NoSuchElementException("Книга с названием " + title + " не найдена.");
    }

}
