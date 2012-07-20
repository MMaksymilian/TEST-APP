package core.orm.dao.impl;

import core.orm.dao.DeclarationRecordDAO;
import core.orm.entities.ConfigStandard;
import core.orm.entities.DeclarationRecord;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 28.06.12
 * Time: 14:44
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class DeclarationRecordDAOImpl extends BaseDAOImpl implements DeclarationRecordDAO {
    public DeclarationRecord getById(Long id) {
        Criteria getByIdCriteria = getSession().createCriteria(DeclarationRecord.class);
        getByIdCriteria.add(Restrictions.idEq(id));
        return (DeclarationRecord) getByIdCriteria.uniqueResult();
    }

    @Override
    public List<DeclarationRecord> listMainDeclarations() {
        Criteria getListCriteria = getSession().createCriteria(DeclarationRecord.class);
        return getListCriteria.list();
    }
}
