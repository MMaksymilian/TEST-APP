package core.orm.entities;

import core.orm.entities.core.BaseEntity;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import org.joda.time.DateTime;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 26.06.12
 * Time: 14:31
 * To change this template use File | Settings | File Templates.
 */
@Entity
@SequenceGenerator(allocationSize=1, name="idSequence", sequenceName="declaration_seq")
@FilterDef(name = "onlyParentDeclartionRecordsFilter")
public class Declaration extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    AppUser user;

    @Column
    @Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
    private DateTime commitDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "declaration")
    @Cascade({CascadeType.ALL})
    @Filter(name = "onlyParentDeclartionRecordsFilter",
        condition = "type = 'MAIN'")
    Set<DeclarationRecord> declarationRecords;

    private Double creditAmount;

    private Double estateValue;

    private Double interest;

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public DateTime getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(DateTime commitDate) {
        this.commitDate = commitDate;
    }

    public Set<DeclarationRecord> getDeclarationRecords() {
        return declarationRecords;
    }

    public void setDeclarationRecords(Set<DeclarationRecord> declarationRecords) {
        this.declarationRecords = declarationRecords;
    }

    public Double getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(Double creditAmount) {
        this.creditAmount = creditAmount;
    }

    public Double getEstateValue() {
        return estateValue;
    }

    public void setEstateValue(Double estateValue) {
        this.estateValue = estateValue;
    }

    public Double getInterest() {
        return interest;
    }

    public void setInterest(Double interest) {
        this.interest = interest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Declaration)) return false;

        Declaration that = (Declaration) o;

        if (commitDate != null ? !commitDate.equals(that.commitDate) : that.commitDate != null) return false;
        if (creditAmount != null ? !creditAmount.equals(that.creditAmount) : that.creditAmount != null) return false;
        if (estateValue != null ? !estateValue.equals(that.estateValue) : that.estateValue != null) return false;
        if (interest != null ? !interest.equals(that.interest) : that.interest != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = user != null ? user.hashCode() : 0;
        result = 31 * result + (commitDate != null ? commitDate.hashCode() : 0);
        result = 31 * result + (creditAmount != null ? creditAmount.hashCode() : 0);
        result = 31 * result + (estateValue != null ? estateValue.hashCode() : 0);
        result = 31 * result + (interest != null ? interest.hashCode() : 0);
        return result;
    }
}
