package app.bean;

import app.bean.config.ConfigUserBean;
import app.bean.session.UserSessionBean;
import app.bean.session.goaltick.GoalTick;
import core.orm.entities.*;
import core.orm.entities.estate.DictEstate;
import org.primefaces.component.wizard.Wizard;
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
import java.util.*;

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

    @ManagedProperty("#{pageController.estate}")
    GoalTick goalTick;

    private Declaration declaration;

    private DeclarationRecord currentMainEstate;

    private DeclarationRecordChild currentChildEstate;

    private DeclarationRecordChild editedChildEstate;

    private TreeNode declarationTree;

    private Wizard wizard;


    @PostConstruct
    public void initMethod() {
        declaration = userSessionBean.getUserDeclaration();
        if (declaration.getDeclarationRecords() != null && declaration.getDeclarationRecords().size() > 0 ) {
            makeDeclarationTree();
        }
        clearAll();
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

    public void clearAll() {
        if (wizard != null) {
            wizard.setStep("main");
        }
        currentMainEstate = new DeclarationRecord();
        currentMainEstate.setDeclarationRecordChildren(new HashSet<DeclarationRecordChild>());
        currentChildEstate = new DeclarationRecordChild();
        setSelectedEstate(null);
    }

    public void clearCurrentChild() {
        currentChildEstate = new DeclarationRecordChild();
    }
    public String wizardFlow(FlowEvent event) {
        String currentStep = event.getOldStep();
        //TODO MOZNA ZROBIC LEPIEJ
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
        if (!declaration.getDeclarationRecords().contains(currentMainEstate)) {
          declaration.getDeclarationRecords().add(currentMainEstate);
          currentMainEstate.setDeclaration(declaration);
        }
        if (editedChildEstate != null) {
            currentMainEstate.getDeclarationRecordChildren().remove(editedChildEstate);
            currentMainEstate.getDeclarationRecordChildren().add(currentChildEstate);
            currentChildEstate.setParentRecordId(currentMainEstate);
            currentChildEstate.setDeclaration(declaration);
            currentChildEstate = new DeclarationRecordChild();
            editedChildEstate = null;
        } else {
            currentChildEstate.setDeclaration(declaration);
            currentChildEstate.setParentRecordId(currentMainEstate);
            currentMainEstate.getDeclarationRecordChildren().add(currentChildEstate);
            currentChildEstate = new DeclarationRecordChild();
        }
    }


    public void fakeTick() {
        goalTick.setCompleted(true);
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

    public void setRemoveChildListener(DeclarationRecordChild childToRemove) {
        currentMainEstate.getDeclarationRecordChildren().remove(childToRemove);
    }

    public void setEditChildListener(DeclarationRecordChild childToEdit) {
        editedChildEstate = childToEdit;
        currentChildEstate = (DeclarationRecordChild)childToEdit.clone();
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
        return currentChildEstate.getShareType();
    }

    public void setChildShareType(DictShareType childShareType) {
        currentChildEstate.setShareType(childShareType);
    }

    public Double getChildValue() {
        return currentChildEstate.getValue();
    }

    public void setChildValue(Double childValue) {
        currentChildEstate.setValue(childValue);
    }

    public DictEstate getChildEstate() {
        return currentChildEstate.getEstate();
    }

    public void setChildEstate(DictEstate childEstate) {
        currentChildEstate.setEstate(childEstate);
    }

    public DictOwnership getChildOwnership() {
        return currentChildEstate.getOwnership();
    }

    public void setChildOwnership(DictOwnership childOwnership) {
        currentChildEstate.setOwnership(childOwnership);
    }

    public Wizard getWizard() {
        return wizard;
    }

    public void setWizard(Wizard wizard) {
        this.wizard = wizard;
    }

    public void setGoalTick(GoalTick goalTick) {
        this.goalTick = goalTick;
    }
}
