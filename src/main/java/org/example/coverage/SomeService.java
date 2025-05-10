package org.example.coverage;

public class SomeService {

    /**
     * 3.1. Метод возвращает Fizz для чисел кратных 3, Buzz для кратных 5, и FizzBuzz для кратных 3 и 5 одновременно
     */
    public String fizzBuzz(int i) {
        if (i % 15 == 0) {
            return "FizzBuzz";
        } else if (i % 3 == 0) {
            return "Fizz";
        } else if (i % 5 == 0) {
            return "Buzz";
        } else {
            return "" + i;
        }
    }

    /**
     * 3.2. Метод firstLast6, где на вход подается массив чисел, а метод
     * возвращает true, если первое или последнее число в массиве равно 6, иначе false.
     */

    public boolean firstLast6(int[] nums) {
        if (nums[0] == 6) {
            return true;
        } else if (nums[nums.length - 1] == 6) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 3.3. метод calculatingDiscount, который принимает сумму
     * покупки и размер скидки, затем вычисляет и возвращает сумму с учетом скидки. Метод должен обрабатывать
     * исключения, связанные с некорректным размером скидки или отрицательной суммой покупки.
     */

    public double calculatingDiscount(double purchaseAmount, int discountAmount) {
        // purchaseAmount - сумма покупки
        // discountAmount - размер скидки
        double discountedAmount = 0; // Сумма со скидкой (первоначальная сумма - скидка %)
        if (purchaseAmount >= 0) {
            if (discountAmount >= 0 && discountAmount <= 100) {
                discountedAmount = purchaseAmount - (purchaseAmount * discountAmount) / 100;
            } else {
                throw new ArithmeticException("Скидка должна быть от 0 до 100%");
            }
        } else {
            // Сумма покупки не может быть отрицательной
            throw new ArithmeticException("Сумма покупки не может быть отрицательной");
        }
        return discountedAmount; // Метод должен возвращать сумму покупки со скидкой
    }


    /**
     * 3.4. метод luckySum. Этот метод принимает на вход три числа и возвращает
     * их сумму. Однако, если одно из чисел равно 13, то оно не учитывается при подсчете суммы.
     */

    public int luckySum(int a, int b, int c) {
        int sum = 0;

        if (a != 13) {
            sum += a;
        }
        if (b != 13) {
            sum += b;
        }
        if (c != 13) {
            sum += c;
        }
        return sum;
    }

    /**
     * Домашнее задание
     * Задание 0. Доделать задания с семинара
     * Задание 1. Напишите тесты, покрывающие на 100% метод evenOddNumber, который проверяет, является ли
     * переданное число четным или нечетным:
     */
    public boolean evenOddNumber(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Домашнее задание
     * Задание 2. Разработайте и протестируйте метод numberInInterval, который проверяет, попадает ли
     * переданное число в интервал (25;100):
     */

    public boolean numberInInterval(int n) {
        return n > 25 && n < 100;
    }
}
