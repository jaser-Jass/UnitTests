package org.example.fourth.card;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class PaymentFormTest {
    /**
     * 4.2. Используя библиотеку Mockito, напишите модульные тесты для проверки функциональности формы оплаты на сайте.
     * * Вместо реальной кредитной карты используйте мок-объект.
     * Создайте класс `CreditCard` с методами `getCardNumber()`, `getCardHolder()`, `getExpiryDate()`, `getCvv()`, `charge(double amount)`.
     * Создайте класс `PaymentForm` с методом `pay(double amount)`.
     * В тестовом классе, создайте мок-объект для класса `CreditCard`.
     * Определите поведение мок-объекта с помощью метода `when()`.
     * Создайте объект класса `PaymentForm`, передайте ему мок-объект в качестве аргумента.
     * Вызовите метод `pay()` и убедитесь, что мок-объект вызывает метод `charge()`
     */
    @Test
    public void testPaymentForm() {
        // Создание мок-объекта для класса CreditCard
        CreditCard mockCreditCard = mock(CreditCard.class);

        // Определение поведения мок-объекта
        when(mockCreditCard.getCardNumber()).thenReturn("1234567812345678");
        when(mockCreditCard.getCardHolder()).thenReturn("Test User");
        when(mockCreditCard.getExpiryDate()).thenReturn("01/23");
        when(mockCreditCard.getCvv()).thenReturn("123");

        // Создание объекта класса PaymentForm, передача ему мок-объекта в качестве аргумента
        PaymentForm paymentForm = new PaymentForm(mockCreditCard);

        // Вызов метода pay() и проверка, что мок-объект вызывает метод charge()
        paymentForm.pay(100);

        // Проверка, что метод charge() был вызван
        verify(mockCreditCard, times(1)).charge(100);
    }
}
