package app.services.impl;

import app.services.DeclarationService;
import core.orm.dao.AppUserDAO;
import core.orm.dao.DeclarationDAO;
import core.orm.entities.AppUser;
import core.orm.entities.Declaration;
import core.orm.entities.DeclarationRecord;
import core.orm.entities.DeclarationRecordChild;
import org.joda.time.DateTime;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    AppUserDAO appUserDAO;

    @Override
    public List<Declaration> getDeclarationsForUser(String login) {
        return declarationDAO.getDeclarationsForUser(login);
    }

    @Override
    public Long saveDeclaration(Declaration declaration) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userLogin = auth.getName();
        AppUser user = appUserDAO.getUserByLogin(userLogin);
        declaration.setUser(user);
        declaration.setCommitDate(new DateTime());

        return declarationDAO.saveDeclaration(declaration);
    }

    @Override
    public Map<Declaration, TreeNode> listDeclarationsTreeForUser(String login) {
        Map<Declaration, TreeNode> declarationMap = new LinkedHashMap<Declaration, TreeNode>();
        List<Declaration> declarations = getDeclarationsForUser(login);
        for (Declaration singleDeclaration : declarations) {
            TreeNode root = new DefaultTreeNode("root", null);
            for (DeclarationRecord parentRecord : singleDeclaration.getDeclarationRecords()) {
                TreeNode parent = new DefaultTreeNode(parentRecord,root);
                for (DeclarationRecordChild childRecord : parentRecord.getDeclarationRecordChildren()) {
                    TreeNode child = new DefaultTreeNode(childRecord, parent);
                }
            }
            declarationMap.put(singleDeclaration, root);
        }
        return declarationMap;
    }
}
