package core.orm.dao.impl;

import core.orm.dao.DictShareTypeDAO;
import core.orm.entities.DictShareType;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 28.06.12
 * Time: 14:46
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class DictShareTypeImpl extends BaseDAOImpl implements DictShareTypeDAO {

    public List<DictShareType> lisDictShareTypes() {
        Criteria criteria = getSession().createCriteria(DictShareType.class);
        return (List<DictShareType>) criteria.list();
    }
}
