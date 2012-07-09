package core.orm.entities.core;

import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 26.06.12
 * Time: 15:04
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
public abstract class DictionaryEntity extends BaseEntity {

    String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
