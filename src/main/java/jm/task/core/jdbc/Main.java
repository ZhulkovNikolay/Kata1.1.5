package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

// UserHibernateDaoImpl должен реализовывать интерефейс UserDao
// В класс Util должна быть добавлена конфигурация для Hibernate (рядом с JDBC), без использования xml.
// Service на этот раз использует реализацию dao через Hibernate
// Методы создания и удаления таблицы пользователей в классе UserHibernateDaoImpl должны быть реализованы с помощью SQL.
public class Main {
    //-----------------
    //Если начать запускать методы из test.java.UserServiceTest, то он выдает сообщения, прописаные в Assert.fail("...").
    //Ругался на отсутствие значения ID по умолчанию
    //При этом если сперва запустить метод Main (отработает без ошибок), а после начать запускать тесты, то ошибок не будет.
    //В процессе "танцев с бубном" я добавил анотации в model.User. Я не уверен, действительно ли нужны они там?
    //-----------------
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
