package app.services.impl;

import app.services.DictIndemnityService;
import core.orm.dao.DictIndemnityDAO;
import core.orm.entities.indemnity.DictIndemnity;
import core.orm.entities.indemnity.DictIndemnityChild;
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
@Service("dictIndemnityService")
@Transactional
public class DictIndemnityServiceImpl implements DictIndemnityService {

    @Autowired
    DictIndemnityDAO dictIndemnityDAO;

    public Map<DictIndemnity, List<DictIndemnityChild>> getAvailableEstates() {
        Map<DictIndemnity, List<DictIndemnityChild>> mapIndemnity = new LinkedHashMap<DictIndemnity, List<DictIndemnityChild>>();
        List<DictIndemnity> parentList = dictIndemnityDAO.listDictIndemnityParent();
        for(DictIndemnity dictIndemnity : parentList ) {
            List<DictIndemnityChild> dictIndemnityChildren = new ArrayList<DictIndemnityChild>();
            mapIndemnity.put(dictIndemnity, dictIndemnityChildren);
            for(DictIndemnityChild dictIndemnityChild : dictIndemnity.getDictIndemnityChildren()) {
                dictIndemnityChildren.add(dictIndemnityChild);
            }
        }
        return mapIndemnity;
    }

    public DictIndemnity getDictIndemnityById(Long id) {
        return dictIndemnityDAO.getById(id);
    }
}
