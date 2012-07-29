package core.orm.entities;

import core.orm.entities.core.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * AppUser: Maksymilian Małek
 * Date: 25.06.12
 * Time: 16:37
 * To change this template use File | Settings | File Templates.
 */
@Entity
@SequenceGenerator(allocationSize=1, name="idSequence", sequenceName="app_user_seq")
public class AppUser extends BaseEntity {

    String login;

    String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    Set<Declaration> declarations;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    Set<UserRole> userRoles;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Declaration> getDeclarations() {
        return declarations;
    }

    public void setDeclarations(Set<Declaration> declarations) {
        this.declarations = declarations;
    }

    public Set<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppUser)) return false;

        AppUser appUser = (AppUser) o;

        if (login != null ? !login.equals(appUser.login) : appUser.login != null) return false;
        if (password != null ? !password.equals(appUser.password) : appUser.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
//        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
