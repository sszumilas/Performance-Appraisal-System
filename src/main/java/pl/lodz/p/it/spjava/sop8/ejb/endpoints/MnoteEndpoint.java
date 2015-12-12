package pl.lodz.p.it.spjava.sop8.ejb.endpoints;

import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.*;
import pl.lodz.p.it.spjava.sop8.ejb.facades.MnoteFacade;
import pl.lodz.p.it.spjava.sop8.exception.AppBaseException;
import pl.lodz.p.it.spjava.sop8.model.Account;
import pl.lodz.p.it.spjava.sop8.model.Mnote;


@Stateful
@LocalBean
@RolesAllowed({"Manager","Admin"})
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class MnoteEndpoint extends AbstractEndpoint implements SessionSynchronization {

    @EJB
    private MnoteFacade mnoteFacade;

    public List<Mnote> getAllMnote() {
        return mnoteFacade.findAll();
    }

    public List<Mnote> pullMnoteList(Account account) {
        return mnoteFacade.pullMnoteList(account);
    }

    public void createMnote(Mnote entity) {
        mnoteFacade.createMnote(entity);
    }

    public void editMnote(Mnote entity) throws AppBaseException {
        mnoteFacade.edit(entity);
    }
    
    public boolean isNoted(Account account, Long year){
       return mnoteFacade.isNoted(account, year);
    }
}
