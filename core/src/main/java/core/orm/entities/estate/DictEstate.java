package core.orm.entities.estate;

import core.orm.entities.DeclarationRecord;
import core.orm.entities.core.DictionaryEntity;

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
public class DictEstate extends DictionaryEntity {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estate")
    Set<DeclarationRecord> declarationRecords;

    //TODO sprawdzić czy pomaga
//    @BatchSize(size = 10)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentEstate")
    Set<DictEstateChild> dictEstateChildren;

    public Set<DeclarationRecord> getDeclarationRecords() {
        return declarationRecords;
    }

    public void setDeclarationRecords(Set<DeclarationRecord> declarationRecords) {
        this.declarationRecords = declarationRecords;
    }

    public Set<DictEstateChild> getDictEstateChildren() {
        return dictEstateChildren;
    }

    public void setDictEstateChildren(Set<DictEstateChild> dictChildren) {
        this.dictEstateChildren = dictChildren;
    }
}
