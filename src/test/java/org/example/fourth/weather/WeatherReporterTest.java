package org.example.fourth.weather;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
public class WeatherReporterTest {
    @Test
    public void  testWeatherReporter() {
        // Создаём мок для WeatherService
        WeatherService mockWeatherService = mock(WeatherService.class);

        // Определяем поведение мока. Когда метод getCurrentTemperature() будет вызван, он вернёт 30
        when(mockWeatherService.getCurrentTemperature()).thenReturn(30);

        // Создаём объект класса WeatherReporter,  передаём ему в конструктор наш мок
        WeatherReporter weatherReporter = new WeatherReporter(mockWeatherService);

        // Вызываем метод generateReport()
        String report = weatherReporter.generateReport();

        // Проверяем, что отчёт содержит ожидаемую информацию о температуре
        assertEquals("Текущая температура: 30 градусов.", report);

    }

}
