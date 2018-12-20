package entity.project;

public class Project {
    long id;
    String name;
    String description;
    int developersCount;
    String licenseInfo;
    MaturityLevel maturityLevel;

    enum MaturityLevel {
        INCUBATION(0), AD_HOC(1), PLANNED(2), MANAGED(3), INTEGRATED(4), EXECUTED(5);
        int level;

        MaturityLevel(int level) {
            this.level = level;
        }
    }
}
