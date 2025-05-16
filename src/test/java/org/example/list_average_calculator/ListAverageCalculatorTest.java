package org.example.list_average_calculator;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * ТЕСТИРУЕМ:
 * - Граничные случаи (один элемент, нули, большие числа)
 * - Разнообразные данные (отрицательные, положительные числа)
 * - Проверку обработки null
 * - Проверку переполнения int
 */
public class ListAverageCalculatorTest {

    private final ListAverageCalculator listAverageCalculator = new ListAverageCalculator();

    // Тестируем метод вычисления среднего значения
    @Test
    void testCalculateAverage() {
        // Обычный случай
        assertEquals(listAverageCalculator.calculateAvarage(Arrays.asList(1, 2, 3)), 2.0);

        // Пустой список
        assertTrue(Double.isNaN(listAverageCalculator.calculateAvarage(Collections.emptyList())));

        // Список с одним значением
        assertEquals(listAverageCalculator.calculateAvarage(Arrays.asList(3)), 3.0);

        // Проверка того, что метод calculateAvarage корректно считает среднее с отрицательными числами
        assertEquals(-2.5, listAverageCalculator.calculateAvarage(Arrays.asList(-1, -2, -4)), 0.0001);

    }

    // Тестируем метод, сравнивающий средние значения двух списков
    @Test
    void testCompareAverages() {
        // Среднее значение первого списка больше
        assertEquals("Первый список имеет большее среднее значение",
                listAverageCalculator.compareAvarages(Arrays.asList(1, 2, 3), Arrays.asList(-1, -2, -3)));

        // Среднее значение второго списка больше
        assertEquals("Второй список имеет большее среднее значение",
                listAverageCalculator.compareAvarages(Arrays.asList(-1, -2, -3), Arrays.asList(1, 2, 3)));

        // Средние значения обоих списков равны
        assertEquals("Средние значения равны",
                listAverageCalculator.compareAvarages(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3)));

        // Первый список пустой
        assertEquals("Первый список пуст или не содержит элементов",
                listAverageCalculator.compareAvarages(Arrays.asList(), Arrays.asList(1, 2, 3)));

        // Второй список пустой
        assertEquals("Второй список пуст или не содержит элементов",
                listAverageCalculator.compareAvarages(Arrays.asList(1, 2, 3), Arrays.asList()));

        // Оба списка пусты
        assertEquals("Оба списка пусты или не содержат элементов",
                listAverageCalculator.compareAvarages(Arrays.asList(), Arrays.asList()));

        // Первый список с одним элементом больше, чем во втором списке
        assertEquals("Первый список имеет большее среднее значение",
                listAverageCalculator.compareAvarages(Arrays.asList(10), Arrays.asList(5)));

        // Средние значения равны (по одному элементу, равному)
        assertEquals("Средние значения равны",
                listAverageCalculator.compareAvarages(Arrays.asList(7), Arrays.asList(7)));

        // Первый список содержит нули, второ — нет
        assertEquals("Второй список имеет большее среднее значение",
                listAverageCalculator.compareAvarages(Arrays.asList(0, 0, 0), Arrays.asList(1, 2, 3)));

       // Оба списка содержат нули
        assertEquals("Средние значения равны",
                listAverageCalculator.compareAvarages(Arrays.asList(0, 0), Arrays.asList(0, 0, 0)));

        // Используем большие Int числа
        assertEquals("Первый список имеет большее среднее значение",
                listAverageCalculator.compareAvarages(Arrays.asList(Integer.MAX_VALUE, Integer.MAX_VALUE),
                        Arrays.asList(Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 1)));

        // Первый список отрицательный, второй положительный
        assertEquals("Второй список имеет большее среднее значение",
                listAverageCalculator.compareAvarages(Arrays.asList(-10, -20), Arrays.asList(10, 20)));

// Оба списки одинаковы, содержащие отрицательные значения
        assertEquals("Средние значения равны",
                listAverageCalculator.compareAvarages(Arrays.asList(-5, -5), Arrays.asList(-5, -5)));

    }

    // Вместо значения предаётся null. Программа выбрасываеn NullPointerException
    @Test
    void testCalculateAverageWithNull() {
        assertThrows(NullPointerException.class, () -> listAverageCalculator.calculateAvarage(null));
    }

    @Test
    void testCompareAveragesWithNull() {
        assertThrows(NullPointerException.class, () -> listAverageCalculator.compareAvarages(null, Arrays.asList(1, 2, 3)));
        assertThrows(NullPointerException.class, () -> listAverageCalculator.compareAvarages(Arrays.asList(1, 2, 3), null));
    }

}
