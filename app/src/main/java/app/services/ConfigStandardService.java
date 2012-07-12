package app.services;

import core.orm.entities.ConfigStandard;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 28.06.12
 * Time: 14:48
 * To change this template use File | Settings | File Templates.
 */
@Service("configStandardService")
@Transactional
public interface ConfigStandardService {
    List listConfigParams();

    void updateConfig(ConfigStandard configStandard);
    void saveConfig(ConfigStandard configStandard);
}
