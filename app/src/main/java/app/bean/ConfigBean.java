package app.bean;

import app.services.ConfigStandardService;
import core.orm.entities.ConfigStandard;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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

    @Max(300000)
    @Min(20000)
    @NotNull
    private Long longValue;

    /* nowy paramtetr*/
//    @NotNull
//    @NotEmpty
    @Length(max = 20)
    private String newName;

//    @NotNull
//    @NotEmpty
    @Length(max = 20)
    private String newValue;

//    @NotNull
//    @NotEmpty
    @Length(max = 20)
    private String newType;
    /* nowy parametr */

    @PostConstruct
    public void init() {
        configStandards = configStandardService.listConfigParams();
        selectedConfig = configStandards.get(0);
    }

    public void updateParameter() {
        selectedConfig.setValue(longValue.toString());
        configStandardService.updateConfig(selectedConfig );
    }

    public void saveParameter() {
        ConfigStandard standardConfig  = new ConfigStandard();
        standardConfig.setKey(getNewName());
        standardConfig.setValue(getNewValue());
        configStandardService.saveConfig(standardConfig);
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

    public Long getLongValue() {
        return longValue;
    }

    public void setLongValue(Long longValue) {
        this.longValue = longValue;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getNewType() {
        return newType;
    }

    public void setNewType(String newType) {
        this.newType = newType;
    }
}
