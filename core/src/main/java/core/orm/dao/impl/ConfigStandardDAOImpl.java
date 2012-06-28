package core.orm.dao.impl;

import core.orm.dao.ConfigStandardDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 28.06.12
 * Time: 14:42
 * To change this template use File | Settings | File Templates.
 */
@Repository
@Transactional
public class ConfigStandardDAOImpl extends BaseDAOImpl implements ConfigStandardDAO {
}
