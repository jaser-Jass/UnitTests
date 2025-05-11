package org.example.fourth.hotel;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
public class BookingServiceTest {
    @Test
    public void testBookingService() {
        // Создание мока
        HotelService mockHotelService = mock(HotelService.class);

        // Определяем поведение мока
        when(mockHotelService.isRoomAvailable(anyInt())).thenAnswer(i -> (Integer) i.getArgument(0) % 2 ==0);

        // Создание экземпляра тестируемого класса с подставленным моком
        BookingService bookingService = new BookingService(mockHotelService);

        // Проверка метода bookRoom() с номером комнаты, который является доступным (четным)
        assertTrue(bookingService.bookRoom(2));

        // Проверка метода bookRoom() с номером комнаты, который является недоступным (нечетным)
        assertFalse(bookingService.bookRoom(3));

        // Проверка, что метод isRoomAvailable() вызывается два раза
        verify(mockHotelService, times(2)).isRoomAvailable(anyInt());
    }
}
