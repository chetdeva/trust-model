import entity.user.GithubUser;
import interactor.GithubUserInteractor;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Trust {

    public Trust() {
    }

    public static void main(String[] args) {
        GithubUserInteractor githubUserInteractor = Injection.getGithubUserInteractor();
        List<GithubUser> githubUsers = githubUserInteractor.getGithubUsers();
        System.out.println(githubUsers);

        connectToDatabase();
    }


    private static void connectToDatabase() {
        Connection connection = null;
        try {
            connection = Injection.getDatabaseService().getConnection();
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
    }
}
