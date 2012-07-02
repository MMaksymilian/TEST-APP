package core.orm.entities;

import core.orm.entities.core.BaseEntity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 02.07.12
 * Time: 10:54
 * To change this template use File | Settings | File Templates.
 */
@Entity
@SequenceGenerator(allocationSize = 1, name="idSequence", sequenceName="user_role_seq")
public class UserRole extends BaseEntity {
    private String roleName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private AppUser user;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }
}

