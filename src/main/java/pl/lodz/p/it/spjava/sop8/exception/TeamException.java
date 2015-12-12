package pl.lodz.p.it.spjava.sop8.exception;

import javax.persistence.PersistenceException;
import pl.lodz.p.it.spjava.sop8.model.Enote;
import pl.lodz.p.it.spjava.sop8.model.Team;

/**
 *
 */
public class TeamException extends AppBaseException {

    static final public String KEY_DB_CONSTRAINT = "error.account.db.constraint.uniq.teamName";

    private TeamException(String message) {
        super(message);
    }

    private TeamException(String message, Throwable cause) {
        super(message, cause);
    }
    
    private Team team;

    public Team getTeam() {
        return team;
    }

    static public TeamException createWithDbCheckConstraintKey(Team team, Throwable cause) {
        TeamException ee = new TeamException(KEY_DB_CONSTRAINT, cause);
        ee.team=team;
        return ee;
    }
}
