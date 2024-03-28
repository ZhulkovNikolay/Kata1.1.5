package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl extends Util implements UserDao {
    private Connection connection = null;

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() throws SQLException {
        connection = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "CREATE TABLE IF NOT EXISTS usersdb.users (ID integer PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(65), LASTNAME VARCHAR(65), AGE integer)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            closeConnection();
        }

    }

    public void dropUsersTable() throws SQLException {
        connection = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DROP TABLE IF EXISTS `users`";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            closeConnection();
        }
    }

    public void saveUser(String name, String lastName, byte age) throws SQLException {
        connection = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO users (name, lastname, age) VALUES(?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            closeConnection();
        }
    }

    public void removeUserById(long id) throws SQLException {
        connection = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM users WHERE ID =?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            closeConnection();
        }

    }

    public List<User> getAllUsers() throws SQLException {
        connection = getConnection();
        List<User> userList = new ArrayList<>();
        String sql = "SELECT id, name, lastname, age FROM users";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setAge(resultSet.getByte("age"));
                userList.add(user);
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            statement.close();
            closeConnection();
        }

        return userList;
    }

    public void cleanUsersTable() throws SQLException {
        connection = getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM users";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            closeConnection();
        }
    }
}
