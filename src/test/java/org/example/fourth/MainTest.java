package org.example.fourth;
import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


class MainTest {

    /**
     * 4.0. Проверка работы Mockito
     */
    @Test
    public void simpleTest() {
        // Создаем мок
        List<String> mockedList = mock(List.class);

        // Используем мок
        mockedList.add("one");
        mockedList.clear();

        // Проверяем, что методы были вызваны
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    /**
     * 4.1. Создать мок-объект Iterator, настроить поведение так, чтобы за два вызова next() Iterator
     * вернул два слова “Hello World”, и проверить это поведение с помощью утверждений
     */
    @Test
    public void iteratorWillReturnHelloWorld() {
        // Arrange
        Iterator iteratorMock = mock(Iterator.class);
        when(iteratorMock.next()).thenReturn("Hello").thenReturn("World");
        // Act
        String result = iteratorMock.next() + " " + iteratorMock.next();
        // Assert
        assertEquals("Hello World", result);

    }

    /**
     * 4.2. Используя библиотеку Mockito, напишите модульные тесты для проверки функциональности формы
     * оплаты на сайте. Вместо реальной кредитной карты используйте мок-объект.
     */



}