package app.bean.config;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
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

    //TODO NAPISAĆ BY WARTOŚĆ BYŁA POBIERANA ZA KAŻDYM RAZEM Z BAZY DANYCH
    private Double maxCredit = 30000d;

    private Double minCredit = 20000d;

    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public Double getMaxCredit() {
        return maxCredit;
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
}
