package pl.lodz.p.it.spjava.sop8.exception;

import javax.persistence.PersistenceException;
import pl.lodz.p.it.spjava.sop8.model.Account;
import pl.lodz.p.it.spjava.sop8.model.Enote;

/**
 *
 */
public class AccountException extends AppBaseException {

    static final public String KEY_DB_CONSTRAINT = "error.account.db.constraint.uniq.login";

    public static Exception createWithDbCheckConstraintKey(Enote entity, PersistenceException ex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private AccountException(String message) {
        super(message);
    }

    private AccountException(String message, Throwable cause) {
        super(message, cause);
    }
    
    private Account account;

    public Account getAccount() {
        return account;
    }

    static public AccountException createWithDbCheckConstraintKey(Account account, Throwable cause) {
        AccountException ee = new AccountException(KEY_DB_CONSTRAINT, cause);
        ee.account=account;
        return ee;
    }
}
