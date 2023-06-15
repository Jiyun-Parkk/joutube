package main.java.joutube.dao;

import main.java.joutube.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VideoDao {

    public void uploadVideo(int owner, String title, String thumbnailImage, int videoLength) {
        ChannelDao channelDao = new ChannelDao();
        String createVideoSQL = "insert into video (channel_id,title,thumbnail_image,video_length) " +
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

            int totalCount = getVideoCount(owner);
            channelDao.updateChannel(totalCount, owner);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getVideoCount(int id) {
        int count = 0;
        String getVideoSQL = "select count(*) as count from video where channel_id = ?";
        try (
                Connection connection = DBUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(getVideoSQL);

        ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            count = resultSet.getInt("count");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

}
