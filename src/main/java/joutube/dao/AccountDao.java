package main.java.joutube.dao;

import main.java.joutube.domain.Account;
import main.java.joutube.util.DBUtil;

import java.sql.*;

public class AccountDao {

    public void createAccount(Account account) {
        ChannelDao channelDao = new ChannelDao();
        String createAccountSQL = "insert into account (name,profile_image,email,password) " +
                "values (?, ?, ?, ?)";
        try (
                Connection connection = DBUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(createAccountSQL, Statement.RETURN_GENERATED_KEYS);

        ) {
            statement.setString(1, account.getName());
            statement.setString(2, account.getProfileImage());
            statement.setString(3, account.getEmail());
            statement.setString(4, account.getPassword());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                channelDao.createChannel(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int updateAccount(String name, String profile, String email, String password,int id) {
        int affectedRow = 0;
        String updateAccountSQL = "update account set name = ?, profile_image = ?, email = ?, password = ? where id = ?";
        try (
                Connection connection = DBUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(updateAccountSQL);
        ) {
            Account getAccount = findAccount(id);
            if(name.length() == 0) {
               name = getAccount.getName();
            }
            if(profile.length() == 0) {
                profile = getAccount.getProfileImage();
            }
            if(email.length() == 0) {
               email = getAccount.getEmail();
            }
            if(password.length() == 0) {
               password = getAccount.getPassword();
            }
            statement.setString(1, name);
            statement.setString(2, profile);
            statement.setString(3, email);
            statement.setString(4, password);
            statement.setInt(5, id);
            affectedRow = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRow;
    }

    public int deleteAccount(int id) {
        int affectedRow = 0;
        String deleteAccountSQL = "delete from account where id = ?";
        String selectChannelSQL = "select id from channel where account_id = ?";
        String deleteChannelSQl = "delete from channel where account_id = ?";
        String deleteVideoSQL = "delete from video where channel_id = ?";
        try (
                Connection connection = DBUtil.getConnection();
                PreparedStatement accountStatement = connection.prepareStatement(deleteAccountSQL);
                PreparedStatement getChannelStatement = connection.prepareStatement(selectChannelSQL);
                PreparedStatement channelStatement = connection.prepareStatement(deleteChannelSQl);
                PreparedStatement videoStatement = connection.prepareStatement(deleteVideoSQL);

        ) {
            // channel id 가져오기
            getChannelStatement.setInt(1,id);
            ResultSet channelResult = getChannelStatement.executeQuery();
            channelResult.next();
            int channelId = channelResult.getInt("id");

            //video 삭제
            videoStatement.setInt(1, channelId);
            videoStatement.executeUpdate();

            //channel 삭제
            channelStatement.setInt(1, id);
            channelStatement.executeUpdate();

            //계정삭제
            accountStatement.setInt(1, id);
            affectedRow = accountStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return affectedRow;
    }

    public Account findAccount(int id) {
        String findAccountSQL = "select * from account where id = ?";
        try (
                Connection connection = DBUtil.getConnection();
                PreparedStatement statement = connection.prepareStatement(findAccountSQL);

        ) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            Account account = Account.builder()
                    .name(resultSet.getString("name"))
                    .profileImage(resultSet.getString("profile_image"))
                    .email(resultSet.getString("email"))
                    .password(resultSet.getString("password")).build();
            return  account;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}


