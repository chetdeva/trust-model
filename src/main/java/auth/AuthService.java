package auth;

import entity.contributor.Contributor;
import entity.user.User;
import store.ContributorStore;

import java.util.ArrayList;
import java.util.List;

public class AuthService {

    final ContributorStore contributorStore;

    public AuthService(ContributorStore contributorStore) {
        this.contributorStore = contributorStore;
    }

    public List<Contributor> loginUsers(List<User> users) {
        List<Contributor> contributors = new ArrayList<>();
        for (User user : users) {
            if (checkLogin(user)) {
                Contributor contributor = contributorStore.getContributor(user.getId());
                contributors.add(contributor);
            }
        }
        return contributors;
    }

    public boolean checkLogin(User user) {
        List<Contributor> contributors = contributorStore.getContributors();
        for (Contributor contributor : contributors) {
            if (user.getId() == contributor.userId) {
                return true;
            }
        }
        return false;
    }
}
