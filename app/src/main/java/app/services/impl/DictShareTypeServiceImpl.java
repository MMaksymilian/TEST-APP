package app.services.impl;

import app.services.DictShareTypeService;
import core.orm.dao.DictShareTypeDAO;
import core.orm.entities.DictShareType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 28.06.12
 * Time: 14:53
 * To change this template use File | Settings | File Templates.
 */
@Service("dictShareTypeService")
@Transactional
public class DictShareTypeServiceImpl implements DictShareTypeService {

    @Autowired
    DictShareTypeDAO dictShareTypeDAO;

    @Override
    public List<DictShareType> listDictShareTypes() {
        return dictShareTypeDAO.lisDictShareTypes();
    }
}
