package core.log;

import core.orm.dao.LogTableChangesDAO;
import core.orm.entities.log.LogTableChanges;
import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.Session;
import org.hibernate.type.Type;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian
 * Date: 03.07.12
 * Time: 20:29
 * To change this template use File | Settings | File Templates.
 */
//@Component
//@Transactional
public class LogInterceptor extends EmptyInterceptor {
//    private Session session;
    private Set inserts = new HashSet();
    private Set updates = new HashSet();
    private Set deletes = new HashSet();

    @Autowired
    private LogTableChangesDAO logTableChangesDAO;

//    public void setSession(Session session){
//        this.session = session;
//    }

    public void log(String action, LogInterface entity) {
        LogTableChanges logTableChanges = new LogTableChanges();
        logTableChanges.setAction(action);
        logTableChanges.setCreateDate(new DateTime());
        logTableChanges.setEntityName(entity.getClass().toString());
        logTableChanges.setDetail(entity.getLogDetail());
        logTableChangesDAO.saveLogTableChanges(logTableChanges);
    }

    @Override
    public boolean onSave(Object entity,Serializable id,
                          Object[] state,String[] propertyNames,Type[] types)
            throws CallbackException {

        System.out.println("onSave");
        if (entity instanceof LogInterface){
            inserts.add(entity);
        }
        return false;
    }

    @Override
    public boolean onFlushDirty(Object entity,Serializable id,
                                Object[] currentState,Object[] previousState,
                                String[] propertyNames,Type[] types) throws CallbackException {
        System.out.println("onFlushDirty");
        if (entity instanceof LogInterface){
            updates.add(entity);
        }
        return false;
    }

    @Override
    public void onDelete(Object entity, Serializable id,
                         Object[] state, String[] propertyNames,
                         Type[] types) {
        System.out.println("onDelete");
        if (entity instanceof LogInterface){
            deletes.add(entity);
        }
    }

    //called before commit into database
    public void preFlush(Iterator iterator) {
    }

    //called after committed into database
    public void postFlush(Iterator iterator) {
        System.out.println("postFlush");

        try{
            for (Iterator it = inserts.iterator(); it.hasNext();) {
                LogInterface entity = (LogInterface) it.next();
                System.out.println("postFlush - insert");
                log("Saved", entity);
            }
            for (Iterator it = updates.iterator(); it.hasNext();) {
                LogInterface entity = (LogInterface) it.next();
                System.out.println("postFlush - update");
                log("Updated", entity);
            }
            for (Iterator it = deletes.iterator(); it.hasNext();) {
                LogInterface entity = (LogInterface) it.next();
                System.out.println("postFlush - delete");
                log("Deleted", entity);
            }
        } finally {
            inserts.clear();
            updates.clear();
            deletes.clear();
        }
    }
}
