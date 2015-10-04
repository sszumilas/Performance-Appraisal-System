package pl.lodz.p.it.spjava.sop8.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * Klasa nadrzędna dla wszystkich klas encyjnych. Ustala wspólne metody:
 * toString() equals() hashCode()
 */
@MappedSuperclass
public abstract class AbstractEntity {
    
    protected static final long serialVersionUID = 1L;

    // Samego klucza głównego nie można dziedziczyć ze względu na stosowanie różnych generatorów tabelowych w różnych encjach.
    protected abstract Object getId();

    // Z kolei nie wiadomo co będzie kluczem biznesowym w poszczególnych encjach
    protected abstract Object getBusinessKey();

    @Version
    @Column(name="version")
    private int version;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[id=" + getId() + 
                ", key=" + getBusinessKey() + ", version=" + version + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        
        if(this.getClass().isAssignableFrom(obj.getClass())) {
            return this.getBusinessKey().equals(((AbstractEntity)obj).getBusinessKey());
        } else {
            return false;
        }

    }

    @Override
    public int hashCode() {
        return getBusinessKey().hashCode(); 
    }
}
