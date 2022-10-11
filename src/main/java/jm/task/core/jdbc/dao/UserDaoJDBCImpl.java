package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private static final Connection connection = Util.getConnection();

    private static final String CREATE_USERS_TABLE = "CREATE TABLE IF NOT EXISTS `pp113db`.`users` (\n" +
            "                                               `id` BIGINT NOT NULL AUTO_INCREMENT,\n" +
            "                                               `username` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_general_ci' NOT NULL,\n" +
            "                                               `lastname` VARCHAR(45) CHARACTER SET 'utf8' COLLATE 'utf8_general_ci' NOT NULL,\n" +
            "                                               `age` INT NOT NULL,\n" +
            "                                               PRIMARY KEY (`id`))\n" +
            "                        ENGINE = InnoDB\n" +
            "                        DEFAULT CHARACTER SET = utf8;";
    private static final String DROP_USERS_TABLE = "DROP TABLE IF EXISTS `pp113db`.`users`";
    private static final String SAVE_USER = "INSERT INTO users (username, lastname, age) VALUES (?, ?, ?)";
    private static final String REMOVE_USER_BY_ID = "DELETE FROM users WHERE id = ?";
    private static final String GET_ALL_USERS = "SELECT * FROM users";
    private static final String CLEAN_USERS_TABLE = "DELETE FROM users";

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        try (PreparedStatement pstm = connection.prepareStatement(CREATE_USERS_TABLE)) {
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (PreparedStatement pstm = connection.prepareStatement(DROP_USERS_TABLE)) {
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement pstm = connection.prepareStatement(SAVE_USER)) {
            pstm.setString(1, name);
            pstm.setString(2, lastName);
            pstm.setByte(3, age);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (PreparedStatement pstm = connection.prepareStatement(REMOVE_USER_BY_ID)) {
            pstm.setLong(1, id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try (PreparedStatement pstm = connection.prepareStatement(GET_ALL_USERS)) {
            ResultSet resultSet = pstm.executeQuery();
            while (resultSet.next()) {
                User user = new User(resultSet.getString("username"),
                        resultSet.getString("lastname"), resultSet.getByte("age"));
                user.setId(resultSet.getLong("id"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public void cleanUsersTable() {
        try (PreparedStatement pstm = connection.prepareStatement(CLEAN_USERS_TABLE)) {
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
