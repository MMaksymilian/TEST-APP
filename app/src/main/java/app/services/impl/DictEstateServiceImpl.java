package app.services.impl;

import app.services.DictEstateService;
import core.orm.dao.DeclarationRecordChildDAO;
import core.orm.dao.DictEstateDAO;
import core.orm.entities.estate.DictEstate;
import core.orm.entities.estate.DictEstateChild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 06.07.12
 * Time: 15:04
 * To change this template use File | Settings | File Templates.
 */
@Service("dictEstateService")
@Transactional
public class DictEstateServiceImpl implements DictEstateService {

    @Autowired
    DictEstateDAO dictEstateDAO;

    @Autowired
    DeclarationRecordChildDAO declarationChildRecordDAO;

    public Map<DictEstate, List<DictEstateChild>> getAvailableEstates() {
        Map<DictEstate, List<DictEstateChild>> mapIndemnity = new LinkedHashMap<DictEstate, List<DictEstateChild>>();
        List<DictEstate> parentList = dictEstateDAO.listDictEstateParent();
        for(DictEstate dictEstate : parentList ) {
            List<DictEstateChild> estateChildren = new ArrayList<DictEstateChild>();
            mapIndemnity.put(dictEstate, estateChildren);
            for(DictEstateChild dictEstateChild : dictEstate.getDictEstateChildren()) {
                estateChildren.add(dictEstateChild);
            }
        }
        return mapIndemnity;
    }

    @Override
    public void updateChild(DictEstateChild dictChildRecord) {
        /*można ewentualnie zmienić na unique result, żeby nie brać całej listy, która może być długa*/
        if ( dictEstateDAO.listDeclarationChildrendContainingEstate(dictChildRecord).size() > 0) {
          System.out.println("jest użyte");
          //TODO  throw exception
        }
        dictEstateDAO.updateChild(dictChildRecord);
    }
}
