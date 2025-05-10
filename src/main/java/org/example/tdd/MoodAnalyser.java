package org.example.tdd;

public class MoodAnalyser {
    // SAD Message -> Грустное
    // HAPPY Message -> Веселое

    public String analyseMood(String message) {
        if (message.contains("грустное")) {
            return "SAD";
        } else {
            return "HAPPY";
        }
    }
}
