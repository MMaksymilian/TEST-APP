package core.orm.dao.impl;

import core.orm.dao.DeclarationDAO;
import core.orm.entities.Declaration;
import core.orm.entities.indemnity.DictIndemnity;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 27.06.12
 * Time: 14:33
 * To change this template use File | Settings | File Templates.
 */
@Repository
@Transactional
public class DeclarationDAOImpl extends BaseDAOImpl implements DeclarationDAO {
    public List<Declaration> getDeclarationsForUser(String login) {
        Criteria declarationCriteria = getSession().createCriteria(Declaration.class);
        declarationCriteria.createAlias("user", "u");
        declarationCriteria.add(Restrictions.like("u.login", login));
        return (List<Declaration>) declarationCriteria.list();
    }

    public Declaration saveDeclaration (Declaration declaration) {
        return (Declaration)getHibernateTemplate().save(declaration);
    }

    @Override
    public List<List<String>> getEstateParentTreeForUserAndDeclaration(String login, Long declarationId) {
        List<List<String>> resultList = new ArrayList<List<String>>();
        Criteria declarationCriteria = getSession().createCriteria(DictIndemnity.class, "ind");
        declarationCriteria.createAlias("user", "u");
        declarationCriteria.createAlias("declartionRecords", "dr");
        declarationCriteria.createAlias("dr.indemnity", "ind");
        declarationCriteria.add(Restrictions.like("u.login", login));
        declarationCriteria.add(Restrictions.like("dr.id", declarationId));
        declarationCriteria.add(Restrictions.isNull("dr.parentRecordId"));
        /*może być źle!*/
        declarationCriteria.addOrder(Order.asc("id"));
        declarationCriteria.addOrder(Order.asc("dr.id"));
        declarationCriteria.addOrder(Order.asc("ind.value"));
        return resultList;
    }

    @Override
    public List<List<List<String>>> getEstateParentTreeForUser(String login) {
        List<List<List<String>>> resultList = new ArrayList<List<List<String>>>();
        Criteria declarationCriteria = getSession().createCriteria(Declaration.class);
        declarationCriteria.createAlias("user", "u");
        declarationCriteria.createAlias("declartionRecords", "dr");
        declarationCriteria.createAlias("dr.indemnity", "ind");
        declarationCriteria.add(Restrictions.like("u.login", login));
//        declarationCriteria.add(Restrictions.like("dr.id", declarationId));
        declarationCriteria.add(Restrictions.isNull("dr.parentRecordId"));
        /*może być źle!*/
        declarationCriteria.addOrder(Order.asc("id"));
        declarationCriteria.addOrder(Order.asc("dr.id"));
        declarationCriteria.addOrder(Order.asc("ind.value"));
        return resultList;
    }

    @Override
    public List<List<String>> getEstateChildTreeForUserAndDeclaration(String login, Long declarationId) {
        List<List<String>> resultList = new ArrayList<List<String>>();
        Criteria declarationCriteria = getSession().createCriteria(Declaration.class);
        declarationCriteria.createAlias("user", "u");
        declarationCriteria.createAlias("declartionRecords", "dr");
        declarationCriteria.createAlias("dr.indemnity", "ind");
        declarationCriteria.add(Restrictions.like("u.login", login));
        declarationCriteria.add(Restrictions.like("dr.id", declarationId));
        declarationCriteria.add(Restrictions.isNotNull("dr.parentRecordId"));
        /*może być źle!*/
        declarationCriteria.addOrder(Order.asc("id"));
        declarationCriteria.addOrder(Order.asc("dr.parentRecordId"));
        declarationCriteria.addOrder(Order.asc("ind.value"));
        return resultList;
    }

    @Override
    public List<List<List<String>>> getEstateChildTreeForUser(String login) {
        List<List<List<String>>> resultList = new ArrayList<List<List<String>>>();
        Criteria declarationCriteria = getSession().createCriteria(Declaration.class);
        declarationCriteria.createAlias("user", "u");
        declarationCriteria.createAlias("declartionRecords", "dr");
        declarationCriteria.createAlias("dr.indemnity", "ind");
        declarationCriteria.add(Restrictions.like("u.login", login));
//        declarationCriteria.add(Restrictions.like("dr.id", declarationId));
        declarationCriteria.add(Restrictions.isNotNull("dr.parentRecordId"));
        /*może być źle!*/
        declarationCriteria.addOrder(Order.asc("id"));
        declarationCriteria.addOrder(Order.asc("dr.parentRecordId"));
        declarationCriteria.addOrder(Order.asc("ind.value"));

        return null;
    }

}
