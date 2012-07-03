package app.dao;

import core.orm.dao.ConfigStandardDAO;
import core.orm.entities.ConfigStandard;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 03.07.12
 * Time: 14:49
 * To change this template use File | Settings | File Templates.
 */
public class ConfigStandardDAOTest extends AbstractTest {

    @Autowired
    ConfigStandardDAO configStandardDAO;

    @Test
    public void getParameters() {
        List<ConfigStandard> configStandardList = configStandardDAO.listConfigParams();
        assertTrue(configStandardList.size() > 0);
//        assertTrue("Błąd nie zgadza się", configStandardList.size() == 4);
    }

    @Test
    public void  saveSomeConfig() {
        ConfigStandard configStandard = new ConfigStandard();
        configStandard.setKey("MAX_CREDIT");
        configStandard.setValue("200");
        configStandardDAO.saveConfig(configStandard);
    }
}
