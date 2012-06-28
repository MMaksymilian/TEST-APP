package core.orm.entities;

import core.orm.entities.core.BaseEntity;
import core.orm.entities.indemnity.DictIndemnity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 26.06.12
 * Time: 14:31
 * To change this template use File | Settings | File Templates.
 */
@Entity
@SequenceGenerator(allocationSize=1, name="idSequence", sequenceName="declaration_record_seq")
public class DeclarationRecord  extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ownership", nullable = false)
    DictOwnership ownership;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "share_type", nullable = false)
    DictShareType shareType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "indemnity", nullable = false)
    DictIndemnity indemnity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_record_id", nullable = false)
    DeclarationRecord parentRecordId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "declaration_id", nullable = false)
    Declaration declaration;

    public Declaration getDeclaration() {
        return declaration;
    }

    public void setDeclaration(Declaration declaration) {
        this.declaration = declaration;
    }

    public DictOwnership getOwnership() {
        return ownership;
    }

    public void setOwnership(DictOwnership ownership) {
        this.ownership = ownership;
    }

    public DictShareType getShareType() {
        return shareType;
    }

    public void setShareType(DictShareType shareType) {
        this.shareType = shareType;
    }

    public DictIndemnity getIndemnity() {
        return indemnity;
    }

    public void setIndemnity(DictIndemnity indemnity) {
        this.indemnity = indemnity;
    }

    public DeclarationRecord getParentRecordId() {
        return parentRecordId;
    }

    public void setParentRecordId(DeclarationRecord parentRecordId) {
        this.parentRecordId = parentRecordId;
    }
}
