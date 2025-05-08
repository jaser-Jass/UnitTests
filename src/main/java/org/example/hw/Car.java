package org.example.hw;

public class Car extends Vehicle {
    private String company;
    private String model;
    private int yearRelease;
    private int numWheels;
    private int speed;

    public Car(String company, String model, int year) {
        this.company = company;
        this.model = model;
        this.yearRelease = year;
        this.numWheels = 4; // Cars usually have 4 wheels
        this.speed = 0;     // Initial speed set to 0
    }

    public void testDrive() { this.speed = 60; }
    public void park() { this.speed = 0; }

    public String getCompany() { return company; }
    public String getModel() { return model; }
    public int getYearRelease() { return yearRelease; }
    public int getNumWheels() { return numWheels; }
    public int getSpeed() { return speed; }

    @Override
    public String toString() {
        return "This car is a " + yearRelease + " " + company + " " + model; // Corrected this line
    }
}
