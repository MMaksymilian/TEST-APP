package core.orm.dao;

import core.orm.entities.indemnity.DictIndemnity;
import core.orm.entities.indemnity.DictIndemnityChild;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 06.07.12
 * Time: 14:29
 * To change this template use File | Settings | File Templates.
 */
public interface DictIndemnityDAO extends BaseDAO<DictIndemnity> {

    List<DictIndemnity> listDictIndemnityParent();
//    List<DictIndemnityChild> listDictIndemnityChildren(DictIndemnity dictIndemnity);
}
