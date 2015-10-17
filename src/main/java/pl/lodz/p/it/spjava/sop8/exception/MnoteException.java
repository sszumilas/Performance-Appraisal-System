package pl.lodz.p.it.spjava.sop8.exception;

import javax.persistence.OptimisticLockException;
import pl.lodz.p.it.spjava.sop8.model.Mnote;

/**
 *
 */
public class MnoteException extends AppBaseException {

    static final public String KEY_OPTIMISTIC_LOCK = "error.mnote.optimisticlock";
    static final public String KEY_DB_CONSTRAINT = "error.mmnote.db.constraint";
    static final public String KEY_INSUFFICIENT_PROCDUCT_AMOUNT = "error.mnote.insufficient.product.amount";
    static final public String KEY_APROVE_OF_APROVED = "error.mnote.aprove.of.aproved";
    static final public String KEY_NO_STATE_IN_EJB_ENDPOINT = "error.mnote.no.state.in.ejb.endpoint";
    static final public String KEY_INVALID_STATE_IN_EJB_ENDPOINT = "error.mnote.invalid.state.in.ejb.endpoint";

    private MnoteException(String message) {
        super(message);
    }

    private MnoteException(String message, Throwable cause) {
        super(message, cause);
    }
    
    private Mnote mnote;

    public Mnote getMnote() {
        return mnote;
    }

    static public MnoteException createWithOptimisticLockKey(Mnote mnote, OptimisticLockException cause) {
        MnoteException me = new MnoteException(KEY_OPTIMISTIC_LOCK, cause);
        me.mnote=mnote;
        return me;
    }

    static public MnoteException createWithDbCheckConstraintKey(Mnote mnote, Throwable cause) {
        MnoteException me = new MnoteException(KEY_DB_CONSTRAINT);
        me.initCause(cause);
        me.mnote=mnote;
        return me;
    }

    static public MnoteException createWithInsufficientProductAmount(Mnote mnote) {
        MnoteException me = new MnoteException(KEY_INSUFFICIENT_PROCDUCT_AMOUNT);
        me.mnote=mnote;
        return me;
    }

    static public MnoteException createWithAproveOfAproved(Mnote mnote) {
        MnoteException me = new MnoteException(KEY_APROVE_OF_APROVED);
        me.mnote=mnote;
        return me;
    }

    static public MnoteException createWithNoStateInEJBEndpoint(Mnote mnote) {
        MnoteException me = new MnoteException(KEY_NO_STATE_IN_EJB_ENDPOINT);
        me.mnote=mnote;
        return me;
    }

    static public MnoteException createWithInvalidStateInEJBEndpoint(Mnote mnote) {
        MnoteException me = new MnoteException(KEY_INVALID_STATE_IN_EJB_ENDPOINT);
        me.mnote=mnote;
        return me;
    }
}
