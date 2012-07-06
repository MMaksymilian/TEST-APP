package core.orm.entities.indemnity;

import core.orm.entities.DeclarationRecord;
import core.orm.entities.core.DictionaryEntity;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 26.06.12
 * Time: 14:32
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="type",
        discriminatorType= DiscriminatorType.STRING
)
@DiscriminatorValue("MAIN")
@SequenceGenerator(allocationSize=1, name="idSequence", sequenceName="dict_indemnity_seq")
public class DictIndemnity  extends DictionaryEntity {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "indemnity")
    Set<DeclarationRecord> declarationRecords;

    //TODO sprawdzić czy pomaga
    @BatchSize(size = 10)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentIndemnity")
    Set<DictIndemnityChild> dictIndemnityChildren;

    public Set<DeclarationRecord> getDeclarationRecords() {
        return declarationRecords;
    }

    public void setDeclarationRecords(Set<DeclarationRecord> declarationRecords) {
        this.declarationRecords = declarationRecords;
    }

    public Set<DictIndemnityChild> getDictIndemnityChildren() {
        return dictIndemnityChildren;
    }

    public void setDictIndemnityChildren(Set<DictIndemnityChild> dictIndemnityChildren) {
        this.dictIndemnityChildren = dictIndemnityChildren;
    }
}
