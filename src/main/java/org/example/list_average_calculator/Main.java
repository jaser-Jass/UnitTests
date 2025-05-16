package org.example.list_average_calculator;

import java.util.ArrayList;
import java.util.List;


/**
 * Задание 1. Создайте программу на Python или Java, которая принимает два списка чисел и выполняет следующие действия:
 * a. Рассчитывает среднее значение каждого списка.
 * b. Сравнивает эти средние значения и выводит соответствующее сообщение:
 * - ""Первый список имеет большее среднее значение"", если среднее значение первого списка больше.
 * - ""Второй список имеет большее среднее значение"", если среднее значение второго списка больше.
 * - ""Средние значения равны"", если средние значения списков равны.
 */
public class Main {
    public static void main(String[] args) {
        ListAverageCalculator listAverageCalculator = new ListAverageCalculator();
        List<Integer> firstList = new ArrayList<>();
        firstList.add(1);
        firstList.add(2);
        firstList.add(3);

        List<Integer> secondList = new ArrayList<>();
        secondList.add(5);
        secondList.add(6);
        secondList.add(7);

        List<Integer> thirdList = new ArrayList<>();

        System.out.println(listAverageCalculator.compareAvarages(firstList, secondList));

        //System.out.println(listAverageCalculator.compareAvarages(firstList, thirdList));
       // System.out.println(listAverageCalculator.calculateAvarage(null));
    }
}
