package core.orm.entities;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian
 * Date: 10.07.12
 * Time: 21:21
 * To change this template use File | Settings | File Templates.
 */
@Entity
@DiscriminatorValue("CHILD")
@SequenceGenerator(allocationSize = 1, name = "idSequence", sequenceName = "declaration_record_seq")
public class DeclarationRecordChild extends DeclarationRecord implements Cloneable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_record_id", nullable = false)
    DeclarationRecord parentRecordId;

    public DeclarationRecord getParentRecordId() {
        return parentRecordId;
    }

    public void setParentRecordId(DeclarationRecord parentRecordId) {
        this.parentRecordId = parentRecordId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeclarationRecordChild)) return false;
        if (!super.equals(o)) return false;

        DeclarationRecordChild that = (DeclarationRecordChild) o;

        if (parentRecordId != null ? !parentRecordId.equals(that.parentRecordId) : that.parentRecordId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (parentRecordId != null ? parentRecordId.hashCode() : 0);
        return result;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}

