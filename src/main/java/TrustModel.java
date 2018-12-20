import auth.AuthService;
import entity.code.Contribution;
import entity.contributor.Contributor;
import mock.TestData;
import store.ContributorStore;
import store.DataStore;

import java.util.ArrayList;
import java.util.List;

public class TrustModel {

    private final Logger logger;
    private final CodeService codeService;
    private final DataStore dataStore;
    private final ContributorStore contributorStore;
    private final AuthService authService;

    private final ArrayList<Contributor> contributors = new ArrayList<>();
    private final ArrayList<Contribution> contributions = new ArrayList<>();

    public TrustModel() {
        logger = Logger.getInstance();
        codeService = new CodeService();
        dataStore = new DataStore();
        contributorStore = new ContributorStore(dataStore);
        authService = new AuthService(contributorStore);
    }

    public void init() {
        loginUsers();

        logger.log("Contributors", contributors);

        contributeCode();

        logger.log("Contributions", contributions);

        reviewCode();

        logger.log("Reviews", contributions);

        calculateTrust();

        logger.log("Trust", contributors);
    }

    private void loginUsers() {
        List<Contributor> contributors = authService.loginUsers(TestData.getUsers());
        setContributors(contributors);
    }

    private void contributeCode() {
        List<Contribution> contributions = contributorStore.getContributions();
        setContributions(contributions);
    }

    private void reviewCode() {
        codeService.reviewCode(contributions);
    }

    private void calculateTrust() {
        updateContributions();
        for (Contributor contributor : getContributors()) {
            contributor.trust = codeService.calculateTrust(contributor.contributions);
        }
    }

    private void updateContributions() {
        for (Contributor contributor : getContributors()) {
            List<Contribution> contributions = new ArrayList<>();
            for (Contribution contribution : getContributions()) {
                if (contributor.id == contribution.contributorId) {
                    contributions.add(contribution);
                }
            }
            contributor.setContributions(contributions);
        }
    }

    public ArrayList<Contributor> getContributors() {
        return contributors;
    }

    public ArrayList<Contribution> getContributions() {
        return contributions;
    }

    public void setContributors(List<Contributor> contributors) {
        this.contributors.addAll(contributors);
    }

    public void setContributions(List<Contribution> contributions) {
        this.contributions.addAll(contributions);
    }

}
