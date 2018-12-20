package entity.contributor;

import entity.code.Contribution;
import entity.project.Project;

import java.util.Date;
import java.util.List;

public class Contributor {
    public long userId;
    public long id;
    String name;
    Date dob;
    String address;
    String email;
    String specialization;
    String contactNumber;
    boolean isWorkingForOtherProjects;
    List<Project> otherProjects;
    public double trust;
    List<Award> awards;
    List<String> remarks;
    public List<Contribution> contributions;
    ContributionLevel contributionLevel;

    public Contributor(long userId, long id, String name) {
        this.userId = userId;
        this.id = id;
        this.name = name;
    }

    public enum ContributionLevel {
        CORE(4), CONTRIBUTOR(3), TESTER(2), USER_EDITOR(1), USER(0);
        final int level;

        ContributionLevel(int level) {
            this.level = level;
        }
    }

    public void setContributions(List<Contribution> contributions) {
        this.contributions = contributions;
    }

    @Override
    public String toString() {
        return "\nuserId: " + userId +
                "\nname: " + name +
                "\ntrust: " + trust;
    }
}
