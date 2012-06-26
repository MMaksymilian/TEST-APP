package core.orm.dao;


import core.orm.entities.AppUser;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * AppUser: Maksymilian Małek
 * Date: 25.06.12
 * Time: 16:45
 * To change this template use File | Settings | File Templates.
 */
public interface UserDAO {

    public AppUser getUserByLogin(String login);
    public List<AppUser> getAllUsers();
}
