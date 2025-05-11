package org.example.fourth.message;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
public class NotificationServiceTest {
    @Test
    public void testNotify() {
        // Создаём мок
        MessageService messageService = mock(MessageService.class);

        // Создаём объект класса, который мы хотим протестировать, передавая мок в качестве зависимости
        NotificationService notificationService = new NotificationService(messageService);

        // Вызываем метод, который хотим протестировать
        notificationService.sendNotification("Привет!", "Анна");
        // Проверяем, был ли вызван метод sendMessage с правильными аргументами
        verify(messageService, times(1)).sendMessage("Привет!", "Анна");
    }

}
