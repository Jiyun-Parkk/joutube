package main.java.joutube.dao;

import main.java.joutube.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VideoDao {

    public void uploadVideo(int owner, String title, String thumbnailImage, int videoLength) {
        String createVideoSQL = "insert into video (owner,title,thumbnail_image,video_length) " +
                "values (?, ?, ?, ?)";
        try (
                Connection connection = DBUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(createVideoSQL);

        ) {
            statement.setInt(1, owner);
            statement.setString(2, title);
            statement.setString(3, thumbnailImage);
            statement.setInt(4, videoLength);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
