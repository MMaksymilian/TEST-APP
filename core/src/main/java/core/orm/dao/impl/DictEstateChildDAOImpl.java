package core.orm.dao.impl;

import core.orm.dao.DictEstateChildDAO;
import core.orm.entities.estate.DictEstate;
import core.orm.entities.estate.DictEstateChild;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: USER
 * Date: 19.07.12
 * Time: 09:42
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class DictEstateChildDAOImpl extends BaseDAOImpl implements DictEstateChildDAO {

    @Override
    public DictEstateChild getById(Long id) {
        Criteria getByIdCriteria = getSession().createCriteria(DictEstateChild.class);
        getByIdCriteria.add(Restrictions.idEq(id));
        return (DictEstateChild) getByIdCriteria.uniqueResult();
    }
}
