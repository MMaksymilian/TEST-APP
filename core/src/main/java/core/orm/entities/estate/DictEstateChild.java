package core.orm.entities.estate;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 26.06.12
 * Time: 15:22
 * To change this template use File | Settings | File Templates.
 */
@Entity
@DiscriminatorValue("CHILD")
@SequenceGenerator(allocationSize=1, name="idSequence", sequenceName="dict_indemnity_seq")
public class DictEstateChild extends DictEstate {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", nullable = true)
    DictEstate parentEstate;

    public DictEstate getParentEstate() {
        return parentEstate;
    }

    public void setParentEstate(DictEstate parentEstate) {
        this.parentEstate = parentEstate;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DictEstateChild)) return false;

        DictEstateChild that = (DictEstateChild) o;

        if (getValue() != null ? !getValue().equals(that.getValue()) : that.getValue() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return getValue() != null ? getValue().hashCode() : 0;
    }
}
