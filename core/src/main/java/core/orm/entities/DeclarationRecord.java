package core.orm.entities;

import core.orm.entities.core.BaseEntity;
import core.orm.entities.estate.DictEstate;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
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
    @Cascade({CascadeType.ALL})
    Set<DeclarationRecordChild> declarationRecordChildren;

    @Digits(fraction = 2, integer = 10)
    Double value;

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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Set<DeclarationRecordChild> getDeclarationRecordChildren() {
        return declarationRecordChildren;
    }

    public void setDeclarationRecordChildren(Set<DeclarationRecordChild> declarationRecordChildren) {
        this.declarationRecordChildren = declarationRecordChildren;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeclarationRecord)) return false;

        DeclarationRecord that = (DeclarationRecord) o;

        if (declaration != null ? !declaration.equals(that.declaration) : that.declaration != null) return false;
        if (estate != null ? !estate.equals(that.estate) : that.estate != null) return false;
        if (ownership != null ? !ownership.equals(that.ownership) : that.ownership != null) return false;
        if (shareType != null ? !shareType.equals(that.shareType) : that.shareType != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ownership != null ? ownership.hashCode() : 0;
        result = 31 * result + (shareType != null ? shareType.hashCode() : 0);
        result = 31 * result + (estate != null ? estate.hashCode() : 0);
        result = 31 * result + (declaration != null ? declaration.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
