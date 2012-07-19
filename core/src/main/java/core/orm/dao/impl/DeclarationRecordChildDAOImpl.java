package core.orm.dao.impl;

import core.orm.dao.DeclarationRecordChildDAO;
import core.orm.entities.DeclarationRecordChild;
import core.orm.entities.DictShareType;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: USER
 * Date: 19.07.12
 * Time: 09:22
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class DeclarationRecordChildDAOImpl extends BaseDAOImpl implements DeclarationRecordChildDAO {

    @Override
    public DeclarationRecordChild getById(Long id) {
        Criteria getByIdCriteria = getSession().createCriteria(DeclarationRecordChild.class);
        getByIdCriteria.add(Restrictions.idEq(id));
        return (DeclarationRecordChild) getByIdCriteria.uniqueResult();
    }
}
