package app.services.impl;

import app.services.DeclarationService;
import core.orm.dao.DeclarationDAO;
import core.orm.entities.Declaration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 27.06.12
 * Time: 14:28
 * To change this template use File | Settings | File Templates.
 */
@Service("declarationService")
@Transactional
public class DeclarationServiceImpl implements DeclarationService {

    @Autowired
    DeclarationDAO declarationDAO;

    public List<Declaration> getDeclarationsForUser (String login) {
       return declarationDAO.getDeclarationsForUser(login);
    }

    public Declaration saveDeclaration(Declaration declaration) {
        if (declaration.getUser().getId() == null) {
            //TODO znaleźć ID użytkownika i podstawić
        }
        return declarationDAO.saveDeclaration(declaration);
    }

    public List<List<List<String>>> getDeclarationIndemnityTreeForUser(String login) {
        List<List<List<String>>> childTree = declarationDAO.getEstateChildTreeForUser(login);
        List<List<List<String>>> parentTree = declarationDAO.getEstateParentTreeForUser(login);
        return null;
    }
}
