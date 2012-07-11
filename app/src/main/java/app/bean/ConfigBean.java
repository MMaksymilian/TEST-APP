package app.bean;

import app.services.ConfigStandardService;
import core.orm.entities.ConfigStandard;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
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

    @NotNull
    private String configKey;
    private String stringValue;

    @Max(300000)
    @NotNull
    private Long longValue;



    @PostConstruct
    public void init() {
        configStandards = configStandardService.listConfigParams();
        selectedConfig = configStandards.get(0);
    }

    public void updateParameter() {
        selectedConfig.setValue(longValue.toString());
        configStandardService.updateConfig(selectedConfig );
    }

    public List<ConfigStandard> getConfigStandards() {
        return configStandards;
    }

    public void setConfigStandards(List<ConfigStandard> configStandards) {
        this.configStandards = configStandards;
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
        longValue = Long.valueOf((String) selectedConfig.getValue());
        this.selectedConfig = selectedConfig;
    }

    public String getConfigKey() {
        return configKey;
    }

    public void setConfigKey(String configKey) {
        this.configKey = configKey;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public Long getLongValue() {
        return longValue;
    }

    public void setLongValue(Long longValue) {
        this.longValue = longValue;
    }
}
