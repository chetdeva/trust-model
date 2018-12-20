package entity.code;

public class Contribution {
    public long contributorId;
    public long id;
    public Code contributed;
    public Code accepted;
    // (accepted/contributed*100)%
    public double accuracy;

    public Contribution(long contributorId, long id, Code contributed) {
        this.contributorId = contributorId;
        this.id = id;
        this.contributed = contributed;
    }

    public void setAccepted(Code accepted) {
        this.accepted = accepted;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }
}
