package core.orm.entities.indemnity;

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
public class DictIndemnity  extends DictionaryEntity {

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentIndemnity")
    Set<DictIndemnityChild> dictIndemnityChildren;

}
