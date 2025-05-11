package org.example.fourth.book;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class BookServiceTest {
    private BookRepository mockBookRepository;
    private BookService bookService;
    @BeforeEach
    void setup() {

        // Создаём мок для репозитория
        mockBookRepository = mock(BookRepository.class);
        // Создаём объект класса, который  хотим протестировать, передавая мок в качестве зависимости
        bookService = new BookService(mockBookRepository);

    }
    // Тестируем метод поиска книги с существующим id
    @Test
    public void testfindBookByExistingId() {
        // Настраиваем  поведение мока
        when(mockBookRepository.findById("1")).thenReturn(new Book("1", "Book1", "Author1"));

        // Получаем книгу по ID
        Book foundBook = bookService.findBookById("1");

        // Проверка названия книги с ID 1
        assertEquals("Book1", foundBook.getTitle(), "Название книги должно быть Book1");

        // Проверка автора книги с ID 1
        assertEquals("Author1", foundBook.getAuthor(), "Автрором книги должен быть Author1");


    }

    // Тестируем метод поиска книги с несуществующим id

    @Test
    void testFindBookByIdNonExistingIdThrowsException() {
        String nonexistentId = "999";  // ID, который не существует

        // Настройка: когда вызывается findById с nonexistentId, он должен выбрасывать исключение
        when(mockBookRepository.findById(nonexistentId)).thenThrow(new NoSuchElementException("Книга с ID " + nonexistentId + " не найдена."));

        // Проверяем, что выбрасывается исключение
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            bookService.findBookById(nonexistentId);
        });

        // Cообщение об ошибке должно совпадать
        assertEquals("Книга с ID " + nonexistentId + " не найдена.", exception.getMessage());
    }
    @Test
    public void testFindAllBooks() {

        // Настраиваем  поведение мока
        when(mockBookRepository.findAll()).thenReturn(Arrays.asList(
                new Book("1", "Book1", "Author1"),
                new Book("2", "Book2", "Author2")));

        // Получаем список всех книг
        List<Book> allBooks = bookService.findAllBooks();

        // Проверяем размер списка
        assertEquals(2, allBooks.size(), "Количество книг должно быть равно двум");

        // Проверяем название первой книги
        assertEquals("Book1", allBooks.get(0).getTitle(), "Первая книга должна иметь название Book1");

        // Проверяем автора первой книги
        assertEquals("Author1", allBooks.get(0).getAuthor(), "Автором первой книги должен быть Author1");

        // Проверяем название второй книги
        assertEquals("Book2", allBooks.get(1).getTitle(), "Вторая книга должна иметь название Book2");

        // Проверяем автора второй книги
        assertEquals("Author2", allBooks.get(1).getAuthor(), "Автором второй книги должен быть Author2");


    }
        // Тестируем метод добавления книги
    @Test
    void testAddBook() {
        Book book = new Book("5", "Book5", "Author5");

        bookService.addBook(book);

        // Проверяем, что метод add был вызван у репозитория
        verify(mockBookRepository, times(1)).add(book);
    }

    // Тестируем метод удаления книги с существующим id
    @Test
    void testDeleteBookWithExistingId() {
        String bookId = "1";  // ID книги, которую будем удалять
        bookService.deleteBook(bookId);
        // Проверяем, что метод delete был вызван с указанным ID
        verify(mockBookRepository, times(1)).delete(bookId);
    }


    // Удаление книги с несуществующим id
    @Test
    void testDeleteBookWithNotExistingId() {
        String bookId = "999";  // ID, который не существует

        // Проверяем, что метод delete был вызван с указанным ID
        doNothing().when(mockBookRepository).delete(bookId);
        // Выполняем удаление
        bookService.deleteBook(bookId);

        // Проверяем, что метод delete был вызван
        verify(mockBookRepository, times(1)).delete(bookId);
    }

    // Тестируем метод update для книги с существующим id
    @Test
    void testUpdateWithExistingId() throws NoSuchFieldException {
        // Создаем книгу, которую хотим обновить
        Book existingBook = new Book("1", "Book1", "Author1");

        // Настраиваем поведение мока: когда мы запрашиваем книгу по ID "1", он должен вернуть существующую книгу
        when(mockBookRepository.findById("1")).thenReturn(existingBook);

        // Обновляем книгу
        Book updatedBook = new Book("1", "UpdateBook", "UpdateAuthor");

        // Добавляем обновлённую книгу в репозиторий
        bookService.update(updatedBook);

        // Проверяем, что метод был вызван с правильными параметрами
        verify(mockBookRepository).update(updatedBook);

        // Перенастраиваем поведение мока после обновления. Ондолжен возвращать обновлённую книгу
        when(mockBookRepository.findById("1")).thenReturn(updatedBook);

        // Проверяем, что после обновления название книги изменилось на ожидаемое
        assertEquals("UpdateBook", bookService.findBookById("1").getTitle());
    }

    // Тестируем метод update для книги с несуществующим id
    @Test
    void testUpdateWithNonExistingIdThrowsException() {
        // Создаем книгу, которую хотим обновить, но она не существует в репозитории
        Book nonExistingBook = new Book("999", "NonExistingBook", "Author");

        // Настраиваем поведение мока: книга не найдена
        when(mockBookRepository.findById("999")).thenReturn(null);

        // Проверяем, что при попытке обновления несуществующей книги выбрасывается исключение
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            bookService.update(nonExistingBook);
        });

        assertEquals("Книга с ID 999 не найдена для обновления.", exception.getMessage());
    }
        // Тестируем метод FindByTitle, поиск книги по несуществующему названию
    @Test
    void testFindByTitleThrowsExceptionWhenNotFound() {
        // Создаём несуществующее название
        String title = "NonExistingBook";

        // Настраиваем поведение мока. должен возвращать null
        when(mockBookRepository.findByTitle(title)).thenReturn(null);

        //  Проверяем выбрасывание исключения, если книга с заданным названием не найдена.
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            bookService.findByTitle(title);
        });

        // проверяем полученное сообщение
        assertEquals("Книга с названием " + title + " не найдена.", exception.getMessage());
    }

    // Проверяем метод FindByTitle с правильными параметрами
    @Test
    void  testFindByTitleReturnsBookWhenFound() {
        // Создаем существующее название
        String title = "Book1";

        // Создаём книгу с существующим названием
        Book book = new Book("1", title, "Author1");

        // Настраиваем поведение мока. Возвращает книгу с переданным названием
        when(mockBookRepository.findByTitle(title)).thenReturn(book);

        // Запуск метода findByTitle
        Book foundBook = bookService.findByTitle(title);

        // Проверяем результат
        assertEquals(book, foundBook);

    }

}

