package pl.lodz.p.it.spjava.sop8.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntity {
    
    protected static final long serialVersionUID = 1L;

    protected abstract Object getId();

    @Version
    @Column(name="version")
    private int version;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[id=" + getId() + 
                ", version=" + version + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        
        if(this.getClass().isAssignableFrom(obj.getClass())) {
            return this.getId().equals(((AbstractEntity)obj).getId());
        } else {
            return false;
        }

    }

    @Override
    public int hashCode() {
        return getId().hashCode(); 
    }
}
