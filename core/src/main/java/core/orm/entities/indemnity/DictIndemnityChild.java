package core.orm.entities.indemnity;

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
public class DictIndemnityChild extends DictIndemnity {

    //TODO - sprawdź czy nullable musi być true czy może być false
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", nullable = true)
    DictIndemnity parentIndemnity;

    public DictIndemnity getParentIndemnity() {
        return parentIndemnity;
    }

    public void setParentIndemnity(DictIndemnity parentIndemnity) {
        this.parentIndemnity = parentIndemnity;
    }
}
