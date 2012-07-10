package core.orm.dao.impl;

import core.orm.dao.DeclarationDAO;
import core.orm.entities.ConfigStandard;
import core.orm.entities.Declaration;
import core.orm.entities.core.BaseEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 27.06.12
 * Time: 14:33
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class DeclarationDAOImpl extends BaseDAOImpl implements DeclarationDAO {
    public List<Declaration> getDeclarationsForUser(String login) {
        Session session = getSession();
        session.enableFilter("onlyParentDeclartionRecordsFilter");
        Criteria declarationCriteria = session.createCriteria(Declaration.class);
        declarationCriteria.createAlias("user", "u");
        declarationCriteria.add(Restrictions.like("u.login", login));
//        association.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
        return (List<Declaration>)declarationCriteria.list();
    }

    public Declaration saveDeclaration (Declaration declaration) {
        return (Declaration)getHibernateTemplate().save(declaration);
    }

    public List<Object[]> getEstateParentTreeForUser(String login) {
        String hql = "select d.id, dr.id, ind.value from Declaration d join d.declarationRecords dr " +
                " join dr.indemnity ind where d.user.login = :Slogin and dr.parentRecordId.id is null " +
                " order by d.id, dr.id , ind.value ";
        List<Object[]> parentRecords = getSession().createQuery(hql).setString("Slogin", login).list();
        return parentRecords;
    }

    public List<Object[]> getEstateChildTreeForUser(String login) {
        String hql = "select d.id, dr.parentRecordId.id , ind.value from Declaration d join d.declarationRecords dr " +
                " join dr.indemnity ind where d.user.login = :Slogin and dr.parentRecordId.id is not null " +
                " order by d.id, dr.parentRecordId.id , ind.value ";
        List<Object[]> childRecords = getSession().createQuery(hql).setString("Slogin", login).list();
        return childRecords;
    }

    public Declaration getById(Long id) {
        Criteria getByIdCriteria = getSession().createCriteria(Declaration.class);
        getByIdCriteria.add(Restrictions.idEq(id));
        return (Declaration) getByIdCriteria.uniqueResult();
    }
}
