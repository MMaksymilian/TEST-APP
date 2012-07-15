package app.bean;

import app.bean.config.ConfigUserBean;
import app.bean.session.UserSessionBean;
import core.orm.entities.Declaration;
import core.orm.entities.DeclarationRecord;
import core.orm.entities.DeclarationRecordChild;
import core.orm.entities.estate.DictEstate;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Maksymilian
 * Date: 15.07.12
 * Time: 13:37
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@ViewScoped
public class EstateAddBean implements Serializable {

    @ManagedProperty("#{userSessionBean}")
    private UserSessionBean userSessionBean;

    private Declaration declaration;

    private DeclarationRecord currentMainEstate = new DeclarationRecord();

    private DeclarationRecordChild currentChildEstate = new DeclarationRecordChild();

    private TreeNode declarationTree;

    private boolean editChild;

    private boolean addChild;

    @PostConstruct
    public void initMethod() {
        declaration = userSessionBean.getUserDeclaration();
        if (declaration.getDeclarationRecords() != null && declaration.getDeclarationRecords().size() > 0 ) {
            makeDeclarationTree();
        }
    }

    public void makeDeclarationTree() {
        Set<DeclarationRecord> declarationRecords = declaration.getDeclarationRecords();
        declarationTree = new DefaultTreeNode("root", null);
        for (DeclarationRecord declarationRecord : declarationRecords) {
            TreeNode mainRecordNode = new DefaultTreeNode(declarationRecord, declarationTree);
            for (DeclarationRecordChild declarationChild : declarationRecord.getDeclarationRecordChildren()) {
                TreeNode childRecordNode = new DefaultTreeNode(declarationChild, mainRecordNode);
            }
        }
    }

    public void editChildListener() {
        editChild = true;
        addChild = false;
        currentChildEstate = new DeclarationRecordChild();
    }

    public String wizardFlow(FlowEvent event) {
        return event.getNewStep();
    }

    /**
     * To nie jest zwykły getter
     * @return
     */
    public DictEstate getSelectedEstate() {
        return currentMainEstate.getEstate();
    }

    /**
     * To nie jest zwykły setter
     * @param selectedEstate
     */
    public void setSelectedEstate(DictEstate selectedEstate) {
        currentMainEstate.setEstate(selectedEstate);
    }

    /**
     * To nie jest zwykły getter
     * @return
     */
    public Double getCurrentMainEstateValue() {
        return currentMainEstate.getValue();
    }

    /**
     * To nie jest zwykły setter
     * @param currentMainEstateValue
     */
    public void setCurrentMainEstateValue(Double currentMainEstateValue) {
        currentMainEstate.setValue(currentMainEstateValue);

    }

    /* GETTERY I SETTERY*/
    public Declaration getDeclaration() {
        return declaration;
    }

    public void setDeclaration(Declaration declaration) {
        this.declaration = declaration;
    }

    public TreeNode getDeclarationTree() {
        return declarationTree;
    }

    public void setDeclarationTree(TreeNode declarationTree) {
        this.declarationTree = declarationTree;
    }

    public DeclarationRecord getCurrentMainEstate() {
        return currentMainEstate;
    }

    public void setCurrentMainEstate(DeclarationRecord currentMainEstate) {
        this.currentMainEstate = currentMainEstate;
    }

    public boolean isEditChild() {
        return editChild;
    }

    public void setEditChild(boolean editChild) {
        this.editChild = editChild;
    }

    public boolean isAddChild() {
        return addChild;
    }

    public void setAddChild(boolean addChild) {
        this.addChild = addChild;
    }

    public DeclarationRecordChild getCurrentChildEstate() {
        return currentChildEstate;
    }

    public void setCurrentChildEstate(DeclarationRecordChild currentChildEstate) {
        this.currentChildEstate = currentChildEstate;
    }

    public void setUserSessionBean(UserSessionBean userSessionBean) {
        this.userSessionBean = userSessionBean;
    }
}
