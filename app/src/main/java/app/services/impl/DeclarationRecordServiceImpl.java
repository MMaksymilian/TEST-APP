package app.services.impl;

import app.services.DeclarationRecordService;
import core.orm.dao.DeclarationRecordDAO;
import core.orm.entities.DeclarationRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 28.06.12
 * Time: 14:52
 * To change this template use File | Settings | File Templates.
 */
@Service("declarationRecordService")
@Transactional
public class DeclarationRecordServiceImpl implements DeclarationRecordService {
    @Autowired
    DeclarationRecordDAO declarationRecordDAO;

    @Override
    public List<DeclarationRecord> listMainDeclarations() {
        return declarationRecordDAO.listMainDeclarations();
    }
}
