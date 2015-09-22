package pl.lodz.p.it.spjava.sop8.exception;

import javax.persistence.OptimisticLockException;
import pl.lodz.p.it.spjava.sop8.model.Enote;

/**
 *
 */
public class EnoteException extends AppBaseException {

    static final public String KEY_OPTIMISTIC_LOCK = "error.enote.optimisticlock";
    static final public String KEY_DB_CONSTRAINT = "error.enote.db.constraint";
    static final public String KEY_INSUFFICIENT_PROCDUCT_AMOUNT = "error.enote.insufficient.product.amount";
    static final public String KEY_APROVE_OF_APROVED = "error.enote.aprove.of.aproved";
    static final public String KEY_NO_STATE_IN_EJB_ENDPOINT = "error.enote.no.state.in.ejb.endpoint";
    static final public String KEY_INVALID_STATE_IN_EJB_ENDPOINT = "error.enote.invalid.state.in.ejb.endpoint";

    private EnoteException(String message) {
        super(message);
    }

    private EnoteException(String message, Throwable cause) {
        super(message, cause);
    }
    
    private Enote enote;

    public Enote getEnote() {
        return enote;
    }

    static public EnoteException createWithOptimisticLockKey(Enote enote, OptimisticLockException cause) {
        EnoteException ee = new EnoteException(KEY_OPTIMISTIC_LOCK, cause);
        ee.enote=enote;
        return ee;
    }

    static public EnoteException createWithDbCheckConstraintKey(Enote enote, Throwable cause) {
        EnoteException ee = new EnoteException(KEY_DB_CONSTRAINT);
        ee.initCause(cause);
        ee.enote=enote;
        return ee;
    }

    static public EnoteException createWithInsufficientProductAmount(Enote enote) {
        EnoteException ee = new EnoteException(KEY_INSUFFICIENT_PROCDUCT_AMOUNT);
        ee.enote=enote;
        return ee;
    }

    static public EnoteException createWithAproveOfAproved(Enote enote) {
        EnoteException ee = new EnoteException(KEY_APROVE_OF_APROVED);
        ee.enote=enote;
        return ee;
    }

    static public EnoteException createWithNoStateInEJBEndpoint(Enote enote) {
        EnoteException ee = new EnoteException(KEY_NO_STATE_IN_EJB_ENDPOINT);
        ee.enote=enote;
        return ee;
    }

    static public EnoteException createWithInvalidStateInEJBEndpoint(Enote enote) {
        EnoteException ee = new EnoteException(KEY_INVALID_STATE_IN_EJB_ENDPOINT);
        ee.enote=enote;
        return ee;
    }
}
