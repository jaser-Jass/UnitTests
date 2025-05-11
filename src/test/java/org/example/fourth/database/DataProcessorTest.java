package org.example.fourth.database;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class DataProcessorTest {
    @Test
    public void testProcessData() {
        // Создаём мок для Database
        Database database = mock(Database.class);

        // Настраиваем его поведение
        when(database.query(anyString())).thenReturn(Arrays.asList("First", "Second", "Third"));

        // Создаём объект класса, который мй хотим протестировать, передавая мок в качестве зависимости
        DataProcessor dataProcessor = new DataProcessor(database);

        // Вызываем метод, который хотим протестировать
        List<String> resultSize = dataProcessor.processData("SELECT * FROM table");

        // Проверяем результат
        assertEquals(3, resultSize.size());
    }
}
