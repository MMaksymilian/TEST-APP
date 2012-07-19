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
        String hql = "select d from Declaration d join d.declarationRecords dr where d.user.login = :uLogin " +
                " order by d.commitDate, dr.estate.value ";
        List<Declaration> declarations = session.createQuery(hql).setString("uLogin", login).list();
//        Criteria declarationCriteria = session.createCriteria(Declaration.class);
//        declarationCriteria.createAlias("user", "u");
//        declarationCriteria.add(Restrictions.like("u.login", login));
//        return (List<Declaration>)declarationCriteria.list();
        return declarations;
    }

    public Long saveDeclaration (Declaration declaration) {
        return (Long) getHibernateTemplate().save(declaration);
    }

    public Declaration getById(Long id) {
        Criteria getByIdCriteria = getSession().createCriteria(Declaration.class);
        getByIdCriteria.add(Restrictions.idEq(id));
        return (Declaration) getByIdCriteria.uniqueResult();
    }
}
