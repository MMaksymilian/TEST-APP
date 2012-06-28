package core.orm.entities.core;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 26.06.12
 * Time: 14:34
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
public abstract class BaseEntity  {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="idSequence")
    Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
