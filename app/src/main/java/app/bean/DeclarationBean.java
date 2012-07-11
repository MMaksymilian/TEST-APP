package app.bean;

import app.services.DeclarationService;
import core.orm.entities.Declaration;
import org.hibernate.validator.constraints.Length;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
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
@ViewScoped
public class DeclarationBean implements Serializable {

    private Map <Declaration, TreeNode> declarationsMap;

    private TreeNode selectedNode;

    @ManagedProperty("#{declarationService}")
    private DeclarationService declarationService;

    @PostConstruct
    public void initMethod() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userLogin = auth.getName();
        declarationsMap = declarationService.listDeclarationsTreeForUser(userLogin);
    }

    public void setDeclarationService(DeclarationService declarationService) {
        this.declarationService = declarationService;
    }

    public Map<Declaration, TreeNode> getDeclarationsMap() {
        return declarationsMap;
    }

    public void setDeclarationsMap(Map<Declaration, TreeNode> declarationsMap) {
        this.declarationsMap = declarationsMap;
    }

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }
}
