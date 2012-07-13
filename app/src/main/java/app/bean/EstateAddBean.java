package app.bean;

import app.services.DictOwnershipService;
import app.services.DictShareTypeService;
import core.orm.entities.DictOwnership;
import core.orm.entities.DictShareType;
import core.orm.entities.estate.DictEstate;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: USER
 * Date: 13.07.12
 * Time: 10:47
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@ViewScoped
public class EstateAddBean implements Serializable {

    private List<DictEstate> estateList;

    private Long value;

    private List<DictShareType> shareTypeList;

    private List<DictOwnership> ownershipList;

    @PostConstruct
    public void initMethod() {

    }

    public List<DictEstate> getEstateList() {
        return estateList;
    }

    public void setEstateList(List<DictEstate> estateList) {
        this.estateList = estateList;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public List<DictOwnership> getOwnershipList() {
        return ownershipList;
    }

    public void setOwnershipList(List<DictOwnership> ownershipList) {
        this.ownershipList = ownershipList;
    }

    public List<DictShareType> getShareTypeList() {
        return shareTypeList;
    }

    public void setShareTypeList(List<DictShareType> shareTypeList) {
        this.shareTypeList = shareTypeList;
    }
}
