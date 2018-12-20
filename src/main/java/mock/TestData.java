package mock;

import entity.code.Code;
import entity.code.Contribution;
import entity.contributor.Contributor;
import entity.user.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestData {

    public static List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User(1, "jeff", "1234"));
        users.add(new User(2, "rachel", "1234"));
        users.add(new User(3, "laura", "1234"));
        users.add(new User(4, "jessica", "1234"));
        users.add(new User(5, "nathan", "1234"));
        users.add(new User(6, "brian", "1234"));
        users.add(new User(7, "matt", "1234"));
        users.add(new User(8, "andrew", "1234"));
        users.add(new User(9, "joe", "1234"));
        users.add(new User(10, "perry", "1234"));
        return users;
    }

    public static List<Contributor> getContributors() {
        List<Contributor> contributors = new ArrayList<>();
        contributors.add(new Contributor(1, 1, "Jeff Savage"));
        contributors.add(new Contributor(2, 2, "Rachel Jones"));
        contributors.add(new Contributor(3, 3, "Laura Croft"));
        contributors.add(new Contributor(4, 4, "Jessica Pearson"));
        contributors.add(new Contributor(5, 5, "Nathan Jones"));
        return contributors;
    }

    public static List<Contribution> getContributions() {
        List<Contribution> contributions = new ArrayList<>();

        // entity.code contributed by Jeff (id = 1)
        contributions.add(new Contribution(1, 1, new Code(1, 1, new Date(), 100)));
        contributions.add(new Contribution(1, 2, new Code(2, 2, new Date(), 50)));

        // Code contributed by Rachel (id = 2)
        contributions.add(new Contribution(2, 3, new Code(3, 3, new Date(), 50)));
        contributions.add(new Contribution(2, 4, new Code(4, 4, new Date(), 50)));

        return contributions;
    }
}
