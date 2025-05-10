package org.example.tdd;
import org.example.tdd.User;
import org.example.tdd.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class UserRepositoryTest {

    private UserRepository repo;
    private User adminUser;
    private User normalUser1;
    private User normalUser2;

    @BeforeEach
    void setup() {
        repo = new UserRepository();

        adminUser = new User("admin", "adminpass", true);
        normalUser1 = new User("user1", "pass1", false);
        normalUser2 = new User("user2", "pass2", false);

        // Аутентифицируем всех:
        adminUser.authenticate("admin", "adminpass");
        normalUser1.authenticate("user1", "pass1");
        normalUser2.authenticate("user2", "pass2");

        // Добавляем всех в репозиторий
        repo.addUser(adminUser);
        repo.addUser(normalUser1);
        repo.addUser(normalUser2);
    }

    @Test
    void testLogoutAllExceptAdmins() {
        repo.logoutAllExceptAdmins();

        // Админ должен оставаться залогинен
        assertTrue(adminUser.isAuthenticate, "Админ должен оставаться залогинен");

        // Остальные пользователи должны быть разлогинены
        assertFalse(normalUser1.isAuthenticate, "Пользователь user1 должен быть разлогинен");
        assertFalse(normalUser2.isAuthenticate, "Пользователь user2 должен быть разлогинен");
    }
}
