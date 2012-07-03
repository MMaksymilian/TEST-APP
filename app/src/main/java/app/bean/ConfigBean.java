package app.bean;

import app.services.ConfigStandardService;
import core.orm.entities.ConfigStandard;
import sun.security.krb5.Config;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 03.07.12
 * Time: 09:49
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@ViewScoped
public class ConfigBean implements Serializable {

    @ManagedProperty("#{configStandardService}")
    ConfigStandardService configStandardService;

    private ConfigStandard selectedConfig;
    private List<ConfigStandard> configStandards;

    @PostConstruct
    public void init() {
        configStandards = configStandardService.listConfigParams();
    }

    public List<ConfigStandard> getConfigStandards() {
        return configStandards;
    }

    public void setConfigStandards(List<ConfigStandard> configStandards) {
        this.configStandards = configStandards;
    }

    public void updateParameter(ConfigStandard configStandard) {
        configStandardService.updateConfig(configStandard );
    }
    public ConfigStandardService getConfigStandardService() {
        return configStandardService;
    }

    public void setConfigStandardService(ConfigStandardService configStandardService) {
        this.configStandardService = configStandardService;
    }

    public ConfigStandard getSelectedConfig() {
        return selectedConfig;
    }

    public void setSelectedConfig(ConfigStandard selectedConfig) {
        this.selectedConfig = selectedConfig;
    }

}
