package app.services.impl;

import app.services.DictOwnershipService;
import core.orm.dao.DictOwnershipDAO;
import core.orm.entities.DictOwnership;
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
@Service("dictOwnershipService")
@Transactional
public class DictOwnershipServiceImpl implements DictOwnershipService {

    @Autowired
    DictOwnershipDAO dictOwnershipDAO;

    @Override
    public List<DictOwnership> listDictOwnerships() {
        return dictOwnershipDAO.listDictOwnerships();
    }
}
