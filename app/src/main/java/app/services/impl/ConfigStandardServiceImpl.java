package app.services.impl;

import core.orm.dao.ConfigStandardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 28.06.12
 * Time: 14:52
 * To change this template use File | Settings | File Templates.
 */
@Service("configStandardService")
@Transactional
public class ConfigStandardServiceImpl {

    @Autowired
    ConfigStandardDAO configStandardDAO;
}
