package core.orm.dao.impl;

import core.orm.dao.ConfigStandardDAO;
import core.orm.entities.AppUser;
import core.orm.entities.ConfigStandard;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 28.06.12
 * Time: 14:42
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ConfigStandardDAOImpl extends BaseDAOImpl implements ConfigStandardDAO {

    public List<ConfigStandard> listConfigParams() {
        Criteria criteria = getSession().createCriteria(ConfigStandard.class);
        return (List<ConfigStandard>) criteria.list();
    }

    public void updateConfig(ConfigStandard configStandard) {
        getHibernateTemplate().update(configStandard);
    }

    public void saveConfig(ConfigStandard configStandard) {
        getHibernateTemplate().save(configStandard);
    }

    public ConfigStandard getById(Long id) {
        Criteria getByIdCriteria = getSession().createCriteria(ConfigStandard.class);
        getByIdCriteria.add(Restrictions.idEq(id));
        return (ConfigStandard) getByIdCriteria.uniqueResult();
    }
}
