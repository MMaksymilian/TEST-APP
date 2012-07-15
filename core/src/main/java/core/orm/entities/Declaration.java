package core.orm.entities;

import core.orm.entities.core.BaseEntity;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

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
}
