package pl.lodz.p.it.spjava.sop8.ejb.endpoints;

import java.util.List;
import javax.ejb.*;
import pl.lodz.p.it.spjava.sop8.ejb.facades.EnoteFacade;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.model.Account;
import pl.lodz.p.it.spjava.sop8.model.Enote;

/**
 *
 * @author Szymek
 */
@Stateful
@LocalBean
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class EnoteEndpoint extends AbstractEndpoint implements SessionSynchronization {

    @EJB
    private EnoteFacade enoteFacade;

    public List<Enote> getAllEnote() {
        return enoteFacade.findAll();
    }

    public List<Enote> pullEnoteList(Account account) {
        return enoteFacade.pullEnoteList(account);
    }

    public void createEnote(Enote entity) {
        enoteFacade.createEnote(entity);
    }

    public void editEnote(Enote entity) throws AppBaseException {
        enoteFacade.edit(entity);
    }

    public List<Enote> findEnote(Account account, Long year) {
        return enoteFacade.findEnote(account, year);
    }
}
