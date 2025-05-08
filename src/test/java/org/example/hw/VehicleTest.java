package org.example.hw;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
public class VehicleTest {
    private Car car;
    private Motorcycle motorcycle;

    @BeforeEach
    void setup() {
         car = new Car("Toyota", "Camry", 2020);
         motorcycle = new Motorcycle("Harley-Davidson", "Sportster", 2022);
    }
    // проверка того, что экземпляр объекта Car также является экземпляром транспортного средства;
    @Test
    void verifyingThatCarIsVehicle() {

        assertTrue(car instanceof Vehicle, "Объект car должен быть экземпляром Vehicle");

    }
    //  проверка того, объект Car создается с 4-мя колесами
    @Test
    void checkingCarCreatedWith4Wheels() {
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    // проверка того, объект Motorcycle создается с 2-мя колесами
    @Test
    void checkingMotorcycleCreatedWith2Wheels() {
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    // проверка того, объект Car развивает скорость 60 в режиме тестового вождения (testDrive())
    @Test
    void checkingCarReachesSpeed60TestDriving() {
        // Act (Выполнение)
        car.testDrive();
        // Assert
        assertThat(car.getSpeed()).isEqualTo(60);
    }

    // проверка того, объект Motorcycle развивает скорость 75 в режиме тестового вождения (testDrive())
    @Test
    void checkingMotorcycleReachingSpeed75TesDriving() {
        // Act (Выполнение)
        motorcycle.testDrive();
        // Assert
        assertThat(motorcycle.getSpeed()).isEqualTo(75);

    }
    //проверить, что в режиме парковки (сначала testDrive, потом park, т.е эмуляция движения транспорта) машина останавливается (speed = 0)
    @Test
    void checkCarStopsInParkingMode() {
        // Act (Выполнение)
        car.testDrive();
        car.park();
        // Assert
        assertThat(car.getSpeed()).isEqualTo(0);
    }

    // проверить, что в режиме парковки (сначала testDrive, потом park  т.е эмуляция движения транспорта) мотоцикл останавливается (speed = 0)
    @Test
    void checkMotorcycleStopsInParkingMode() {
        // Act (Выполнение)
        motorcycle.testDrive();
        motorcycle.park();
        // Assert
        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }
}
