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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRole)) return false;

        UserRole userRole = (UserRole) o;

        if (roleName != null ? !roleName.equals(userRole.roleName) : userRole.roleName != null) return false;
        if (user != null ? !user.equals(userRole.user) : userRole.user != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleName != null ? roleName.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}

