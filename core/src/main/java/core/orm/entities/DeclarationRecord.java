package core.orm.entities;

import core.orm.entities.core.BaseEntity;
import core.orm.entities.estate.DictEstate;

import javax.persistence.*;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 26.06.12
 * Time: 14:31
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="type",
        discriminatorType= DiscriminatorType.STRING
)
@DiscriminatorValue("MAIN")
@SequenceGenerator(allocationSize=1, name="idSequence", sequenceName="declaration_record_seq")
public class DeclarationRecord  extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ownership", nullable = false)
    DictOwnership ownership;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "share_type", nullable = false)
    DictShareType shareType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estate_id", nullable = false)
    DictEstate estate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "declaration_id", nullable = false)
    Declaration declaration;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "parentRecordId")
    Set<DeclarationRecordChild> declarationRecordChildren;

    Integer value;

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

    public DictEstate getEstate() {
        return estate;
    }

    public void setEstate(DictEstate estate) {
        this.estate = estate;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Set<DeclarationRecordChild> getDeclarationRecordChildren() {
        return declarationRecordChildren;
    }

    public void setDeclarationRecordChildren(Set<DeclarationRecordChild> declarationRecordChildren) {
        this.declarationRecordChildren = declarationRecordChildren;
    }
}
