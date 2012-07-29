
package app.bean.session;

import app.bean.session.goaltick.GoalTick;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: USER
 * Date: 12.07.12
 * Time: 14:03
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@SessionScoped
public class PageController implements Serializable {
    private String chosenMenuItemId = "menuForm:menuProductType";

    private GoalTick productType;
    private GoalTick totalAmount;
    private GoalTick estate;
    private GoalTick parameters;
    private GoalTick declarations;
    private GoalTick interest;
    private GoalTick credit;
    private GoalTick creditPeriod;
    private GoalTick priceCondition;
    private GoalTick additionalParameter;
    private GoalTick documents;
    private GoalTick summary;

    @PostConstruct
    public void initMethod() {
       productType = new GoalTick();
       totalAmount = new GoalTick("wnioskowana_kwota_kredytu");
       estate = new GoalTick("zabezpieczenie");
       parameters = new GoalTick();
       declarations = new GoalTick();
       interest = new GoalTick("oprocentowanie_kredytu");
       credit = new GoalTick();
       creditPeriod = new GoalTick();
       priceCondition = new GoalTick();
       additionalParameter = new GoalTick();
       documents = new GoalTick();
       summary = new GoalTick();
    }

    public void chooseMenuItem(ActionEvent event) {
        chosenMenuItemId = event.getComponent().getClientId();
    }

    public void chooseStringMenuItem(String menuItem) {
        chosenMenuItemId = "menuForm:" + menuItem;
    }

    /*GETTERy I SETTERy*/
    public String getChosenMenuItemId() {
        return chosenMenuItemId;
    }

    public void setChosenMenuItemId(String chosenMenuItemId) {
        this.chosenMenuItemId = chosenMenuItemId;
    }

    public GoalTick getProductType() {
        return productType;
    }

    public void setProductType(GoalTick productType) {
        this.productType = productType;
    }

    public GoalTick getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(GoalTick totalAmount) {
        this.totalAmount = totalAmount;
    }

    public GoalTick getEstate() {
        return estate;
    }

    public void setEstate(GoalTick estate) {
        this.estate = estate;
    }

    public GoalTick getParameters() {
        return parameters;
    }

    public void setParameters(GoalTick parameters) {
        this.parameters = parameters;
    }

    public GoalTick getDeclarations() {
        return declarations;
    }

    public void setDeclarations(GoalTick declarations) {
        this.declarations = declarations;
    }

    public GoalTick getInterest() {
        return interest;
    }

    public void setInterest(GoalTick interest) {
        this.interest = interest;
    }

    public GoalTick getCredit() {
        return credit;
    }

    public void setCredit(GoalTick credit) {
        this.credit = credit;
    }

    public GoalTick getCreditPeriod() {
        return creditPeriod;
    }

    public void setCreditPeriod(GoalTick creditPeriod) {
        this.creditPeriod = creditPeriod;
    }

    public GoalTick getPriceCondition() {
        return priceCondition;
    }

    public void setPriceCondition(GoalTick priceCondition) {
        this.priceCondition = priceCondition;
    }

    public GoalTick getAdditionalParameter() {
        return additionalParameter;
    }

    public void setAdditionalParameter(GoalTick additionalParameter) {
        this.additionalParameter = additionalParameter;
    }

    public GoalTick getDocuments() {
        return documents;
    }

    public void setDocuments(GoalTick documents) {
        this.documents = documents;
    }

    public GoalTick getSummary() {
        return summary;
    }

    public void setSummary(GoalTick summary) {
        this.summary = summary;
    }
}

