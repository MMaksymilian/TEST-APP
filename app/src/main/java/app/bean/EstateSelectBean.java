package app.bean;

import core.orm.entities.estate.DictEstate;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian
 * Date: 15.07.12
 * Time: 14:10
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
//może ewentualnie request scoped
@ViewScoped
public class EstateSelectBean implements Serializable {

    @ManagedProperty("#{estateBean}")
    EstateBean estateBean;

    @ManagedProperty("#{estateAddBean}")
    EstateAddBean estateAddBean;

    private DictEstate selectedEstate;

    public void setEstateBean(EstateBean estateBean) {
        this.estateBean = estateBean;
    }

    public void setEstateAddBean(EstateAddBean estateAddBean) {
        this.estateAddBean = estateAddBean;
    }

    public void setSelectedEstate(DictEstate selectedEstate) {
        this.selectedEstate = selectedEstate;
        estateBean.setSelectedEstate(selectedEstate);
        if (selectedEstate != null) {
            estateBean.handleEstateChange();
        }
        estateAddBean.setSelectedEstate(selectedEstate);
    }

    public DictEstate getSelectedEstate() {
        return selectedEstate;
    }
}
