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
@SequenceGenerator(allocationSize=1, name="idSequence", sequenceName="declaration_record_seq")
public class DeclarationRecordChild extends DeclarationRecord{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_record_id", nullable = false)
    DeclarationRecord parentRecordId;

    public DeclarationRecord getParentRecordId() {
        return parentRecordId;
    }

    public void setParentRecordId(DeclarationRecord parentRecordId) {
        this.parentRecordId = parentRecordId;
    }
}

