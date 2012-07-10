package app.services.impl;

import app.services.DeclarationService;
import core.orm.dao.DeclarationDAO;
import core.orm.entities.Declaration;
import org.primefaces.model.TreeNode;
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
 * Date: 27.06.12
 * Time: 14:28
 * To change this template use File | Settings | File Templates.
 */
@Service("declarationService")
@Transactional
public class DeclarationServiceImpl implements DeclarationService {

    @Autowired
    DeclarationDAO declarationDAO;

    public List<Declaration> getDeclarationsForUser(String login) {
        return declarationDAO.getDeclarationsForUser(login);
    }

    public Declaration saveDeclaration(Declaration declaration) {
        if (declaration.getUser().getId() == null) {
            //TODO znaleźć ID użytkownika i podstawić
        }
        return declarationDAO.saveDeclaration(declaration);
    }

    public Map<Long, Map<Long, List<String[]>>> getDeclarationIndemnityTreeForUser(String login) {
        /*TODO można było użyć connect by byłoby wygodnie, ale to tylko dla Oracle*/
        List<Object[]> childRecords = declarationDAO.getEstateChildTreeForUser(login);
        List<Object[]> parentRecords = declarationDAO.getEstateParentTreeForUser(login);
        ArrayList<Object[]> childArrayRecords = new ArrayList<Object[]>(childRecords);
        ArrayList<Object[]> parentArrayRecords = new ArrayList<Object[]>(parentRecords);
        int childRecordsIndex = 0;
        Map<Long, Map<Long, List<String[]>>> mergedRecords = new LinkedHashMap<Long, Map<Long, List<String[]>>>();
        Map<Long, List<String[]>> declarationRecords = null;
        for (Object[] parentObject : parentArrayRecords) {
            if (!mergedRecords.containsKey((Long) parentObject[0])) {
                declarationRecords = new LinkedHashMap<Long, List<String[]>>();
                mergedRecords.put((Long) parentObject[0], declarationRecords);
            }
            if (!declarationRecords.containsKey((Long) parentObject[1])) {
                String[] dataInfo = new String[2];
                dataInfo[0] = ((Long) parentObject[1]).toString();
                dataInfo[1] = (String) parentObject[2];
                List<String[]> dataInfoList = new ArrayList<String[]>();
                dataInfoList.add(dataInfo);
                declarationRecords.put((Long) parentObject[1], dataInfoList);
            }
            for (; childArrayRecords.size() > childRecordsIndex && childArrayRecords.get(childRecordsIndex)[0].equals(parentObject[0])
                    && childArrayRecords.get(childRecordsIndex)[1].equals(parentObject[1]); childRecordsIndex++) {
                String[] dataInfo = new String[2];
                dataInfo[1] = (String) childArrayRecords.get(childRecordsIndex)[2];
                declarationRecords.get((Long) parentObject[1]).add(dataInfo);
            }
        }
        return mergedRecords;
    }

    @Override
    public Map<Declaration, TreeNode> listDeclarationsTreeForUser(String login) {
        List<Declaration> declarations = getDeclarationsForUser(login);
        return null;
    }
}
