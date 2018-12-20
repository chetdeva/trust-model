package database;

import entity.user.GithubUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class GithubUsersDao {

    private final DatabaseService databaseService;

    public GithubUsersDao(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            connection = databaseService.getConnection();
            if (connection != null) {
                System.out.println("Connection established");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return connection;
    }

    public List<GithubUser> getAll() {
        return Collections.emptyList();
    }

    public void insert(List<GithubUser> githubUsers) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = databaseService.getConnection();

            // the mysql insert statement
            String query = "insert into githubusers"
                    + " (name, login, location, language, gravatar, followers, contributions)"
                    + " values (?, ?, ?, ?, ?, ?, ?)";

            // create the mysql insert preparedstatement
            statement = connection.prepareStatement(query);

            for (GithubUser githubUser : githubUsers) {

                statement.setString(1, githubUser.name);
                statement.setString(2, githubUser.login);
                statement.setString(3, githubUser.location);
                statement.setString(4, githubUser.language);
                statement.setString(5, githubUser.gravatar);
                statement.setInt(6, githubUser.followers);
                statement.setInt(7, githubUser.contributions);

                // execute the preparedstatement
                statement.addBatch();

            }

            int[] numUpdates = statement.executeBatch();
            for (int i = 0; i < numUpdates.length; i++) {
                if (numUpdates[i] == -2) {
                    System.out.println("Execution " + i +
                            ": unknown number of rows updated");
                } else {
                    System.out.println("Execution " + i +
                            "successful: " + numUpdates[i] + " rows updated");
                }
            }
            connection.commit();

        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (statement != null)
                    connection.close();
            } catch (SQLException se) {
            }// do nothing
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    private static GithubUsersDao githubUsersDao;

    public static GithubUsersDao getInstance(DatabaseService propertiesService) {
        if (githubUsersDao == null) {
            githubUsersDao = new GithubUsersDao(propertiesService);
        }
        return githubUsersDao;
    }
}
