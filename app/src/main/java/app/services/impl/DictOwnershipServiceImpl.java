package app.services.impl;

import core.orm.dao.DictOwnershipDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 28.06.12
 * Time: 14:53
 * To change this template use File | Settings | File Templates.
 */
@Service("dictOwnershipService")
@Transactional
public class DictOwnershipServiceImpl {

    @Autowired
    DictOwnershipDAO dictOwnershipDAO;
}