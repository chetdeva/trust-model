package store;

import entity.code.Contribution;
import entity.contributor.Contributor;

import java.util.List;

public class ContributorStore {

    private final DataStore dataStore;

    public ContributorStore(DataStore dataStore) {
        this.dataStore = dataStore;
    }

    public Contributor getContributor(long userId) {
        List<Contributor> contributors = getContributors();
        for (Contributor contributor : contributors) {
            if (userId == contributor.userId) {
                return contributor;
            }
        }
        return null;
    }

    public List<Contributor> getContributors() {
        return dataStore.getContributors();
    }

    public List<Contribution> getContributions() {
        return dataStore.getContributions();
    }

}
