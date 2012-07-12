package app.bean;

import app.services.ConfigStandardService;
import core.orm.entities.ConfigStandard;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.access.AccessDeniedException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.validation.Valid;
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

    @PostConstruct
    public void init() {
        configStandards = configStandardService.listConfigParams();
    }

    public void updateParameter() {
        selectedConfig.setValue(longValue.toString());
        try {
            configStandardService.updateConfig(selectedConfig );
        } catch (AccessDeniedException accessDeniedException) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, accessDeniedException.getMessage(), accessDeniedException.getMessage()));
            accessDeniedException.printStackTrace();
        }
    }

    public void setSelectedConfig(ConfigStandard selectedConfig) {
        longValue = Long.valueOf((String) selectedConfig.getValue());
        this.selectedConfig = selectedConfig;
    }

    public List<ConfigStandard> getConfigStandards() {
        return configStandards;
    }

    public void setConfigStandards(List<ConfigStandard> configStandards) {
        this.configStandards = configStandards;
    }

    public ConfigStandard getSelectedConfig() {
        return selectedConfig;
    }

    public Long getLongValue() {
        return longValue;
    }

    public void setLongValue(Long longValue) {
        this.longValue = longValue;
    }

    public void setConfigStandardService(ConfigStandardService configStandardService) {
        this.configStandardService = configStandardService;
    }
}
