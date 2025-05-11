package org.example.fourth.book;

import java.util.List;
import java.util.NoSuchElementException;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findBookById(String id) {
        return bookRepository.findById(id);
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        bookRepository.add(book);
    }

    public void deleteBook(String id) {
        bookRepository.delete(id);
    }
    public void update(Book book) throws NoSuchFieldException {
        if (bookRepository.findById(book.getId()) == null) {
            throw new NoSuchElementException("Книга с ID " + book.getId() + " не найдена для обновления.");
        }
        bookRepository.update(book);
    }

    public Book findByTitle(String title) {
        Book findBook = bookRepository.findByTitle(title);
        if (findBook == null) {
            throw new NoSuchElementException("Книга с названием " + title + " не найдена.");
        }
        return findBook;
    }
}
