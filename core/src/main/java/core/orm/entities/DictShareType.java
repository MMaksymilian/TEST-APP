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
@SequenceGenerator(allocationSize=1, name="idSequence", sequenceName="dict_share_type_seq")
public class DictShareType  extends DictionaryEntity {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shareType")
    Set<DeclarationRecord> declarationRecords;
}
