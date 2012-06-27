package core.orm.dao.impl;

import core.orm.dao.DeclarationDAO;
import core.orm.entities.Declaration;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
        declarationCriteria.add(Restrictions.like("user.login", login));
        return (List<Declaration>) declarationCriteria.list();
    }

    public Declaration saveDeclaration (Declaration declaration) {
        return (Declaration)getHibernateTemplate().save(declaration);
    }
}
