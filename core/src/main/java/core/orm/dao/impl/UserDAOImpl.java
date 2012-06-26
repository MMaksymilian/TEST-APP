package core.orm.dao.impl;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import core.orm.dao.UserDAO;
import orm.entities.User;

import java.util.List;

@Component
@Transactional
public class UserDAOImpl extends BaseDAOImpl implements UserDAO {
    public User getUserByLogin(String login) {
        User u = (User) DataAccessUtils.uniqueResult(getHibernateTemplate().find("from User as u where u.login = ?", login));
        return u;
    }

    public List<User> getAllUsers() {
        return (List<User>)(getHibernateTemplate().find("from User"));
    }
}
