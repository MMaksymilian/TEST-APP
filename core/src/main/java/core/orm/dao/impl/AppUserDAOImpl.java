package core.orm.dao.impl;

import core.orm.dao.AppUserDAO;
import core.orm.entities.AppUser;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppUserDAOImpl extends BaseDAOImpl implements AppUserDAO {
    public AppUser getUserByLogin(String login) {
        Criteria criteria = getSession().createCriteria(AppUser.class);
        criteria.add(Restrictions.like("login", login));
        return (AppUser) criteria.uniqueResult();
    }

    public List<AppUser> getAllUsers() {
        Criteria criteria = getSession().createCriteria(AppUser.class);
        return (List<AppUser>)criteria.list();
    }

    public AppUser getById(Long id) {
        Criteria getByIdCriteria = getSession().createCriteria(AppUser.class);
        getByIdCriteria.add(Restrictions.idEq(id));
        return (AppUser) getByIdCriteria.uniqueResult();
    }
}
