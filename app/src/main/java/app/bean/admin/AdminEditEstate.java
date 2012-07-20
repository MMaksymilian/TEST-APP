package app.bean.admin;

import app.services.DictEstateService;
import core.orm.entities.estate.DictEstate;
import core.orm.entities.estate.DictEstateChild;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

    List<DictEstate> recordList;

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
            recordList = new ArrayList<DictEstate>();
            for ( Iterator it =  declarationRecordMap.keySet().iterator();it.hasNext(); ) {
                DictEstate dict = (DictEstate)it.next();
                recordList.add(dict);
            }
            setSelectRecord(recordList.get(0));
            childrenList = declarationRecordMap.get(getSelectRecord());
        }
    }

    public void setSelectRecord(DictEstate selectRecord) {
        this.selectRecord = selectRecord;
    }

    public void saveRecordChild() {
        dictEstateService.updateChild(selectedRecordChild);
    }

    /*GETTERy i SETTERy*/

    public List<DictEstate> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<DictEstate> recordList) {
        this.recordList = recordList;
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
