package app.model;

import core.orm.entities.core.BaseEntity;
import core.orm.entities.estate.DictEstate;
import org.primefaces.model.SelectableDataModel;

import javax.faces.model.ListDataModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian
 * Date: 22.07.12
 * Time: 11:17
 * To change this template use File | Settings | File Templates.
 */
public class BaseEntityDataModel<T extends BaseEntity> extends ListDataModel<T> implements SelectableDataModel<T> {

    List<T> recordList;

    public BaseEntityDataModel() {
        recordList = new ArrayList<T>();
        setWrappedData(recordList);
    }

    @Override
    public Object getRowKey(T object) {
        return object.getId();
    }

    /*TODO DOPISAĆ KOD KTÓRY BĘDZIE SKUTECZNY PRZY DUŻEJ LICZBIE DANYCH BRANYCH Z DB*/
    @Override
    public T getRowData(String rowKey) {
        T currentRow = null;
        for (T dictEstate : recordList) {
            if (dictEstate.getId().equals(Long.getLong(rowKey))) {
                currentRow = dictEstate;
                break;
            }
        }
        return currentRow;
    }

    public List<T> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<T> recordList) {
        this.recordList = recordList;
    }
}
