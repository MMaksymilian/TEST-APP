package core.orm.dao;

import core.orm.entities.ConfigStandard;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 28.06.12
 * Time: 14:38
 * To change this template use File | Settings | File Templates.
 */
public interface ConfigStandardDAO extends BaseDAO<ConfigStandard> {
    List listConfigParams();
    String getParameterByKey(String name);

    void updateConfig(ConfigStandard configStandard);
    void saveConfig(ConfigStandard configStandard);
}
