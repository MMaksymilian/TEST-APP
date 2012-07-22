package app.bean.admin;

import app.exception.service.ChildIsUsedException;
import app.model.BaseEntityDataModel;
import app.services.DictEstateService;
import core.orm.entities.estate.DictEstate;
import core.orm.entities.estate.DictEstateChild;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: USER
 * Date: 20.07.12
 * Time: 13:17
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@ViewScoped
public class AdminEditEstate implements Serializable {

    @ManagedProperty("#{dictEstateService}")
    DictEstateService dictEstateService;

    BaseEntityDataModel<DictEstate> recordModel;

    List<DictEstateChild> childrenList;

    DictEstate selectRecord;

    DictEstateChild selectedRecordChild;

    @PostConstruct
    public void initMethod() {
        refreshDeclarationRecordList();
    }

    public void refreshDeclarationRecordList() {
        Map<DictEstate, List<DictEstateChild>> declarationRecordMap = dictEstateService.getAvailableEstates();
        if (declarationRecordMap.size() > 0) {
            recordModel = new BaseEntityDataModel<DictEstate>();
            for ( Iterator it =  declarationRecordMap.keySet().iterator();it.hasNext(); ) {
                DictEstate dict = (DictEstate)it.next();
                recordModel.getRecordList().add(dict);
            }
            if (getSelectRecord() == null) {
                setSelectRecord(recordModel.getRecordList().get(0));
            }
            childrenList = declarationRecordMap.get(getSelectRecord());
        }
    }

    public void setSelectRecord(DictEstate selectRecord) {
        this.selectRecord = selectRecord;
    }

    public void saveRecordChild() {
        try {
            dictEstateService.updateChild(selectedRecordChild);
        } catch (ChildIsUsedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            FacesContext context = FacesContext.getCurrentInstance();
            FacesContext facesContext = FacesContext.getCurrentInstance();
            Locale locale = facesContext.getViewRoot().getLocale();
            ResourceBundle bundle = ResourceBundle.getBundle("message.messages", locale);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, bundle.getString("exception.admin.estate.used"), bundle.getString("exception.admin.estate.used")));
        }
        refreshDeclarationRecordList();
    }

    /*GETTERy i SETTERy*/

    public BaseEntityDataModel<DictEstate> getRecordModel() {
        return recordModel;
    }

    public void setRecordModel(BaseEntityDataModel<DictEstate> recordModel) {
        this.recordModel = recordModel;
    }

    public void setDictEstateService(DictEstateService dictEstateService) {
        this.dictEstateService = dictEstateService;
    }

    public DictEstate getSelectRecord() {
        return selectRecord;
    }

    public List<DictEstateChild> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<DictEstateChild> childrenList) {
        this.childrenList = childrenList;
    }

    public DictEstateChild getSelectedRecordChild() {
        return selectedRecordChild;
    }

    public void setSelectedRecordChild(DictEstateChild selectedRecordChild) {
        this.selectedRecordChild = selectedRecordChild;
    }
}


