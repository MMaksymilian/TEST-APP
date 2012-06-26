package core.orm.entities;

import core.orm.entities.core.BaseEntity;
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
public class Declaration extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user", nullable = false)
    AppUser user;

    @Column
    @Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
    private DateTime commitDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "declaration")
    Set<DeclarationRecord> declarationRecords;

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
}
