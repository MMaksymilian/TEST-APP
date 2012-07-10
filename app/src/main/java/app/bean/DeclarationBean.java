package app.bean;

import app.services.DeclarationService;
import org.hibernate.validator.constraints.Length;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian Małek
 * Date: 29.06.12
 * Time: 09:06
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
public class DeclarationBean {

    @NotNull
//    @Length(min= 3, max= 10)
    private String name;

    @ManagedProperty("#{declarationService}")
    private DeclarationService declarationService;

    @PostConstruct
    public void initMethod() {
        declarationService.listDeclarationsTreeForUser("Rambo");
    }

/*    Ewentualnie można od razu z serwisu brać List<DeclarationData>*/
    public List<DeclarationData> declarationDataList() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userLogin = auth.getName();
        Map<Long, Map<Long, List<String[]>>> serviceTree = declarationService.getDeclarationIndemnityTreeForUser(userLogin);
        List<DeclarationData> tree = new ArrayList<DeclarationData>();
        for(Map.Entry<Long, Map<Long, List<String[]>>> entryDeclarations : serviceTree.entrySet()) {
            DefaultTreeNode root = new DefaultTreeNode("Root", null);
            DeclarationData declarationData = new DeclarationData();
            declarationData.setDeclarationId(entryDeclarations.getKey());
            declarationData.setDeclarationTree(root);
            tree.add(declarationData);
//            tree.put(entryDeclarations.getKey(), root);
            Map<Long, List<String[]>> parentMap = entryDeclarations.getValue();
            for(Map.Entry<Long, List<String[]>> treeEntry : parentMap.entrySet()) {
                List<String[]> treeBranch = treeEntry.getValue();
                boolean parentNode = true;
                TreeNode parentRecordNode = null;
                for(String[] node : treeBranch) {
                    if(parentNode) {
                        parentRecordNode = new DefaultTreeNode(node[1], root);
                    } else {
                        TreeNode childRecordNode = new DefaultTreeNode(node[1], parentRecordNode);
                    }
                    parentNode = false;
                }
            }
        }
        return tree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeclarationService getDeclarationService() {
        return declarationService;
    }

    public void setDeclarationService(DeclarationService declarationService) {
        this.declarationService = declarationService;
    }
}
