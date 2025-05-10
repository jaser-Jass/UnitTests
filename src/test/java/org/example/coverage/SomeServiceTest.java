package org.example.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;



public class SomeServiceTest {
    private  SomeService someService;

    @BeforeEach
    void setUp() { someService = new SomeService(); }
    // 3.1
    @ParameterizedTest
    @ValueSource(ints = {3, 6, 9, 33})
    void  multipleThreeNotFiveReturnsFizz(int n) { assertEquals("Fizz", someService.fizzBuzz(n)); }

    @ParameterizedTest
    @ValueSource(ints = {5, 10, 20, 55})
    void multipleFiveNotTreeReturnBuzz(int n) { assertEquals("Buzz", someService.fizzBuzz(n)); }

    @ParameterizedTest
    @ValueSource(ints = {15, 225, 3375})
    void multipleThreeAndFiveFizzBuzz(int n) { assertEquals("FizzBuzz", someService.fizzBuzz(n)); }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 41, 43})
    void notMultipleOfThreeOfFiveReturnsNumber(int n) { assertEquals(Integer.toString(n), someService.fizzBuzz(n)); }

    // 3.2
    @Test
    void first6arrayShouldReturnTrue() { assertTrue(someService.firstLast6(new int[]{6, 3, 5, 3})); }

    @Test
    void last6arrayShouldReturnTrue() { assertTrue(someService.firstLast6(new int[]{2, 345, 6})); }

    @Test
    void noLast6arrayShouldReturnFalse() {assertFalse(someService.firstLast6(new int[]{2, 345, 2})); }

    // 3.3
    // Недостаточное покрытие
    @Test
    void insufficientCoverageTest() {
        System.out.println(someService.calculatingDiscount(2000, 10));
        assertThat(someService.calculatingDiscount(2000, 50)).isEqualTo(1000); // обычная скидка
        assertThat(someService.calculatingDiscount(2000,100)).isEqualTo(0); //  обычная скидка
        assertThat(someService.calculatingDiscount(2000,0)).isEqualTo(2000); //  обычная скидка

        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000, 110))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть от 0 до 100%"); // Процент скидки больше 100

        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть от 0 до 100%"); // Процент скидки меньше 0

        assertThatThrownBy(() ->
                someService.calculatingDiscount(-2000, 10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Сумма покупки не может быть отрицательной");
    }

    // 3.4

    @Test
    void luckySumReturnSumWithout13() {
        assertThat(someService.luckySum(2, 3, 13)).isEqualTo(5);
        assertThat(someService.luckySum(2, 13, 9)).isEqualTo(11);
        assertThat(someService.luckySum(13, 9, 9)).isEqualTo(18);
        assertThat(someService.luckySum(9, 9, 9)).isEqualTo(27);
        assertThat(someService.luckySum(13, 13, 13)).isEqualTo(0);
    }

    // 3.7.  Напишите тесты, покрывающие на 100% метод evenOddNumber, который проверяет, является ли
    //переданное число четным или нечетным:

    @Test
    void testEvenNumber() {
        assertTrue(someService.evenOddNumber(4));
        assertTrue(someService.evenOddNumber(0));
        assertTrue(someService.evenOddNumber(-2));

    }
    @Test
    void testOddNumber() {
        assertFalse(someService.evenOddNumber(3));
        assertFalse(someService.evenOddNumber(-1));
        assertFalse(someService.evenOddNumber(99));
    }

    // Разработайте и протестируйте метод numberInInterval, который проверяет, попадает ли
    //переданное число в интервал (25;100)

    @Test
    void numberInIntervalTest() {
        assertTrue(someService.numberInInterval(26));
        assertTrue(someService.numberInInterval(50));
        assertTrue(someService.numberInInterval(99));
    }
    @Test
    void numberNotInIntervalTest() {
        assertFalse(someService.numberInInterval(25));
        assertFalse(someService.numberInInterval(24));
        assertFalse(someService.numberInInterval(100));
        assertFalse(someService.numberInInterval(101));
        assertFalse(someService.numberInInterval(0));
        assertFalse(someService.numberInInterval(-10));
    }

}
