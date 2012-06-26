package core.orm.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 25.06.12
 * Time: 16:37
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "TRI_USERS")
public class User {

    String login;

    String password;

    @Id
    @Column(name = "LOGIN")
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
