package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

//В методе main класса Main должны происходить следующие операции:
// Создание таблицы User(ов)
// Добавление 4 User(ов) в таблицу с данными на свой выбор. После каждого добавления должен быть вывод в консоль (User с именем — name добавлен в базу данных)
// Получение всех User из базы и вывод в консоль (должен быть переопределен toString в классе User)
// Очистка таблицы User(ов)
// Удаление таблицы
public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Albus", "Dumbledore", (byte) 99);
        userService.saveUser("Severus", "Snape", (byte) 54);
        userService.saveUser("Ronald", "Weasley", (byte) 30);
        userService.saveUser("Neville", "Longbottom", (byte) 22);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
