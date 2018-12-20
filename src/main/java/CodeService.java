import entity.code.Code;
import entity.code.Contribution;

import java.util.List;

import static util.RandomNumberGenerator.generateRandomNumber;

public class CodeService {

    public void reviewCode(List<Contribution> contributions) {
        for (Contribution contribution : contributions) {
            Code codeContributed = contribution.contributed;
            int locAccepted = generateRandomNumber(0, (int) codeContributed.loc);
            Code codeAccepted = new Code(contribution.contributorId, codeContributed.id, codeContributed.date, locAccepted);
            contribution.setAccepted(codeAccepted);
            contribution.setAccuracy(calculateAccuracy(codeContributed, codeAccepted));
        }
    }

    public double calculateAccuracy(Code codeContributed, Code codeAccepted) {
        return (double) codeAccepted.loc / codeContributed.loc * 100;
    }

    public double calculateTrust(List<Contribution> contributions) {
        double trust = 0.0;
        for (Contribution contribution : contributions) {
            trust += contribution.accuracy;
        }
        return trust;
    }
}
