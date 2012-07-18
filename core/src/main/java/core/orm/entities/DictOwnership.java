package core.orm.entities;

import core.orm.entities.core.DictionaryEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 26.06.12
 * Time: 14:32
 * To change this template use File | Settings | File Templates.
 */
@Entity
@SequenceGenerator(allocationSize=1, name="idSequence", sequenceName="dict_ownership_seq")
public class DictOwnership  extends DictionaryEntity {
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ownership")
    Set<DeclarationRecord> declarationRecords;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DictOwnership)) return false;

        DictOwnership that = (DictOwnership) o;

        if (getValue() != null ? !getValue().equals(that.getValue()) : that.getValue() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return getValue() != null ? getValue().hashCode() : 0;
    }
}
