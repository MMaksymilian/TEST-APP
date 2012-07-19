package core.orm.dao.impl;

import core.orm.dao.UserRoleDAO;
import core.orm.entities.DictShareType;
import core.orm.entities.UserRole;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: USER
 * Date: 19.07.12
 * Time: 09:21
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class UserRoleDAOImpl extends BaseDAOImpl implements UserRoleDAO {

    @Override
    public UserRole getById(Long id) {
        Criteria getByIdCriteria = getSession().createCriteria(UserRole.class);
        getByIdCriteria.add(Restrictions.idEq(id));
        return (UserRole) getByIdCriteria.uniqueResult();
    }
}
