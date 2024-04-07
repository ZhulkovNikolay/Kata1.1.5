package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

// UserHibernateDaoImpl должен реализовывать интерефейс UserDao
// В класс Util должна быть добавлена конфигурация для Hibernate (рядом с JDBC), без использования xml.
// Service на этот раз использует реализацию dao через Hibernate
// Методы создания и удаления таблицы пользователей в классе UserHibernateDaoImpl должны быть реализованы с помощью SQL
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
