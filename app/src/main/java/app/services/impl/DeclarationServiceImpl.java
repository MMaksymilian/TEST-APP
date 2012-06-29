package app.services.impl;

import app.services.DeclarationService;
import core.orm.dao.DeclarationDAO;
import core.orm.entities.Declaration;
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

    public List<Declaration> getDeclarationsForUser (String login) {
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
        List<Object[]> childRecords= declarationDAO.getEstateChildTreeForUser(login);
        List<Object[]> parentRecords = declarationDAO.getEstateParentTreeForUser(login);
        ArrayList<Object[]> childArrayRecords = new ArrayList<Object[]>(childRecords);
        ArrayList<Object[]> parentArrayRecords = new ArrayList<Object[]>(parentRecords);
        int childRecordsIndex = 0;
        int parentRecordsIndex = 0;
        Map<Long, List<String>> mergedRecords = new LinkedHashMap<Long, List<String>>();
        for(Object[] parentObject : parentArrayRecords) {
            Object[] recordData = parentArrayRecords.get(parentRecordsIndex);
            if (!mergedRecords.containsKey((Long)recordData[0])) {

            }
            List<String> declarationRecords = new ArrayList<String>();
            mergedRecords.put((Long)recordData[0], declarationRecords);
            while(childArrayRecords.get(childRecordsIndex)[1].equals(recordData[1])) {
                declarationRecords.add((String)recordData[2]);
                childRecordsIndex++;
            }
            parentRecordsIndex++;
        }
//        Map<Long, Map<Long, List<String[]>>> treeParent =  rewriteFromResultToMap(parentRecords);
//        Map<Long, Map<Long, List<String[]>>> treeChild = rewriteFromResultToMap(childRecords);
//        Map<Long, Map<Long, List<String[]>>> resultTree = mergeMaps(treeParent, treeChild);
        return null;
    }

    private Map<Long, Map<Long, List<String[]>>> mergeMaps(Map<Long, Map<Long, List<String[]>>> treeParent, Map<Long, Map<Long, List<String[]>>> treeChild) {
        Map<Long, Map<Long, List<String[]>>> merged = new LinkedHashMap<Long, Map<Long, List<String[]>>>();
        for (Map.Entry<Long, Map<Long, List<String[]>>> entry : treeParent.entrySet()) {
          Long declarationId = entry.getKey();
          Map<Long, List<String[]>> declarationParentRecords = entry.getValue();
          Map<Long, List<String[]>> declarationChildRecords = treeChild.get(declarationId);
          Map<Long, List<String[]>> declarationRecords = new LinkedHashMap<Long, List<String[]>>();
          for(Map.Entry<Long, List<String[]>> parentRecord : declarationParentRecords.entrySet()) {
              Long parentRecordId = parentRecord.getKey();
//              declarationRecords.put(pa)
//              for(declarationChildRecords.get(parentRecordId)) {
//
//              }

          }
        }
        return merged;
    }

//    private Map<Long, Map<Long, List<String[]>>> rewriteFromResultToMap(List<Object[]> records) {
//        Map<Long, Map<Long, List<String[]>>> map = new LinkedHashMap<Long, Map<Long, List<String[]>>>();
//        for (Object[] childRecordData : records) {
//            if (map.containsKey((Long)childRecordData[0])) {
//                Map<Long, List<String[]>> parentRecordsMap = map.get((Long)childRecordData[0]);
//                insertToTreeForDeclaration(childRecordData, parentRecordsMap);
//            } else {
//                Map<Long, List<String[]>> parentRecordsMap = new LinkedHashMap<Long, List<String[]>>();
//                insertToTreeForDeclaration(childRecordData, parentRecordsMap);
//                map.put((Long)childRecordData[0], parentRecordsMap);
//            }
//        }
//        return map;
//    }
//
//    private void insertToTreeForDeclaration(Object[] childRecordData, Map<Long, List<String[]>> parentRecordsMap) {
//        if (parentRecordsMap.containsKey((Long)childRecordData[1])) {
//            parentRecordsMap.get((Long)childRecordData[1]).add(new String[]{((Long)childRecordData[1]).toString(), (String) childRecordData[2]});
//        } else {
//            List<String[]> recordsInfoList = new ArrayList<String[]>();
//            recordsInfoList.add(new String[] { ((Long)childRecordData[1]).toString() , (String)childRecordData[2]});
//            parentRecordsMap.put((Long)childRecordData[1],recordsInfoList );
//        }
//    }
}
