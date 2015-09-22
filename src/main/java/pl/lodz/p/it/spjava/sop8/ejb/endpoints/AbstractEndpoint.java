package pl.lodz.p.it.spjava.sop8.ejb.endpoints;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.SessionContext;

abstract public class AbstractEndpoint {

    @Resource
    SessionContext sctx;
    protected static final Logger LOGGER = Logger.getGlobal();
    private String transactionId;

    // Przywróć "wykomentowane" linie aby uzyskać prostą implementację SessionSynchronization
    public void afterBegin() {
        transactionId = Long.toString(System.currentTimeMillis())
                + ThreadLocalRandom.current().nextLong(Long.MAX_VALUE);
        LOGGER.log(Level.INFO, "Transakcja TXid={0} rozpoczęta w {1}, tożsamość: {2}",
                new Object[]{transactionId, this.getClass().getName(), sctx.getCallerPrincipal().getName()});
    }

    public void beforeCompletion() {
        LOGGER.log(Level.INFO, "Transakcja TXid={0} przed zatwierdzeniem w {1}, tożsamość {2}",
                new Object[]{transactionId, this.getClass().getName(), sctx.getCallerPrincipal().getName()});
    }

    public void afterCompletion(boolean committed) {
        LOGGER.log(Level.INFO, "Transakcja TXid={0} zakończona w {1} poprzez {3}, tożsamość {2}",
				new Object[]{transactionId, this.getClass().getName(), sctx.getCallerPrincipal().getName(),       committed ? "ZATWIERDZENIE" : "ODWOŁANIE"});
    }
}