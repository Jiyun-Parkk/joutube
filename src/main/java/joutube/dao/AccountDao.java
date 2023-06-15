package main.java.joutube.dao;

import main.java.joutube.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDao {

    public void createAccount(String name, String profile_image, String email, String password) {
        String createAccountSQL = "insert into account (name,profile_image,email,password) " +
                "values (?, ?, ?, ?)";
        try (
                Connection connection = DBUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(createAccountSQL);

        ) {
            statement.setString(1, name);
            statement.setString(2, profile_image);
            statement.setString(3, email);
            statement.setString(4, password);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int deleteAccount(int id) {
        int affectedRow = 0;
        String deleteAccountSQL = "delete from joutube where id = ?";
        try (
                Connection connection = DBUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(deleteAccountSQL);

        ) {
            statement.setInt(1, id);
            affectedRow = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRow;
    }
}


