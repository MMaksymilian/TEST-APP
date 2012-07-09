package core.orm.dao.impl;

import core.orm.dao.DictIndemnityDAO;
import core.orm.entities.ConfigStandard;
import core.orm.entities.indemnity.DictIndemnity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 06.07.12
 * Time: 14:29
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class DictIndemnityDAOImpl extends BaseDAOImpl implements DictIndemnityDAO {

    public List<DictIndemnity> listDictIndemnityParent() {
        Criteria listCriteria = getSession().createCriteria(DictIndemnity.class, "dParent");
        listCriteria.createAlias("dictIndemnityChildren", "children");
//        listCriteria.addOrder(Order.asc("dParent.value"));
//        listCriteria.addOrder(Order.asc("children.value"));
        return (List<DictIndemnity>) listCriteria.list();
    }

    public DictIndemnity getById(Long id) {
        Criteria getByIdCriteria = getSession().createCriteria(DictIndemnity.class);
        getByIdCriteria.add(Restrictions.idEq(id));
        return (DictIndemnity) getByIdCriteria.uniqueResult();
    }
}
