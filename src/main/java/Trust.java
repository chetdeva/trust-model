import database.GithubUsersDao;
import entity.user.GithubUser;
import interactor.GithubUserInteractor;

import java.util.List;

public class Trust {

    public Trust() {
    }

    public static void main(String[] args) {
        GithubUserInteractor githubUserInteractor = Injection.getGithubUserInteractor();
        GithubUsersDao githubUsersDao = Injection.getGithubUsersDao();


        List<GithubUser> githubUsers = githubUserInteractor.getGithubUsers();
        System.out.println(githubUsers);

        githubUsersDao.insert(githubUsers);
    }
}
