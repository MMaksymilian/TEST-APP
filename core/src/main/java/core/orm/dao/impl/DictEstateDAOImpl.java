package core.orm.dao.impl;

import core.orm.dao.DictEstateDAO;
import core.orm.entities.DeclarationRecordChild;
import core.orm.entities.estate.DictEstate;
import core.orm.entities.estate.DictEstateChild;
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
public class DictEstateDAOImpl extends BaseDAOImpl implements DictEstateDAO {

    public List<DictEstate> listDictEstateParent() {
        Criteria listCriteria = getSession().createCriteria(DictEstate.class);
        listCriteria.addOrder(Order.asc("value"));
//        Criteria associationCriteria = listCriteria.createCriteria("dictIndemnityChildren");
//        associationCriteria.addOrder(Order.desc("value"));
//        listCriteria.addOrder(Order.asc("dParent.value"));
        listCriteria.createAlias("dictEstateChildren", "dictEstateChildren");
        listCriteria.addOrder(Order.asc("dictEstateChildren.value"));
        return (List<DictEstate>) listCriteria.list();
    }

    @Override
    public void updateChild(DictEstateChild dictChildRecord) {
        getHibernateTemplate().saveOrUpdate(dictChildRecord);
    }

    @Override
    public List<DeclarationRecordChild> listDeclarationChildrendContainingEstate(DictEstate dictEstate) {
        Criteria listCriteria = getSession().createCriteria(DeclarationRecordChild.class);
        listCriteria.add(Restrictions.in("estate", new DictEstate[]{dictEstate}));
        return listCriteria.list();
    }

    public DictEstate getById(Long id) {
        Criteria getByIdCriteria = getSession().createCriteria(DictEstate.class);
        getByIdCriteria.add(Restrictions.idEq(id));
        return (DictEstate) getByIdCriteria.uniqueResult();
    }
}
