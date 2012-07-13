package app.bean;

import app.services.ConfigStandardService;
import core.orm.entities.ConfigStandard;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian
 * Date: 12.07.12
 * Time: 20:01
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@ViewScoped
public class ConfigAddBean implements Serializable {

    @ManagedProperty("#{configStandardService}")
    ConfigStandardService configStandardService;

    @NotNull
    @Length(max = 20)
    private String newName;

    @NotNull
    @Max(300000)
    @Min(20000)
    private Long newValue;

    @NotEmpty
    @Length(max = 20)
    private String newType;

    public void saveParameter() {
        ConfigStandard standardConfig  = new ConfigStandard();
        standardConfig.setKey(getNewName());
        standardConfig.setValue(getNewValue().toString());
        configStandardService.saveConfig(standardConfig);
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public Long getNewValue() {
        return newValue;
    }

    public void setNewValue(Long newValue) {
        this.newValue = newValue;
    }

    public String getNewType() {
        return newType;
    }

    public void setNewType(String newType) {
        this.newType = newType;
    }

    public void setConfigStandardService(ConfigStandardService configStandardService) {
        this.configStandardService = configStandardService;
    }
}
