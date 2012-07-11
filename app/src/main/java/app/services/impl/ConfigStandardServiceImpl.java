package app.services.impl;

import app.services.ConfigStandardService;
import core.orm.dao.ConfigStandardDAO;
import core.orm.entities.ConfigStandard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 28.06.12
 * Time: 14:52
 * To change this template use File | Settings | File Templates.
 */
@Service("configStandardService")
@Transactional
public class ConfigStandardServiceImpl implements ConfigStandardService {

    @Autowired
    ConfigStandardDAO configStandardDAO;

    public List listConfigParams() {
        return configStandardDAO.listConfigParams();
    }

    public void updateConfig(ConfigStandard configStandard) {
        configStandardDAO.updateConfig(configStandard);
    }

    @Override
    public void saveConfig(ConfigStandard configStandard) {
        configStandardDAO .saveConfig(configStandard);
    }
}
