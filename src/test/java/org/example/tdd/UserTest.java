package org.example.tdd;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
// 3.6.   Разработайте класс User с методом аутентификации по логину и паролю. Метод должен возвращать true, если
//    введенные логин и пароль корректны, иначе false. Протестируйте все методы

    @Test
    void  userCreation() {
        User user = new User("user_0", "psw123", false);
        assertTrue(user.authenticate("user_0", "psw123"));

    }

    @Test
    void userCreationFailed() {
        User user = new User("user_0", "123psw", false);
        assertFalse(user.authenticate("user_0", "psw123"));
    }
// 3.7. Добавьте класс UserRepository для управления пользователями. В этот класс должен быть включен метод
//addUser, который добавляет пользователя в систему, если он прошел аутентификацию. Покройте тестами новую
//функциональность

    @Test
    void userRepository() {
        UserRepository userRepository = new UserRepository();
        User userNA = new User("user_0", "psw123", false);
        userRepository.addUser(userNA);
        assertFalse(userRepository.findByName(userNA.name));
    }

    @Test
    void userRepositoryNA() {
        UserRepository userRepository = new UserRepository();
        User userNA = new User("user_0", "psw123", false);
        userNA.authenticate("user_0", "psw23");
        userRepository.addUser(userNA);
        assertFalse(userRepository.findByName(userNA.name));
    }
}
