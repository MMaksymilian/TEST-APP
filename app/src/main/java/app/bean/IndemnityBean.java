package app.bean;

import app.services.DictIndemnityService;
import core.orm.entities.indemnity.DictIndemnity;
import core.orm.entities.indemnity.DictIndemnityChild;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 06.07.12
 * Time: 14:51
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@SessionScoped
public class IndemnityBean implements Serializable {

    @ManagedProperty("#{dictIndemnityService}")
    private DictIndemnityService dictIndemnityService;

    private DictIndemnity selectedEstate;
    private Map<DictIndemnity, List<DictIndemnityChild>> estatesMap;
    private List<DictIndemnity> mainEstates;
    private List<DictIndemnityChild> childEstates;

    @PostConstruct
    public void initMethod() {
        estatesMap = dictIndemnityService.getAvailableEstates();
        mainEstates = new ArrayList<DictIndemnity>();
        for(Map.Entry<DictIndemnity, List<DictIndemnityChild>> mainEstateEntry : estatesMap.entrySet()) {
            mainEstates.add(mainEstateEntry.getKey());
        }
    }
//    AjaxBehaviorEvent
    public void handleEstateChange () {
        childEstates = estatesMap.get(selectedEstate);
//        return null;
    }

    public void setDictIndemnityService(DictIndemnityService dictIndemnityService) {
        this.dictIndemnityService = dictIndemnityService;
    }

    public DictIndemnity getSelectedEstate() {
        return selectedEstate;
    }

    public void setSelectedEstate(DictIndemnity selectedEstate) {
        this.selectedEstate = selectedEstate;
    }

    public List<DictIndemnity> getMainEstates() {
        return mainEstates;
    }

    public void setMainEstates(List<DictIndemnity> mainEstates) {
        this.mainEstates = mainEstates;
    }

    public List<DictIndemnityChild> getChildEstates() {
        if (selectedEstate == null) {
            return (List<DictIndemnityChild>)estatesMap.values().toArray()[0];
        }
        return childEstates;
    }

    public void setChildEstates(List<DictIndemnityChild> childEstates) {
        this.childEstates = childEstates;
    }
}
