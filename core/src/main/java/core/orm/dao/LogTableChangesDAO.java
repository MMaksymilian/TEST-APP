package core.orm.dao;

import core.orm.entities.log.LogTableChanges;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian
 * Date: 03.07.12
 * Time: 20:12
 * To change this template use File | Settings | File Templates.
 */
public interface LogTableChangesDAO {
    public void saveLogTableChanges(LogTableChanges logTableChanges);
}
