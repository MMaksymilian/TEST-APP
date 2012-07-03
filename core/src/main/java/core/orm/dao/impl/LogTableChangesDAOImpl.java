package core.orm.dao.impl;

import core.orm.dao.LogTableChangesDAO;
import core.orm.entities.log.LogTableChanges;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian
 * Date: 03.07.12
 * Time: 20:12
 * To change this template use File | Settings | File Templates.
 */

/**
 * Nie jest @Repository specjalnie!
 */
public class LogTableChangesDAOImpl extends HibernateDaoSupport implements LogTableChangesDAO {

    @Override
    public void saveLogTableChanges(LogTableChanges logTableChanges) {
        getSession().save(logTableChanges);
    }
}
