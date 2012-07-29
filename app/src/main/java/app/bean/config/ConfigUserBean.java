package app.bean.config;

import app.services.ConfigStandardService;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.validation.constraints.Digits;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 11.07.12
 * Time: 15:07
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean(eager = true)
@ApplicationScoped
public class ConfigUserBean {
    private String dateFormat = "MM/dd/yyyy";

    private Double maxCredit;

    /*TODO mozna sprobowac wstrzyknac configUserBean do admin-a(configBean) i tam bezposrednio zmienic maxCredit, zeby nie ciagnac za kazdym razem z bazy*/
    @ManagedProperty("#{configStandardService}")
    private ConfigStandardService configStandardService;

    private Double minCredit = 20000d;

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public Double getMaxCredit() {
        return Double.valueOf(configStandardService.getParameterByKey("MAX_CREDIT"));
    }

    public void setMaxCredit(Double maxCredit) {
        this.maxCredit = maxCredit;
    }

    public Double getMinCredit() {
        return minCredit;
    }

    public void setMinCredit(Double minCredit) {
        this.minCredit = minCredit;
    }

    public void setConfigStandardService(ConfigStandardService configStandardService) {
        this.configStandardService = configStandardService;
    }
}
