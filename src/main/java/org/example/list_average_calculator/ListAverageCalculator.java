package org.example.list_average_calculator;


import java.util.List;


public class ListAverageCalculator {

    // Рассчитывает среднее значение каждого списка.
    public double calculateAvarage(List<Integer> numbers) {
        if (numbers.isEmpty()) return Double.NaN;

        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return (double) sum / numbers.size();
    }


    // Сравнивает эти средние значения
    public String compareAvarages(List<Integer> firstList, List<Integer> secondList) {
        double avgFirst = calculateAvarage(firstList);
        double avgSecond = calculateAvarage(secondList);

        boolean firstNaN = Double.isNaN(avgFirst);
        boolean secondNaN = Double.isNaN(avgSecond);

        if (firstNaN && secondNaN) {
            return "Оба списка пусты или не содержат элементов";
        } else if (firstNaN) {
            return "Первый список пуст или не содержит элементов";
        } else if (secondNaN) {
            return "Второй список пуст или не содержит элементов";
        } else {
            int cmp = Double.compare(avgFirst, avgSecond);
            if (cmp > 0) {
                return "Первый список имеет большее среднее значение";
            } else if (cmp < 0) {
                return "Второй список имеет большее среднее значение";
            } else {
                return "Средние значения равны";
            }
        }
    }
}
