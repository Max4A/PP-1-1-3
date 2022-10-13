package jm.task.core.jdbc;


import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    private final static UserService userService = new UserServiceImpl();
    public static void main(String[] args) {


        // реализуйте алгоритм здесь
        // 1. Создание таблицы User(ов)
        userService.createUsersTable();

        // 2. Добавление 4 User(ов) в таблицу с данными на свой выбор.
        userService.saveUser("John", "Silver", (byte) 44);
        userService.saveUser("Billy", "Bones", (byte) 52);
        userService.saveUser("Cap", "Smollett", (byte) 38);
        userService.saveUser("Jim", "Howkince", (byte) 16);

        // 3. Получение всех User из базы и вывод в консоль
        userService.getAllUsers();

        // Удаление записи с id = 2
        userService.removeUserById(2L);

        // 4. Очистка таблицы User(ов)
        userService.cleanUsersTable();

        // 5. Удаление таблицы
        userService.dropUsersTable();
    }
}
