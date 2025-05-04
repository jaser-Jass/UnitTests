package org.example.calculator;

public final class Calculator {

    public static double calculation(double a, double b, char operation) throws ArithmeticException {
        switch(operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if(b == 0){
                    throw new ArithmeticException("Деление на ноль недопустимо!");
                }
                return a / b;
            default:
                throw new IllegalArgumentException("Неверный символ операции: " + operation);
        }
    }

    public static double squareRootExtraction(double number) {
        if(number < 0){
            throw new IllegalArgumentException("Квадратный корень из отрицательного числа невозможен!");
        }
        return Math.sqrt(number);
    }
    public static double calculatingDiscount(double amount, int discountPercent) {
        if(discountPercent < 0 || discountPercent > 100) {
            throw new IllegalStateException("Скидка должна быть в пределах от 0 до 100 процентов.");
        }
        return amount * (1 - discountPercent / 100.0);
    }
}
