package app.bean;

import app.services.DictEstateService;
import core.orm.entities.estate.DictEstate;
import core.orm.entities.estate.DictEstateChild;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
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
@ViewScoped
public class EstateBean implements Serializable {

    @ManagedProperty("#{dictEstateService}")
    private DictEstateService dictEstateService;

    private DictEstate selectedEstate;
    private Map<DictEstate, List<DictEstateChild>> estatesMap;
    private List<SelectItem> mainEstates;
    private List<DictEstateChild> childEstates;

    @PostConstruct
    public void initMethod() {
        estatesMap = dictEstateService.getAvailableEstates();

        mainEstates = new ArrayList<SelectItem>();
        for(Map.Entry<DictEstate, List<DictEstateChild>> mainEstateEntry : estatesMap.entrySet()) {
            mainEstates.add(new SelectItem(mainEstateEntry.getKey(), mainEstateEntry.getKey().getValue()));
        }

        selectedEstate = (DictEstate) estatesMap.keySet().toArray()[0];
        handleEstateChange();
    }
//    AjaxBehaviorEvent
    public void handleEstateChange () {
        childEstates = estatesMap.get(selectedEstate);
//        return null;
    }

    public DictEstate getSelectedEstate() {
        return selectedEstate;
    }

    public void setSelectedEstate(DictEstate selectedEstate) {
        this.selectedEstate = selectedEstate;
    }

    public List<SelectItem> getMainEstates() {
        return mainEstates;
    }

    public void setMainEstates(List<SelectItem> mainEstates) {
        this.mainEstates = mainEstates;
    }

    public List<DictEstateChild> getChildEstates() {
        return childEstates;
    }

    public void setChildEstates(List<DictEstateChild> childEstates) {
        this.childEstates = childEstates;
    }

    public void setDictEstateService(DictEstateService dictEstateService) {
        this.dictEstateService = dictEstateService;
    }
}
