package main.java.joutube.dao;

import main.java.joutube.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChannelDao {

    public void createChannel(int id) {
        String createChannelSQL = "insert into channel (account_id) values (?)";
        try (
                Connection connection = DBUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(createChannelSQL);
        ) {
            statement.setInt(1, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
