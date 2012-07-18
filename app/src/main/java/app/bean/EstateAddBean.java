package app.bean;

import app.bean.config.ConfigUserBean;
import app.bean.session.UserSessionBean;
import core.orm.entities.*;
import core.orm.entities.estate.DictEstate;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Locale;
import java.util.ResourceBundle;
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

    /*dodatkowe pole nieruchomości*/
    private DeclarationRecordChild currentChildEstate = new DeclarationRecordChild();

    private DictShareType childShareType;

    private DictOwnership childOwnership;

    private DictEstate childEstate;

    private Double childValue;
    /*dodatkowe pole nieruchomości*/
    private TreeNode declarationTree;

    private boolean editChild;

    private boolean addChild;

    @PostConstruct
    public void initMethod() {
        declaration = userSessionBean.getUserDeclaration();
        if (declaration.getDeclarationRecords() != null && declaration.getDeclarationRecords().size() > 0 ) {
            makeDeclarationTree();
        }
        currentMainEstate.setDeclarationRecordChildren(new HashSet<DeclarationRecordChild>());
        DeclarationRecordChild declarationRecordChild = new DeclarationRecordChild();
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
        String currentStep = event.getOldStep();
        if (currentStep.equals("main") && currentMainEstate.getEstate() == null) {
            FacesContext context = FacesContext.getCurrentInstance();
            FacesContext facesContext = FacesContext.getCurrentInstance();
            Locale locale = facesContext.getViewRoot().getLocale();
            ResourceBundle bundle = ResourceBundle.getBundle("message.messages", locale);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, bundle.getString("estate.wizard.warn.wybierz_nieruchomosc"), bundle.getString("estate.wizard.warn.wybierz_nieruchomosc")));
            return currentStep;

        }
        return event.getNewStep();
    }

    public void addToList() {
        currentMainEstate.getDeclarationRecordChildren().add(currentChildEstate);
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

    public void setUserSessionBean(UserSessionBean userSessionBean) {
        this.userSessionBean = userSessionBean;
    }

    public void setCurrentChildEstate(DeclarationRecordChild currentChildEstate) {
        this.currentChildEstate = currentChildEstate;
    }

    public DictShareType getChildShareType() {
        return childShareType;
    }

    public void setChildShareType(DictShareType childShareType) {
        currentChildEstate.setShareType(childShareType);
        this.childShareType = childShareType;
    }

    public Double getChildValue() {
        return childValue;
    }

    public void setChildValue(Double childValue) {
        currentChildEstate.setValue(childValue);
        this.childValue = childValue;
    }

    public DictEstate getChildEstate() {
        return childEstate;
    }

    public void setChildEstate(DictEstate childEstate) {
        currentChildEstate.setEstate(childEstate);
        this.childEstate = childEstate;
    }

    public DictOwnership getChildOwnership() {
        return childOwnership;
    }

    public void setChildOwnership(DictOwnership childOwnership) {
        currentChildEstate.setOwnership(childOwnership);
        this.childOwnership = childOwnership;
    }

}
