package core.orm.dao.impl;

import core.orm.dao.UserDAO;
import core.orm.entities.AppUser;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDAOImpl extends BaseDAOImpl implements UserDAO {
    public AppUser getUserByLogin(String login) {
        Criteria criteria = getSession().createCriteria(AppUser.class);
        criteria.add(Restrictions.like("login", login));
        return (AppUser) criteria.uniqueResult();
    }

    public List<AppUser> getAllUsers() {
        Criteria criteria = getSession().createCriteria(AppUser.class);
        return (List<AppUser>)criteria.list();
    }
}
