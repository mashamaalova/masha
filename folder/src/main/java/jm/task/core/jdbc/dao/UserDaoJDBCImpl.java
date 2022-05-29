package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private static Statement statement;

    public UserDaoJDBCImpl() {
        try {
            statement = Util.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createUsersTable() {
        try {
            statement.execute("create table users (\n" +
                    "id BIGINT AUTO_INCREMENT PRIMARY KEY,\n" +
                    "name varchar(100) NOT NULL,\n" +
                    "lastname varchar(100) NOT NULL,\n" +
                    "age TINYINT NOT NULL\n" +
                    ");");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Не удалось создать таблицу!");
        }
    }

    public void dropUsersTable() {
        try {
            statement.execute("DROP TABLE IF EXISTS users;");
        } catch (SQLException e) {
            System.out.println("Не удалось удалить таблицу!");
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            statement.execute("INSERT INTO users (name, lastname, age) VALUES ('" + name + "', '" + lastName + "', '" + age + "');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try {
            statement.execute("DELETE FROM users where id=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        ResultSet resultSet = null;
        List<User> listUsers = new ArrayList<>();
        try {
            resultSet = statement.executeQuery("SELECT * FROM mydbtest.users;");
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastname"));
                user.setAge(resultSet.getByte("age"));
                listUsers.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listUsers;
    }

    public void cleanUsersTable() {
        try {
            statement.execute("DELETE from users");
        } catch (SQLException e) {
            System.out.println("Не удалось очистить тамблицу1");
        }
    }
}
