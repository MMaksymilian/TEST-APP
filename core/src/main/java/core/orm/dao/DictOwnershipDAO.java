package core.orm.dao;

import core.orm.entities.DictOwnership;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 28.06.12
 * Time: 14:38
 * To change this template use File | Settings | File Templates.
 */
public interface DictOwnershipDAO extends BaseDAO<DictOwnership> {

    List<DictOwnership> listDictOwnerships();
}
