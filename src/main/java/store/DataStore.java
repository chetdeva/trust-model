package store;

import entity.code.Contribution;
import entity.contributor.Contributor;
import mock.TestData;

import java.util.List;

public class DataStore {

    public List<Contributor> getContributors() {
        return TestData.getContributors();
    }

    public List<Contribution> getContributions() {
        return TestData.getContributions();
    }
}
