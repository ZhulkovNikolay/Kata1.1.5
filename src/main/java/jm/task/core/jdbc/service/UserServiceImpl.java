package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    //private UserDao userDaoJDBC = new UserDaoJDBCImpl();
    private UserDao userDaoHibernate = new UserDaoHibernateImpl();

    public void createUsersTable() {
        try {
            //userDaoJDBC.createUsersTable();
            userDaoHibernate.createUsersTable();
        } catch (SQLException e) {
            System.err.println("Не удалось создать Базу Данных");
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try {
            //userDaoJDBC.dropUsersTable();
            userDaoHibernate.dropUsersTable();
        } catch (SQLException e) {
            System.err.println("Не удалось удалить таблицу");
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            //userDaoJDBC.saveUser(name, lastName, age);
            userDaoHibernate.saveUser(name, lastName, age);
        } catch (SQLException e) {
            System.err.println("Не удалось создать User");
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try {
            //userDaoJDBC.removeUserById(id);
            userDaoHibernate.removeUserById(id);
        } catch (SQLException e) {
            System.err.println("Не удалось удалить User");
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = null;
        try {
            //userList = userDaoJDBC.getAllUsers();
            userList = userDaoHibernate.getAllUsers();
        } catch (SQLException e) {
            System.err.println("Не удалось получить userList");
            e.printStackTrace();
        }
        return userList;
    }

    public void cleanUsersTable() {
        try {
            //userDaoJDBC.cleanUsersTable();
            userDaoHibernate.cleanUsersTable();
        } catch (SQLException e) {
            System.err.println("Не удалось очистить таблицу");
            e.printStackTrace();
        }
    }
}
