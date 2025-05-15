package org.example.five.number;

import java.util.Random;

public class RandomNumberModule {
    public int[] generateRandomNumbers(int arraySize) {
        Random random = new Random();
        int[] numbers = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            numbers[i] = random.nextInt(100);
        }
        return numbers;
    }
}
