package entity.code;

import java.util.Date;

public class Code {
    public long contributionId;
    public long id;
    public Date date;
    public long loc;

    public Code(long contributionId, long id, Date date, long loc) {
        this.contributionId = contributionId;
        this.id = id;
        this.date = date;
        this.loc = loc;
    }
}
