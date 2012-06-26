package core.orm.dao;

import orm.entities.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 25.06.12
 * Time: 16:45
 * To change this template use File | Settings | File Templates.
 */
public interface UserDAO {

    public User getUserByLogin(String login);
    public List<User> getAllUsers();
}
