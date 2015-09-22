package pl.lodz.p.it.spjava.sop8.exception;

import pl.lodz.p.it.spjava.sop8.model.Account;

/**
 *
 */
public class AccountException extends AppBaseException {

    static final public String KEY_DB_CONSTRAINT = "error.account.db.constraint.uniq.login";

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
