package org.example.fourth.book;

import java.util.List;

public interface BookRepository {
    Book findById(String id);
    public Book findByTitle(String title);
    List<Book> findAll();
    void add(Book book);
    void delete(String id);
    public void update(Book book);
}
