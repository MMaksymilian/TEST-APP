package core.orm.dao.impl;

import core.orm.dao.DictOwnershipDAO;
import core.orm.entities.DictOwnership;
import core.orm.entities.indemnity.DictIndemnity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 28.06.12
 * Time: 14:45
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class DictOwnershipDAOImpl extends BaseDAOImpl implements DictOwnershipDAO {

    public List<DictOwnership> listDictOwnerships() {
        Criteria criteria =  getSession().createCriteria(DictOwnership.class);
        return (List<DictOwnership>) criteria.list();
    }

    public DictOwnership getById(Long id) {
        Criteria getByIdCriteria = getSession().createCriteria(DictOwnership.class);
        getByIdCriteria.add(Restrictions.idEq(id));
        return (DictOwnership) getByIdCriteria.uniqueResult();
    }
}
